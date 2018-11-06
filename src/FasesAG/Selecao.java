package FasesAG;
import java.util.ArrayList;
import java.util.Arrays;

import Geral.Cromossomo;
import Geral.OrdenaPorFitness;

public class Selecao {
	
	public static Cromossomo torneio(ArrayList<Cromossomo> lc, int nParticipantes) {
		Cromossomo[] participantes = selecionaGrupo(lc, nParticipantes);
		Arrays.sort(participantes, new OrdenaPorFitness());
		return participantes[0];
	}

	private static Cromossomo[] selecionaGrupo(ArrayList<Cromossomo> selecionados, int nParticipantes) {
		Cromossomo[] participantes = new Cromossomo[nParticipantes];
		int[] mapa = new int[selecionados.size()];
		int i = 0; 
		do{
			int pos = (int)(Math.random()*selecionados.size());
			if (mapa[pos] == 0) {
				mapa[pos] = 1;
				participantes[i] = selecionados.get(pos);
				i++;
			}
		}while (i < nParticipantes);
		return participantes;		
	}
}
