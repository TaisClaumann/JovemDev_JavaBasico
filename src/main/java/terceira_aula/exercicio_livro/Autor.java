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
			enumSexo = Util.escolheSexo();
		}while(valida()==false);
	}
	
	public boolean valida() {
		boolean valido = true;
		String palavras[] = nome.trim().split("\\s+");
		
		if(idade <=0) {
			valido = false;
			JOptionPane.showMessageDialog(null, "A idade precisa ser maior que 0");
		} else if (palavras.length != 2) {
			valido = false;
			JOptionPane.showMessageDialog(null, "O nome precisa ter NOME e SOBRENOME apenas");
		}
		
		return valido;
	}
	
	public String toString() {
		String mensagem ="Autor: "+nome+"  Sexo: "+enumSexo.getDescrição()+"  Idade: "+idade+" anos";
		return mensagem;
	}

}
