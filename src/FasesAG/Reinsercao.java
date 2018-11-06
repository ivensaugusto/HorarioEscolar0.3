package FasesAG;
import java.util.ArrayList;
import java.util.Collections;

import Geral.Cromossomo;
import Geral.OrdenaPorFitness;

public class Reinsercao {

	/**
	 * Localiza o cromossomo com maior fitness e substitui por um filho
	 * @param lc
	 * @param c
	 * @return
	 */
	public static ArrayList<Cromossomo> maiorFit(ArrayList<Cromossomo> lc, Cromossomo c) {
		OrdenaPorFitness ordenacao = new OrdenaPorFitness();
		Collections.sort(lc, ordenacao.reversed());
		if(lc.get(0).getFitness() > c.getFitness())
		{
			lc.set(0, c);
		}
		Collections.sort(lc, ordenacao);
		return lc;
	}

	public static ArrayList<Cromossomo> piorPai(ArrayList<Cromossomo> lc, Cromossomo pai, Cromossomo filho) {
		//TODO Implementar o pior pai
		Collections.sort(lc, new OrdenaPorFitness());
		return lc;
	}

	public static ArrayList<Cromossomo> listaResultados(ArrayList<Cromossomo> lc, int limite) {
		ArrayList<Cromossomo> nl = new ArrayList<Cromossomo>();
		for (Cromossomo cromossomo : lc) {
			if (cromossomo.getFitness() <= limite){
				nl.add(cromossomo);
			}
		}
		return nl;
	}
}
