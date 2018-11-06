package FasesAG;
import java.util.ArrayList;

import Geral.Cromossomo;
import Geral.Gen;

public class Deteccao {
/**
 * Verifica se dois cromossomos são iguais, em caso positivo retorna o cromossomo.
 * Recebe uma lista de cromossomo (populacao).
 * @param listaDeCromossomo
 * @param c
 * @return
 */
	public static Cromossomo clone(ArrayList<Cromossomo> listaDeCromossomo, Cromossomo c) {
		Cromossomo original = null;
		for (Cromossomo cromossomo : listaDeCromossomo) {
			if(c.UID().hashCode() == cromossomo.UID().hashCode()) {
				original = cromossomo;
				break;
			}
		}
		return original;
	}
	
	
	public static boolean comparaGens(Gen[][] g1, Gen[][] g2) {
		boolean comparacao = true;
		int g1Aulas = g1.length;
		int g1dias = g1[0].length;
		int g2Aulas = g2.length;
		int g2dias = g2[0].length;
		if(g1Aulas == g2Aulas && g1dias == g2dias) {
			for (int i = 0; i < g1Aulas; i++) {
				for (int j = 0; j < g1dias; j++) {
					if(g1[i][j].UID() != g2[i][j].UID()) {
						comparacao = false;
						break;
					}
				}
			}
		}
		return comparacao;
	}	
}