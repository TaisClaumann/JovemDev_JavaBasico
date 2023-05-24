package terceira_aula.exercicio_futebol;

import javax.swing.JOptionPane;

public class Util {
	
	
	public static String imprimeMenu() {
		String menu = "1 - Cadastrar Times" + "\n"
					+ "2 - Listar todos os jogadores de um time"+"n"
					+ "3 - Verificar artilheiro do campeonato"+"n"
					+ "4 - Verificar qual time que fez mais gols no campeonato"+"\n"
					+ "5 - Sair";
		
		return menu;
	}
	
	public static void armazenaTime() {
		Time time = new Time();
	}

}
