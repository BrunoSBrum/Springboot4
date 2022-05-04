package application.politicos.controller.form;

import java.time.LocalDateTime;
import java.util.Map;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;
import application.politicos.validacao.IdeologiaPermitida;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class PartidoForm {
	
	@NotEmpty @NotNull
	private String nome;
	
	@NotEmpty @NotNull
	private String sigla;
	
	@IdeologiaPermitida
	@NotEmpty @NotNull
	private String ideologia;
	
	@JsonFormat(pattern = "dd/MM/yyyy" )
	private LocalDateTime dataFundacao;
	

	public Map<String, ?> getId() {
		return null;
	}
	
	
}
