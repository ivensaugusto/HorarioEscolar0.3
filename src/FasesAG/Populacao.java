package FasesAG;
import java.util.ArrayList;
import java.util.Collections;

import Geral.Cromossomo;
import Geral.QuadroHorario;
import Geral.OrdenaPorFitness;
import Geral.Preferencia;

public class Populacao {
	ArrayList<Cromossomo> listaCromo;
	private Cromossomo Top1;
	private QuadroHorario QuadroHorario;
	
	public Populacao(QuadroHorario quadroHorario) {
		super();
		this.QuadroHorario = quadroHorario;
	}

	public ArrayList<Cromossomo> criar(ArrayList<Preferencia> lp, int tamanho) {
		QuadroHorario horario = new QuadroHorario(this.QuadroHorario.getAulas(), this.QuadroHorario.getDias());
		this.listaCromo = new ArrayList<Cromossomo>();
		Cromossomo cromo;
		for (int i = 0; i < tamanho; i++) {
			cromo  = new Cromossomo(lp, horario);
			listaCromo.add(cromo);
		}
		setTop1(achaMenor(this.listaCromo));
		return listaCromo;
	}
	
	public Cromossomo achaMenor(ArrayList<Cromossomo> lc) {
		Collections.sort(lc, new OrdenaPorFitness());
		if(lc.isEmpty()) {
			return null;
		}
		return lc.get(0);
	}
	
	public Cromossomo achaMaior(ArrayList<Cromossomo> lc) {
		OrdenaPorFitness crescente = new OrdenaPorFitness();
		Collections.sort(lc, crescente.reversed());
		return lc.get(0);
	}
	public Cromossomo getTop1() {
		return Top1;
	}

	public void setTop1(Cromossomo top1) {
		Top1 = top1;
	}
	public String toString2() {
		StringBuilder builder = new StringBuilder();
		builder.append("Populacao:\n");
		for (Cromossomo c : listaCromo) {
			builder.append("|Fitness|");
			builder.append(c.getFitness());
		}
		builder.append("|");
		return builder.toString();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Populacao:");
		builder.append(listaCromo);
		return builder.toString();
	}

	
	
	
	
	
	
}
