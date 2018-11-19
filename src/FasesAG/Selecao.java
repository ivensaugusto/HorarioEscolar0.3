package FasesAG;
import java.util.ArrayList;
import java.util.Arrays;

import Geral.Cromossomo;
import Geral.OrdenaPorFitness;

public class Selecao {
	/**
	 * Recebe uma lista de participantes e retorna aquele com o menor fitness.
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
	 * Seleciona aleatoriamente um numero "nParticipantes" da populacao, e retorna em forma de lista. 
	 * @param populacao
	 * @param nParticipantes
	 * @return
	 */
//	private static Cromossomo[] selecionaGrupo(ArrayList<Cromossomo> populacao, int nParticipantes) {
//		Cromossomo[] participantes = new Cromossomo[nParticipantes];
//		int[] mapa = new int[populacao.size()];
//		int i = 0; 
//		do{
//			int pos = (int)(Math.random()*populacao.size());
//			if (mapa[pos] == 0) {
//				mapa[pos] = 1;
//				participantes[i] = populacao.get(pos);
//				i++;
//			}
//		}while (i < nParticipantes);
//		return participantes;		
//	}
	
	@SuppressWarnings("unchecked")
	private static Cromossomo[] selecionaGrupo(ArrayList<Cromossomo> populacao, int nParticipantes) {
		Cromossomo[] participantes = new Cromossomo[nParticipantes];
		ArrayList<Cromossomo> populacaoAux = (ArrayList<Cromossomo>) populacao.clone();
		int i = 0;
		do{
			int pos = (int)(Math.random()*populacaoAux.size());
			participantes[i] = populacaoAux.get(pos);
			populacaoAux.remove(pos);
			i++;
		}while (i < nParticipantes);
		return participantes;		
	}
}
