package segunda_aula.exercicio_carro;

import java.util.List;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Carro {
	
	String marca;
	int ano;
	listaCor cor;
	
	public void cadastraCarro() {
		marca = JOptionPane.showInputDialog("Informe a marca");
		
		while(marca.isEmpty()) {
			marca = JOptionPane.showInputDialog("A marca não pode ser vazia, informe novamente");
		}
		
		ano = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano"));
		
		String menu = "**Informe o código da cor**\n"+
					  "1 - Vermelho\n"+
					  "2 - Branco";
		
		int opcaoCor = Integer.parseInt(JOptionPane.showInputDialog(menu));
		
		if(opcaoCor==1) {
			cor = listaCor.VERMELHO;
		} else if (opcaoCor==2) {
			cor = listaCor.BRANCO;
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
	
	public static double calculaPercentual(List<Carro> carros, int contador) {
		double porcentCarro = (contador*100)/carros.size();
		return porcentCarro;
	}
	
	public String toString() {
		String mensagem = "Marca: "+marca+"\nAno: "+ano+"\nCor: "+String.valueOf(cor);
		return mensagem;
	}
	

}
