package application.politicos.DTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import application.politicos.model.Associados;
import application.politicos.repository.AssociadoRepository;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Setter @Getter @ToString
public class AssociadosDto {

	
	@Autowired @Setter(value = AccessLevel.NONE) @Getter(value = AccessLevel.NONE)
	private AssociadoRepository associadoRepository;
	
		
	private Long id;
	private String nome;
	private String cargo;
	private String sexo;
	private LocalDate dataNascimento;	
	
	
	public AssociadosDto(Associados associados) {
		this.id = associados.getIdAssociado();
		this.nome = associados.getNome();
		this.cargo = associados.getCargo();
		this.sexo = associados.getSexo();
		this.dataNascimento = associados.getDataNascimento();
		
	
	}
	

	
	public List<Associados> listarNomeOrdem(){
		return associadoRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
		
	}
	
	
	public static List<AssociadosDto> converter(List<Associados> associados){
		return associados.stream().map(AssociadosDto::new).collect(Collectors.toList());
	}
	
	
	
	

}


