package by.htp.itacademy.car.web.annotation.processor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import by.htp.itacademy.car.web.annotation.FillingInData;
import by.htp.itacademy.car.web.annotation.exception.IllegalParameterException;
import by.htp.itacademy.car.web.annotation.util.ConstructorParametersEnum;

public final class FillingInDataProcessor implements AnnotationProcessor {
	
	FillingInDataProcessor() {}
	
	void fillingInDataFromForm(HttpServletRequest request, Object obj, Map<String, List<String>> parametersFromForm) 
			throws Exception {
		
		for (Field field : obj.getClass().getDeclaredFields()) {
			if (field != null && field.isAnnotationPresent(FillingInData.class)) {
				if (!field.isAccessible()) {
					field.setAccessible(true);
				}
				
				Annotation annotation = field.getAnnotation(FillingInData.class);
				FillingInData fillingInData = (FillingInData) annotation;
				
				field.set(obj, getConstructor(obj, fillingInData.numberOfParameters())
						.newInstance(getParametersFromReques(request, obj, parametersFromForm)));
			}
		}
	}
	
	Object[] getParametersFromReques(HttpServletRequest request, Object obj, Map<String, List<String>> parametersFromForm) 
			throws Exception {
		
		String objSimpleName = obj.getClass().getSimpleName().toLowerCase();
		byte count = (byte) parametersFromForm.get(objSimpleName).size();
		Object[] data = new Object[count];
		
		int i = 0;
		for (String value : parametersFromForm.get(objSimpleName)) {
			data[i] = request.getParameter(value);
			i++;
		}

		return data;
	}
	
	Constructor<?> getConstructor(Object obj, ConstructorParametersEnum count) 
			throws IllegalParameterException {
		
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
