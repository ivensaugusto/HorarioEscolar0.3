package Principal;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import CriteriosDeParada.*;
import FasesAG.*;
import Geral.Configuracao;
import Geral.Cromossomo;
import Geral.Preferencia;

public class AG {
	public static void executarAG() {
		CriteriosParada criterio = new ParadaTodosCriterios();
		ValoresDeParada valoresDeParada = new ValoresDeParada();
		///variaveis de controle /////
		int contClones = 0, contMutacoes = 0;
		String saidaResultados = "", auxSaidaMutacao="", saidaMutacao = "",
				saidaClone = "", saidaMelhoria = "";
		boolean mutante = false;
		Cromossomo aux = null;
		valoresDeParada.tempoInicial = Instant.now();
		Duration duracao = null;
		ArrayList<Cromossomo> lc;
		///////////////////////

		System.out.println("Carregando preferencias...");
		ArrayList<Preferencia> lp = Preferencia.carregaListaPref(Principal.quadroHorario);
		
		System.out.println("Executando AG...");
		Populacao p = new Populacao(Principal.quadroHorario);				

		System.out.println("Criando populacao...");
		lc = p.criar(lp, Principal.configuracao.getPopulacao());

		System.out.println("Inicio do AG em:\n" + valoresDeParada.tempoInicial);
		do {
			valoresDeParada.contCiclos++;
			Cromossomo pai1 = Selecao.torneio(lc, Principal.configuracao.getnParticipantes());
			Cromossomo pai2 = Selecao.torneio(lc, Principal.configuracao.getnParticipantes());
			Cromossomo[] filhos = Cruzamento.novoCruzamento(pai1, pai2);
			for (Cromossomo cromossomo : filhos) {
				auxSaidaMutacao = cromossomo.toString();
				mutante = Mutacao.mutar(lp, cromossomo, Principal.configuracao.getProbMutacao(), 
						Principal.configuracao.getnGensMutados());
				if (mutante) {
					contMutacoes++;
					duracao = Duration.between(valoresDeParada.tempoInicial, Instant.now());
					saidaMutacao += concatMutacao(auxSaidaMutacao, cromossomo, duracao);
				}
				
				aux = Deteccao.clone(lc, cromossomo);
				if (aux == null) {
					Avaliacao.Gens(cromossomo);
					Reinsercao.maiorFit(lc, cromossomo);
				} else{
					contClones++;
					duracao = Duration.between(valoresDeParada.tempoInicial, Instant.now());
					saidaClone += concatClones(aux, cromossomo, duracao);
					
				}
				aux = null;
				aux = p.achaMenor(lc);
				if(aux.getFitness() < valoresDeParada.fitAtual) {
					valoresDeParada.fitAtual = aux.getFitness();
					valoresDeParada.contMelhorias++;
					duracao = Duration.between(valoresDeParada.tempoInicial, Instant.now());
					saidaMelhoria += concatMelhorias(aux, duracao);
					System.out.println("Ocorreu uma melhoria " + duracao);
				}

				//Controle.msgAtividade(valoresDeParada.tempoInicial);
			}
		}while(!criterio.parar(Principal.configuracao, valoresDeParada));

		System.out.print("\n");
		Instant tempoFinal = Instant.now();
		ArrayList<Cromossomo> nl = new ArrayList<Cromossomo>();
		nl = Reinsercao.listaResultados(lc, valoresDeParada.fitAtual);
		saidaResultados += "Resultados:\n\n";
		saidaResultados += nl.toString() + "\n\n";

		String resumo = preparaResumoLog(valoresDeParada.contCiclos, nl.size(), valoresDeParada.fitAtual, contClones,
				contMutacoes, valoresDeParada.tempoInicial, tempoFinal, valoresDeParada.contMelhorias);

		System.out.println(saidaResultados + resumo);

		Log("populacao.txt", p.toString() + resumo);
		Log("mutacoes.txt", saidaMutacao + resumo);
		Log("clones.txt", saidaClone + resumo);
		Log("melhorias.txt", saidaMelhoria + resumo);
		Log("resultados.txt", saidaResultados + resumo);

	}


	public static void executarAGcomMascara() {
			CriteriosParada criterio = new ParadaTodosCriterios();
			ValoresDeParada valoresDeParada = new ValoresDeParada();
			///variaveis de controle /////
			int contClones = 0, contMutacoes = 0;
			String saidaResultados = "", auxSaidaMutacao="", saidaMutacao = "",
					saidaClone = "", saidaMelhoria = "";
			boolean mutante = false;
			Cromossomo aux = null;
			valoresDeParada.tempoInicial = Instant.now();
			Duration duracao = null;
			ArrayList<Cromossomo> lc;
			///////////////////////

			System.out.println("Carregando preferencias...");
			ArrayList<Preferencia> lp = Preferencia.carregaListaPref(Principal.quadroHorario);
			
			System.out.println("Executando AG...");
			Populacao p = new Populacao(Principal.quadroHorario);				

			System.out.println("Criando populacao...");
			lc = p.criar(lp, Principal.configuracao.getPopulacao());

			System.out.println("Inicio do AG em:\n" + valoresDeParada.tempoInicial);
			do {
				valoresDeParada.contCiclos++;
				Cromossomo pai1 = Selecao.torneio(lc, Principal.configuracao.getnParticipantes());
				Cromossomo pai2 = Selecao.torneio(lc, Principal.configuracao.getnParticipantes());
				Cromossomo[] filhos = Cruzamento.mascara(pai1, pai2);
				for (Cromossomo cromossomo : filhos) {
					auxSaidaMutacao = cromossomo.toString();
					mutante = Mutacao.mutar(lp, cromossomo, Principal.configuracao.getProbMutacao(), 
							Principal.configuracao.getnGensMutados());
					if (mutante) {
						contMutacoes++;
						duracao = Duration.between(valoresDeParada.tempoInicial, Instant.now());
						saidaMutacao += concatMutacao(auxSaidaMutacao, cromossomo, duracao);
					}
					
					aux = Deteccao.clone(lc, cromossomo);
					if (aux == null) {
						Avaliacao.Gens(cromossomo);
						Reinsercao.maiorFit(lc, cromossomo);
					} else{
						contClones++;
						duracao = Duration.between(valoresDeParada.tempoInicial, Instant.now());
						saidaClone += concatClones(aux, cromossomo, duracao);
						
					}
					aux = null;
					aux = p.achaMenor(lc);
					if(aux.getFitness() < valoresDeParada.fitAtual) {
						valoresDeParada.fitAtual = aux.getFitness();
						valoresDeParada.contMelhorias++;
						duracao = Duration.between(valoresDeParada.tempoInicial, Instant.now());
						saidaMelhoria += concatMelhorias(aux, duracao);
						System.out.println("Ocorreu uma melhoria " + duracao);
					}

					//Controle.msgAtividade(valoresDeParada.tempoInicial);
				}
			}while(!criterio.parar(Principal.configuracao, valoresDeParada));

			System.out.print("\n");
			Instant tempoFinal = Instant.now();
			ArrayList<Cromossomo> nl = new ArrayList<Cromossomo>();
			nl = Reinsercao.listaResultados(lc, valoresDeParada.fitAtual);
			saidaResultados += "Resultados:\n\n";
			saidaResultados += nl.toString() + "\n\n";
			String resumo = preparaResumoLog(valoresDeParada.contCiclos, nl.size(), valoresDeParada.fitAtual, contClones,
					contMutacoes, valoresDeParada.tempoInicial, tempoFinal, valoresDeParada.contMelhorias);
			System.out.println(saidaResultados + resumo);
			Log("mascara-populacao.txt", p.toString() + resumo);
			Log("mascara-mutacoes.txt", saidaMutacao + resumo);
			Log("mascara-clones.txt", saidaClone + resumo);
			Log("mascara-melhorias.txt", saidaMelhoria + resumo);
			Log("mascara-resultados.txt", saidaResultados + resumo);
		}

	public static void Log(String nomeArq, String conteudo) {
		long instante = Instant.now().toEpochMilli();
		String nome = Configuracao.CAMINHO_DIR + "log-"+ instante + "-"+ nomeArq;
		//String nome = Paths.get(Configuracao.CAMINHO_DIR, "log-"+ instante + "-"+ nomeArq).toUri().toString();
		//System.out.println(nome);
		Controle.salvar(nome, conteudo);
	}

	public static String preparaResumoLog(int contCiclos, int qntResultados, int melhorFitness, int contClones,
			int contMutacoes, Instant tempoInicial, Instant tempoFinal, int contMelhorias) {
		Duration duracao = Duration.between(tempoInicial, tempoFinal);		
		String resumo = "\n" + Principal.configuracao + "\n";
		resumo += "\nResumo:\n";			
		resumo += "Quantidade de ciclos: " + contCiclos + "\n";
		resumo += "Quantidade de resultados: " + qntResultados + "\n";
		resumo += "Quantidade de melhorias: " + contMelhorias + "\n";
		resumo += "Melhor fitness: " + melhorFitness + "\n";
		resumo += "Foram detectados " + contClones + " clones.\n";
		resumo += "Foram detectadas " + contMutacoes + " mutacoes.\n";
		resumo += "Tempo Inicial " + tempoInicial + "\n";
		resumo += "Tempo Final " + tempoFinal + "\n";
		resumo += "Duracao: " + duracao + "";
		return resumo;	
	}

	public static String concatMutacao(String antes, Cromossomo depois, Duration tempogasto) {
		String saida = "Ocorreu uma mutacao apos " + tempogasto + " tempo\n";
		saida += "\nde:\n" + antes;
		saida += "\npara:\n" + depois;
		return saida;
	}

	public static String concatClones(Cromossomo antes, Cromossomo depois, Duration tempogasto) {
		String saida = "Encontrou um clone apos " + tempogasto + " tempo\n";
		saida += "\nde:\n" + antes;
		saida += "\npara:\n" + depois;
		return saida;
	}

	public static String concatMelhorias(Cromossomo depois, Duration tempogasto) {
		String saida = "Encontrou uma melhoria apos " + tempogasto + " tempo\n";
		saida += "" + depois;
		return saida;
	}
}
