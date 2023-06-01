package quinta_aula.exercicio_farmacia;

import lombok.Getter;

@Getter
public class EquipamentoMedico extends Produto{

	public EquipamentoMedico(String nome, int estoque, double valor) {
		super(nome, estoque, valor);
	}

}
