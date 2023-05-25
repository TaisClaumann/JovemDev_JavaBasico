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
	
	public void cadastraLivro() {
		do {
			titulo = JOptionPane.showInputDialog("Informe o título");
			preco = Double.parseDouble(JOptionPane.showInputDialog("Informe o preço"));
			adicionaAutor();
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
	
	public List<Autor> adicionaAutor(){
		int contador=0;
		String continuar="";
		
		do {
			String menu = Util.imprimeMenu();
			autores.add(Util.escolheAutor(autores, menu));
			continuar = JOptionPane.showInputDialog("Deseja continuar");
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
	
	public String toString() {
		String mensagem ="Título: "+titulo+"  Preço: R$"+String.format("%.2f", preco)+"\n";
		return mensagem;
	}
}
