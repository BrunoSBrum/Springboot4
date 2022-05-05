package application.politicos.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import application.politicos.validacao.ApenasAlgunsCargos;
import application.politicos.validacao.MasculinoOuFeminino;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Entity @Setter @Getter @ToString @Table(name="associados")
public class Associados {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idAssociado;
	
	@NotNull @NotEmpty
	@Column(name = "nome")
	private String nome;
	
	@ApenasAlgunsCargos
	@NotEmpty @NotNull
	@Column(name = "cargo")
	private String cargo;
	
	@MasculinoOuFeminino 
	@NotEmpty @NotNull
	@Column(name = "sexo")
	private String sexo;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "partidos_id")
	private Partidos partidos;
	
	
	
	
	
	public Associados() {
		
	}
	
	

	public Associados(@NotNull @NotEmpty String nome, @NotEmpty @NotNull String cargo, @NotEmpty @NotNull String sexo,
			LocalDate dataNascimento) {
		this.nome = nome;
		this.cargo = cargo;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
	}



	public Associados(@NotNull @NotEmpty String nome, @NotEmpty @NotNull String cargo,
			@NotEmpty @NotNull String sexo,  LocalDate dataNascimento, Partidos partido) {
		this.nome = nome;
		this.cargo = cargo;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.partidos = partido;
	
	
	
	}


	

	

}
