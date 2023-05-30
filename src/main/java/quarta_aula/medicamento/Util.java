package quarta_aula.medicamento;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Util {
	
	private List<Medicamento> medicamentos = new ArrayList<>();
	private List<Pessoa> pessoas = new ArrayList<>();
	private List<Prescricao> prescricoes = new ArrayList<>();
	
	public void cadastraMedicamento(String nome, EnumAdministracao administracao) {
		Medicamento medicamento = new Medicamento(nome, administracao);
		medicamentos.add(medicamento);
	}
	
	public void addContraindicacao(Medicamento medicamento, String contraindicacao) {
		if(temMedicamento(medicamento)) {
			medicamento.addContraindicacao(contraindicacao);
		}
	}
	
	public void addIndicacao(Medicamento medicamento, String indicacao) {
		if(temMedicamento(medicamento)) {
			medicamento.addIndicacao(indicacao);
		}
	}
	
	public void cadastraPessoa(String nome, String sintoma) {
		Pessoa pessoa = new Pessoa(nome, sintoma);
		pessoas.add(pessoa);
	}
	
	public void addAlergia(Pessoa pessoa, String alergia) {
		if(temPessoa(pessoa)) {
			pessoa.addAlergia(alergia);
		}
	}
	
	public void addPrescricao(Pessoa pessoa) {
		if(temPessoa(pessoa)) {
			Prescricao prescricao = new Prescricao(pessoa);
			prescricao.addPrescricao(pessoa, medicamentos);
			prescricoes.add(prescricao);
		}
	}
	
	public String listaPessoaMedicamento(Pessoa pessoa) {
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
	
	public boolean temPessoa(Pessoa pessoa) {
		boolean temPessoa = false;
		for (Pessoa p : pessoas) {
			if(p.equals(pessoa)) {
				temPessoa = true;
			}
		}
		return temPessoa;
	}
	
	public boolean temMedicamento(Medicamento medicamento) {
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
