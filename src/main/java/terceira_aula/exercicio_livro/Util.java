package terceira_aula.exercicio_livro;

import java.util.ArrayList;

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
	
	public static String escolheAutor(ArrayList<Autor> autores) {
		String menu = "Informe o Autor\n";
		
		for (Autor autor : autores) {
			menu += "- "+autor.getNome()+"\n";
		}
		
		String pergAutor = JOptionPane.showInputDialog(menu);
		return pergAutor;
	}

}
