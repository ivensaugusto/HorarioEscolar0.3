package FasesAG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import Geral.Cromossomo;
import Geral.OrdenaPorFitness;
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
	public static boolean checarDisciplinasSequencia(Cromossomo cromossomo) {
		return false;
	}

	/**
	 * TODO Este metodo sera implementado caso a grade de horarios NAO permita
	 * que a disciplina tenha mais do que X aulas em um mesmo dia
	 * @param cromossomo
	 * @return
	 */
	public static boolean checarQtdMaxDisciplinasDia(Cromossomo cromossomo) {
		return false;
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
