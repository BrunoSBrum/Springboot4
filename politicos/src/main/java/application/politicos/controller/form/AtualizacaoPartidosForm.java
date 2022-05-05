package application.politicos.controller.form;

import java.time.LocalDate;

import application.politicos.model.Partidos;
import application.politicos.repository.PartidoRepository;
import lombok.Getter;
import lombok.Setter;



@Getter @Setter
public class AtualizacaoPartidosForm {

	private String nome;
	private String sigla;
	private String ideologia;
	private LocalDate dataFundacao;

	
	public Partidos atualizar(Long id, PartidoRepository partidoRepository) {
		
		@SuppressWarnings("deprecation")
		Partidos partidos = partidoRepository.getOne(id);
		partidos.setNome(this.nome);
		partidos.setSigla(this.sigla);
		partidos.setIdeologia(this.ideologia);
		partidos.setDataFundacao(this.dataFundacao);
		
		return partidos;
	}
	
}
