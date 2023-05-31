package quinta_aula.exercicio_banco;

public class ContaUniversitaria extends Conta{
	
	private final double limiteSaldo = 2000.0;

	public ContaUniversitaria(Integer numero, String agencia, String nomeCorrentista, double saldo) {
		super(numero, agencia, nomeCorrentista, saldo);
	}
	
	@Override
	public void deposito(double valor) {
		if(limiteDisponivel(valor)>=0) {
			super.deposito(valor);
		}
	}
	
	@Override
	public void saque(double saque) {
		if(temDinheiro(saque)) {
			super.saque(saque);
		}
	}
	
	@Override
	public void transferencia(Conta contaDeposito, double valor) {
		if(temDinheiro(valor)) {
			saque(valor);
			contaDeposito.deposito(valor);
		}
	}
	
	public double limiteDisponivel(double valor) {
		return limiteSaldo-getSaldo()-valor;
	}

}
