package terceira_aula.exercicio_livro;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import lombok.Getter;

@Getter
public class Livro {

	private String titulo;
	private double preco;
	private List<Autor> autores = new ArrayList<Autor>();
	
	public void cadastraLivro(List<Autor> todosAltores) {
		boolean validaPreco = true;
		
		do {
			titulo = JOptionPane.showInputDialog("Informe o título").toLowerCase();
			try {
				preco = Double.parseDouble(JOptionPane.showInputDialog("Informe o preço"));
			} catch (Exception e) {
				validaPreco = false;
			}
			adicionaAutor(todosAltores);
		}while(valida()==false && validaPreco==false);
	}
	
	public boolean valida() {
		boolean cadValido = true;
		
		if(preco<=0) {
			cadValido = false;
			JOptionPane.showMessageDialog(null, "O preço precisa ser maior que R$0,00");
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
	
	public boolean temAutorCrianca() {
		boolean temCrianca = false;
		
		for (Autor autor : autores ) {
			if(autor.getIdade()<=12) {
				temCrianca = true;
			}
		}
		
		return temCrianca;
	}
	
	public boolean temAutorDoGenero(Sexo sexo) {
		boolean temAutor = false;
		
		for (Autor autor : autores) {
			if(autor.getEnumSexo()==sexo) {
				temAutor = true;
			}
		}
		
		return temAutor;
	}
	
	public String toString() {
		String mensagem ="Livro: "+titulo+"  Preço: R$"+String.format("%.2f", preco)+"\n";
		return mensagem;
	}
}
