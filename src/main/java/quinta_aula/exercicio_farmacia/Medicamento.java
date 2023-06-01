package quinta_aula.exercicio_farmacia;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
public class Medicamento extends Produto{

	private boolean precisaReceita;
	private String nomeMedico;
	
	public Medicamento(String nome, int estoque, double valor, boolean precisaReceita) {
		super(nome, estoque, valor);
		this.precisaReceita = precisaReceita;
	}
	
	public void vendaComPrescricao(Cliente cliente, int quantidade, String nomeMedico) {
		if(temEstoque(quantidade)) {
			super.venda(cliente, quantidade);
			this.nomeMedico = nomeMedico;
		}
	}
	
	public String sobPrescricao() {
		return precisaReceita ? "SIM" : "Não";	
	}
	
	@Override
	public String toString() {
		return getNome()+" Preço: R$"+getValor()+" Prescrição: "+sobPrescricao()+"\n"
	          +"Estoque: "+getEstoque()+"\n";
	}
}
