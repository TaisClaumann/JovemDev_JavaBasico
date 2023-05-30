package quarta_aula.medicamento;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumAdministracao {
	
	INJETAVEL("Injetável"), 
	TOPICO("Tópico"), 
	ORAL("Oral"), 
	SUPOSITORIO("Supositório");
	
	private String descricao;

}
