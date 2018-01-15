package by.htp.itacademy.car.web.annotation.processor.fillingindata;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
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
		FillingInData annotationValue = (FillingInData) annotation;
		int paramsCount = annotationValue.numberOfParameters().getCount();
		RequestParametersEnum listOfParams = annotationValue.listOfParameters();
		
		Constructor<?> constructor = getConstructor(obj, paramsCount);
		Object[] values = getParametersFromRequest(request, obj, listOfParams);
	}
}
