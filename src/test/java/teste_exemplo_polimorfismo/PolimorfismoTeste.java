package teste_exemplo_polimorfismo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import quinta_aula.exemplo_polimorfismo.Cilindro;
import quinta_aula.exemplo_polimorfismo.Circulo;
import quinta_aula.exemplo_polimorfismo.Forma;
import quinta_aula.exemplo_polimorfismo.Quadrado;
import quinta_aula.exemplo_polimorfismo.Triangulo;

public class PolimorfismoTeste {
	
	List<Forma> formas = new ArrayList<>();
	
	@BeforeEach
	public void init() {
		formas.add(new Cilindro());
		formas.add(new Circulo());
		formas.add(new Quadrado());
		formas.add(new Triangulo());
		
	}

	@Test
	@DisplayName("Teste desenhar cilindro")
	public void desenharCilindro() {
		String s = formas.get(0).desenhar();
		assertEquals("Sou a Forma Cilindro", s);
	}
	
	@Test
	@DisplayName("Teste desenhar circulo")
	public void desenharCirculo() {
		String s = formas.get(1).desenhar();
		assertEquals("Sou um círculo e tenho meu próprio desenho", s);
	}
	
	@Test
	@DisplayName("Teste desenhar quadrado")
	public void desenharQuadrado() {
		String s = formas.get(2).desenhar();
		assertEquals("Sou a Forma Quadrado e tenho 4 lados", s);
	}
	
	@Test
	@DisplayName("Teste desenhar triangulo")
	public void desenharTriangulo() {
		String s = formas.get(3).desenhar();
		assertEquals("Sou a Forma Triângulo e tenho 3 lados", s);
	}
	
	@Test
	@DisplayName("Teste calcular área círculo")
	public void calculaAreaCirculo() {
		String s = "";
		
		if(formas.get(1) instanceof Circulo) {
			Circulo c = (Circulo) formas.get(1);
			s = c.calculaArea();
		}
		
		assertEquals("Minha área pode ser calculada", s);
	}
}
