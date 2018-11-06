package Geral;
public class Disciplina {
	private String nome;
	private String professor;
	private String periodo;  // TODO implementar para n�o cruzar periodos diferentes. 
	private int cargaHoraria;
	
	public Disciplina(String nome, String professor,  String periodo, int cargaHoraria) {
		super();
		this.nome = nome;
		this.professor = professor;
		this.periodo = periodo;
		this.cargaHoraria = cargaHoraria;
	}
	
	public String toString2() {
		String s = this.nome + "," + this.professor + "," + this.periodo + "," + this.cargaHoraria;		
		return s;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	@Override
	public String toString() {
		String s = "Nome: " + this.nome + "   "
		+ "Professor: " + this.professor + "\n"
		+ "Periodo: " + this.periodo + "  "
		+ "Carga horaria: " + this.cargaHoraria;
		return s;
	}

	public int getTotalIteracoesGeniado() {
		return this.cargaHoraria / 30;
	}
	public int getTotalIteracoes() {
		return this.cargaHoraria / 15;
	}

	@Override
	public boolean equals(Object obj) {
		boolean igual = false;

		if(obj != null && obj.getClass() == this.getClass()) {
			if(((Disciplina)obj).nome.equals(this.nome))
				igual=true;
		}

		return igual;
	}
}