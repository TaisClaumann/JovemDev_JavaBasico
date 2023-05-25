package terceira_aula.exercicio_livro;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Util {
	
	public static String imprimeMenu() {
		String menu= "**Menu de Opções**"+"\n"
				   + "1 - Cadastrar Autor"+"\n"
				   + "2 - Cadastrar Livros"+"\n"
				   + "3 - Listar Livros Cadastrados"+"\n"
				   + "4 - Pesquisar por autor"+"\n"
				   + "5 - Pesquisar por valor"+"\n"
				   + "6 - Listar livros cujos altores tenham crianças"+"\n"
				   + "7 - Listar livros pelo gênero do autor"+"\n"
				   + "8 - Sair";
		
		return menu;
	}
	
	public static Sexo escolheCor() {
		String menu = "Informe o sexo\n\n";
		
		for (Sexo tipoSexo : Sexo.values()) {
			menu += tipoSexo.getCodigo()+" - "+tipoSexo.getDescrição()+"\n";
		}
		
		int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
		Sexo sexo = Sexo.findById(opcao);
		
		return sexo;
	}
	
	public static void cadastraAutor(List<Autor> autores) {
		String continuar = "";

		do {
			Autor autor = new Autor();
			autor.cadastraAutor();
			autores.add(autor);
			continuar = JOptionPane.showInputDialog("Deseja continuar?");
		} while (continuar.equalsIgnoreCase("sim"));
	}
	
	public static Autor escolheAutor(List<Autor> autores, String menu) {
		Autor autor = new Autor();
		Autor autorEscolhido = new Autor();
		String pergAutor = JOptionPane.showInputDialog(menu);
		
		if(pergAutor.equalsIgnoreCase(autor.getNome())) {
			autorEscolhido = autor;
		}
		
		return autorEscolhido;
	}
	
	public static String menuAutor(List<Autor> autores) {
		String menu = "Informe o Autor\n";

		for (Autor autor : autores) {
			menu += "- " + autor.getNome() + "\n";
		}
		
		return menu;
	}
	
	public static void cadastraLivro(List<Livro> livros) {
		String continuar = "";
		
		do {
			Livro livro = new Livro();
			livro.cadastraLivro();
			livros.add(livro);
			continuar = JOptionPane.showInputDialog("Deseja continuar?");
		}while(continuar.equalsIgnoreCase("sim"));
		
	}
	
	public static String listaLivros(ArrayList<Livro> livros) {
		String resposta ="";
		
		for (Livro livro : livros) {
			resposta += livro.toString() + livro.getAutor()+"\n";
		}
		
		return resposta;
	}

}
