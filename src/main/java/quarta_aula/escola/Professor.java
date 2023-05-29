package quarta_aula.escola;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Professor {
	
	private String nome;
	private EnumFormacao formacao;
	
	public String toString() {
		return "Prof: "+nome+"  Formação: "+formacao+"\n";
	}
}
