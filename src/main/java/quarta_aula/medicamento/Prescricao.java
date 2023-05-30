package quarta_aula.medicamento;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Prescricao {
	
	@NonNull
	private Pessoa pessoa;
	private List<Medicamento> medicamentos = new ArrayList<>();
	
	public void addPrescricao(Pessoa pessoa, List<Medicamento> todosMedicamentos) {
		String sintoma = pessoa.getSintoma();
		
		for (Medicamento medicamento : todosMedicamentos) {
			if(isIndicado(sintoma, medicamento) && !temAlergia(medicamento, pessoa)) {
				medicamentos.add(medicamento);
			}
		}
	}
	
	public boolean isIndicado(String sintoma, Medicamento medicamento) {
		boolean indicado = false;
		
		if(medicamento.getIndicacoes().contains(sintoma)) {
			indicado = true;
		}
		return indicado;
	}
	
	public boolean temAlergia(Medicamento medicamento, Pessoa pessoa) {
		boolean temAlergia = false;
		List<String> alergias = pessoa.getAlergias();
		
		for (String alergia : alergias) {
			if(medicamento.getContraindicacoes().contains(alergia)) {
				temAlergia = true;
			}
		}
	
		return temAlergia;
	}
	
	public String listaMedicamento() {
		String lista = "Medicamentos: "+"\n";
		
		for (Medicamento medicamento : medicamentos) {
			lista += "- "+medicamento.getNome()+"\n";
		}
		return lista;
	}
	
	public String toString() {
		return pessoa.toString()+listaMedicamento();
	}

}
