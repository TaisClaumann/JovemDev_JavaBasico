package quarta_aula.medicamento;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class Medicamento {
	
	@NonNull
	private String nome;
	@NonNull
	private EnumAdministracao administracao;
	private List<String> alergiasContra = new ArrayList<>();
	private List<String> indicacoes = new ArrayList<>();
	

	
}
