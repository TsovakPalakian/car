package by.htp.itacademy.car.web.annotation.processor.fillingindata;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import javax.servlet.http.HttpServletRequest;

import by.htp.itacademy.car.web.annotation.FillingInData;
import by.htp.itacademy.car.web.annotation.exception.IllegalParameterException;
import by.htp.itacademy.car.web.annotation.util.RequestParametersEnum;

public class FillingInDateForParameterProcessor extends FillingInDataProcessor {

	public void fillingInDataFromFormForParameters(HttpServletRequest request, Object obj, RequestParametersEnum params)
			throws IllegalParameterException, IllegalAccessException, IllegalArgumentException, 
				InvocationTargetException, SecurityException, ClassNotFoundException, InstantiationException {
		
		for (Method method : getDeclaredMethods(obj)) {
			if (!method.isAccessible()) {
				method.setAccessible(true);
			}
			
			Object[] args = null;
			
			for (Parameter parameter : getParametersOfMethod(method)) {

				int i = 0;
				if (parameter.isAnnotationPresent(FillingInData.class)) {
					
					initValues(request, obj, parameter);
					
					Object newObject = null;
					if (paramsCount == values.length) {
						newObject = constructor.newInstance(values);
					} else {
						throw new IllegalArgumentException();
					}
					
					args[i] = newObject;
					
				} else {
					args[i] = parameter.getClass().getClassLoader();
				}
			}
			
			method.invoke(obj, args);
		}
	}
}
