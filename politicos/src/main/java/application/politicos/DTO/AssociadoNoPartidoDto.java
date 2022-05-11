package application.politicos.DTO;

import application.politicos.model.Associados;
import application.politicos.model.Partidos;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AssociadoNoPartidoDto {

	private String nome;
	private String cargo;
	private String nomePartido;
	
	
	
	public AssociadoNoPartidoDto(Associados associados, Partidos partidos) {
		this.setNome(associados.getNome());
		this.setCargo(associados.getCargo());
		this.setNomePartido(partidos.getNome());
		
	}
	
}
