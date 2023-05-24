package terceira_aula.exercicio_livro;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Sexo {
	
	FEMININO("F",1), MASCULINO("M",2);
	
	private String descrição;
	private int codigo;

	public static Sexo findById(int codigo) {
		for (Sexo tipoSexo : Sexo.values()) {
			if(codigo == tipoSexo.codigo) {
				return tipoSexo;
			}
		}
		return null;
	}

}
