package by.htp.itacademy.car.web.annotation.processor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import by.htp.itacademy.car.web.annotation.exception.IllegalParameterException;
import by.htp.itacademy.car.web.annotation.util.ConstructorParametersEnum;

public final class Methods {

	private Methods() {
	}

	protected static Class<?>[] getParameterTypes(Object obj, ConstructorParametersEnum count) 
			throws IllegalParameterException {
		
		if (obj == null) {
			throw new IllegalParameterException("A object can not to be null!");
		}

		Constructor<?>[] constructors = obj.getClass().getConstructors();

		Class<?>[] parameterTypes = null;
		
		for (int i = 0; i < constructors.length; ++i) {
			if (constructors[i].getParameterCount() == count.getCount()) {
				parameterTypes = constructors[i].getParameterTypes();
			}
		}
		
		if (parameterTypes == null) {
			throw new IllegalParameterException("A constructor with such a number of parameters does not exist!");
		}
		
		return null;
	}
	protected static Class<?>[] getParameterTypes(Object obj, byte count) 
			throws IllegalParameterException {
		
		if (obj == null) {
			throw new IllegalParameterException("A object can not to be null!");
		}

		Constructor<?>[] constructors = obj.getClass().getConstructors();

		Class<?>[] parameterTypes = null;
		
		for (int i = 0; i < constructors.length; ++i) {
			if (constructors[i].getParameterCount() == count) {
				parameterTypes = constructors[i].getParameterTypes();
			}
		}
		
		if (parameterTypes == null) {
			throw new IllegalParameterException("A constructor with such a number of parameters does not exist!");
		}
		
		return null;
	}
	protected static Field[] getDeclaredFields(Object obj) 
			throws IllegalParameterException {
		
		if (obj == null) {
			throw new IllegalParameterException("A object can not to be null!");
		}
		
		return obj.getClass().getDeclaredFields();
	}

	protected static Method[] getDeclaredMethods(Object obj) 
			throws IllegalParameterException {
		
		if (obj == null) {
			throw new IllegalParameterException("A object can not to be null!");
		}
		
		return obj.getClass().getDeclaredMethods();
	}
	
	protected static Class<?> getFieldClass(Field field) 
			throws ClassNotFoundException, IllegalParameterException {
		
		if (field == null) {
			throw new IllegalParameterException("A field can not to be null!");
		}
		
		return Class.forName(field.getType().getName());
	}

	protected static Constructor<?>[] getConstructors(Object obj) 
			throws IllegalParameterException, SecurityException, ClassNotFoundException {
		
		if (obj == null) {
			throw new IllegalParameterException("A object can not to be null!");
		}
		
		return Class.forName(obj.getClass().getName()).getConstructors();
	}
}
