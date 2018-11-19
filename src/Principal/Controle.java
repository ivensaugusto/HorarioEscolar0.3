package Principal;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

import Geral.Cromossomo;
import Geral.Disciplina;
import Geral.QuadroHorario;
import Geral.OrdenaPorFitness;
import Geral.Preferencia;
public class Controle {	
	public static void salvar(String caminho, String texto) {
		FileWriter arquivo;
		BufferedWriter gravador;
		try {
			arquivo = new FileWriter(caminho);//Cria um arquivo.
			gravador = new BufferedWriter(arquivo);//Cria um gravador e carrega o arquivo no buffer dele.
			gravador.write(texto);//Grava o texto informado no arquivo.
			gravador.close();//Fecha gravador.
			arquivo.close();//Fecha arquivo.
		}catch(IOException e) {
			System.out.println("Erro ao salvar arquivo!");//Imprime mensagem de erro.
		}
	}
	public static String carregar(String caminho) {
		//System.out.println("Iniciando carregamento de arquivo...");
		FileReader arquivo;
		BufferedReader leitor;
		String linha = "", texto = "";//Cria as vari√°veis que v√£o receber texto.
		try {
			arquivo = new FileReader(caminho);//Abre um arquivo.
			leitor = new BufferedReader(arquivo);//Criando leitor de arquivo.
			while(linha != null) {//Copia uma linha at√© a linha ser nula(fim).
				linha = leitor.readLine();//Copia uma linha do arquivo para vari√°vel.
				if(linha != null) {
					texto += linha + "\n";
				}				
			}
			leitor.close();//Fecha gravador.
			arquivo.close();//Fecha arquivo.
			//System.out.println("Arquivo carregado na memoria.\n");
		}catch(IOException e) {
			System.out.println("Erro na abertura de arquivo!\n");//Imprime mensagem de erro.			
		}
		return texto;
	}
	public static ArrayList<Disciplina> listaDisciplinas(String texto) {
		String vet1[] = texto.split("\n");
		String vet2[] = null;
		Disciplina d;
		ArrayList<Disciplina> ld = new ArrayList<Disciplina>();
		for(int i = 0; i < vet1.length; i++) {
			vet2 = vet1[i].split(",");
			d = new Disciplina(vet2[0], vet2[1], vet2[2], Integer.valueOf(vet2[3]));
			ld.add(d);
		}
		return ld;
	}

	public static void cadastrarDisciplina() {
		boolean concluido = false;
		boolean sucesso=false;
		int opcaoCadastro;
		Disciplina disc = null;
		do {
			opcaoCadastro = Visao.menuCadastro();
			switch(opcaoCadastro) {
			case 1: // "1) Confirmar\n"
				disc = Visao.obterAtributosDisciplina();
				sucesso = Controle.cadDisciplina(disc);
				if(sucesso)
					System.err.println("Disciplina cadastrada com sucesso.\n");
				else
					System.err.println("Erro durante o cadastrado.\n");
				break;
			case 2: // "2) Alterar\n"
				System.err.println("Cadastre novamente.");
				break;
			case 0: // "0) Cancelar\n";
				System.err.println("Cadastro cancelado.");
				concluido = true;
				break;
			default:
				System.err.println("Opcao invalida!");
				break;
			}
		}while(!concluido);
	}

	public static boolean cadDisciplina(Disciplina disc) {
		String texto = carregar("Disciplinas.txt");
		texto += disc.toString2();
		salvar("Disciplinas.txt", texto);
		return true;
	}

	public static void exibeDisciplinas() {
		StringBuilder sb = new StringBuilder();
		String texto = carregar("Disciplinas.txt");
		ArrayList<Disciplina> listaDisciplina = Controle.listaDisciplinas(texto);
		sb.append("Lista de disciplinas");
		for (Disciplina disciplina : listaDisciplina) {
			sb.append(disciplina);			
			sb.append("\n\n");
		}
		System.out.println(sb.toString());
	}

	public static void simularPreferencias(QuadroHorario quadroHorario) {
		Visao.avisoPerdaArqPreferencias();
		String opcao = Tools.inString("Deseja continuar?(s/n)"); 
		if (opcao.equalsIgnoreCase("S")) {
			int pesoInicial = Tools.inInt("Informe o menor peso:"); 
			int pesoFinal = Tools.inInt("Informe o maior peso:"); 
			Preferencia.criaLista(quadroHorario, pesoInicial, pesoFinal);
		}
	}


	//////   Refatorar   ///////
	public static ArrayList<Preferencia> listaPreferencias(String texto, QuadroHorario h) {
		String vet1[] = texto.split("\n");
		String vet2[] = null;
		String vet3[] = null;
		int[][] pref = null;
		Disciplina d;
		Preferencia p;
		ArrayList<Preferencia> lp = new ArrayList<Preferencia>();

		for(int i = 0; i < vet1.length; i++) {
			vet2 = vet1[i].split(";");
			vet3 = vet2[0].split(",");
			d = new Disciplina(vet3[0], vet3[1], vet3[2], Integer.valueOf(vet3[3]));
			vet3 = vet2[1].split(",");
			pref = new int[vet2.length-1][vet3.length];
			for (int j = 1; j < vet2.length; j++) {
				vet3 = vet2[j].split(",");
				for (int j1 = 0; j1 < vet3.length; j1++) {
					pref[j-1][j1] = Integer.valueOf(vet3[j1]);
				}
			}
			p = new Preferencia(h, d, pref);
			lp.add(p);
		}
		return lp;
	}

	public static ArrayList<Cromossomo> selecionaMelhoresFit(ArrayList<Cromossomo> lc, int fitness) {
		ArrayList<Cromossomo> melhoresFit = new ArrayList<Cromossomo>();
		OrdenaPorFitness crescente = new OrdenaPorFitness();
		Collections.sort(lc, crescente.reversed());
		int i = 0;
		while(lc.get(i).getFitness() < fitness*2) {
			melhoresFit.add(lc.get(i)); 
			i++;
		}
		return melhoresFit;
	}
	public static void msgAtividade_old(Instant tempoInicial) {
		Duration duracao = Duration.between(tempoInicial, Instant.now());
		long intervalo = 10000;
		if((duracao.toMillis()%intervalo) <= 20) {
			System.out.println("...AG em execuÁ„o..." + duracao);
		}		
	}
	
	public static void msgAtividade(long inicioApos, long intervalo) {
		Timer timer = new Timer();
		TimerTask tarefa = new TimerTask() {
			public void run() {
				//mÈtodo
				try {
					System.out.println("...AG em execuÁ„o...");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		timer.scheduleAtFixedRate(tarefa, inicioApos, intervalo);
	}

	
}