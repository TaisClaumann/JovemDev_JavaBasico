package quinta_aula.exemplo_polimorfismo;

public class Circulo extends Forma{

	public Circulo() {
		super("Circulo");
	}

	@Override
	public String desenhar() { //sobrescreveu o desenhar de Forma
		return "Sou um círculo e tenho meu próprio desenho";
	}
	
	public String calculaArea() {
		return "Minha área pode ser calculada";
	}
}
