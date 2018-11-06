package FasesAG;
import java.util.ArrayList;

import Geral.Cromossomo;
import Geral.Gen;
import Geral.Preferencia;

public class Mutacao {
	public static boolean mutar(ArrayList<Preferencia> lp, Cromossomo cromo, int probMut, int nGenMutado) {
		boolean mutante = false;
		int aulas = cromo.getHorario().getAulas();
		int dias = cromo.getHorario().getDias();
		int aulaMut;
		int diaMut;
		int novoGen;
		Preferencia p;
		Gen novo;
		double probMutacao = Math.random()*100;
		if (probMutacao < probMut) {
			mutante = true;
			for (int i = 0; i < nGenMutado; i++) {
				aulaMut = (int)(Math.random()*aulas);
				diaMut = (int)(Math.random()*dias);
				novoGen = (int)(Math.random()*lp.size());	
				p = lp.get(novoGen);
				novo = new Gen(p);
				cromo.trocaGen(aulaMut, diaMut, novo);
			}
		}
		return mutante;
	}
}