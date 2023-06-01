package teste_banco;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import quinta_aula.exercicio_banco.Caixa;
import quinta_aula.exercicio_banco.ContaCorrente;
import quinta_aula.exercicio_banco.ContaEspecial;
import quinta_aula.exercicio_banco.ContaUniversitaria;

class TesteCaixa {

	Caixa caixa = new Caixa();
	
	@BeforeEach
	void setUp() {
		caixa.clearData();
		
		ContaCorrente corrente1 = new ContaCorrente(123, "C1", "Bob", 1000);
		ContaEspecial especial1 = new ContaEspecial(321, "E1", "Bob", 1000, 500);
		ContaUniversitaria universitaria1 = new ContaUniversitaria(456, "EI", "Bob", 1000);
		
		caixa.getContas().add(corrente1);
		caixa.getContas().add(especial1);
		caixa.getContas().add(universitaria1);
		
		ContaCorrente corrente2 = new ContaCorrente(123, "C1", "Bob", 1000);
		ContaEspecial especial2 = new ContaEspecial(321, "E1", "Bob", 1000, 500);
		ContaUniversitaria universitaria2 = new ContaUniversitaria(456, "EI", "Bob", 1000);
		
		caixa.getContas().add(corrente2);
		caixa.getContas().add(especial2);
		caixa.getContas().add(universitaria2);
	}
	
	@Test
	@DisplayName("Teste cadastro de conta")
	void cadastroConta() {
		ContaCorrente corrente2 = new ContaCorrente(1234, "C2", "Bob", 1000);
		caixa.cadastraConta(corrente2);
		assertEquals(7, caixa.getContas().size());
		
		ContaEspecial especial2 = new ContaEspecial(3210, "E2", "Bob", 900, 1000);
		caixa.cadastraConta(especial2);
		assertEquals(8, caixa.getContas().size());
	}
	
	@Test
	@DisplayName("Teste cadastra conta universitaria")
	void cadastraContaUniversitaria() {
		ContaUniversitaria universitaria2 = new ContaUniversitaria(4567, "E2", "Bob", 1000);
		caixa.cadastraConta(universitaria2);
		assertEquals(7, caixa.getContas().size());
	}
	
	@Test
	@DisplayName("Teste saque de uma conta corrente, especial e universitária")
	void saque() {
		ContaCorrente corrente1 = (ContaCorrente) caixa.getContas().get(0);
		caixa.saque(corrente1, 100);
		assertEquals(900, corrente1.getSaldo());
		caixa.saque(corrente1, 1000);
		assertEquals(900, corrente1.getSaldo());
		
		ContaEspecial especial1 = (ContaEspecial) caixa.getContas().get(1);
		caixa.saque(especial1, 100);
		assertEquals(900, especial1.getSaldo());
		caixa.saque(especial1, 600);
		assertEquals(900, especial1.getSaldo());
		
		ContaUniversitaria universitaria1 = (ContaUniversitaria) caixa.getContas().get(2);
		caixa.saque(universitaria1, 100);
		assertEquals(900, corrente1.getSaldo());
		caixa.saque(universitaria1, 1000);
		assertEquals(900, corrente1.getSaldo());
	}
	
	@Test
	@DisplayName("Teste deposito em uma conta corrente, especial e universitária")
	void deposito() {
		ContaCorrente corrente1 = (ContaCorrente) caixa.getContas().get(0);
		caixa.deposito(corrente1, 100);
		assertEquals(1100, corrente1.getSaldo());
		
		ContaEspecial especial1 = (ContaEspecial) caixa.getContas().get(1);
		caixa.deposito(especial1, 100);
		assertEquals(1100, especial1.getSaldo());
		
		ContaUniversitaria universitaria1 = (ContaUniversitaria) caixa.getContas().get(2);
		caixa.deposito(universitaria1, 100);
		assertEquals(1100, universitaria1.getSaldo());
		caixa.deposito(universitaria1, 1000);
		assertEquals(1100, universitaria1.getSaldo());
	}
	
	@Test
	@DisplayName("Teste de transferencia de uma conta corrente para corrente e especial")
	void transferenciaCorrente() {
		ContaCorrente corrente1 = (ContaCorrente) caixa.getContas().get(0);
		ContaCorrente corrente2 = (ContaCorrente) caixa.getContas().get(3);
		caixa.transferencia(corrente1, corrente2, 100);
		assertEquals(900, corrente1.getSaldo());
		assertEquals(1100, corrente2.getSaldo());
		
		caixa.transferencia(corrente1, corrente2, 1000);
		assertEquals(900, corrente1.getSaldo());
		assertEquals(1100, corrente2.getSaldo());
		
		ContaEspecial especial1 = (ContaEspecial) caixa.getContas().get(1);
		caixa.transferencia(corrente1, especial1, 100);
		assertEquals(800, corrente1.getSaldo());
		assertEquals(1100, especial1.getSaldo());
		
		caixa.transferencia(corrente1, especial1, 1000);
		assertEquals(800, corrente1.getSaldo());
		assertEquals(1100, especial1.getSaldo());
	}
	
	@Test
	@DisplayName("Teste de transferencia de uma conta corrente para universitária")
	void transferenciaCorrenteUni() {
		ContaCorrente corrente1 = (ContaCorrente) caixa.getContas().get(0);
		ContaUniversitaria universitaria1 = (ContaUniversitaria) caixa.getContas().get(2);
		
		corrente1.deposito(1000);
		
		caixa.transferencia(corrente1, universitaria1, 100);
		assertEquals(1900, corrente1.getSaldo());
		assertEquals(1100, universitaria1.getSaldo());
		
		caixa.transferencia(corrente1, universitaria1, 1000);
		assertEquals(1900, corrente1.getSaldo());
		assertEquals(1100, universitaria1.getSaldo());
	}
	
	@Test
	@DisplayName("Teste de transferencia de uma conta especial para corrente e especial")
	void transferenciaEspecial() {
		ContaCorrente corrente1 = (ContaCorrente) caixa.getContas().get(0);
		ContaEspecial especial1 = (ContaEspecial) caixa.getContas().get(1);
		ContaEspecial especial2 = (ContaEspecial) caixa.getContas().get(4);
		
		caixa.transferencia(especial1, corrente1, 100);
		assertEquals(1100, corrente1.getSaldo());
		assertEquals(900, especial1.getSaldo());
		
		caixa.transferencia(especial1, corrente1, 600);
		assertEquals(1100, corrente1.getSaldo());
		assertEquals(900, especial1.getSaldo());
		
		caixa.transferencia(especial1, especial2, 100);
		assertEquals(1100, especial2.getSaldo());
		assertEquals(800, especial1.getSaldo());
	}
	
	@Test
	@DisplayName("Teste de transferencia de uma conta especial para universitária")
	void transferenciaEspecialUni() {
		ContaEspecial especial1 = (ContaEspecial) caixa.getContas().get(1);
		ContaUniversitaria universitaria1 = (ContaUniversitaria) caixa.getContas().get(2);
		
		especial1.setLimite(1000);
		especial1.deposito(1000);
		
		caixa.transferencia(especial1, universitaria1, 100);
		assertEquals(1900, especial1.getSaldo());
		assertEquals(1100, universitaria1.getSaldo());
		
		caixa.transferencia(especial1, universitaria1, 1000);
		assertEquals(1900, especial1.getSaldo());
		assertEquals(1100, universitaria1.getSaldo());
	}
	
	@Test
	@DisplayName("Teste de transferencia de uma conta universitaria para corrente e especial")
	void transferenciaUniversitaria() {
		ContaCorrente corrente1 = (ContaCorrente) caixa.getContas().get(0);
		ContaEspecial especial1 = (ContaEspecial) caixa.getContas().get(1);
		ContaUniversitaria universitaria1 = (ContaUniversitaria) caixa.getContas().get(2);
		
		caixa.transferencia(universitaria1, corrente1, 100);
		assertEquals(1100, corrente1.getSaldo());
		assertEquals(900, universitaria1.getSaldo());
		
		caixa.transferencia(universitaria1, corrente1, 1000);
		assertEquals(1100, corrente1.getSaldo());
		assertEquals(900, universitaria1.getSaldo());
		
		caixa.transferencia(universitaria1, especial1, 100);
		assertEquals(1100, especial1.getSaldo());
		assertEquals(800, universitaria1.getSaldo());
		
		caixa.transferencia(universitaria1, especial1, 1000);
		assertEquals(1100, especial1.getSaldo());
		assertEquals(800, universitaria1.getSaldo());
	}
	
	@Test
	@DisplayName("Teste de transferencia de uma conta universitaria para universitária")
	void transferenciaUniUni() {
		ContaUniversitaria universitaria1 = (ContaUniversitaria) caixa.getContas().get(2);
		ContaUniversitaria universitaria2 = (ContaUniversitaria) caixa.getContas().get(5);
		
		caixa.transferencia(universitaria1, universitaria2, 100);
		assertEquals(1100, universitaria2.getSaldo());
		assertEquals(900, universitaria1.getSaldo());
		
		caixa.transferencia(universitaria1, universitaria2, 1000);
		assertEquals(1100, universitaria2.getSaldo());
		assertEquals(900, universitaria1.getSaldo());
	}
}
