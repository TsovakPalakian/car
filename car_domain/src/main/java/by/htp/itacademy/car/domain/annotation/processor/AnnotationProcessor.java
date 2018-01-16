package by.htp.itacademy.car.domain.annotation.processor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import javax.servlet.http.HttpServletRequest;

import by.htp.itacademy.car.domain.annotation.exception.IllegalParameterException;
import by.htp.itacademy.car.domain.annotation.util.RequestParametersEnum;

public abstract class AnnotationProcessor {

	// There is the problem of choosing a constructor of class with an equal number
	// of parameters.
	protected Constructor<?> getConstructor(Class<?> clazz, int paramCount)
			throws IllegalParameterException, SecurityException, ClassNotFoundException {

		System.out.println(clazz);
		if (clazz == null) {
			throw new IllegalParameterException("An object can not to be null!");
		}
		System.out.println("obj " + clazz);
		Constructor<?>[] constructors = getConstructors(clazz);
		for (Constructor<?> con : constructors) {
			System.out.println(con);
		}
		Constructor<?> constructor = null;

		for (int i = 0; i < constructors.length; ++i) {
			if (constructors[i].getParameterCount() == paramCount) {
				constructor = constructors[i];
			}
		}

		if (constructor == null) {
			throw new IllegalParameterException("A constructor with such a number of parameters does not exist!");
		}
		
		System.out.println(constructor.getName() + " : " + constructor.getParameterCount());

		return constructor;
	}

	// There is the problem of choosing parameter types the constructor of a class
	// with an equal number
	// of parameters.
	protected Class<?>[] getParameterTypesOfConstructor(Class<?> clazz, int paramCount)
			throws IllegalParameterException, SecurityException, ClassNotFoundException {

		if (clazz == null) {
			throw new IllegalParameterException("An object can not to be null!");
		}

		Constructor<?>[] constructors = getConstructors(clazz);

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

	protected Class<?> getInstanceOfField(Field field) 
			throws ClassNotFoundException, IllegalParameterException, 
				IllegalArgumentException, IllegalAccessException {

		if (field == null) {
			throw new IllegalParameterException("A field can not to be null!");
		}
		
		Class<?> clazz = Class.forName(field.getType().getName());
		return clazz;
	}
	
	protected Object getInstanceOfClass(Class<?> clazz) 
			throws IllegalParameterException, InstantiationException, IllegalAccessException {
		
		if (clazz == null) {
			throw new IllegalParameterException("A class can not to be null!");
		}
		
		return clazz.newInstance();
	}
	
	protected Constructor<?>[] getConstructors(Class<?> clazz)
			throws IllegalParameterException, SecurityException, ClassNotFoundException {

		if (clazz == null) {
			throw new IllegalParameterException("An object can not to be null!");
		}
		System.out.println(clazz);
		System.out.println(clazz.getClass());
		System.out.println(clazz.getClass().getTypeName());
		System.out.println(clazz.getClass().getName());
		return clazz.getConstructors();
	}

	protected Object[] getParametersFromRequest(HttpServletRequest request, RequestParametersEnum params) {

		Object[] data = new Object[params.getList().size()];

		int i = 0;
		for (String value : params.getList()) {
			data[i] = request.getParameter(value);
			i++;
		}
		
		for (Object obje : data) {
			System.out.println(obje);
		}
		
		return data;
	}

	protected Parameter[] getParametersOfMethod(Method method) 
			throws IllegalParameterException {
		
		if (method == null) {
			throw new IllegalParameterException("A method can not be null!");
		}
		
		return method.getParameters();
	}
	
	protected Annotation[] getDeclaredAnnotationsOfParameter(Parameter parameter) 
			throws IllegalParameterException {
		
		if (parameter == null) {
			throw new IllegalParameterException("A parameter can not be null!");
		}
		
		return parameter.getDeclaredAnnotations();
	}
}
