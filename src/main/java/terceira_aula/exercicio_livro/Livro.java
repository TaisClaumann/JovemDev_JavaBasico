package terceira_aula.exercicio_livro;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import lombok.Getter;

@Getter
public class Livro {

	private String titulo;
	private double preco;
	private String autor;
	
	public void cadastraLivro(ArrayList<Autor> autores) {
		titulo = JOptionPane.showInputDialog("Informe o título");
		preco = Double.parseDouble(JOptionPane.showInputDialog("Informe o preço"));
		autor = Util.escolheAutor(autores);
	}
	
	public String toString() {
		String mensagem ="Título: "+titulo+"  Preço: R$"+String.format("%.2f", preco)+"\n";
		return mensagem;
	}
}
