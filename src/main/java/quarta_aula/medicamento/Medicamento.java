package quarta_aula.medicamento;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Medicamento {
	
	@NonNull
	private String nome;
	@NonNull
	private EnumAdministracao administracao;
	private List<String> contraindicacoes = new ArrayList<>();
	private List<String> indicacoes = new ArrayList<>();
	
	public void addContraindicacao(String contra){
		contraindicacoes.add(contra);
	}
	
	public void addIndicacao(String indca){
		indicacoes.add(indca);
	}
}
