package Principal;
import Geral.Configuracao;
import Geral.QuadroHorario;

public class Principal {
	
	static Configuracao configuracao;
	static QuadroHorario quadroHorario;
	
	public static void main(String[] args) {
		configuracao = new Configuracao();
		quadroHorario = new QuadroHorario(4,5);
		boolean fim = false;
		int opcaoGeral = -1;
		
		for (int i = 0; i < 5; i++) {
			AG.executarAG();
		}
		
		
/*
		do {
			opcaoGeral = Visao.menuGeral();
			//int opcaoGeral = 5;
			switch(opcaoGeral) {
			case 1: //Cadastrar disciplina\n
				Controle.cadastrarDisciplina();
				break;
			case 2: //Exibir Disciplinas cadastradas\n
				Controle.exibeDisciplinas();
				break;
			case 3: //Simular prefer�ncias
				Controle.simularPreferencias(quadroHorario);
				break;
			case 4: //Importar respostas
				System.out.println("Em constru��o...\nEstamos trabalhando para servi-lo melhor.\n");
				break;
			case 5://Executar AG
				AG.executarAG();
				break;
			case 0: //Sair
				System.out.println("Programa encerrado.");
				fim = true;
				break;
			default:
				System.err.println("Opcao invalida!");
				break;
			}
		}while(!fim);*/
		
		System.exit(0);
	}
}
