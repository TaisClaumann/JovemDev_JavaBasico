package terceira_aula.exercicio_futebol;

import java.util.List;

import javax.swing.JOptionPane;

import lombok.Getter;

@Getter
public class Util {
	
	private static String resposta ="";
	private static int maiorQuantGols;
	
	public static String imprimeMenu() {
		String menu = "**Menu de Opções**"+"\n"
					+ "1 - Cadastrar Times" + "\n"
					+ "2 - Listar todos os jogadores de um time"+"\n"
					+ "3 - Verificar artilheiro do campeonato"+"\n"
					+ "4 - Verificar qual time que fez mais gols no campeonato"+"\n"
					+ "5 - Sair";
		
		return menu;
	}
	
	public static String listaJogadoresTimes(List<Time> times) {
		String pergTime = JOptionPane.showInputDialog("Informe o time a ser filtrado");
		
		for (Time time : times) {
			if(pergTime.equalsIgnoreCase(time.getNome())) {
				resposta = time.toString()+time.getJogador();
			}
		}
		
		return resposta;
	}
	
	public static String verificaArtilheiro(List<Time> times) {
		resposta ="";
		maiorQuantGols=0;
		
		for (Time time : times) {	
			if(time.getArtilheiro().getQuantGols()>maiorQuantGols) {
				maiorQuantGols = time.getArtilheiro().getQuantGols();
				resposta = time.getArtilheiro().toString();
			}
		}
		
		return resposta;
	}
		
	public static String verificaTimeMaiorGol(List<Time> times) {
		maiorQuantGols=0;
		
		for (Time time : times) {
			if(time.getSomaGolsJog()>maiorQuantGols) {
				maiorQuantGols = time.getSomaGolsJog();
				resposta = "Time com maiores gols: "+time.toString()+"Total Gols: "+maiorQuantGols;
			}
		}
		
		return resposta;
	}

}
