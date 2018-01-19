package by.htp.itacademy.car.domain.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import by.htp.itacademy.car.domain.annotation.util.ConstructorParametersEnum;
import by.htp.itacademy.car.domain.annotation.util.RequestParametersEnum;

import static by.htp.itacademy.car.domain.annotation.util.ConstructorParametersEnum.*;
import static by.htp.itacademy.car.domain.annotation.util.RequestParametersEnum.*;
import static java.lang.annotation.ElementType.*;

@Documented
@Target({METHOD, FIELD, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface FillingInData {
	
	String from() default "";
	RequestParametersEnum listOfParameters() default EMPTY;
	ConstructorParametersEnum numberOfParameters() default ZERO;
}
