package teste_medicamento;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import quarta_aula.medicamento.EnumAdministracao;
import quarta_aula.medicamento.Medicamento;
import quarta_aula.medicamento.Pessoa;
import quarta_aula.medicamento.Util;

class TesteUtil {
	
	Util util = new Util();

	@BeforeEach
	void init() {
		util.clearData();
		
	}
	
	@Test
	@DisplayName("Teste cadastro de medicamentos")
	void testCadastraMedicamento() {
		Util.cadastraMedicamento("Med 1", EnumAdministracao.TOPICO);
		Util.cadastraMedicamento("Med 2", EnumAdministracao.SUPOSITORIO);
		assertEquals(2, Util.medicamentos.size());
	}
	
	@Test
	@DisplayName("Teste adiciona contraindicações a um medicamento")
	void testAddContraindicacao() {
		Medicamento m1 = new Medicamento("Med 1", EnumAdministracao.TOPICO);
		Util.medicamentos.add(m1);
		
		Util.addContraindicacao(m1, "Contra 1");
		Util.addContraindicacao(m1, "Contra 2");
		assertEquals(2, m1.getContraindicacoes().size());
	}
	
	@Test
	@DisplayName("Teste adiciona indicações a um medicamento")
	void testAddIndicacao() {
		Medicamento m1 = new Medicamento("Med 1", EnumAdministracao.TOPICO);
		Util.medicamentos.add(m1);
		
		Util.addIndicacao(m1, "Indica 1");
		Util.addIndicacao(m1, "Indica 2");
		assertEquals(2, m1.getIndicacoes().size());
	}
	
	@Test
	@DisplayName("Teste cadastro de pessoas")
	void testCadastraPessoa() {
		Util.cadastraPessoa("Pessoa 1", "Sintoma 1");
		Util.cadastraPessoa("Pessoa 2", "Sintoma 2");
		assertEquals(2, Util.pessoas.size());
	}
	
	@Test
	@DisplayName("Teste adiciona alergias a uma pessoa")
	void testAddAlergia() {
		Pessoa p1 = new Pessoa("Pessoa 1", "Sintoma 1");
		Util.pessoas.add(p1);
		
		Util.addAlergia(p1, "Alergia 1");
		Util.addAlergia(p1, "Alergia 2");
		assertEquals(2, p1.getAlergias().size());
	}
	
	@Test
	@DisplayName("Teste adiciona prescricao para uma pessoa")
	void testAddPrescricao() {
		Pessoa p1 = new Pessoa("Pessoa 1", "Sintoma 1");
		Util.pessoas.add(p1);
		
		Medicamento m1 = new Medicamento("Med 1", EnumAdministracao.TOPICO);
		Util.medicamentos.add(m1);
		Util.addIndicacao(m1, "Sintoma 1");
		Medicamento m2 = new Medicamento("Med 2", EnumAdministracao.TOPICO);
		Util.medicamentos.add(m2);
		Util.addIndicacao(m2, "Sintoma 2");
		Medicamento m3 = new Medicamento("Med 3", EnumAdministracao.TOPICO);
		Util.medicamentos.add(m3);
		Util.addIndicacao(m3, "Sintoma 1");
		
		Util.addContraindicacao(m1, "Diabete");
		Util.addContraindicacao(m3, "Colesterol alto");
		Util.addAlergia(p1, "Diabete");
		
		Util.addPrescricao(p1);
		assertEquals(1, Util.prescricoes.size());
		assertTrue(Util.prescricoes.get(0).getPessoa().equals(p1));
		assertTrue(Util.prescricoes.get(0).getMedicamentos().contains(m3));
	}
	
	@Test
	@DisplayName("Teste lista pessoa com seus respectivos medicamentos")
	void testListaPessoaMedicamento() {
		Pessoa p1 = new Pessoa("Pessoa 1", "Sintoma 1");
		Util.pessoas.add(p1);
		Util.addAlergia(p1, "Diabete");
		
		Medicamento m3 = new Medicamento("Med 3", EnumAdministracao.TOPICO);
		Util.medicamentos.add(m3);
		Util.addIndicacao(m3, "Sintoma 1");
		Util.addContraindicacao(m3, "Colesterol alto");
		Util.addPrescricao(p1);
		
		String lista = p1.toString() +
					   "Medicamentos: " + "\n" +
					   "- "+ m3.getNome()+"\n";
		
		assertEquals(lista, Util.listaPessoaMedicamento(p1));
	}
	
	
}
