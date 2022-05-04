package application.politicos.DTO;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import application.politicos.model.Partidos;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class PartidoDto {

	private Long id;
	private String nome;
	private String sigla;
	private String ideologia;
	private LocalDateTime dataFundacao;
	
	public PartidoDto(Partidos partido) {
		this.id = partido.getId();
		this.nome = partido.getNome();
		this.sigla = partido.getSigla();
		this.ideologia = partido.getIdeologia();
		this.dataFundacao = partido.getDataFundacao();
		
	}
	
	public static List<PartidoDto> converter(List<Partidos> partidos){
		return partidos.stream().map(PartidoDto::new).collect(Collectors.toList());
	}
	
	

	
}
