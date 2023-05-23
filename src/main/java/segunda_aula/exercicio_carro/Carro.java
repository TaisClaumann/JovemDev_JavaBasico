package segunda_aula.exercicio_carro;

import javax.swing.JOptionPane;

public class Carro {
	
	String marca;
	int ano;
	listaCor cor;
	
	public void cadastraCarro() {
		marca = JOptionPane.showInputDialog("Informe a marca");
		ano = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano"));
		
		String menu = "**Informe o código da cor**\n"+
					  "1 - Vermelho\n"+
					  "2 - Branco";
		
		int opcaoCor = Integer.parseInt(JOptionPane.showInputDialog(menu));
		
		if(opcaoCor==1) {
			cor = cor.VERMELHO;
		} else if (opcaoCor==2) {
			cor = cor.BRANCO;
		} else {
			while(opcaoCor != 1 && opcaoCor !=2) {
				JOptionPane.showMessageDialog(null, "Cor inválida");
				opcaoCor = Integer.parseInt(JOptionPane.showInputDialog(menu));
			}
		}
	}
	
	public enum listaCor{
		BRANCO(), VERMELHO();
	}
	
	public String toString() {
		String mensagem = "Marca: "+marca+"\nAno: "+ano+"\nCor: "+String.valueOf(cor);
		return mensagem;
	}
	

}
