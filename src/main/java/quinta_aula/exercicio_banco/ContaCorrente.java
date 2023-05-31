package quinta_aula.exercicio_banco;

public class ContaCorrente extends Conta{

	public ContaCorrente(Integer numero, String agencia, String nomeCorrentista, double saldo) {
		super(numero, agencia, nomeCorrentista, saldo);
	}
	
	@Override
	public void saque(double saque) {
		if(temDinheiro(saque)) {
			super.saque(saque);
		} else {
			String msg = "Saldo da conta inferior ao saque";
		}
	}
	
	@Override
	public void transferencia(Conta contaDestino, double valor) {
		if(temDinheiro(valor)) {
			if(contaDestino instanceof ContaUniversitaria) {
				ContaUniversitaria contaUni = (ContaUniversitaria) contaDestino;
				
				if(contaUni.limiteDisponivel(valor)>=0) {
					super.transferencia(contaDestino, valor);
				}
		
			} else {
				super.transferencia(contaDestino, valor);
			}
		}
	}
}
