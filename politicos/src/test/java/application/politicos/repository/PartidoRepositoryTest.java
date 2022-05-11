package application.politicos.repository;



import java.time.LocalDate;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import application.politicos.model.Partidos;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class PartidoRepositoryTest {

	@Autowired
	private PartidoRepository repository;
	
	@SuppressWarnings("deprecation")
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	

	@Test
	@DisplayName("save in database, when return successful")
	public void saveInDatabase() {
		Partidos partidos = new Partidos("Brasil sul", "BS", "Direita", LocalDate.of(2000, 5, 10));
		this.repository.save(partidos);
		
		Assertions.assertThat(partidos.getId()).isNotNull();
		Assertions.assertThat(partidos.getNome()).isEqualTo("Brasil sul");
		Assertions.assertThat(partidos.getSigla()).isEqualTo("BS");
		Assertions.assertThat(partidos.getIdeologia()).isEqualTo("Direita");
		Assertions.assertThat(partidos.getDataFundacao()).isEqualTo(LocalDate.of(2000, 5, 10));
		
	}
	@Test
	@DisplayName("delete in database, when return successful")
	public void deleteDate() {
		Partidos partidos = new Partidos("Brasil sul", "BS", "Direita", LocalDate.of(2000, 5, 10));
		repository.save(partidos);
		
		repository.delete(partidos);
		
		Assertions.assertThat(repository.findById(partidos.getId())).isEmpty();
	
}
	@Test
	@DisplayName("update in database, when return successful")
	public void update() {
		Partidos partidos = new Partidos("Brasil sul", "BS", "Direita", LocalDate.of(2000, 5, 10));
		repository.save(partidos);
		
		partidos.setNome("Brasil Norte");
		partidos.setIdeologia("Esquerda");
		
		repository.save(partidos);
		
		Assertions.assertThat(partidos.getNome()).isEqualTo("Brasil Norte");
		Assertions.assertThat(partidos.getIdeologia()).isEqualTo("Esquerda");
	
}
	
	
	@Test
	@DisplayName("Save throw ConstraintViolationException when name is empty")
	public void save_Throws_NameIsEmpty() {
		Partidos partidos = new Partidos();
		
		Assertions.assertThatThrownBy(() -> this.repository.save(partidos))
			.isInstanceOf(ConstraintViolationException.class);
		
			
	}
	
	/*@Test
	public void saveIdeologiaIncorreta() {
		Partidos partidos = new Partidos("Brasil sul", "BS", "Direitaaa", LocalDate.of(2000, 5, 10));
		this.repository.save(partidos);
		
	}
	*/
	
	@Test
	@DisplayName("Find by name return list when successful")
	public void findByname_ReturnListPartidos() {
		Partidos partidoToBeSaved = new Partidos("Brasil sul", "BS", "Direita", LocalDate.of(2000, 5, 10));
		Partidos partidoSalvo = this.repository.save(partidoToBeSaved);
		
		String name = partidoSalvo.getNome();
		
		List<Partidos> partidos = this.repository.findByNome(name);
		
		Assertions.assertThat(partidos).isNotEmpty();
		Assertions.assertThat(partidos).contains(partidoSalvo);
	}

	
	@Test
	@DisplayName("Find by name return empty list when no name is found")
	public void findByname_ReturnEmpty() {

		List<Partidos> partidos = this.repository.findByNome("xaxa");
		
		Assertions.assertThat(partidos).isEmpty();
	}
	
	
}
