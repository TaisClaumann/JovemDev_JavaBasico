package quarta_aula.escola;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Disciplina {
	
	private String nome;
	private int cargaHoraria;
	private Professor prof;

}
