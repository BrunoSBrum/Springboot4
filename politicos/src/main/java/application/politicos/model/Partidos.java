package application.politicos.model;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import application.politicos.validacao.IdeologiaPermitida;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;




@Entity @Getter @Setter @ToString @Table(name="partidos")
public class Partidos {
	
	


	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "O campo nome é obrigatório") 
	@NotNull
	private String nome;
	
	@NotEmpty(message = "O campo sigla é obrigatório") 
	@NotNull
	private String sigla;
	
	@IdeologiaPermitida
	@NotEmpty(message = "O campo ideologia é obrigatório, Esquerda, Direita ou Centro") 
	@NotNull
	private String ideologia;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_fundacao")
	private LocalDate dataFundacao;

	@OneToMany(mappedBy = "partidos", fetch = FetchType.EAGER,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH})
	private List<Associados> associados;
	
	
	public String getNome() {
		return nome;
	}

	

	public Partidos() {
		
	}
	
	
	public Partidos(@NotEmpty @NotNull String nome, @NotEmpty @NotNull String sigla,
			@NotEmpty @NotNull String ideologia, LocalDate dataFundacao) {
		this.nome = nome;
		this.sigla = sigla;
		this.ideologia = ideologia;
		this.dataFundacao = dataFundacao;
	}



	public static Object builder() {
		
		return null;
	}





	

	
	
	


	
	
}
