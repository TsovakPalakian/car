package by.htp.itacademy.car.domain.annotation.processor.fillingindata;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import javax.servlet.http.HttpServletRequest;

import by.htp.itacademy.car.domain.annotation.FillingInData;

public class FillingInDataForParameterProcessor extends FillingInDataProcessor {

	@Override
	public void fillingInDataFromFormForParameters(HttpServletRequest request, Object obj)
			throws Exception {
		
		for (Method method : getDeclaredMethods(obj)) {
			if (!method.isAccessible()) {
				method.setAccessible(true);
			}
			
			checkAnnotationAndInvokeMethod(request, obj, method);
			
		}
	}
	
	private void checkAnnotationAndInvokeMethod(HttpServletRequest request, Object obj, Method method) 
			throws Exception {
		Object[] methodValues = null;
		
		if (method.isAnnotationPresent(FillingInData.class)) {
			Parameter[] parameters = getParametersOfMethod(method);
			methodValues = new Object[parameters.length];
			
			for (Parameter parameter : parameters) {

				int i = 0;
				if (parameter.isAnnotationPresent(FillingInData.class)) {
					initValues(request, parameter);
					
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
}
