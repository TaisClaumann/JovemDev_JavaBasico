package quinta_aula.exercicio_farmacia;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Produto {

	private String nome;
	private int estoque;
	private double valor;
	
	public void venda(Cliente cliente, int quantidade) {
		estoque = getEstoque()-quantidade;
		cliente.setSaldoDevedor(cliente.getSaldoDevedor()+(getValor()*quantidade));
	}
	
	public boolean temEstoque(int quantVenda) {
		return estoque>=quantVenda;
	}
	
	public String toString(){
		return getNome()+" Preço: R$"+getValor()+" Estoque: "+getEstoque()+"\n";
	}
}