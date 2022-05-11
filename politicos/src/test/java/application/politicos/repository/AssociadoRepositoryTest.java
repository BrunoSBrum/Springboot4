package application.politicos.repository;


import java.time.LocalDate;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import application.politicos.model.Associados;
import application.politicos.model.Partidos;


@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class AssociadoRepositoryTest {

	@Autowired
	private AssociadoRepository repository;
	
	@Test
	@DisplayName("save in database, when return successful")
	public void saveInDatabase() {
		Associados associados = new Associados("João", "Prefeito", "Masculino", LocalDate.of(2000, 5, 10));
		this.repository.save(associados);
		
		Assertions.assertThat(associados.getIdAssociado()).isNotNull();
		Assertions.assertThat(associados.getNome()).isEqualTo("João");
		Assertions.assertThat(associados.getCargo()).isEqualTo("Prefeito");
		Assertions.assertThat(associados.getSexo()).isEqualTo("Masculino");
		Assertions.assertThat(associados.getDataNascimento()).isEqualTo(LocalDate.of(2000, 5, 10));
		
	}
	
	@Test
	@DisplayName("delete in database, when return successful")
	public void deleteDate() {
		Associados associados = new Associados("João", "Prefeito", "Masculino", LocalDate.of(2000, 5, 10));
		repository.save(associados);
		
		repository.delete(associados);
		
		Assertions.assertThat(repository.findById(associados.getIdAssociado())).isEmpty();
	
}
	
	@Test
	@DisplayName("update in database, when return successful")
	public void update() {
		Associados associados = new Associados("João", "Prefeito", "Masculino", LocalDate.of(2000, 5, 10));
		repository.save(associados);
		
		associados.setNome("Joaquina");
		associados.setCargo("Presidente");
		
		repository.save(associados);
		
		Assertions.assertThat(associados.getNome()).isEqualTo("Joaquina");
		Assertions.assertThat(associados.getCargo()).isEqualTo("Presidente");
	
}
	@Test
	@DisplayName("Find by name return list when successful")
	public void findByname_ReturnListPartidos() {
		Associados associadoToBeSaved = new Associados("João", "Prefeito", "Masculino", LocalDate.of(2000, 5, 10));
		Associados associadoSalvo = this.repository.save(associadoToBeSaved);
		
		String name = associadoSalvo.getNome();
		
		List<Associados> associados = this.repository.findByNome(name);
		
		Assertions.assertThat(associados).isNotEmpty();
		Assertions.assertThat(associados).contains(associadoSalvo);
	}
	
	@Test
	@DisplayName("Find by name return empty list when no name is found")
	public void findByname_ReturnEmpty() {

		List<Associados> associados = this.repository.findByNome("xaxa");
		
		Assertions.assertThat(associados).isEmpty();
	}
	
	@Test
	@DisplayName("Save throw ConstraintViolationException when name is empty")
	public void save_Throws_NameIsEmpty() {
		Associados associados = new Associados();
		
		Assertions.assertThatThrownBy(() -> this.repository.save(associados))
			.isInstanceOf(ConstraintViolationException.class);

	}
}	
