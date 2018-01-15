package by.htp.itacademy.car.web.annotation.processor;

import java.lang.reflect.Constructor;

import by.htp.itacademy.car.web.annotation.exception.IllegalParameterException;


abstract class AnnotationProcessor {

	protected Constructor<?>[] getConstructors(Object obj) 
			throws IllegalParameterException, SecurityException, ClassNotFoundException {

		if (obj == null) {
			throw new IllegalParameterException("A object can not to be null!");
		}

		return Class.forName(obj.getClass().getName()).getConstructors();
	}

}
