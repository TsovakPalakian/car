package by.htp.itacademy.car.web.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import by.htp.itacademy.car.web.annotation.util.ConstructorParametersEnum;
import static by.htp.itacademy.car.web.annotation.util.ConstructorParametersEnum.*;

import static java.lang.annotation.ElementType.*;

@Documented
@Target({FIELD, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface FillingInData {
	
	String name();
	ConstructorParametersEnum numberOfParameters() default ZERO;
}
