package terceira_aula.exercicio_livro;

import javax.swing.JOptionPane;

import lombok.Getter;

@Getter
public class Autor {
	
	private String nome;
	private Sexo enumSexo;
	private int idade;
	
	public void cadastraAutor() {
		nome = JOptionPane.showInputDialog("Informe o nome do autor");
		idade = Integer.parseInt(JOptionPane.showInputDialog("Informe a idade"));
		enumSexo = Util.escolheCor();
	}
	
	public String toString() {
		String mensagem ="Nome: "+nome+"  Sexo: "+enumSexo+"  Idade: "+idade;
		return mensagem;
	}

}
