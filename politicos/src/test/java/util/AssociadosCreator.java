package util;

import java.time.LocalDate;

import application.politicos.model.Associados;

public class AssociadosCreator {

	public static Associados createAssociadosToBeSaved() {
		
		return new Associados("João", "Prefeito", "Masculino", LocalDate.of(2000, 5, 10));
		
	}
	
	public static Associados createValidAssociados() {
		Long id = 1L;
		return new Associados(id, "João", "Prefeito", "Masculino", LocalDate.of(2000, 5, 10));
		
	}
	
	public static Associados createValidUpdateAssociados() {
		Long id = 1L;
		return new Associados(id, "João", "Prefeito", "Masculino", LocalDate.of(2000, 5, 10));
		
	}
	
	
	
}
