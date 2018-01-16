package by.htp.itacademy.car.domain.annotation.processor.fillingindata;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

import javax.servlet.http.HttpServletRequest;

import by.htp.itacademy.car.domain.annotation.FillingInData;
import by.htp.itacademy.car.domain.annotation.exception.IllegalParameterException;
import by.htp.itacademy.car.domain.annotation.processor.AnnotationProcessor;
import by.htp.itacademy.car.domain.annotation.util.RequestParametersEnum;

public abstract class FillingInDataProcessor extends AnnotationProcessor {
	
	protected Integer paramsCount;
	protected Constructor<?> constructor;
	protected Object[] values;
	
	protected void initValues(HttpServletRequest request, Class<?> clazz, Parameter parameter) 
			throws SecurityException, ClassNotFoundException, IllegalParameterException {
		System.out.println(clazz);
		Annotation annotation = parameter.getAnnotation(FillingInData.class);
		transferAnnotation(request, clazz, annotation);
	}
	
	protected void initValues(HttpServletRequest request, Class<?> clazz, Field field) 
			throws SecurityException, ClassNotFoundException, IllegalParameterException {
		
		Annotation annotation = field.getAnnotation(FillingInData.class);
		transferAnnotation(request, clazz, annotation);
	}
	
	private void transferAnnotation(HttpServletRequest request, Class<?> clazz, Annotation annotation) 
			throws SecurityException, ClassNotFoundException, IllegalParameterException {
		
		FillingInData annotationValue = (FillingInData) annotation;
		this.paramsCount = annotationValue.numberOfParameters().getCount();
		RequestParametersEnum listOfParams = annotationValue.listOfParameters();
		System.out.println(clazz);
		this.constructor = getConstructor(clazz, this.paramsCount);
		this.values = getParametersFromRequest(request, listOfParams);
	}
	
	public void fillingInDataFromFormForParameters(HttpServletRequest request, Object obj)
			throws IllegalParameterException, IllegalAccessException, IllegalArgumentException, 
			InvocationTargetException, SecurityException, ClassNotFoundException, InstantiationException {
		
	}
	
	public void fillingInDataFromFormForFields(HttpServletRequest request, Object obj) 
			throws SecurityException, ClassNotFoundException, IllegalParameterException, InstantiationException, 
				IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	}
}
