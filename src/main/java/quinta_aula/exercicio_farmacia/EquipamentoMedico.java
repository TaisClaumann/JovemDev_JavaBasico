package quinta_aula.exercicio_farmacia;

import lombok.Getter;

@Getter
public class EquipamentoMedico extends Produto{
	
	private int qtdEncomendas;

	public EquipamentoMedico(String nome, int estoque, double valor) {
		super(nome, estoque, valor);
	}
	
	@Override
	public boolean venda(Cliente cliente, int quantidade) {
		if(temEstoque(quantidade)) {
			return super.venda(cliente, quantidade);
		} 

		do {
			estoque = getEstoque() - 1;
			quantidade -= 1;
		} while (getEstoque() > 0);

		qtdEncomendas += quantidade;
		cliente.setSaldoDevedor(cliente.getSaldoDevedor() + (getValor() * quantidade));
		return true;
	}
	
	
	@Override
	public String toString() {
		return super.toString()+"\n"
			 + "Encomenda(as): "+getQtdEncomendas();
	}
}
