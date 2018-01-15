package by.htp.itacademy.car.web.annotation.processor.fillingindata;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import javax.servlet.http.HttpServletRequest;

import by.htp.itacademy.car.web.annotation.FillingInData;
import by.htp.itacademy.car.web.annotation.util.RequestParametersEnum;

public class FillingInDateForParameterProcessor extends FillingInDataProcessor {

	public void fillingInDataFromFormForParameters(HttpServletRequest request, Object obj,
			RequestParametersEnum params) {

	}

	public void getMethods(Object obj) throws Exception {

		Method[] methods = obj.getClass().getDeclaredMethods();

		for (Method method : methods) {

			if (!method.isAccessible()) {
				method.setAccessible(true);
			}

			Parameter[] parameters = method.getParameters();

			Object[] args = new Object[parameters.length];

			int i = 0;
			for (Parameter parameter : parameters) {
				Annotation annotation = getAnnotation(obj, parameter);
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
