package primeira_aula;

public class Pessoa {

	String nome, sexo;
	double peso, altura;
	
	public double calculaIMC() {
		double imc = peso/Math.pow(altura, 2);
		return imc;
	}
	
	public String distincaoIMC(double imc) {
		String distincao ="";
		
		if(sexo.equalsIgnoreCase("F")) {
			if(imc<19.1) {
				distincao = "Abaixo do Peso";
			}else if(imc>=19.1 && imc<25.9) {
				distincao = "Peso Ideal";
			}else if(imc>=25.9 && imc<27.4) {
				distincao = "Pouco Acima do Peso";
			}else if(imc>=27.4 && imc<32.4) {
				distincao = "Acima do Peso";
			} else {
				distincao = "Obesidade";
			}
			
		} else {	
			if(imc<20.7) {
				distincao = "Abaixo do Peso";
			}else if(imc>=20.7 && imc<26.5) {
				distincao = "Peso Ideal";
			}else if(imc>=26.5 && imc<27.9) {
				distincao = "Pouco Acima do Peso";
			}else if(imc>=27.9 && imc<31.2) {
				distincao = "Acima do Peso";
			} else {
				distincao = "Obesidade";
			}
		}
		
		return distincao;
	}
	
	public String toString(double imc, String distincao) {
		String mensagem = "Nome: "+nome+"\tSexo: "+sexo+"\t\tPeso: "+peso+"\tAltura: "+altura+
						"\nIMC: "+String.format("%.2f", imc)+"\tDistincao: "+distincao+"\n";
		return mensagem;
	}
}
