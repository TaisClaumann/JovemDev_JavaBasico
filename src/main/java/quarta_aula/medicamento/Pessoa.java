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
public class Pessoa {
	
	@NonNull
	private String nome;
	@NonNull
	private String sintoma;
	private List<String> alergias = new ArrayList<>();
	

}
