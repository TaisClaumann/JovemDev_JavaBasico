package terceira_aula.exercicio_futebol;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Time {

	private String nome;
	private List<Jogador> jogadores = new ArrayList<Jogador>();
	private Jogador jog;
	
	public void cadastroTime() {
		nome = JOptionPane.showInputDialog("Informe o nome do time");
		String continuar = "";
		
		do {
			jog = new Jogador();
			jog.cadastraJogador();
			jogadores.add(jog);
			continuar = JOptionPane.showInputDialog("Deseja continuar?");
		}while(continuar.equalsIgnoreCase("sim"));
	}
	
	public Jogador getArtilheiro() {
		Jogador artilheiro = jogadores.get(0);
		
		for (Jogador jogador : jogadores) {
			if(jogador.getQuantGols() > artilheiro.getQuantGols()) {
				artilheiro = jogador;
			}
		}
		
		return artilheiro;
	}
	
	public String getJogador() {
		String jog ="";
		
		for (Jogador jogador : jogadores) {
			jog += jogador.toString();
		}
		
		return jog;
	}
	
	public int getSomaGolsJog() {
		int totalGols =0;
		
		for (Jogador jogador : jogadores) {
			totalGols += jogador.getQuantGols();
		}
		
		return totalGols;
	}
	
	public String toString() {
		String mensagem ="Time: "+nome+"\n";
		return mensagem;
	}
}
