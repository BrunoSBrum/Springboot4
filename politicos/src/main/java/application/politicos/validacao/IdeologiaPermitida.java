package application.politicos.validacao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidacaoIdeologia.class)
public @interface IdeologiaPermitida {
	
	String message() default "Somente é permitido as seguintes ideologias, Esquerda, Centro e Direita";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload> [] payload() default {};

}
