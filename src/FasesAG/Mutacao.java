package FasesAG;
import java.util.ArrayList;

import Geral.Cromossomo;
import Geral.Gen;
import Geral.Preferencia;

public class Mutacao {
	/**
	 * Verifica a probabilidade de mutação e altera o numero especificado de gens.
	 * Busca um gen aleatório na lista de preferencias.
	 * @param listaDePreferencias
	 * @param cromo
	 * @param probMut
	 * @param nGenMutado
	 * @return
	 */
	public static boolean mutar(ArrayList<Preferencia> listaDePreferencias, Cromossomo cromo, int probMut, int nGenMutado) {
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
				novoGen = (int)(Math.random()*listaDePreferencias.size());	
				p = listaDePreferencias.get(novoGen);
				novo = new Gen(p);
				cromo.trocaGen(aulaMut, diaMut, novo);
			}
		}
		return mutante;
	}
}