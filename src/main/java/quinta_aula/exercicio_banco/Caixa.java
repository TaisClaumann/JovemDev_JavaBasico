package quinta_aula.exercicio_banco;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Caixa {
	
	private List<Conta> contas = new ArrayList<>();
	
	public void cadastraContaCorrente(ContaCorrente conta) {
		ContaCorrente contaCorrente = conta;
		contas.add(contaCorrente);
	}
	
	public void cadastraContaEspecial(ContaEspecial conta) {
		ContaEspecial contaEspecial = conta;
		contas.add(contaEspecial);
	}
	
	public void cadastraContaUniversitaria(ContaUniversitaria conta) {
		ContaUniversitaria contaUniversitaria = conta;
		contas.add(contaUniversitaria);
	}
	
	public void saque(Conta conta) {
		
		
		
		
	}

}
