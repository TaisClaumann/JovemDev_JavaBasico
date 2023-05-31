package quinta_aula.exercicio_banco;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Conta {
	
	private Integer numero;
	private String agencia;
	private String nomeCorrentista;
	private double saldo;
	
	public Conta(Integer numero, String agencia, String nomeCorrentista, double saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.nomeCorrentista = nomeCorrentista;
		this.saldo = saldo;
	}
	
	public void deposito(double valor) {
		setSaldo(saldo+valor);
	}
	
	public void saque(double saque) {
			setSaldo(saldo-saque);
	}
	
	public void transferencia(Conta contaDestino, double valor) {
			saque(valor);
			contaDestino.deposito(valor);
	}
	
	public boolean temDinheiro(double saque) {
		return saque <= getSaldo();
	}
}
