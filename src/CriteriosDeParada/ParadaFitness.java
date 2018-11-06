package CriteriosDeParada;

import Geral.Configuracao;

public final class ParadaFitness implements CriteriosParada {

	@Override
	public boolean parar(Configuracao configuracao, ValoresDeParada valoresDeParada){
		return	(configuracao.getFitnessAlvo() >= valoresDeParada.fitAtual);

	}

}
