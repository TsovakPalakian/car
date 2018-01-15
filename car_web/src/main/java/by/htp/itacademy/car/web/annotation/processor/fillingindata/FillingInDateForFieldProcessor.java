package by.htp.itacademy.car.web.annotation.processor.fillingindata;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import by.htp.itacademy.car.web.annotation.FillingInData;
import by.htp.itacademy.car.web.annotation.exception.IllegalParameterException;
import by.htp.itacademy.car.web.annotation.util.RequestParametersEnum;

public class FillingInDateForFieldProcessor extends FillingInDataProcessor {
	
	public void fillingInDataFromFormForFields(HttpServletRequest request, Object obj) 
			throws SecurityException, ClassNotFoundException, IllegalParameterException, InstantiationException, 
				IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		for (Field field : getDeclaredFields(obj)) {
			if (field.isAnnotationPresent(FillingInData.class)) {
				if (!field.isAccessible()) {
					field.setAccessible(true);
				}
				
				Annotation annotation = field.getAnnotation(FillingInData.class);
				FillingInData annotationValue = (FillingInData) annotation;
				int paramsCount = annotationValue.numberOfParameters().getCount();
				RequestParametersEnum listOfParams = annotationValue.listOfParameters();
				
				Constructor<?> constructor = getConstructor(obj, paramsCount);
				Object[] values = getParametersFromRequest(request, obj, listOfParams);
				
				if (paramsCount == values.length) {
					Object newObject = constructor.newInstance(values);
					field.set(obj, newObject);
				} else {
					throw new IllegalArgumentException();
				}
			}
		}
	}
}
