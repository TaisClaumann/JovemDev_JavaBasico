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
	
	public static String listaJogadoresTime(List<Time> times) {
		String pergTime = JOptionPane.showInputDialog("Informe o time a ser filtrado");
		
		for (Time time : times) {
			if(pergTime.equalsIgnoreCase(time.getNome())) {
				resposta = "";
				
				resposta = time.toString();
				for (Jogador jogador : time.getJogadores()) {
					resposta+= jogador.toString();
				}
			}
		}
		
		return resposta;
	}
	
	public static String verificaArtilheiro(List<Time> times) {
		maiorQuantGols =0;
		
		for (Time time : times) {
			
			for (Jogador jogador : time.getJogadores()) {
				
				if(jogador.getQuantGols()>maiorQuantGols) {
					maiorQuantGols = jogador.getQuantGols();
					resposta = "Artilheiro:\n"+jogador.toString();
				}
			}
		}
		
		return resposta;
	}
	
	public static String verificaTimeMaiorGol(List<Time> times) {
		maiorQuantGols = 0;
		
		for (Time time : times) {
			int totalGols =0;
			
			for (Jogador jog : time.getJogadores()) {
				totalGols += jog.getQuantGols();
			}
			
			if(totalGols>maiorQuantGols) {
				maiorQuantGols = totalGols;
				resposta = "O time com maior qtd de gols: "+time.toString()+ "Total gols: "+maiorQuantGols;
			}
		}
		
		return resposta;
	}

}
