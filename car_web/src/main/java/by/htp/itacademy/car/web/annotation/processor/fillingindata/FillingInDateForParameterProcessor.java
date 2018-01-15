package by.htp.itacademy.car.web.annotation.processor.fillingindata;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import javax.servlet.http.HttpServletRequest;

import by.htp.itacademy.car.web.annotation.FillingInData;
import by.htp.itacademy.car.web.annotation.exception.IllegalParameterException;
import by.htp.itacademy.car.web.annotation.util.RequestParametersEnum;

public class FillingInDateForParameterProcessor extends FillingInDataProcessor {

	public void fillingInDataFromFormForParameters(HttpServletRequest request, Object obj, RequestParametersEnum params)
			throws IllegalParameterException {
		
		for (Method method : getDeclaredMethods(obj)) {
			if (!method.isAccessible()) {
				method.setAccessible(true);
			}
			for (Parameter parameter : getParametersOfMethod(method)) {
				
			}
		}
	}

	

	public Annotation getAnnotation(Object obj, Parameter parameter) {
		Annotation[] annotations = parameter.getDeclaredAnnotations();
		FillingInData annotValue = null;
		for (Annotation annotation : annotations) {
			if (annotation.annotationType() == FillingInData.class) {
				annotValue = (FillingInData) annotation;
			}
		}
		return annotValue;
	}
}
