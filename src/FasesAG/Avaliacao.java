package FasesAG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import Geral.Configuracao;
import Geral.Cromossomo;
import Geral.Gen;
import Geral.OrdenaPorFitness;
import Geral.QuadroHorario;
import Geral.Slot;
import Principal.Tools;

public class Avaliacao {
	/**
	 * Este metodo chama metodo que recalcula o FITNESS, 
	 * se este ainda nao estiver calculado.
	 * @param cromossomo
	 * @return
	 */
	public static double Gens(Cromossomo cromossomo) {
		return cromossomo.getFitness();
	}

	public static boolean checarSlotVazio(Cromossomo cromossomo) {
		Slot slot = cromossomo.obterSlotDisponivel();
		return slot == null;
	}

	public static boolean checarErroQntAulas(Cromossomo cromossomo) {
		boolean erro = cromossomo.checarErroQntAulas();
		return erro;
	}

	/**
	 * TODO Este metodo sera implementado caso a grade de horarios NAO permita
	 * que a disciplina tenha X aulas em sequencias no mesmo dia
	 * @param cromossomo
	 * @return
	 */
	public static boolean[][] checarDisciplinasSequencia(Cromossomo cromossomo) {
		int aulas = cromossomo.getHorario().getAulas();
		int dias = cromossomo.getHorario().getDias();
		boolean[][] sequencias;
		sequencias = new boolean[dias][aulas / 2];
		if(aulas % 2 == 0) {
			for (int i = 0; i < dias; i++) {
				for (int j = 0; j < aulas; j += 2) {
					if(i == 2 && j == 0) {
						sequencias[i][j] = true;
					}else {
						Gen aula1 = cromossomo.getSlot(j, i).getGen();
						Gen aula2 = cromossomo.getSlot(j + 1, i).getGen();
						if(aula1 == aula2) {
							sequencias[i][j] = true;
						}
					}
				}
			}
		}else {
			for (int i = 0; i < dias; i++) {
				for (int j = 0; j < aulas;) {
					if(i == 2 && j == 0) {
						sequencias[i][j] = true;
					}else {
						if(j < 3) {
							Gen aula1 = cromossomo.getSlot(j, i).getGen();
							Gen aula2 = cromossomo.getSlot(j + 1, i).getGen();
							Gen aula3 = cromossomo.getSlot(j + 2, i).getGen();
							if(aula1 == aula2 && aula2 == aula3) {
								sequencias[i][j] = true;
							}
							j += 3;

						}else {

							Gen aula1 = cromossomo.getSlot(j, i).getGen();
							Gen aula2 = cromossomo.getSlot(j + 1, i).getGen();
							if(aula1 == aula2) {
								sequencias[i][j] = true;
							}

							j += 2;
						}
					}
				}
			}	
		}
		penalizarPorSequencia(cromossomo, sequencias, 15);
		return sequencias;
	}

	public static void penalizarPorSequencia(Cromossomo cromossomo, 
			boolean[][] sequencias, double porcentagemPena) {
		for (int i = 0; i < sequencias.length; i++) {
			for (int j = 0; j < sequencias[0].length; j ++) {
				if(sequencias[i][j] == false) {
					double pesoAula = cromossomo.getSlot(j, i).getPeso();
					penalizar(cromossomo, pesoAula, porcentagemPena);
				}
			}
		}
	}

	public static void penalizar(Cromossomo cromossomo, double pesoAula, double porcentagemPena) {
		double acrescimo = (pesoAula * (porcentagemPena / 100));
		cromossomo.setFitness(cromossomo.getFitness() + acrescimo);
	}
	
	public static void marcarDefeito(Cromossomo cromossomo) {
		cromossomo.setFitness(Configuracao.VALOR_SLOT_DEFEITUOSO);
	}

	/**
	 * TODO Este metodo sera implementado caso a grade de horarios NAO permita
	 * que a disciplina tenha mais do que X aulas em um mesmo dia.
	 * @param cromossomo, QuadroHorario
	 * @return false caso exista mais que uma repetição no mesmo dia. 
	 */
	public static boolean checarQtdMaxDisciplinasDia(Cromossomo cromossomo) {
		int aulas = cromossomo.getHorario().getAulas();
		int dias = cromossomo.getHorario().getDias();
		boolean resultado = true;
		int cont = -1;
		double pesoAux = 0;
		for (int dia = 0; dia < dias; dia++) {
			for (int aula = 0; aula < aulas; aula++) {
				Slot aux = cromossomo.getSlot(aula, dia);
				cont = -1;
				for (int i = 0; i < aulas; i++) {
					if (aux.getGen().UID().equals(cromossomo.getSlot(aula, dia).getGen().UID())) {
						cont++;
						pesoAux += cromossomo.getSlot(aula, dia).getPeso();
					}
				}
				if (cont > 2) {
					penalizar(cromossomo, pesoAux, 10);
					resultado =  false;
				}
			}
		}
		return resultado;
	}

	/***
	 * TODO implementar
	 * @return
	 */
	public static boolean checarDisciplinaNaoDistribuida() {
		return false;
	}

	/***
	 * Escolhe o pior cromossomo dentro da lista indicada
	 * @param pai1
	 * @param pai2
	 * @return
	 */
	public static Cromossomo encontrarPiorPai(ArrayList<Cromossomo> pais) {
		Cromossomo pior = null;
		if(!pais.isEmpty()) {
			OrdenaPorFitness ordenacao = new OrdenaPorFitness();
			Collections.sort(pais, ordenacao.reversed());

			pior = pais.get(0);
		}
		return pior;
	}
}
