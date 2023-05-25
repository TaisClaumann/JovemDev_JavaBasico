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
				Autor autor = new Autor();
				autor.cadastraAutor();
				autores.add(autor);
				break;
			case 2:
				Livro livro = new Livro();
				livro.cadastraLivro(autores);;
				livros.add(livro);
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
