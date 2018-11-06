package FasesAG;

import Geral.Cromossomo;
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

	public boolean checarSlotVazio(Cromossomo cromossomo) {
		Slot slot = cromossomo.obterSlotDisponivel();
		return slot == null;
	}
	
	public boolean checarErroQntAulas(Cromossomo cromossomo) {
		boolean erro = cromossomo.checarErroQntAulas();
		return erro;
	}
	
	/**
	 * TODO Este metodo sera implementado caso a grade de horarios NAO permita
	 * que a disciplina tenha X aulas em sequencias no mesmo dia
	 * @param cromossomo
	 * @return
	 */
	public boolean checarDisciplinasSequencia(Cromossomo cromossomo) {
		return false;
	}

	/**
	 * TODO Este metodo sera implementado caso a grade de horarios NAO permita
	 * que a disciplina tenha mais do que X aulas em um mesmo dia
	 * @param cromossomo
	 * @return
	 */
	public boolean checarQtdMaxDisciplinasDia(Cromossomo cromossomo) {
		return false;
	}
	
	/***
	 * TODO implementar
	 * @return
	 */
	public boolean checarDisciplinaNaoDistribuida() {
		return false;
	}	
}
