package teste_farmacia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import quinta_aula.exercicio_farmacia.Caixa;
import quinta_aula.exercicio_farmacia.Cliente;
import quinta_aula.exercicio_farmacia.EquipamentoMedico;
import quinta_aula.exercicio_farmacia.Medicamento;
import quinta_aula.exercicio_farmacia.Perfumaria;

class TesteCaixa {

	Caixa caixa = new Caixa();
	
	@BeforeEach
	void setUp() {
		caixa.clearData();
		Medicamento m1 = new Medicamento("Med 1", 5, 10.0, false);
		Medicamento m2 = new Medicamento("Med 2", 5, 10.0, true);
		Perfumaria p1 = new Perfumaria("Perfume 1", 5, 10.0);
		EquipamentoMedico e1 = new EquipamentoMedico("Equipamento 1", 5, 10.0);
		
		caixa.getProdutos().add(m1);
		caixa.getProdutos().add(m2);
		caixa.getProdutos().add(p1);
		caixa.getProdutos().add(e1);
		
		Cliente c1 = new Cliente("Cliente 1", 200.0);
		caixa.cadastraCliente(c1);
		Cliente c2 = new Cliente("Cliente 2", 200.0);
		caixa.cadastraCliente(c2);
	}
	
	@Test
	@DisplayName("Teste de cadastro de medicamentos e afins")
	void cadastroProduto() {
		Perfumaria p3 = new Perfumaria("Perfume 3", 5, 10.0);
		caixa.cadastraProduto(p3);
		assertEquals(5, caixa.getProdutos().size());
	}
	
	@Test
	@DisplayName("Teste de venda de produtos sem prescrição médica")
	void vendaProduto() {
		Medicamento m1 = (Medicamento) caixa.getProdutos().get(0);
		Perfumaria p1 = (Perfumaria) caixa.getProdutos().get(2);
		EquipamentoMedico e1 = (EquipamentoMedico) caixa.getProdutos().get(3);
		Cliente c1 = caixa.getClientes().get(0);
		
		caixa.vendaSemPrescricao(m1, c1, 2);
		assertEquals(3, m1.getEstoque());
		assertEquals(220.0, c1.getSaldoDevedor());
		
		caixa.vendaSemPrescricao(p1, c1, 1);
		assertEquals(4, p1.getEstoque());
		assertEquals(230.0, c1.getSaldoDevedor());
		
		caixa.vendaSemPrescricao(e1, c1, 1);
		assertEquals(4, e1.getEstoque());
		assertEquals(240.0, c1.getSaldoDevedor());
		
		caixa.vendaSemPrescricao(e1, c1, 5);
		assertEquals(1, e1.getQtdEncomendas());
		assertEquals(0, e1.getEstoque());
	}
	
	@Test
	@DisplayName("Teste de venda de produtos com prescrição medica")
	void vendaSobPrescricao() {
		Medicamento m1 = (Medicamento) caixa.getProdutos().get(0);
		Medicamento m2 = (Medicamento) caixa.getProdutos().get(1);
		Perfumaria p1 = (Perfumaria) caixa.getProdutos().get(2);
		Cliente c1 = caixa.getClientes().get(0);
		
		caixa.vendaSobPrescricao(m1, c1, 2, "Medico");
		assertEquals(5, m1.getEstoque());
		assertEquals(200.0, c1.getSaldoDevedor());
		
		caixa.vendaSobPrescricao(m2, c1, 2, "Medico");
		assertEquals(3, m2.getEstoque());
		assertEquals(220.0, c1.getSaldoDevedor());
		
		caixa.vendaSobPrescricao(p1, c1, 1, "Medico");
		assertEquals(5, p1.getEstoque());
		assertEquals(220.0, c1.getSaldoDevedor());
	}
	
	@Test
	@DisplayName("Teste de debito de dívida")
	void debitoDeDivida() {
		Cliente c1 = caixa.getClientes().get(0);
		Cliente c2 = caixa.getClientes().get(1);
		
		caixa.debitoDeDivida(c1, 10.0);
		assertEquals(190.0, c1.getSaldoDevedor());
		
		caixa.debitoDeDivida(c2, 210);
		assertEquals(200.0, c2.getSaldoDevedor());
	}
	
	@Test
	@DisplayName("Teste listar clientes devedores")
	void listaClientesDevedores() {
		Cliente c1 = caixa.getClientes().get(0);
		Cliente c2 = caixa.getClientes().get(1);
		
		String expected = c1.toString()+c2.toString();
		assertEquals(expected, caixa.getClientesDevedores());
		
		caixa.debitoDeDivida(c2, 200);
		
		expected = c1.toString();
		assertEquals(expected, caixa.getClientesDevedores());
	}
	
	@Test
	@DisplayName("Teste listar clientes sem dívida")
	void listaClientesSemDivida() {
		Cliente c2 = caixa.getClientes().get(1);
		
		String expected = "";
		assertEquals(expected, caixa.getClientesSemDividas());
		
		caixa.debitoDeDivida(c2, 200);
		
		expected = c2.toString();
		assertEquals(expected, caixa.getClientesSemDividas());
	}
	
	@Test
	@DisplayName("Teste listar medicamentos")
	void listaMedicamentos() {
		Medicamento m1 = (Medicamento) caixa.getProdutos().get(0);
		Medicamento m2 = (Medicamento) caixa.getProdutos().get(1);
		
		String expected = m1.toString() + m2.toString();
		
		assertEquals(expected, caixa.listaMedicamentos());
	}
	
	@Test
	@DisplayName("Teste listar perfumarias")
	void listaPerfumarias() {
		Perfumaria p1 = (Perfumaria) caixa.getProdutos().get(2);
		assertEquals(p1.toString(), caixa.listaPerfumarias());
	}
	
	@Test
	@DisplayName("Teste listar equipamentos médicos")
	void listaEquiMedico() {
		EquipamentoMedico e1 = (EquipamentoMedico) caixa.getProdutos().get(3);
		assertEquals(e1.toString(), caixa.listaEquipMedicos());
	}
}
