package by.htp.itacademy.car.web.annotation.processor.fillingindata;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import javax.servlet.http.HttpServletRequest;

import by.htp.itacademy.car.web.annotation.FillingInData;
import by.htp.itacademy.car.web.annotation.processor.AnnotationProcessor;
import by.htp.itacademy.car.web.annotation.util.RequestParametersEnum;

public abstract class FillingInDataProcessor extends AnnotationProcessor {
	
	public void fillingInDataFromFormForFields(HttpServletRequest request, Object obj) 
			throws Exception {
		
		for (Field field : getDeclaredFields(obj)) {
			if (field.isAnnotationPresent(FillingInData.class)) {
				
				if (!field.isAccessible()) {
					field.setAccessible(true);
				}
				
				Annotation annotation = field.getAnnotation(FillingInData.class);
				FillingInData annotationValue = (FillingInData) annotation;
				
				Constructor<?> constructor = getConstructor(obj, annotationValue.numberOfParameters().getCount());
				Object[] values = getParametersFromRequest(request, obj, annotationValue.listOfParameters());
				Object newObject = constructor.newInstance(values);
				
				field.set(obj, newObject);
			}
		}
	}
	
	public void fillingInDataFromFormForParameters(HttpServletRequest request, Object obj, RequestParametersEnum params) {
		
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
