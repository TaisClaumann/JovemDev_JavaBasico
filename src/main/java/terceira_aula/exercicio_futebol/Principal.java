package terceira_aula.exercicio_futebol;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {

		String menu = Util.imprimeMenu();
		int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
		
		switch (opcao) {
		case 1:
			Time time = new Time();
			time.cadastroTime();
			
			
			break;
		case 2:
			break;
		case 3:
			break;	
		case 4:
			break;
		case 5:
			break;
		default:
			break;
		}
		
	}

}
