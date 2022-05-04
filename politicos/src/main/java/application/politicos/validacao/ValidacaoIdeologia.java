package application.politicos.validacao;

import java.util.ArrayList;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidacaoIdeologia implements ConstraintValidator<IdeologiaPermitida, String> {
	
	ArrayList<String> ideologia = new ArrayList<String>();

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		ideologia.add("Direita");
		ideologia.add("Centro");
		ideologia.add("Esquerda");
		
		
		return ideologia.contains(value);
	}
	
	

}
