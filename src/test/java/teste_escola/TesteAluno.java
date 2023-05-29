package teste_escola;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import quarta_aula.escola.Aluno;
import quarta_aula.escola.Disciplina;
import quarta_aula.escola.EnumFormacao;
import quarta_aula.escola.Professor;
import quarta_aula.escola.Util;

class TesteAluno {

	@Test
	@DisplayName("Teste verificação de se o aulo tem a disciplina passada por parâmetro")
	void testAlunoTemDisciplina() {
		Aluno aluno1 = new Aluno("Aluno 1");
		Professor prof = new Professor("Rogerio", EnumFormacao.GRADUACAO);
		Disciplina d1 = new Disciplina("Matemática", 20, prof);
		Util.alunos.add(aluno1);
		Util.professores.add(prof);
		Util.disciplinas.add(d1);
		
		Util.addDisciplinaAluno(aluno1, d1);
		aluno1.alunoTemDisciplina(d1);
		assertEquals(true, aluno1.alunoTemDisciplina(d1));
	}

}
