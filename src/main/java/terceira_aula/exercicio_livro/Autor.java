package terceira_aula.exercicio_livro;

import javax.swing.JOptionPane;

import lombok.Getter;

@Getter
public class Autor {
	
	private String nome;
	private Sexo enumSexo;
	private int idade;
	
	public void cadastraAutor() {
		do {
			nome = JOptionPane.showInputDialog("Informe o nome e o sobrenome do autor");
			idade = Integer.parseInt(JOptionPane.showInputDialog("Informe a idade"));
			enumSexo = Util.escolheCor();
			valida();
		}while(valida()==false);
	}
	
	public boolean valida() {
		boolean valido = true;
		
		if(idade <=0) {
			valido = false;
			JOptionPane.showMessageDialog(null, "A idade precisa ser maior que 0");
		}
		
		return valido;
	}
	
	public String toString() {
		String mensagem ="Nome: "+nome+"  Sexo: "+enumSexo+"  Idade: "+idade;
		return mensagem;
	}

}
