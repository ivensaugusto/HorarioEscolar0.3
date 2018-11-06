package Geral;
import java.util.Arrays;

public class QuadroHorario {
	private Disciplina[][] horario;
	private int dias;
	private int aulas;
	private int diaQuinzenal;
	private int aulaQuinzenal;
	private int quinzenais;
	
	public QuadroHorario(int aulas, int dias) {
		this.horario = new Disciplina[aulas][dias];
		this.dias = dias;
		this.aulas = aulas;
		this.aulaQuinzenal = 0;// TODO implementar entrada de dados para quantidade de aulas quinzenais
		this.diaQuinzenal = 2; // e para indicar quais ser�o os slot delas.
		this.quinzenais = 1; 
	}
	
	public int getTotalSlots() {
		return this.aulas*this.dias; 
	}

	public void setHorario(Disciplina[][] horario) {
		this.horario = horario;
	}
	
	public Disciplina[][] getHorario() {
		return horario;
	}

	public int getDias() {
		return dias;
	}

	public int getQuinzenais() {
		return quinzenais;
	}

	public void setQuinzenais(int quinzenais) {
		this.quinzenais = quinzenais;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public int getAulas() {
		return aulas;
	}

	public void setAulas(int aulas) {
		this.aulas = aulas;
	}
	
	public int getDiaQuinzenal() {
		return diaQuinzenal;
	}

	public void setDiaQuinzenal(int diaQuinzenal) {
		this.diaQuinzenal = diaQuinzenal;
	}

	public int getAulaQuinzenal() {
		return aulaQuinzenal;
	}

	public void setAulaQuinzenal(int aulaQuinzenal) {
		this.aulaQuinzenal = aulaQuinzenal;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Horario [horario=");
		builder.append(Arrays.toString(horario));
		builder.append(", dias=");
		builder.append(dias);
		builder.append(", aulas=");
		builder.append(aulas);
		builder.append("]");
		return builder.toString();
	}

	
}
