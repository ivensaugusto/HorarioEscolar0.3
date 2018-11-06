package Geral;
import java.util.ArrayList;

import Principal.Controle;
import Principal.Tools;

public class Preferencia {
	/*
	 * Deve gerar uma tabela de preferï¿½ncias de horï¿½rio para cada disciplina.
	 * A tabela deve ser do mesmo tamanho que a matriz do horï¿½rio.
	 * Estï¿½ classe serï¿½ responsavel por importar os resultados reais, 
	 * quando estiverem disponiveis.
	 */

	private Disciplina disciplina;
	private int[][] pesos;
	private QuadroHorario horario;

	public Preferencia(QuadroHorario horario, Disciplina disciplina, int[][] pesos) {
		this.disciplina = disciplina;
		this.horario = horario;
		this.pesos = pesos;
	}

	public Preferencia(QuadroHorario horario, Disciplina disciplina, int pesoInicial, int pesoFinal) {
		this.disciplina = disciplina;
		this.horario = horario;
		this.pesos = simularPesos(horario, pesoInicial, pesoFinal);
	}
/**
 * Cria um arquivo txt, contendo uma lista de dados. 
 * São eles:
 * Disciplina,nome professor,periodo, carga horaria e 
 * uma matriz com os pesos de cada slot.
 * Cada linha (tupla) da lista é separada por uma quebra de linha "\n".
 * Os dados da disciplina são separados da matriz de pesos por um ";".
 * Cada conjunto de dias é separado tambem por ";".
 * Cada horario de aula é separado por uma ",".
 * ver: preferencia.toString2(), Controle.listaPreferencias().
 * @param horario
 * @param pesoInicial
 * @param pesoFinal
 */
	public static void criaLista(QuadroHorario horario, int pesoInicial, int pesoFinal){
		final String caminhoDisciplina  = "Disciplinas.txt",
				caminhoPreferencia = "Preferencias.txt";
		String saida = "",
				texto = "";
		texto = Controle.carregar(caminhoDisciplina);
		ArrayList<Disciplina> listaDisciplina = Controle.listaDisciplinas(texto);
		Preferencia preferencia;
		int i = 0;
		ArrayList<Preferencia> lp = new ArrayList<Preferencia>();
		for (Disciplina disciplina : listaDisciplina) {
			preferencia = new Preferencia(horario, disciplina, pesoInicial, pesoFinal);
			lp.add(preferencia);
			saida += preferencia.toString2();
			i++;
			if(i < listaDisciplina.size()) {
				saida += "\n";
			}
		}
		Controle.salvar(caminhoPreferencia, saida);
	}

	public static ArrayList<Preferencia> carregaListaPref(QuadroHorario horario){
		final String caminhoPreferencia = "Preferencias.txt";
		String texto = Controle.carregar(caminhoPreferencia);
		ArrayList<Preferencia> lp = Controle.listaPreferencias(texto, horario);
		return lp;
	}

	/**
	 * Simula as escolhas de peso para cada Slot, criando uma matriz no formato (aula,dia).
	 * cada peso será um numero inteiro aleatório entre peso inical e peso final
	 * Os pesos indicam uma escala de preferencia, para cada um dos 
	 * horarios de um dia da semana, "Slot (aula, dia)".
	 * @param horario
	 * @param pesoInicial
	 * @param pesoFinal
	 * @return
	 */
	public int [][] simularPesos(QuadroHorario horario, int pesoInicial, int pesoFinal) {
		//pesoInicial = 11;
		//pesoFinal = pesoInicial + 9; // [0..9] o total de aulas da semana (20) dividido por 2, devido as aulas geminadas.
		/// 99 significa que o professor nao pode dar aquela aula naquele dia e hora. ///
		int[][] preferencia = Tools.randomIntMat(horario.getAulas(), horario.getDias(), pesoInicial, pesoFinal);
		return preferencia;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

//	public int[][] getPreferencia() {
//		return pesos;
//	}
//
//	public void setPreferencia(int[][] preferencia) {
//		this.pesos = preferencia;
//	}

	public int getDias() {
		return horario.getDias();
	}

	public int getAulas() {
		return horario.getAulas();
	}

	public int getPeso(Slot slot) {

		return this.pesos[slot.aula][slot.dia];
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(disciplina);
		builder.append("\nPreferencia:\n");
		builder.append(Tools.writeIntMat(pesos));
		return builder.toString();
	}

	public String toString2() {
		StringBuilder builder = new StringBuilder();
		builder.append(disciplina.toString2());
		builder.append(";");
		for (int aula = 0; aula < pesos.length; aula++) {
			for (int dia = 0; dia < pesos[0].length; dia++) {
				builder.append(String.valueOf(pesos[aula][dia]));
				if (aula != pesos.length-1 || dia != pesos[0].length-1) {
					builder.append(",");
				}
			}
			builder.append(";");
		}
		return builder.toString();
	}
}




















