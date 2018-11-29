package FasesAG;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

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
		if(lc.get(0).getFitness() > c.getFitness()){
			lc.set(0, c);
		}else if (lc.get(0).getFitness() == c.getFitness()){
			lc.add(c);
		}
		Collections.sort(lc, ordenacao);
		return lc;
	}

	public static ArrayList<Cromossomo> piorPai(ArrayList<Cromossomo> lc, Cromossomo filho) {
		Cromossomo pai1 = Reinsercao.encontraCromossomoPeloUID(lc, filho.getUIDPai1());
		Cromossomo pai2 = Reinsercao.encontraCromossomoPeloUID(lc, filho.getUIDPai2());
		//ArrayList<Cromossomo> pais = new ArrayList<Cromossomo>(Arrays.asList(pai1, pai2));
		ArrayList<Cromossomo> pais = new ArrayList<Cromossomo>();
		
		if(pai1 != null)
			pais.add(pai1);
		
		if(pai2 != null)
			pais.add(pai2);
		
		Cromossomo piorPai = Avaliacao.encontrarPiorPai(pais);
		filhoMelhorQuePai(lc, piorPai, filho);
		Collections.sort(lc, new OrdenaPorFitness());
		return lc;
	}

	private static void filhoMelhorQuePai(ArrayList<Cromossomo> lc, Cromossomo piorPai, Cromossomo filho) {
		
		if(piorPai == null || piorPai.getFitness() == filho.getFitness()) {
			lc.add(filho);
		} else if(piorPai.getFitness() > filho.getFitness()) {
			int pos = lc.indexOf(piorPai);
			if(pos >= 0)
				lc.set(pos, filho);
		}
	}

	private static Cromossomo encontraCromossomoPeloUID(ArrayList<Cromossomo> lc, String uidPai) {
		Cromossomo pai = null;
		for(Cromossomo item : lc) {
			if(item.UID().equals(uidPai)) {
				pai = item;
				break;
			}
		}
		return pai;
	}

	public static ArrayList<Cromossomo> listaResultados(ArrayList<Cromossomo> lc, double limite) {
		ArrayList<Cromossomo> nl = new ArrayList<Cromossomo>();
		for (Cromossomo cromossomo : lc) {
			if (cromossomo.getFitness() <= limite){
				nl.add(cromossomo);
			}
		}
		return nl;
	}


}
