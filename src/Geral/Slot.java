package Geral;

public class Slot {
	public int aula;
	public int dia;
	public boolean quinzenal;
	private Gen gen;

	public Slot(int lin, int col, boolean quinzenal) {
		this(lin,col,  quinzenal, null);

	}
	public Slot(int lin, int col, boolean quinzenal, Gen gen) {
		super();
		this.aula = lin;
		this.dia = col;
		this.quinzenal = quinzenal;
		this.gen = gen;
	}

	public void setGen(Gen gen) {
		this.gen=gen;
	}
	public Gen getGen() {
		return this.gen;
	}

	public boolean disponivel() {
		return this.gen == null;
	}
	
	public int getPeso() {
		int peso = 0;
		if(this.gen == null)
			peso = Configuracao.VALOR_SLOT_DEFEITUOSO;
		else
			peso = this.getGen().getPeso(this);
		
		// TODO: Condições das penalidades do GEN dentro do SLOT
		return peso;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if(this.gen != null) {
			builder.append(this.gen.getDisciplina().getNome());
			builder.append(":");
			builder.append(String.format("%02d", this.gen.getPeso(this)));
		}
		else
		{
			builder.append("   :  ");
		}
		return builder.toString();
	}
	public int getAulasDistribuidas() {
		return this.quinzenal ? 2 : 1;
	}
}