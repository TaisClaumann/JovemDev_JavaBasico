package quinta_aula.exercicio_farmacia;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Produto {

	private String nome;
	protected int estoque;
	private double valor;
	
	public boolean venda(Cliente cliente, int quantidade) {
		estoque = getEstoque() - quantidade;
		cliente.setSaldoDevedor(cliente.getSaldoDevedor() + (getValor() * quantidade));
		return true;
	}
	
	public boolean temEstoque(int quantVenda) {
		return estoque>=quantVenda;
	}
	
	public String toString(){
		return getNome()+" Preço: R$"+getValor()+" Estoque: "+getEstoque()+"\n";
	}
}
