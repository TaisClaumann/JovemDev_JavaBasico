package teste_escola;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import quarta_aula.escola.Aluno;
import quarta_aula.escola.Disciplina;
import quarta_aula.escola.EnumFormacao;
import quarta_aula.escola.Professor;
import quarta_aula.escola.Util;

class TesteUtil {

	private Util util = new Util();
	
	@BeforeEach
	void init() {
		util.clearData();
		Professor p1 = new Professor("Tais", EnumFormacao.GRADUACAO);
		Util.professores.add(p1);
		Util.cadastraDisciplina("Português", 20, p1);
		
		Professor p2 = new Professor("Bruno", EnumFormacao.ESPECIALIZACAO);
		Util.professores.add(p2);
		Util.cadastraDisciplina("Espanhol", 20, p2);
		
		Professor p3 = new Professor("Kauã", EnumFormacao.GRADUACAO);
		Util.professores.add(p1);
		Util.cadastraDisciplina("Matemática", 20, p1);
		
		Professor p4 = new Professor("Tata", EnumFormacao.ESPECIALIZACAO);
		Util.professores.add(p2);
		Util.cadastraDisciplina("Geografia", 20, p2);
		
		
	}
	
	@Test
	@DisplayName("Teste cadastro de Professor")
	void testCadastraProfessor() {
		Util.cadastraProfessor("Rogerio", EnumFormacao.ESPECIALIZACAO);
		assertEquals(5, Util.professores.size());
	}
	
	@Test
	@DisplayName("Teste cadastro de Disciplina")
	void testCadastraDisciplina() {
		Professor p5 = new Professor("Tais", EnumFormacao.ESPECIALIZACAO);
		Util.professores.add(p5);
		Util.cadastraDisciplina("Português", 20, p5);
		assertEquals(5, Util.disciplinas.size());
	}
	
	@Test
	@DisplayName("Teste cadastro de Aluno")
	void testCadastraAluno() {
		Util.cadastraAluno("Aluna 1");
		assertEquals(1, Util.alunos.size());
	}
	
	@Test
	@DisplayName("Teste adicionar disciplinas em um aluno")
	void testAddDisciplinaAluno() {
		Aluno aluno1 = new Aluno("Aluno 1");
		Professor prof = new Professor("Rogerio", EnumFormacao.ESPECIALIZACAO);
		Disciplina d1 = new Disciplina("Matemática", 20, prof);
		Util.alunos.add(aluno1);
		Util.professores.add(prof);
		Util.disciplinas.add(d1);
		
		Util.addDisciplinaAluno(aluno1, d1);
		assertTrue(aluno1.getAlunoDisciplinas().contains(d1));
		
		Disciplina d2 = new Disciplina("Geografia", 20, prof);
		Util.disciplinas.add(d2);
		Util.addDisciplinaAluno(aluno1, d2);
		assertEquals(2, aluno1.getAlunoDisciplinas().size());
		
		Aluno aluno2 = new Aluno("Aluno 2");
		Util.alunos.add(aluno2);
		Util.addDisciplinaAluno(aluno2, d2);
		assertEquals(2, aluno1.getAlunoDisciplinas().size());
		assertEquals(1, aluno2.getAlunoDisciplinas().size());
	}
	
	@Test
	@DisplayName("Teste adicionar notas a uma diciplina de um aluno")
	void testAddNotasDisciplinaAluno() {
		Aluno aluno1 = new Aluno("Aluno 1");
		Professor prof = new Professor("Rogerio", EnumFormacao.POS_GRADUACAO);
		Disciplina d1 = new Disciplina("Matemática", 20, prof);
		Disciplina d2 = new Disciplina("Geografia", 20, prof);
		
		Util.alunos.add(aluno1);
		Util.professores.add(prof);
		Util.disciplinas.add(d1);
		Util.disciplinas.add(d2);
		Util.addDisciplinaAluno(aluno1, d1);
		Util.addDisciplinaAluno(aluno1, d2);
		
		Util.addNotasDisciplinaAluno(aluno1, d1, 10.0, 5.0, 8.0);
		Util.addNotasDisciplinaAluno(aluno1, d2, 9.0, 4.0, 7.0);
		
		List<Double> notasDesejadasD1 = Arrays.asList(10.0, 5.0, 8.0);
		List<Double> notasDesejadasD2 = Arrays.asList(9.0, 4.0, 7.0);
		assertEquals(notasDesejadasD1, aluno1.getNotasDisciplina(d1));
		assertEquals(notasDesejadasD2, aluno1.getNotasDisciplina(d2));
	}
	
	@Test
	@DisplayName("Testa calcular a media de todas as notas")
	void testCalculaMediaAluno() {
		Aluno aluno1 = new Aluno("Aluno 1");
		Professor prof = new Professor("Rogerio", EnumFormacao.POS_GRADUACAO);
		Disciplina d1 = new Disciplina("Matemática", 20, prof);
		Disciplina d2 = new Disciplina("Geografia", 20, prof);
		
		Util.alunos.add(aluno1);
		Util.professores.add(prof);
		Util.disciplinas.add(d1);
		Util.disciplinas.add(d2);
		Util.addDisciplinaAluno(aluno1, d1);
		Util.addDisciplinaAluno(aluno1, d2);
		
		Util.addNotasDisciplinaAluno(aluno1, d1, 10.0, 5.0, 8.0);
		Util.addNotasDisciplinaAluno(aluno1, d2, 9.0, 4.0, 7.0);
		Util.calculaMediaAluno(aluno1);
		String media = "Matemática - "+(10.0 + 5.0 + 8.0)/3
					 + "Geografia - "+(9.0 + 4.0 + 7.0)/3;
		assertEquals(media, Util.calculaMediaAluno(aluno1));
	}
	
	@Test
	@DisplayName("Teste lista disciplinas cujos professores tem graduação")
	void testListaDisciplinaProfGraduacao() {
		List<Disciplina> disciplinas = Util.listaDisciplinaProfGraduacao();
		assertEquals(2, disciplinas.size());
	}
}
