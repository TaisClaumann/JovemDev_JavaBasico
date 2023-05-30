package quarta_aula.medicamento;

import java.util.ArrayList;
import java.util.List;

public class Util {
	
	static public List<Medicamento> medicamentos = new ArrayList<>();
	static public List<Pessoa> pessoas = new ArrayList<>();
	static public List<Prescricao> prescricoes = new ArrayList<>();
	
	public static void cadastraMedicamento(String nome, EnumAdministracao administracao) {
		Medicamento medicamento = new Medicamento(nome, administracao);
		medicamentos.add(medicamento);
	}
	
	public static void addContraindicacao(Medicamento medicamento, String contraindicacao) {
		if(temMedicamento(medicamento)) {
			medicamento.addContraindicacao(contraindicacao);
		}
	}
	
	public static void addIndicacao(Medicamento medicamento, String indicacao) {
		if(temMedicamento(medicamento)) {
			medicamento.addIndicacao(indicacao);
		}
	}
	
	public static void cadastraPessoa(String nome, String sintoma) {
		Pessoa pessoa = new Pessoa(nome, sintoma);
		pessoas.add(pessoa);
	}
	
	public static void addAlergia(Pessoa pessoa, String alergia) {
		if(temPessoa(pessoa)) {
			pessoa.addAlergia(alergia);
		}
	}
	
	public static void addPrescricao(Pessoa pessoa) {
		if(temPessoa(pessoa)) {
			Prescricao prescricao = new Prescricao(pessoa);
			prescricao.addPrescricao(pessoa, medicamentos);
			prescricoes.add(prescricao);
		}
	}
	
	public static String listaPessoaMedicamento(Pessoa pessoa) {
		String lista = "";
		if(temPessoa(pessoa)) {
			
			for (Prescricao prescricao : prescricoes) {
				if(prescricao.getPessoa().equals(pessoa)) {
					lista = prescricao.toString();
				}
			}	
		}
		return lista;
	}
	
	public static boolean temPessoa(Pessoa pessoa) {
		boolean temPessoa = false;
		for (Pessoa p : pessoas) {
			if(p.equals(pessoa)) {
				temPessoa = true;
			}
		}
		return temPessoa;
	}
	
	public static boolean temMedicamento(Medicamento medicamento) {
		boolean temMedicamento = false;
		for (Medicamento m : medicamentos) {
			if(m.equals(medicamento)) {
				temMedicamento = true;
			}
		}
		return temMedicamento;
	}
	
	public void clearData() {
		medicamentos.clear();
		pessoas.clear();
	}

}
