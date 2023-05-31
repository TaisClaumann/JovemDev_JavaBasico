package quinta_aula.exercicio_farmacia;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Cliente {
	
	private String nome;
	private double saldoDevedor;
	
	public void debitoDivida(double valor) {
		if(valor<=getSaldoDevedor()) {
			setSaldoDevedor(getSaldoDevedor()-valor);
		}
	}
	
	public boolean temDivida(Cliente cliente){
		return getSaldoDevedor()>0;
	}
	
	public String toString() {
		return "Nome: "+getNome()+"  Saldo Devedor: R$"+getSaldoDevedor()+"\n";
	}
}
