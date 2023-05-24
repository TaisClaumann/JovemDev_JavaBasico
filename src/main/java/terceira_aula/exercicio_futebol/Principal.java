package terceira_aula.exercicio_futebol;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {

		List<Time> times = new ArrayList<Time>();
		String continuar ="";
		int opcao =0;
		
		do {
			
			String menu = Util.imprimeMenu();
			opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			switch (opcao) {
			case 1:
					Time time = new Time();
					time.cadastroTime();
					times.add(time);
				break;
			case 2:
				JOptionPane.showMessageDialog(null, Util.listaJogadoresTime(times));
				break;
			case 3:
				JOptionPane.showMessageDialog(null, Util.verificaArtilheiro(times));
				break;	
			case 4:
				JOptionPane.showMessageDialog(null, Util.verificaTimeMaiorGol(times));
				break;
			}
			
		}while(opcao!=5);
		
		
		
	}

}
