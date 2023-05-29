package quarta_aula.escola;

import java.util.ArrayList;
import java.util.List;

public class Util {
	
	static List<Professor> professores = new ArrayList<Professor>();
	static List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	static List<Aluno> alunos = new ArrayList<Aluno>();
	
	public static void cadastraProfessor(String nomeProf, EnumFormacao formacao) {
		Professor prof = new Professor(nomeProf, formacao);
		professores.add(prof);
	}
	
	public static void cadastraDisciplina(String nomeDisc, int cargaHoraria, Professor p) {
		Disciplina disciplina = new Disciplina(nomeDisc, cargaHoraria, p);
		disciplinas.add(disciplina);
	}

}
