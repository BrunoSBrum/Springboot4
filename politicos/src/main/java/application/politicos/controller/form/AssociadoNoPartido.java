package application.politicos.controller.form;

import application.politicos.model.Associados;
import application.politicos.model.Partidos;
import application.politicos.repository.AssociadoRepository;
import application.politicos.repository.PartidoRepository;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class AssociadoNoPartido {

	private Long idAssociado;
	private Long idPartido;
	

	@SuppressWarnings("deprecation")
	public Associados vincularPartido(PartidoRepository pRepository, AssociadoRepository aRepository) {
		System.out.println(idAssociado);
		
		Associados associados =  aRepository.getOne(idAssociado);
		Partidos partidos = pRepository.getOne(idPartido);
		
		associados.setPartidos(partidos);
		return associados;
		
		
}
	
	
	
	
}
