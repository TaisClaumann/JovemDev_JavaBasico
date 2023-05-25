package terceira_aula.exercicio_livro;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		int opcao =0;
		ArrayList<Autor> autores = new ArrayList<Autor>();
		ArrayList<Livro> livros = new ArrayList<Livro>();
		
		do {
			String menu = Util.imprimeMenu();
			opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			switch (opcao) {
			case 1:
				Util.cadastraAutor(autores);
				break;
			case 2:
				Util.cadastraLivro(livros);
				break;
			case 3:
				JOptionPane.showMessageDialog(null, Util.listaLivros(livros));
				break;
			case 4:

				break;
			case 5:

				break;
			case 6:

				break;
			case 7:

				break;

			default:
				break;
			}
			
		}while(opcao != 8);

	}

}
