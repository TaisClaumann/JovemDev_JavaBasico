package segunda_aula.exercicio_carro;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		List<Carro> carros = new ArrayList<Carro>();
		int opcao =0;
		
		do {
			
			String menu = "Para cadastrar um carro: 1\n"+
					  "Para listar os carros por período de fabricacao: 2\n"+
					  "Para listar carros por marca: 3\n"+
					  "Para listar carros por cor: 4\n"+
					  "Sair: 0";
		
			opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
			String resultado ="";
			int contador =0;

			if(opcao==1) {
				Carro carro = new Carro();
				carro.cadastraCarro();
				
				carros.add(carro);
			
			} else if(opcao==2) {
				int anoInicial = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano inicial a ser filtrado"));
				int anoFinal = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano final a ser filtrado"));
			
				for (Carro carro : carros) {
					if(carro.ano >= anoInicial && carro.ano <= anoFinal) {
						resultado += carro.toString()+"\n\n";
						contador++;
					}
				}
				
				JOptionPane.showMessageDialog(null, resultado+"Porcentagem: "+Carro.calculaPercentual(carros, contador));
			
			} else if (opcao==3) {
				String filtroMarca = JOptionPane.showInputDialog("Informe a marca a ser filtrada");
				
				for (Carro carro : carros) {
					if(carro.marca.equalsIgnoreCase(filtroMarca)) {
						resultado += carro.toString()+"\n\n";
						contador++;
					}
				}
				
				JOptionPane.showMessageDialog(null, resultado+"Porcentagem: "+Carro.calculaPercentual(carros, contador));
			
			} else if (opcao==4) {
				String filtroCor = JOptionPane.showInputDialog("Informe a cor a ser filtrada");
				
				for (Carro carro : carros) {
					
					if(filtroCor.equalsIgnoreCase(carro.cor.toString())) {
						resultado += carro.toString()+"\n\n";
						contador++;
					}
				}
				
				JOptionPane.showMessageDialog(null, resultado+"Porcentagem: "+Carro.calculaPercentual(carros, contador));
			} 
			
		}while(opcao!=0);

	}

}
