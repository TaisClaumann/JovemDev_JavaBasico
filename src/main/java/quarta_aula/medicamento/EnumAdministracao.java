package quarta_aula.medicamento;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EnumAdministracao {
	
	INJETAVEL("Injetável"), TOPICO("Tópico"), ORAL("Oral"), SUPOSITORIO("Supositório");
	
	String descricao;

}
