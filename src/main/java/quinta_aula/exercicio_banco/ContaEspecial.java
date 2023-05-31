package quinta_aula.exercicio_banco;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaEspecial extends Conta{
	
	private double limite;

	public ContaEspecial(Integer numero, String agencia, String nomeCorrentista, double saldo, double limite) {
		super(numero, agencia, nomeCorrentista, saldo);
		
		if(temDinheiro(limite)) {
			this.limite = limite;
		}
	}

	@Override
	public void saque(double saque) {
		if(temLimite(saque)) {
			super.saque(saque);
		}
	}
	
	@Override
	public void transferencia(Conta contaDestino, double valor) {
		if(temLimite(valor)) {
			super.transferencia(contaDestino, valor);
		}
	}
	
	public boolean temLimite(double saque) {
		return saque <= getLimite();
	}
}
