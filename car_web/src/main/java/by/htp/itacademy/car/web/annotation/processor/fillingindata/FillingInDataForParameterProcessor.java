package by.htp.itacademy.car.web.annotation.processor.fillingindata;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import javax.servlet.http.HttpServletRequest;

import by.htp.itacademy.car.web.annotation.FillingInData;
import by.htp.itacademy.car.web.annotation.exception.IllegalParameterException;

public class FillingInDataForParameterProcessor extends FillingInDataProcessor {

	@Override
	public void fillingInDataFromFormForParameters(HttpServletRequest request, Object obj)
			throws IllegalParameterException, IllegalAccessException, IllegalArgumentException, 
				InvocationTargetException, SecurityException, ClassNotFoundException, InstantiationException {
		
		for (Method method : getDeclaredMethods(obj)) {
			if (!method.isAccessible()) {
				method.setAccessible(true);
			}
			
			Parameter[] parameters = getParametersOfMethod(method);
			Object[] methodValues = new Object[parameters.length];
			
			for (Parameter parameter : parameters) {

				int i = 0;
				if (parameter.isAnnotationPresent(FillingInData.class)) {
					
					initValues(request, obj, parameter);
					
					Object newObject = null;
					if (paramsCount == values.length) {
						newObject = constructor.newInstance(values);
					} else {
						throw new IllegalArgumentException();
					}
					
					methodValues[i++] = newObject;
				} else {
					methodValues[i++] = parameter.getClass().getClassLoader();
				}
			}
			
			method.invoke(obj, methodValues);
		}
	}

	@Override
	public void fillingInDataFromFormForFields(HttpServletRequest request, Object obj)
			throws SecurityException, ClassNotFoundException, IllegalParameterException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	}
}
