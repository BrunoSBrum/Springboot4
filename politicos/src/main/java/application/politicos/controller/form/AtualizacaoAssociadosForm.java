package application.politicos.controller.form;

import java.time.LocalDate;

import application.politicos.model.Associados;
import application.politicos.repository.AssociadoRepository;
import lombok.Getter;
import lombok.Setter;



@Getter @Setter
public class AtualizacaoAssociadosForm {

	private String nome;
	private String cargo;
	private String sexo;
	private LocalDate dataNascimento;
	
	
	
	public Associados atualizar(Long id, AssociadoRepository associadoRepository) {
		
		@SuppressWarnings("deprecation")
		Associados associados = associadoRepository.getOne(id);

		associados.setNome(this.nome);
		associados.setCargo(this.cargo);
		associados.setSexo(this.sexo);
		associados.setDataNascimento(this.dataNascimento);
		
		return associados;
		
		
	}
	
	
}
