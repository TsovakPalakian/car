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
import by.htp.itacademy.car.domain.annotation.util.ListOfParametersEnum;

public abstract class FillingInDataProcessor extends AnnotationProcessor {
	
	protected Integer paramsCount;
	protected Constructor<?> constructor;
	protected Object[] values;
	
	protected void initValues(HttpServletRequest request, Parameter parameter) 
			throws SecurityException, ClassNotFoundException, IllegalParameterException {
		
		Annotation annotation = parameter.getAnnotation(FillingInData.class);
		transferAnnotation(request, parameter.getType(), annotation);
	}
	
	protected void initValues(HttpServletRequest request, Field field) 
			throws SecurityException, ClassNotFoundException, IllegalParameterException {
		
		Annotation annotation = field.getAnnotation(FillingInData.class);
		transferAnnotation(request, field.getType(), annotation);
	}
	
	private void transferAnnotation(HttpServletRequest request, Class<?> clazz, Annotation annotation) 
			throws SecurityException, ClassNotFoundException, IllegalParameterException {
		
		FillingInData annotationValue = (FillingInData) annotation;
		this.paramsCount = annotationValue.numberOfParameters().getCount();
		ListOfParametersEnum listOfParams = annotationValue.listOfParameters();
		
		this.constructor = getConstructor(clazz, this.paramsCount);
		this.values = getParametersFromRequest(request, listOfParams);
	}
	
	public void fillingInDataFromFormForParameters(HttpServletRequest request, Object obj)
			throws Exception {
		
	}
	
	public void fillingInDataFromFormForFields(HttpServletRequest request, Object obj) 
			throws Exception {
		
	}
}
