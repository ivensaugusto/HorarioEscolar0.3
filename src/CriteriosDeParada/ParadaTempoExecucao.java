package CriteriosDeParada;

import java.time.Duration;
import java.time.Instant;

import Geral.Configuracao;

public final class ParadaTempoExecucao implements CriteriosParada{

	@Override
	public boolean parar(Configuracao configuracao, ValoresDeParada valoresDeParada){
		Instant tempoFinal = Instant.now();
		Duration tempoDecorrido = Duration.between(valoresDeParada.tempoInicial, tempoFinal);
		return configuracao.getTempoMax().getSeconds() <= tempoDecorrido.getSeconds();
	}

}
