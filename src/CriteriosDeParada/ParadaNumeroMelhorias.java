package CriteriosDeParada;

import Geral.Configuracao;

public class ParadaNumeroMelhorias implements CriteriosParada {

	@Override
	public boolean parar(Configuracao configuracao, ValoresDeParada valoresDeParada) {
		return (configuracao.getMaximoMelhorias() <= valoresDeParada.contMelhorias);
	}

}
