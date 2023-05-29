package quarta_aula.escola;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Aluno {
	
	private String nome;
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	private double nota1;
	private double nota2;
	private double nota3;
	
}
