package terceira_aula.exercicio_livro;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import lombok.Getter;

@Getter
public class Livro {

	private String titulo;
	private double preco;
	List<Autor> autores = new ArrayList<Autor>();
	
	public void cadastraLivro(List<Autor> todosAltores) {
		do {
			titulo = JOptionPane.showInputDialog("Informe o título").toLowerCase();
			preco = Double.parseDouble(JOptionPane.showInputDialog("Informe o preço"));
			int contador =0;
			String continuar="";
			adicionaAutor(todosAltores);
			valida();
		}while(valida()==false);
	}
	
	public boolean valida() {
		boolean cadValido = true;
		
		if(preco<=0) {
			cadValido = false;
			JOptionPane.showMessageDialog(null, "O preço precisa ser maior que 0");
		} else if(titulo.equals("")) {
			cadValido = false;
			JOptionPane.showMessageDialog(null, "O nome do livro deve ser preenchido");
		}
		
		return cadValido;
	}
	
	public List<Autor> adicionaAutor(List<Autor> todosAutores){
		int contador=0;
		String continuar="";
		
		do {
			String menu = Util.imprimeMenu();
			autores.add(Util.escolheAutor(todosAutores));
			continuar = JOptionPane.showInputDialog("Deseja cadastrar mais algum autor?");
			contador++;
		}while(continuar.equalsIgnoreCase("sim") && contador<=4);
		
		return autores;
	}
	
	public String getAutor() {
		String listaAutor ="";
		
		for (Autor autor : autores) {
			listaAutor += autor.toString();
		}
		
		return listaAutor;
	}
	
	public boolean temAutor(Autor autor) {
		return this.autores.contains(autor);
	}
	
	public static Autor buscaAutorPorNome(List<Autor> todosAutores, String nome) {
		Autor autorSelect = new Autor();
		
		for (Autor autor : todosAutores) {
			if(nome.equalsIgnoreCase(autor.getNome())) {
				autorSelect = autor;
			}
		}
	
		return autorSelect;
	}
	
	public static boolean temAutorCrianca(List<Autor> todosAutores) {
		boolean temCrianca = false;
		
		for (Autor autor : todosAutores) {
			if(autor.getIdade()<=12) {
				temCrianca = true;
			}
		}
		
		return temCrianca;
	}
	
	public String toString() {
		String mensagem ="Livro: "+titulo+"  Preço: R$"+String.format("%.2f", preco)+"\n";
		return mensagem;
	}
}
