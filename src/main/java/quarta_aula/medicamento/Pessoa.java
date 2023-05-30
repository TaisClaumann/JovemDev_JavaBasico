package quarta_aula.medicamento;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Pessoa {
	
	@NonNull
	private String nome;
	@NonNull
	private String sintoma;
	private List<String> alergias = new ArrayList<>();
	
	public void addAlergia(String alergia){
		alergias.add(alergia);
	}
	
	public String listaAlergia() {
		String lista = "Alergias:"+"\n";
		
		for (String alergia : alergias) {
			lista += "- "+alergia;
		}
		
		return lista;
	}
	
	public String toString() {
		return nome+"  Sintoma: "+sintoma+"\n"
			   + listaAlergia();
	}
}
