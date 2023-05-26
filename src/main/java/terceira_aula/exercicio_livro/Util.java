package terceira_aula.exercicio_livro;

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
	
	public static Sexo escolheSexo() {
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
	
	public static Autor escolheAutor(List<Autor> autores) {
		String menu = menuAutor(autores);
		String pergAutor = JOptionPane.showInputDialog(menu);
		Autor autorEscolhido = new Autor();
		
		for (Autor autor : autores) {
			if(pergAutor.equalsIgnoreCase(autor.getNome())) {
				autorEscolhido = autor;
			}
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
	
	public static void cadastraLivro(List<Livro> livros, List<Autor> autores) {
		String continuar = "";
		
		do {
			Livro livro = new Livro();
			livro.cadastraLivro(autores);
			livros.add(livro);	
			continuar = JOptionPane.showInputDialog("Deseja cadastrar outro livro?");
		}while(continuar.equalsIgnoreCase("sim"));
	}
	
	public static String listaLivros(List<Livro> livros) {
		String resposta =""; 
		
		for (Livro livro : livros) {
			resposta += livro.toString() + livro.getAutor()+"\n";
		}
		
		return resposta;
	}
	
	public static String buscaLivroPorAutor(List<Autor> autores, List<Livro> livros) {
		Autor autorEscolhido = Livro.buscaAutorPorNome(autores, JOptionPane.showInputDialog(menuAutor(autores)));
		String resposta = "";
		
		for (Livro livro : livros) {
			if(livro.temAutor(autorEscolhido)) {
				resposta += autorEscolhido.getNome()+"\n"+livro.toString();
			}
		}
		
		return resposta;
	}
	
	public static String buscaLivroPorPreco(List<Livro> livros) {
		double valorMin = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor mínimo"));
		double valorMax = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor maximo"));
		String resposta = "";
		
		for (Livro livro : livros) {
			if(livro.getPreco()>=valorMin && livro.getPreco()<=valorMax) {
				resposta += livro.toString();
			}
		}
		
		return resposta;
	}
	
	public static String buscaLivroAutorCrianca(List<Livro> livros) {
		String resposta = "";
		
		for (Livro livro : livros) {
			if(livro.temAutorCrianca()==true) {
				resposta += livro.getAutor()+"\n"+livro.toString();
			}
		}
		
		return resposta;
	}
	
	public static String buscaLivroGeneroAutor(List<Autor> autores, List<Livro> livros) {
		Sexo sexo = escolheSexo();
		Autor autorEscolhido = new Autor();
		String listaLivro = "";
		
		for (Autor autor : autores) {
			if(autor.getEnumSexo()==sexo) {
				autorEscolhido = autor;
				
				for (Livro livro : livros) {
					if(livro.temAutor(autorEscolhido)) {
						listaLivro+= autorEscolhido.toString()+"\n"+livro.toString();
					}
				}
			}
		}
		
		return listaLivro;
	}
}
