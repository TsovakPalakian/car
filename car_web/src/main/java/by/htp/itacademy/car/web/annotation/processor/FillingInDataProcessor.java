package by.htp.itacademy.car.web.annotation.processor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import by.htp.itacademy.car.web.annotation.FillingInData;
import by.htp.itacademy.car.web.annotation.exception.IllegalParameterException;
import by.htp.itacademy.car.web.annotation.util.ConstructorParametersEnum;

public final class FillingInDataProcessor implements AnnotationProcessor {
	
	public FillingInDataProcessor() {}
	
	public void fillingInDataFromFormForFields(HttpServletRequest request, Object obj, List<String> parametersFromForm) 
			throws IllegalAccessException, IllegalParameterException, InstantiationException {
		
		for (Field field : obj.getClass().getDeclaredFields()) {
			if (field != null && field.isAnnotationPresent(FillingInData.class)) {
				if (!field.isAccessible()) {
					field.setAccessible(true);
				}
				
				Annotation annotation = field.getAnnotation(FillingInData.class);
				FillingInData fillingInData = (FillingInData) annotation;
				
				try {
					field.set(obj, getConstructor(obj, fillingInData.numberOfParameters())
							.newInstance(getParametersFromReques(request, obj, parametersFromForm)));
				} catch (IllegalArgumentException e) {
					throw new IllegalArgumentException(e.getMessage());
				} catch (IllegalAccessException e) {
					throw new IllegalAccessException(e.getMessage());
				} catch (InstantiationException e) {
					throw new InstantiationException(e.getMessage());
				} catch (IllegalParameterException e) {
					throw new IllegalParameterException(e.getMessage());
				} catch (InvocationTargetException e) {
					
				}
			}
		}
	}
	
	public void fillingInDataFromFormForParameters(HttpServletRequest request, Object obj, List<String> parametersFromForm) {
		
	}
	
	Object[] getParametersFromReques(HttpServletRequest request, Object obj, List<String> parametersFromForm) {
		
		Object[] data = new Object[parametersFromForm.size()];
		
		int i = 0;
		for (String value : parametersFromForm) {
			data[i] = request.getParameter(value);
			i++;
		}

		return data;
	}
	
	//There is the problem of choosing a constructor of class with an equal number of parameters.
	Constructor<?> getConstructor(Object obj, ConstructorParametersEnum count) throws IllegalParameterException {
		
		if (obj == null) {
			throw new IllegalParameterException("An object can not to be null!");
		}

		Constructor<?>[] constructors = obj.getClass().getConstructors();
		Constructor<?> constructor = null;
		
		for (int i = 0; i < constructors.length; ++i) {
			if (constructors[i].getParameterCount() == count.getCount()) {
				constructor = constructors[i];
			}
		}
		
		if (constructor == null) {
			throw new IllegalParameterException("A constructor with such a number of parameters does not exist!");
		}
		
		return constructor;
	}
}
