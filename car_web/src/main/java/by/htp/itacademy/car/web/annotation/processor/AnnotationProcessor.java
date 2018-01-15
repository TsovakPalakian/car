package by.htp.itacademy.car.web.annotation.processor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import by.htp.itacademy.car.web.annotation.exception.IllegalParameterException;
import by.htp.itacademy.car.web.annotation.util.ConstructorParametersEnum;

abstract class AnnotationProcessor {

	protected Constructor<?> getConstructorByEnum(Object obj, ConstructorParametersEnum paramCount)
			throws IllegalParameterException, SecurityException, ClassNotFoundException {

		return getConstructorByEnum(obj, paramCount.getCount());
	}

	// There is the problem of choosing a constructor of class with an equal number
	// of parameters.
	protected Constructor<?> getConstructorByEnum(Object obj, int paramCount) 
			throws IllegalParameterException, SecurityException, ClassNotFoundException {

		if (obj == null) {
			throw new IllegalParameterException("An object can not to be null!");
		}

		Constructor<?>[] constructors = getConstructors(obj);
		Constructor<?> constructor = null;

		for (int i = 0; i < constructors.length; ++i) {
			if (constructors[i].getParameterCount() == paramCount) {
				constructor = constructors[i];
			}
		}

		if (constructor == null) {
			throw new IllegalParameterException("A constructor with such a number of parameters does not exist!");
		}

		return constructor;
	}

	protected Class<?>[] getParameterTypesOfConstructorByEnum(Object obj, ConstructorParametersEnum paramCount)
			throws IllegalParameterException, SecurityException, ClassNotFoundException {

		return getParameterTypesOfConstructorByInt(obj, paramCount.getCount());
	}

	protected Class<?>[] getParameterTypesOfConstructorByInt(Object obj, int paramCount)
			throws IllegalParameterException, SecurityException, ClassNotFoundException {

		if (obj == null) {
			throw new IllegalParameterException("An object can not to be null!");
		}

		Constructor<?>[] constructors = getConstructors(obj);

		Class<?>[] parameterTypes = null;

		for (int i = 0; i < constructors.length; ++i) {
			if (constructors[i].getParameterCount() == paramCount) {
				parameterTypes = constructors[i].getParameterTypes();
			}
		}

		if (parameterTypes == null) {
			throw new IllegalParameterException("A constructor with such a number of parameters does not exist!");
		}

		return parameterTypes;
	}

	protected Field[] getDeclaredFields(Object obj) throws IllegalParameterException {

		if (obj == null) {
			throw new IllegalParameterException("An object can not to be null!");
		}

		return obj.getClass().getDeclaredFields();
	}

	protected Method[] getDeclaredMethods(Object obj) throws IllegalParameterException {

		if (obj == null) {
			throw new IllegalParameterException("An object can not to be null!");
		}

		return obj.getClass().getDeclaredMethods();
	}

	protected Class<?> getInstanceOfField(Field field) throws ClassNotFoundException, IllegalParameterException {

		if (field == null) {
			throw new IllegalParameterException("A field can not to be null!");
		}

		return Class.forName(field.getType().getName());
	}

	protected Constructor<?>[] getConstructors(Object obj)
			throws IllegalParameterException, SecurityException, ClassNotFoundException {

		if (obj == null) {
			throw new IllegalParameterException("An object can not to be null!");
		}

		return Class.forName(obj.getClass().getName()).getConstructors();
	}

}
