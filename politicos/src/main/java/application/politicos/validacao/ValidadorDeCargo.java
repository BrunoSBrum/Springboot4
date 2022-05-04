package application.politicos.validacao;

import java.util.ArrayList;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidadorDeCargo implements ConstraintValidator<ApenasAlgunsCargos, String> {
	
	
	ArrayList<String> cargos = new ArrayList<String>();
	
	@Override
	public boolean isValid(String cargo, ConstraintValidatorContext constraintValidatorContext) {
		
		
		cargos.add("Vereador");
		cargos.add("Prefeito");
		cargos.add("Deputado Federal");
		cargos.add("Deputado Estadual");
		cargos.add("Senador");
		cargos.add("Governador");
		cargos.add("Presidente");
		cargos.add("Nenhum");
		

		return cargos.contains(cargo);
	}

}
