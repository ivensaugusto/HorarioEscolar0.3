package CriteriosDeParada;
import Geral.Configuracao;

public class ParadaTodosCriterios implements CriteriosParada{

	@Override
	public boolean parar(Configuracao configuracao, ValoresDeParada valoresDeParada) {
		CriteriosParada fitness = new ParadaFitness();
		CriteriosParada ciclos = new ParadaMaximoCiclos();
		CriteriosParada melhorias = new ParadaNumeroMelhorias();
		CriteriosParada tempo = new ParadaTempoExecucao();

		
		return melhorias.parar(configuracao, valoresDeParada) 
				|| fitness.parar(configuracao, valoresDeParada)
				|| ciclos.parar(configuracao, valoresDeParada)
				|| tempo.parar(configuracao, valoresDeParada);
	}

}
