package terceira_aula.exercicio_futebol;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Jogador {
	
	private String nome;
	private int numCamisa;
	private int quantGols;

	public void cadastraJogador() {
			nome = JOptionPane.showInputDialog("Nome do jogador");
			numCamisa = Integer.parseInt(JOptionPane.showInputDialog("Número da camisa"));
			quantGols = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de gols no campeonato"));
	}
	
	public String toString() {
		return "Nome: "+nome+"   Camisa: "+numCamisa+"   Gols: "+quantGols+"\n";
	}
	
}
