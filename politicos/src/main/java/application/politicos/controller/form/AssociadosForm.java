package application.politicos.controller.form;

import java.time.LocalDateTime;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import application.politicos.model.Associados;
import application.politicos.model.Partidos;
import application.politicos.repository.PartidoRepository;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class AssociadosForm {
	
	
	private String nome;
	private String cargo;
	private String sexo;
	private LocalDateTime dataNascimento;
	@ManyToOne@JoinColumn(name = "nomePartido")
	private String nomePartido;
	
	
	public Associados converter() {
		
		return new Associados(nome, cargo, sexo, dataNascimento);
	}

	public Associados converter(PartidoRepository partidoRepository) {
		Partidos partido = partidoRepository.findByNome(nomePartido);
		return new Associados(nome, cargo, sexo, dataNascimento, partido);
	}

	
	
}
