package terceira_aula.exercicio_livro;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		int opcao =0;
		List<Autor> autores = new ArrayList<Autor>();
		List<Livro> livros = new ArrayList<Livro>();
		
		do {
			String menu = Util.imprimeMenu();
			opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			switch (opcao) {
			case 1:
				Util.cadastraAutor(autores);
				break;
			case 2:
				Util.cadastraLivro(livros, autores);
				break;
			case 3:
				JOptionPane.showMessageDialog(null, Util.listaLivros(livros));
				break;
			case 4:
				JOptionPane.showMessageDialog(null, Util.buscaLivroPorAutor(autores, livros));
				break;
			case 5:
				JOptionPane.showMessageDialog(null, Util.buscaLivroPorPreco(livros));
				break;
			case 6:
				JOptionPane.showMessageDialog(null, Util.buscaLivroAutorCrianca(autores, livros));
				break;
			case 7:
				JOptionPane.showMessageDialog(null, Util.buscaLivroGeneroAutor(autores, livros));
				break;
			default:
				break;
			}
			
		}while(opcao != 8);

	}

}
