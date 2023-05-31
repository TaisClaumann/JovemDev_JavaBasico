package quarta_aula.escola;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class Aluno {

	@NonNull
	private String nome;
	private List<Disciplina> alunoDisciplinas = new ArrayList<Disciplina>();

	public boolean alunoTemDisciplina(Disciplina disciplina) {
		boolean temDisciplina = true;

		for (Disciplina d : alunoDisciplinas) {
			if (!alunoDisciplinas.contains(disciplina)) {
				temDisciplina = false;
			}
		}
		return temDisciplina;
	}

	public void addNotasDisciplina(Disciplina disciplina, double nota1, double nota2, double nota3) {
		for (Disciplina d : alunoDisciplinas) {
			if(d.equals(disciplina)) {
				disciplina.adicionaNotas(nota1, nota2, nota3);
			}
		}
	}
	
	public List<Double> getNotasDisciplina(Disciplina disciplina){
		List<Double> notasDisciplina = new ArrayList<>();
		
		for (Disciplina d : alunoDisciplinas) {
			if(d.equals(disciplina)) {
				notasDisciplina = disciplina.getNotas();
			}
		}
		
		return notasDisciplina;
	}
	
	public String getMediaDisciplina(){
		String media = "";
		
		for (Disciplina d : alunoDisciplinas) {
			media += d.getNome()+" - "+d.calculaMedia();
		}
		
		return media;
	}
	
	public String toString() {
		return "Aluno: "+nome;
	}
}
