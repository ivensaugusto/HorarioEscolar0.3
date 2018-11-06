package FasesAG;
import java.util.ArrayList;
import java.util.Arrays;

import Geral.Cromossomo;
import Geral.OrdenaPorFitness;

public class Selecao {
	/**
	 * Recebe uma lista de participantes e retorna aquela com o menor fitness.
	 * @param lc
	 * @param nParticipantes
	 * @return
	 */
	public static Cromossomo torneio(ArrayList<Cromossomo> lc, int nParticipantes) {
		Cromossomo[] participantes = selecionaGrupo(lc, nParticipantes);
		Arrays.sort(participantes, new OrdenaPorFitness());
		return participantes[0];
	}
	/**
	 * Seleciona aleatóriamente um numero "nParticipantes" da população, e retorna emforma de lista. 
	 * @param populacao
	 * @param nParticipantes
	 * @return
	 */
	private static Cromossomo[] selecionaGrupo(ArrayList<Cromossomo> populacao, int nParticipantes) {
		Cromossomo[] participantes = new Cromossomo[nParticipantes];
		int[] mapa = new int[populacao.size()];
		int i = 0; 
		do{
			int pos = (int)(Math.random()*populacao.size());
			if (mapa[pos] == 0) {
				mapa[pos] = 1;
				participantes[i] = populacao.get(pos);
				i++;
			}
		}while (i < nParticipantes);
		return participantes;		
	}
}
