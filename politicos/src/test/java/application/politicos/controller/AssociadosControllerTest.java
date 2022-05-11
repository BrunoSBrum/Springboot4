package application.politicos.controller;


import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import application.politicos.model.Associados;
import application.politicos.repository.AssociadoRepository;
import util.AssociadosCreator;

@ExtendWith(SpringExtension.class)
class AssociadosControllerTest {

	@InjectMocks
	private AssociadosController associadosController;
	
	@Mock
	private AssociadoRepository repository;
	
	
	@BeforeEach
	void setUp() {
		PageImpl<Associados> associadosPage = 
				new PageImpl<>(List.of(AssociadosCreator.createValidAssociados()));
		BDDMockito.when(repository.listAll(ArgumentMatchers.any()))
			.thenReturn(associadosPage);
				
	}
	/*
	@Test
	@DisplayName("List return list of associados inside page object when successful")
	void list_ReturnsListAssociados_WhenSucessful() {
		String expectedName = AssociadosCreator.createValidAssociados().getNome();
		
		AssociadosDto associadosPage = associadosController.listar(null, null).get(0);
		
		Assertions.assertAll(associadosPage).isNotNull(;)
	}

	
	*/
}
