package quinta_aula.exercicio_banco;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Caixa {

	private List<Conta> contas = new ArrayList<>();

	public void cadastraConta(Conta conta) {
		contas.add(conta);
	}

	public void saque(Conta conta, double valor) {
		if (existeConta(conta)) {

			if (conta instanceof ContaCorrente) {
				ContaCorrente contaCorrente = (ContaCorrente) conta;
				contaCorrente.saque(valor);
			} else if (conta instanceof ContaEspecial) {
				ContaEspecial contaEspecial = (ContaEspecial) conta;
				contaEspecial.saque(valor);
			} else {
				ContaUniversitaria contaUni = (ContaUniversitaria) conta;
				contaUni.saque(valor);
			}
		}
	}

	public void deposito(Conta conta, double valor) {
		if (existeConta(conta)) {

			if (conta instanceof ContaCorrente) {
				ContaCorrente contaCorrente = (ContaCorrente) conta;
				contaCorrente.deposito(valor);
			} else if (conta instanceof ContaEspecial) {
				ContaEspecial contaEspecial = (ContaEspecial) conta;
				contaEspecial.deposito(valor);
			} else {
				ContaUniversitaria contaUni = (ContaUniversitaria) conta;
				contaUni.deposito(valor);
			}
		}
	}

	public void transferencia(Conta contaSaque, Conta contaDeposito, double valor) {
		if (existeConta(contaSaque)&& existeConta(contaDeposito)) {

			if (contaSaque instanceof ContaCorrente) {
				ContaCorrente contaCorrente = (ContaCorrente) contaSaque;
				contaCorrente.transferencia(contaDeposito, valor);
				
				if(contaDeposito instanceof ContaUniversitaria) {
					
				}
				
			} else if (contaSaque instanceof ContaEspecial) {
				ContaEspecial contaEspecial = (ContaEspecial) contaSaque;
				contaEspecial.transferencia(contaDeposito, valor);
			} else {
				ContaUniversitaria contaUni = (ContaUniversitaria) contaSaque;
				contaUni.transferencia(contaDeposito, valor);
			}
		}
	}

	public boolean existeConta(Conta conta) {
		return contas.contains(conta);
	}
	
	public void clearData() {
		contas.clear();
	}
}
