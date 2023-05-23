package primeira_aula;

public class Principal {

	public static void main(String[] args) {
		
		Pessoa jessica = new Pessoa();
		jessica.nome = "Jessica";
		jessica.sexo = "F";
		jessica.peso = 56.0;
		jessica.altura = 1.55;
		double imc = jessica.calculaIMC();
		String distincao = jessica.distincaoIMC(imc);
		System.out.println(jessica.toString(imc, distincao));
		
		Pessoa gabriel = new Pessoa();
		gabriel.nome = "Gabriel";
		gabriel.sexo = "M";
		gabriel.peso = 80.0;
		gabriel.altura = 1.68;
		imc = gabriel.calculaIMC();
		distincao= gabriel.distincaoIMC(imc);
		System.out.println(gabriel.toString(imc, distincao));

	}

}
