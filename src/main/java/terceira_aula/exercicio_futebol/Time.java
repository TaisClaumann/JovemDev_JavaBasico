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
			jog.cadastraJogador();
			jogadores.add(jog);
			continuar = JOptionPane.showInputDialog("Deseja continuar?");
		}while(continuar.equalsIgnoreCase("sim"));
	}
}
