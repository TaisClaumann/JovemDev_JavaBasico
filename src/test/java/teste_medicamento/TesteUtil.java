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
		Medicamento m1 = new Medicamento("Med 1", EnumAdministracao.TOPICO);
		util.getMedicamentos().add(m1);
		util.addIndicacao(m1, "Sintoma 1");
		
		Medicamento m2 = new Medicamento("Med 2", EnumAdministracao.TOPICO);
		util.getMedicamentos().add(m2);
		util.addIndicacao(m2, "Sintoma 2");
		
		Medicamento m3 = new Medicamento("Med 3", EnumAdministracao.TOPICO);
		util.getMedicamentos().add(m3);
		util.addIndicacao(m3, "Sintoma 1");
		
		util.addContraindicacao(m1, "Diabete");
		util.addContraindicacao(m3, "Colesterol alto");
		
		Pessoa p1 = new Pessoa("Pessoa 1", "Sintoma 1");
		util.getPessoas().add(p1);
		util.addAlergia(p1, "Diabetes");
		
	}
	
	@Test
	@DisplayName("Teste cadastro de medicamentos")
	void testCadastraMedicamento() {
		util.cadastraMedicamento("Med 1", EnumAdministracao.TOPICO);
		assertEquals(4, util.getMedicamentos().size());
	}
	
	@Test
	@DisplayName("Teste adiciona contraindicações a um medicamento")
	void testAddContraindicacao() {
		Medicamento m1 = util.getMedicamentos().get(0);
		util.addContraindicacao(m1, "Contra 1");
		
		assertEquals(2, m1.getContraindicacoes().size());
	}
	
	@Test
	@DisplayName("Teste adiciona indicações a um medicamento")
	void testAddIndicacao() {
		Medicamento m1 = util.getMedicamentos().get(0);	
		util.addIndicacao(m1, "Indica 1");
		
		assertEquals(2, m1.getIndicacoes().size());
	}
	
	@Test
	@DisplayName("Teste cadastro de pessoas")
	void testCadastraPessoa() {
		util.cadastraPessoa("Pessoa 1", "Sintoma 1");
		util.cadastraPessoa("Pessoa 2", "Sintoma 2");
		assertEquals(3, util.getPessoas().size());
	}
	
	@Test
	@DisplayName("Teste adiciona alergias a uma pessoa")
	void testAddAlergia() {
		Pessoa p1 = util.getPessoas().get(0);
		
		util.addAlergia(p1, "Alergia 1");
		util.addAlergia(p1, "Alergia 2");
		assertEquals(3, p1.getAlergias().size());
	}
	
	@Test
	@DisplayName("Teste adiciona prescricao para uma pessoa")
	void testAddPrescricao() {
		Pessoa p1 = util.getPessoas().get(0);
		Medicamento m3 = util.getMedicamentos().get(2);
		
		util.addPrescricao(p1);
		
		assertEquals(1, util.getPrescricoes().size());
		assertTrue(util.getPrescricoes().get(0).getPessoa().equals(p1));
		assertTrue(util.getPrescricoes().get(0).getMedicamentos().contains(m3));
	}
	
	@Test
	@DisplayName("Teste lista pessoa com seus respectivos medicamentos")
	void testListaPessoaMedicamento() {
		Pessoa p1 = util.getPessoas().get(0);
		util.addAlergia(p1, "Diabete");
		
		Medicamento m3 = util.getMedicamentos().get(2);
		util.addIndicacao(m3, "Sintoma 1");
		util.addContraindicacao(m3, "Colesterol alto");
		util.addPrescricao(p1);
		
		String lista = p1.toString() +
					   "Medicamentos: " + "\n" +
					   "- "+ m3.getNome()+"\n";
		
		assertEquals(lista, util.listaPessoaMedicamento(p1));
	}
	
	
}
