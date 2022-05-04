package application.politicos.validacao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidadorDeCargo.class)
public @interface ApenasAlgunsCargos {
	
	String message() default "Somente são permitidos cargos validos, casa não tenha cargo, marque como Nenhum";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload> [] payload() default {};

}
