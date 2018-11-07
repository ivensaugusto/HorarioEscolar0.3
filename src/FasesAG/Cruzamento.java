package FasesAG;
import java.util.Random;

import Geral.Cromossomo;
import Geral.Slot;

public class Cruzamento {
	/**
	 * Recebe dois cromossomos pais e gera dois novos filhos atrav�z da troca de gens entre os iniciais.
	 * Cada filho � um espelho do outro.
	 * @param pai1
	 * @param pai2
	 * @return
	 */
	public static Cromossomo[] mascara(Cromossomo pai1, Cromossomo pai2) {
		Random rnd = new Random();
		int aulas = pai1.getHorario().getAulas();
		int dias = pai1.getHorario().getDias();
		Slot[][] slotsFilho1 = new Slot[aulas][dias];
		Slot[][] slotsFilho2 = new Slot[aulas][dias];
		for (int i = 0; i < aulas; i++) {
			for (int j = 0; j < dias; j++) {
				if (rnd.nextInt(2) == 0) {
					slotsFilho1[i][j] = pai1.getSlot(i,j);
					slotsFilho2[i][j] = pai2.getSlot(i,j);
				}else {
					slotsFilho1[i][j] = pai2.getSlot(i,j);
					slotsFilho2[i][j] = pai1.getSlot(i,j);
				}
			}
		}
		// A avaliacao foi retirada para melhoria de desempenho, sera feita 
		// no processo de mutacao.		
		Cromossomo filho1 = new Cromossomo(slotsFilho1, pai1.getHorario());
		Cromossomo filho2 = new Cromossomo(slotsFilho2, pai2.getHorario());
		Cromossomo[] filhos = new Cromossomo[] { filho1, filho2 };

		//		System.out.println("na Cruzamento:\n");
		//		System.out.println(filho1);
		//		System.out.println(filho2);
		return filhos ;
	}
	/**
	 * TODO:
	 * Escolher e implementar novo metodo de cruzamento que garanta a cria��o de filhos validos.
	 * @param pai1
	 * @param pai2
	 * @return lista filhos contendo dois cromossomos.
	 */
	public static Cromossomo[] novoCruzamento(Cromossomo pai1, Cromossomo pai2) {
		// TODO: Escolher e implementar novo metodo de cruzamento que garanta a cria��o de filhos validos.
		return null;
	}

}