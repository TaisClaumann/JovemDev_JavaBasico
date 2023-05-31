package quinta_aula.exemplo_polimorfismo;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Forma {

	private String nome;
	private List<Forma> formas = new ArrayList<>();
	
	public Forma(String nome) {
		this.nome = nome;
	}
	
	public String desenhar() {
		return "Sou a Forma "+getNome();
	}
}
