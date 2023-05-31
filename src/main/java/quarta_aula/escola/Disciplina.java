package quarta_aula.escola;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class Disciplina {
	
	@NonNull
	private String nome;
	@NonNull
	private int cargaHoraria;
	@NonNull
	private Professor prof;
	private List<Double> notas = new ArrayList<>();
	
	public void adicionaNotas(double nota1, double nota2, double nota3){
		notas.add(nota1);
		notas.add(nota2);
		notas.add(nota3);
	}
	
	public double calculaMedia() {
		double media = 0;
		
		for (Double nota : notas) {
			media += nota;
		}
		
		return media/3;
	}
	
	public boolean temProfGraduacao() {
		boolean temProf = false;
		
		if(prof.getFormacao().equals(EnumFormacao.GRADUACAO)) {
			temProf = true;
		}
		
		return temProf;
	}
	
	public String toString() {
		return prof.toString()+
			  "Disciplina: "+nome+"  Carga Horária: "+cargaHoraria+"h"+"\n";
	}
	
}
