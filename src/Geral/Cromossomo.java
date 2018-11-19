package Geral;
import java.util.ArrayList;
import java.util.Random;

import Principal.Tools;

public class Cromossomo {
	private Slot[][] slots;
	private String label;
	private ArrayList<Preferencia> _preferencias;
	private QuadroHorario _horario;
	private int fitness = Integer.MIN_VALUE;
	private String UIDPai1 = null;
	private String UIDPai2 = null;

	public Cromossomo(ArrayList<Preferencia> preferencias, QuadroHorario horario) {
		this._preferencias = preferencias;
		this._horario = horario;
		this.label = null;
		this.slots = this.gerar(preferencias, horario);
		this.UIDPai1 = null;
		this.UIDPai2 = null;
	}

	public Cromossomo(Slot[][] slots, Cromossomo pai1, Cromossomo pai2) {
		this.slots = slots;
		this._horario = pai1.getHorario();
		this.label = null;
		this.fitness = Integer.MIN_VALUE;
		this.UIDPai1 = pai1.UID();
		this.UIDPai2 = pai2.UID();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cromossomo:\n");
		builder.append(Tools.writeMat(slots));
		builder.append("\nFitness: ");
		builder.append(this.getFitness());
		builder.append("\n\n");
		//builder.append(" Label=" + label + "\n");
		return builder.toString();
	}	

	//	public void gerar() {
	//		this.slots = this.gerar(this._preferencias, this._horario);
	//		this.label = null;
	//	}

	public Slot[][] gerar(ArrayList<Preferencia> preferencias, QuadroHorario horario) {
		Slot[][] slots = criarIndividual(preferencias, horario);
		return slots;
	}

	/**
	 * criarIndividual: Cria uma matriz, que � um conjunto slots, contendo um gen em cada. 
	 * Usa uma regra que coloca aulas em horarios seguidos.
	 * 
	 * @param Lista de preferencias, grade horaria.
	 * @return Conjunto de caracteres (String).
	 */
	private Slot[][] criarIndividual(ArrayList<Preferencia> preferencias, QuadroHorario horario) {
		Slot[][] slotsQuadroHorario = criarSlotsEmBranco(horario);
		Gen gen;
		Slot slot;
		int totalDeAulas;
		int aulasDistribuidas=0;
		for (Preferencia preferencia : preferencias) {
			totalDeAulas = preferencia.getDisciplina().getTotalIteracoes();
			do {
				slot = obterSlotDisponivel(slotsQuadroHorario, true);
				if(slot != null) {
					gen = new Gen(preferencia);
					slot.setGen(gen);
				}
				aulasDistribuidas = this.calcularAulasDistribuidas(slotsQuadroHorario, preferencia);
			}while(aulasDistribuidas < totalDeAulas && slot != null);
		}
		return slotsQuadroHorario;
	}

	public int calcularAulasDistribuidas(Slot[][] slots, Preferencia preferencia) {
		int aulasDistribuidas = 0;
		Slot slot;
		for (int aula = 0; aula < slots.length; aula++) {
			for (int dia = 0; dia < slots[0].length; dia++) {
				slot = slots[aula][dia];
				Gen gen = slot.getGen();
				if(!slot.disponivel() && preferencia.getDisciplina().equals(gen.getDisciplina()))
					aulasDistribuidas += slot.getAulasDistribuidas();
			}
		}
		return aulasDistribuidas;
	}

	/**
	 * criarGeminado: Cria uma matriz, que � um conjunto slots, contendo um gen em cada. 
	 * Usa uma regra que coloca aulas geminadas em horarios seguidos.
	 * 
	 * @param Lista de preferencias, grade horaria.
	 * @return Conjunto de caracteres (String).
	 */
	@SuppressWarnings("unused")
	private Slot[][] criarGeminado(ArrayList<Preferencia> preferencias, QuadroHorario horario) {
		Slot[][] slotsQuadroHorario = criarSlotsEmBranco(horario);
		Gen gen;
		Slot slot;
		boolean fim = false;
		boolean permiteSlotQuinzenal = false;
		int iteracoes;
		for (Preferencia preferencia : preferencias) {
			iteracoes = preferencia.getDisciplina().getTotalIteracoesGeniado();
			permiteSlotQuinzenal = (iteracoes > 1);
			for (int i = 0; i < iteracoes; i++) {
				fim = false;
				do {
					slot = obterSlotDisponivel(slotsQuadroHorario, permiteSlotQuinzenal);
					if(slot != null) {
						gen = new Gen(preferencia);
						slot.setGen(gen);
						if (testaQuinzenal(slot.aula, slot.dia)) {
							if(i < (iteracoes-1)) {
								addGenNoSlot(slotsQuadroHorario, preferencia, false);
								// BREAK no FOR
								i = iteracoes;
							}
						}else {
							dobraAula(slotsQuadroHorario, slot);
						}
						fim = true;
					}
				}while(!fim && slot != null);
			}
		}
		return slotsQuadroHorario;
	}

	private Slot[][] criarSlotsEmBranco(QuadroHorario horario) {
		int aulas= horario.getAulas();
		int dias = horario.getDias();

		Slot[][] slots = new Slot[aulas][dias];
		for(int aula = 0 ; aula < aulas ; aula++) {
			for(int dia = 0 ; dia < dias ; dia++) {
				slots[aula][dia] = new Slot(aula, dia, this.testaQuinzenal(aula, dia));
			}
		}
		return slots;
	}

	private void addGenNoSlot(Slot[][] cromoAux, Preferencia preferencia, boolean permiteSlotQuinzenal) {
		Gen gen;
		Slot slot;
		boolean fim = false;
		int slotsDisponiveis;
		do {
			fim = false;
			slotsDisponiveis  = obterSlotsDisponiveis(cromoAux, permiteSlotQuinzenal).size();
			slot = obterSlotDisponivel(cromoAux, permiteSlotQuinzenal);
			if(slot == null) {
				slot = obterSlotDisponivel(cromoAux, true);
			}
			if(slot != null) {
				gen = new Gen(preferencia);
				if (testaQuinzenal(slot.aula, slot.dia)) {
					if( slotsDisponiveis == 1) {
						gen.setDefeituoso(true);
						slot.setGen(gen);
						fim = true;
					}
				}else { 
					dobraAula(cromoAux, slot);
					fim = true;
				}
			}
		}while(!fim && slot != null);
	}

	private void dobraAula(Slot[][] slots, Slot slot) {
		Slot novoSlot;
		if(slot.aula == 0 || slot.aula == 2) {
			novoSlot = slots[slot.aula+1][slot.dia];
		}else {
			novoSlot = slots[slot.aula-1][slot.dia];
		}
		novoSlot.setGen(slot.getGen());
	}

	public Slot obterSlotDisponivel(Slot[][] cromoAux, boolean permiteSlotQuinzenal) {
		ArrayList<Slot> slotsDisponiveis = obterSlotsDisponiveis(cromoAux, permiteSlotQuinzenal);
		Slot s = null;
		if(slotsDisponiveis != null && slotsDisponiveis.size()>0) {
			Random rnd = new Random();
			int i = rnd.nextInt(slotsDisponiveis.size());
			s = slotsDisponiveis.get(i);
		}
		return s;
	}

	public ArrayList<Slot> obterSlotsDisponiveis(Slot[][] cromoAux, Boolean permiteSlotQuinzenal) {
		ArrayList<Slot> slots = new ArrayList<Slot>();
		Slot slot;
		for (int i = 0; i < cromoAux.length; i++) {
			for (int j = 0; j < cromoAux[0].length; j++) {
				slot = cromoAux[i][j]; 
				if(slot.disponivel()) {
					slots.add(slot);
				}
			}
		}
		return slots;
	}

	/**
	 * Retorna true se o slot do horario for quinzenal. 
	 * Verifica tamb�m se a aula anterior ou posterior, dependendo da posi��o na matriz, � quinzenal e retorna true caso seja.
	 * @param Conjunto de aula e dia de uma dispciplina (int, int).
	 * @return Um boleano (boolean).
	 */
	private boolean testaQuinzenal(int aula, int dia) {
		int aulaQuinzenal = this._horario.getAulaQuinzenal();
		int diaQuinzenal = this._horario.getDiaQuinzenal();
		boolean quinzenal = false;
		if(aulaQuinzenal == 0 || aulaQuinzenal == 2) {
			quinzenal = (dia == diaQuinzenal) && ((aula == aulaQuinzenal)|| (aula == aulaQuinzenal+1));			
		}else {
			quinzenal = (dia == diaQuinzenal) && ((aula == aulaQuinzenal)|| (aula == aulaQuinzenal-1));
		}
		return quinzenal;
	}
	/*
	private boolean cheio() {
		return obterSlotsDisponiveis(this.gens, true).size() == 0;
	}
	 */ 
	public int calculaFitness() {
		int fitnessTotal = 0;
		for (int i = 0; i < this.slots.length; i++) {
			for (int j = 0; j < this.slots[0].length; j++) {
				fitnessTotal += this.slots[i][j].getPeso();
			}			
		}
		return fitnessTotal;
	}

	public Slot getSlot(int aula, int dia) {
		return slots[aula][dia];
	}

	/***
	 * Este metodo recalcula o FITNESS, se este ainda nao estiver
	 * calculado.
	 * @return
	 */
	public int getFitness() {
		//if(this.fitness == Integer.MIN_VALUE)
		this.fitness = this.calculaFitness();
		return this.fitness;
	}

	public String getLabel() {
		return label+"";
	}

	public QuadroHorario getHorario() {
		return this._horario;
	}
	
	public String getUIDPai1() {
		return UIDPai1;
	}

	public String getUIDPai2() {
		return UIDPai2;
	}

	public String UID() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < slots.length; i++) {
			for (int j = 0; j < slots[0].length; j++) {
				if(this.slots[i][j].getGen() == null)
					sb.append("|null|");
				else					
					sb.append(this.slots[i][j].getGen().UID());
			}
		}
		return sb.toString();
	}

	public void trocaGen(int aula, int dia, Gen novo) {
		this.slots[aula][dia].setGen(novo);
		this.fitness = Integer.MIN_VALUE; 
	}

	public Slot obterSlotDisponivel() {
		return this.obterSlotDisponivel(this.slots, true);
	}
	public boolean checarErroQntAulas() {
		boolean erro = false;
		int aulasDistribuidas = 0;
		for(Preferencia p : this._preferencias){
			aulasDistribuidas = this.calcularAulasDistribuidas(this.slots, p);
			if(aulasDistribuidas > p.getDisciplina().getTotalIteracoes()) {
				erro = true;
				break;
			}
		}
		return erro;
	}
}









