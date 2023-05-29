package quarta_aula.escola;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EnumFormacao {
	
	GRADUACAO(1, "Graduação"), ESPECIALIZACAO(2, "Especialização"), POS_GRADUACAO(3, "Pós-graduação");
	
	Integer codigo;
	String descricao;
}
