package Geral;

public class Gen {
	private Object quinzenal;
	private Preferencia preferencia;
	private boolean defeituoso;

	public Gen(Preferencia preferencia) {
		this.preferencia = preferencia;
		this.quinzenal = null;
	}

	public Preferencia getPreferencia() {
		return preferencia;
	}

	public boolean isDefeituoso() {
		return defeituoso;
	}

	public Disciplina getDisciplina() {
		return this.preferencia.getDisciplina();
	}

	public int getPeso(Slot slot) {
		int peso= this.preferencia.getPeso(slot);
		if(this.defeituoso)
			peso += Configuracao.VALOR_SLOT_DEFEITUOSO;

		return peso;
	}

	public Object getQuinzenal() {
		return quinzenal;
	}

	public void setQuinzenal(Object quinzenal) {
		this.quinzenal = quinzenal;
	}

	public String UID() {
		return this.preferencia.getDisciplina().getNome() + "|";
	}

	public void setDefeituoso(boolean defeituoso) {
		this.defeituoso = defeituoso;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getDisciplina().getNome());//		
//		if (this.getPeso() < 10)
//			builder.append(":0");
//		else
//			builder.append(":");
//		builder.append(this.getPeso());
		return builder.toString();
	}
}
