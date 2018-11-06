package Principal;

import Geral.Disciplina;

public class Visao {

	public static int menuGeral() {
		String menu = "\nMenu:\n"
				+ "1) Cadastrar disciplina\n"
				+ "2) Exibir disciplinas\n"
				+ "3) Simular preferencias\n"
				+ "4) Importar respostas\n"
				+ "5) Executar AG\n"
				+ "0) Sair\n"
				+ "Escolha uma das opções acima:";
		return Tools.inInt(menu);
	}

	public static int menuCadastro() {
		String menu = "Dados corretos?\n"
				+ "1) Confirmar\n"
				+ "2) Alterar\n"
				+ "0) Cancelar\n"
				+ "Escolha uma das opções acima:";
		return Tools.inInt(menu);
	}

	public static Disciplina obterAtributosDisciplina() {
		String nome = Tools.inString("Nome da disciplina: ");
		String docente = Tools.inString("Nome do docente: ");
		String periodo = Tools.inString("Periodo: ");
		int cargaHoraria = Tools.inInt("Carga Horaria: ");
		System.out.println();
		Visao.confirmarDados(nome, docente, periodo, cargaHoraria);
		return new Disciplina(nome, docente, periodo, cargaHoraria);
	}

	public static void confirmarDados(String nome, String docente, String periodo, int cargaHoraria) {
		String saida = "Dados informados: \n"
				+ "Nome da disciplina: " + nome + "\n"
				+ "Nome do docente: " + docente + "\n"
				+ "Periodo: " + periodo + "\n"
				+ "Carga Horaria: " + cargaHoraria + "\n";
		System.out.println(saida);
	}
	
	public static void avisoPerdaArqPreferencias() {
		System.err.println("Cria um arquivo que contem as preferencias de horario de aulas"
							+ " para cada disciplina cadastrada!\n"
							+ "Esta opção simula as respostas dos professores aos questionados.\n"
							+ "ATENÇÃO! O arquivo anterior (caso exista) será apagado.\n"); 
	}
}
