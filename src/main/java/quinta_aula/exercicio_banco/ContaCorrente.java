package quinta_aula.exercicio_banco;

public class ContaCorrente extends Conta{

	public ContaCorrente(Integer numero, String agencia, String nomeCorrentista, double saldo) {
		super(numero, agencia, nomeCorrentista, saldo);
	}
	
	@Override
	public void saque(double saque) {
		if(temDinheiro(saque)) {
			super.saque(saque);
		}
	}
	
	@Override
	public void transferencia(Conta contaDestino, double valor) {
		if(temDinheiro(valor)) {
			super.transferencia(contaDestino, valor);
		}
	}
}
