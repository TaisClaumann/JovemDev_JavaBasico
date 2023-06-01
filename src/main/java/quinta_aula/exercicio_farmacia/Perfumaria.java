package quinta_aula.exercicio_farmacia;

public class Perfumaria extends Produto{

	public Perfumaria(String nome, int estoque, double valor) {
		super(nome, estoque, valor);
	}
	
	@Override
	public boolean venda(Cliente cliente, int quantidade) {
		if(temEstoque(quantidade) && cliente.getSaldoDevedor()<=300) {
			super.venda(cliente, quantidade);
			return true;
		}
		return false;
	}
}
