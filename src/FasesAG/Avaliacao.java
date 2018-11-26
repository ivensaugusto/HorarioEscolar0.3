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

public class Avaliacao {
	/**
	 * Este metodo chama metodo que recalcula o FITNESS, 
	 * se este ainda nao estiver calculado.
	 * @param cromossomo
	 * @return
	 */
	public static int Gens(Cromossomo cromossomo) {
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
	public static boolean[][] checarDisciplinasSequencia(Cromossomo cromossomo, QuadroHorario quadroHorario) {
		return null;
	
	}

	/**
	 * TODO Este metodo sera implementado caso a grade de horarios NAO permita
	 * que a disciplina tenha mais do que X aulas em um mesmo dia
	 * @param cromossomo
	 * @return
	 */
	public static boolean checarQtdMaxDisciplinasDia(Cromossomo cromossomo, QuadroHorario quadroHorario) {
		int dias = quadroHorario.getDias();
		int aulas = quadroHorario.getAulas();
		int cont = -1;
		for (int dia = 0; dia < dias; dia++) {
			for (int aula = 0; aula < aulas; aula++) {
				Slot aux = cromossomo.getSlot(aula, dia);
				cont = -1;
				for (int i = 0; i < aulas; i++) {
					if (aux.getGen().UID().equals(cromossomo.getSlot(aula, dia).getGen().UID())) {
						cont++;
					}
				}
				if (cont > 2) {
					System.out.println("Repete mais que duas vezes no mesmo dias!"+cont);
					return false;
				}
				
			}
		}
		return true;
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
