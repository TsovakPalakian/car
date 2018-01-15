package by.htp.itacademy.car.web.annotation.processor.fillingindata;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

import javax.servlet.http.HttpServletRequest;

import by.htp.itacademy.car.web.annotation.FillingInData;
import by.htp.itacademy.car.web.annotation.exception.IllegalParameterException;
import by.htp.itacademy.car.web.annotation.processor.AnnotationProcessor;
import by.htp.itacademy.car.web.annotation.util.RequestParametersEnum;

public abstract class FillingInDataProcessor extends AnnotationProcessor {
	
	protected Integer paramsCount;
	protected Constructor<?> constructor;
	protected Object[] values;
	
	protected void initValues(HttpServletRequest request, Object obj, Parameter parameter) 
			throws SecurityException, ClassNotFoundException, IllegalParameterException {
		
		Annotation annotation = parameter.getAnnotation(FillingInData.class);
		transferAnnotation(request, obj, annotation);
	}
	
	protected void initValues(HttpServletRequest request, Object obj, Field field) 
			throws SecurityException, ClassNotFoundException, IllegalParameterException {
		
		Annotation annotation = field.getAnnotation(FillingInData.class);
		transferAnnotation(request, obj, annotation);
	}
	
	private void transferAnnotation(HttpServletRequest request, Object obj, Annotation annotation) 
			throws SecurityException, ClassNotFoundException, IllegalParameterException {
		
		FillingInData annotationValue = (FillingInData) annotation;
		this.paramsCount = annotationValue.numberOfParameters().getCount();
		RequestParametersEnum listOfParams = annotationValue.listOfParameters();
		
		this.constructor = getConstructor(obj, this.paramsCount);
		this.values = getParametersFromRequest(request, obj, listOfParams);
	}
	
	public abstract void fillingInDataFromFormForParameters(HttpServletRequest request, Object obj)
			throws IllegalParameterException, IllegalAccessException, IllegalArgumentException, 
			InvocationTargetException, SecurityException, ClassNotFoundException, InstantiationException;
	
	public abstract void fillingInDataFromFormForFields(HttpServletRequest request, Object obj) 
			throws SecurityException, ClassNotFoundException, IllegalParameterException, InstantiationException, 
				IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
