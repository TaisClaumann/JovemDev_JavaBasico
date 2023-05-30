package quarta_aula.medicamento;

import java.util.ArrayList;
import java.util.List;

public class Util {
	
	static List<Medicamento> medicamentos = new ArrayList<>();
	static List<Pessoa> pessoas = new ArrayList<>();
	
	public static void cadastraMedicamento(String nome, EnumAdministracao administracao) {
		Medicamento medicamento = new Medicamento(nome, administracao);
		medicamentos.add(medicamento);
	}

}
