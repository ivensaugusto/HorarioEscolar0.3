package CriteriosDeParada;

import Geral.Configuracao;

public final class ParadaMaximoCiclos implements CriteriosParada{

	@Override
	public boolean parar(Configuracao configuracao, ValoresDeParada valoresDeParada) {
		return (configuracao.getMaxCiclos() <= valoresDeParada.contCiclos);
	}
	
}
