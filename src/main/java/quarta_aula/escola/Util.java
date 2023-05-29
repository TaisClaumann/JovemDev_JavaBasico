package quarta_aula.escola;

import java.util.ArrayList;
import java.util.List;

public class Util {

	static public List<Professor> professores = new ArrayList<Professor>();
	static public List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	static public List<Aluno> alunos = new ArrayList<Aluno>();

	public static void cadastraProfessor(String nomeProf, EnumFormacao formacao) {
		Professor prof = new Professor(nomeProf, formacao);
		professores.add(prof);
	}

	public static void cadastraDisciplina(String nomeDisc, int cargaHoraria, Professor p) {
		if (validaEscolhaProfessor(p)) {
			Disciplina disciplina = new Disciplina(nomeDisc, cargaHoraria, p);
			disciplinas.add(disciplina);
		}
	}

	public static boolean validaEscolhaProfessor(Professor p) {
		boolean profValido = true;

		if (!professores.contains(p)) {
			profValido = false;
		}
		return profValido;
	}

	public static boolean validaEscolhaAluno(Aluno aluno) {
		boolean alunoValido = true;
		
		if(!alunos.contains(aluno)) {
			alunoValido = false;
		}

		return alunoValido;
	}

	public static void cadastraAluno(String nome) {
		Aluno aluno = new Aluno(nome);
		alunos.add(aluno);
	}

	public static void addDisciplinaAluno(Aluno aluno, Disciplina disciplina) {
		if(validaEscolhaAluno(aluno)) {
			for (Aluno a : alunos) {
				if(a.equals(aluno)) {
					a.getAlunoDisciplinas().add(disciplina);
				}
			}
		}
	}
	
	public static void addNotasDisciplinaAluno(Aluno aluno, Disciplina disciplina, double nota1, double nota2, double nota3) {
		if(validaEscolhaAluno(aluno)) {
			for (Aluno a : alunos) {
				if(a.equals(aluno)) {
					a.addNotasDisciplina(disciplina, nota1, nota2, nota3);
				}
			}
		}
	}
	
	public static String calculaMediaAluno(Aluno aluno) {
		String media = "";
		
		if(validaEscolhaAluno(aluno)) {
			media = aluno.getMediaDisciplina();
		}
		return media;
	}
	
	public static List<Disciplina> listaDisciplinaProfGraduacao(){
		List<Disciplina> disciplinasGraduacao = new ArrayList<>();
		for (Disciplina d : disciplinas) {
			if(d.temProfGraduacao()) {
				disciplinasGraduacao.add(d);
			}
		}
		
		return disciplinasGraduacao;
	}

	public void clearData() {
		professores.clear();
		disciplinas.clear();
		alunos.clear();
	}

}
