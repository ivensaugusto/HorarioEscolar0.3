package FasesAG;
import java.util.Random;

import Geral.Configuracao;
import Geral.Cromossomo;
import Geral.Slot;
import Principal.Tools;
import Geral.Gen;

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
					slotsFilho1[i][j] = pai1.getSlot(i, j);
					slotsFilho2[i][j] = pai2.getSlot(i, j);
				}else {
					slotsFilho1[i][j] = pai2.getSlot(i, j);
					slotsFilho2[i][j] = pai1.getSlot(i, j);
				}
			}
		}
		// A avaliacao foi retirada para melhoria de desempenho, sera feita 
		// no processo de mutacao.		
		Cromossomo filho1 = new Cromossomo(slotsFilho1, pai1, pai2);
		Cromossomo filho2 = new Cromossomo(slotsFilho2, pai2, pai1);
		
		Cromossomo[] filhos = new Cromossomo[] {filho1, filho2};
		
		return filhos ;
	}
	/**
	 * TODO:
	 * Escolher e implementar novo metodo de cruzamento que garanta a cria��o de filhos validos.
	 * @param pai1
	 * @param pai2
	 * @return lista filhos contendo dois cromossomos.
	 */
	public static Cromossomo[] cruzamentoIC(Cromossomo pai1, Cromossomo pai2) {
		// TODO: Escolher e implementar novo metodo de cruzamento que garanta a cria��o de filhos validos.
		Random rnd = new Random();
		int aulas = pai1.getHorario().getAulas();
		int dias = pai1.getHorario().getDias();
		Slot[][] slotsFilho1 = new Slot[aulas][dias];
		Slot[][] slotsFilho2 = new Slot[aulas][dias];
		for (int dia = 0; dia < dias; dia++) {
			for (int aula = 0; aula < aulas; aula += 2) {
				Gen g1 = pai1.getSlot(aula, dia).getGen();
				Gen g2 = pai1.getSlot(aula + 1, dia).getGen();
				Gen g3 = pai2.getSlot(aula, dia).getGen();
				Gen g4 = pai2.getSlot(aula + 1, dia).getGen();
				if (g1.compara(g2) || g3.compara(g4)) {
					slotsFilho1[aula][dia] = pai1.getSlot(aula, dia);
					slotsFilho1[aula + 1][dia] = pai1.getSlot(aula + 1, dia);
					slotsFilho2[aula][dia] = pai2.getSlot(aula, dia);
					slotsFilho2[aula + 1][dia] = pai2.getSlot(aula + 1, dia);
				}else {
					for (int i = 0; i < 2; i++) {
						if (rnd.nextInt(4) == 0) {
							slotsFilho1[aula + i][dia] = pai1.getSlot(aula + i, dia);
							slotsFilho2[aula + i][dia] = pai1.getSlot(aula + i, dia);
						}else if (rnd.nextInt(4) == 1) {
							slotsFilho1[aula + i][dia] = pai1.getSlot(aula + i, dia);
							slotsFilho2[aula + i][dia] = pai2.getSlot(aula + i, dia);
						}else if (rnd.nextInt(4) == 2) {
							slotsFilho1[aula + i][dia] = pai2.getSlot(aula + i, dia);
							slotsFilho2[aula + i][dia] = pai1.getSlot(aula + i, dia);
						}else {
							slotsFilho1[aula + i][dia] = pai2.getSlot(aula + i, dia);
							slotsFilho2[aula + i][dia] = pai2.getSlot(aula + i, dia);
						}
					}
				}
			}
		}
		// A avaliacao foi retirada para melhoria de desempenho, sera feita 
		// apos o processo de mutacao.		
		Cromossomo filho1 = new Cromossomo(slotsFilho1, pai1, pai2);
		Cromossomo filho2 = new Cromossomo(slotsFilho2, pai2, pai1);
		Cromossomo[] filhos = new Cromossomo[] {filho1, filho2};

		//		System.out.println("na Cruzamento:\n");
		//		System.out.println(filho1);
		//		System.out.println(filho2);
		return filhos;
	}
}