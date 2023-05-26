package terceira_aula.exercicio_livro;

import javax.swing.JOptionPane;

import lombok.Getter;

@Getter
public class Autor {
	
	private String nome;
	private Sexo enumSexo;
	private int idade;
	
	public void cadastraAutor() {
		boolean validaIdade = true;
		
		do {
			nome = JOptionPane.showInputDialog("Informe o nome e o sobrenome do autor");
			try {
				idade = Integer.parseInt(JOptionPane.showInputDialog("Informe a idade"));
			} catch (Exception e) {
				validaIdade = false;
			}
			enumSexo = Util.escolheSexo();
		}while(valida()==false || validaIdade==false);
	}
	
	public boolean valida() {
		boolean cadValido = true;
		String palavras[] = nome.trim().split("\\s+");
		
		if(idade <=0) {
			cadValido = false;
			JOptionPane.showMessageDialog(null, "A idade precisa ser maior que 0");
		} else if (palavras.length != 2) {
			cadValido = false;
			JOptionPane.showMessageDialog(null, "O nome precisa ter NOME e SOBRENOME");
		}
		
		return cadValido;
	}
	
	public String toString() {
		String mensagem ="Autor: "+nome+"  Sexo: "+enumSexo.getDescrição()+"  Idade: "+idade+" anos";
		return mensagem;
	}

}
