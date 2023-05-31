package quinta_aula.exercicio_farmacia;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EquipamentoMedico extends Produto{
	
	private int qtdEncomendas;

	public EquipamentoMedico(String nome, int estoque, double valor) {
		super(nome, estoque, valor);
	}

	@Override
	public void venda(Cliente cliente, int quantidade) {
		if(temEstoque(quantidade)) {
			super.venda(cliente, quantidade);
		} else {
			
			do {
				setEstoque(getEstoque()-1);
				quantidade -= 1;
			} while(getEstoque()>0);
			
			setQtdEncomendas(quantidade);
			cliente.setSaldoDevedor(cliente.getSaldoDevedor()+(getValor()*quantidade));
		}
	}
	
	@Override
	public String toString() {
		return super.toString()+"\n"
			 + "Encomenda(as): "+getQtdEncomendas();
	}
}
