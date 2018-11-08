package Geral;

import java.time.Duration;

public class Configuracao {
	public static final int VALOR_SLOT_DEFEITUOSO = 9999;
	public static final String CAMINHO_DIR = "./Log/";
	private int ProbMutacao;
	private int nGensMutados;
	private int nParticipantes;
	private int populacao;
	private int maxCiclos;
	private Duration tempoMax;
	private int fitnessAlvo;
	private int maximoMelhorias;

	public Configuracao() {
		super();
		this.ProbMutacao = 1;
		this.nGensMutados = 1;
		this.nParticipantes = 32;
		this.populacao = 200;
		this.maxCiclos = 2000000;
		this.tempoMax = Duration.ofMinutes(5);
		this.fitnessAlvo = 19;
		this.maximoMelhorias = 100;
	}

	public Configuracao(int fitnessAuxiliar, int probMutacao, int nGensMutados, 
			int nParticipantes, int populacao, int maxCiclos, int fitnessAlvo) {
		this();
		this.ProbMutacao = probMutacao;
		this.nGensMutados = nGensMutados;
		this.nParticipantes = nParticipantes;
		this.populacao = populacao;
		this.maxCiclos = maxCiclos;
		this.fitnessAlvo = fitnessAlvo;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Configuracao:\n");
		builder.append("ProbMutacao=");
		builder.append(ProbMutacao);
		builder.append(", nGensMutados=");
		builder.append(nGensMutados);
		builder.append(",\nnParticipantes=");
		builder.append(nParticipantes);
		builder.append(", populacao=");
		builder.append(populacao);
		builder.append(",\nmaxCiclos=");
		builder.append(maxCiclos);
		builder.append(", maximoMelhorias=");
		builder.append(maximoMelhorias);
		builder.append(",\ntempoMax=");
		builder.append(tempoMax.toMinutes());
		builder.append(", fitnessAlvo=");
		builder.append(fitnessAlvo);
		return builder.toString();
	}
	

	public int getProbMutacao() {
		return ProbMutacao;
	}
	public void setProbMutacao(int probMutacao) {
		this.ProbMutacao = probMutacao;
		if(probMutacao > 100) { //Deveria lancar uma mgs de erro?
			this.ProbMutacao = 100;
		}
	}
	public int getnGensMutados() {
		return nGensMutados;
	}
	public void setnGensMutados(int nGensMutados) {
		this.nGensMutados = nGensMutados;
	}

	public Duration getTempoMax() {
		return tempoMax;
	}

	public void setTempoMax(Duration tempoMax) {
		this.tempoMax = tempoMax;
	}

	public int getnParticipantes() {
		return nParticipantes;
	}
	public void setnParticipantes(int nParticipantes) {
		this.nParticipantes = nParticipantes;
		if(nParticipantes > this.populacao) {
			this.nParticipantes = this.populacao;
		}
	}
	public int getPopulacao() {
		return populacao;
	}
	public void setPopulacao(int populacao) {
		this.populacao = populacao;
	}
	public int getMaxCiclos() {
		return maxCiclos;
	}
	public void setMaxCiclos(int maxCiclos) {
		this.maxCiclos = maxCiclos;
	}
	public int getFitnessAlvo() {
		return fitnessAlvo;
	}
	public void setMaximoMelhorias(int maximoMelhorias) {
		this.maximoMelhorias= maximoMelhorias;
	}
	public int getMaximoMelhorias() {
		return maximoMelhorias;
	}
	public void setFitnessAlvo(int fitnessAlvo) {
		this.fitnessAlvo = fitnessAlvo;
	}
}