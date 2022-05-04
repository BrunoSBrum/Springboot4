package application.politicos.validacao;

import java.util.ArrayList;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidadoSexo implements ConstraintValidator<MasculinoOuFeminino, String>{
	
	ArrayList<String> sexo = new ArrayList<String>();
	
	@Override
	public boolean isValid(String resultSexo, ConstraintValidatorContext constraintValidatorContext) {
		
		sexo.add("Masculino");
		sexo.add("Feminino");
		
		
		return sexo.contains(resultSexo);

}
}
