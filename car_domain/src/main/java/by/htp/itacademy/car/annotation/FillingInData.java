package by.htp.itacademy.car.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import by.htp.itacademy.car.annotation.util.ConstructorParametersEnum;
import by.htp.itacademy.car.annotation.util.ListOfParametersEnum;

import static by.htp.itacademy.car.annotation.util.ConstructorParametersEnum.*;
import static by.htp.itacademy.car.annotation.util.ListOfParametersEnum.*;
import static java.lang.annotation.ElementType.*;

@Documented
@Target({METHOD, FIELD, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface FillingInData {
	
	String from() default "";
	ListOfParametersEnum listOfParameters() default EMPTY;
	ConstructorParametersEnum numberOfParameters() default ZERO;
}
