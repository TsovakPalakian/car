package by.htp.itacademy.car.domain.annotation.processor.fillingindata;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import by.htp.itacademy.car.domain.annotation.FillingInData;
import by.htp.itacademy.car.domain.annotation.exception.IllegalParameterException;

public class FillingInDataForFieldProcessor extends FillingInDataProcessor {
	
	public void fillingInDataFromFormForFields(HttpServletRequest request, Class<?> clazz) 
			throws SecurityException, ClassNotFoundException, IllegalParameterException, InstantiationException, 
				IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		for (Field field : getDeclaredFields(clazz)) {
			if (field.isAnnotationPresent(FillingInData.class)) {
				if (!field.isAccessible()) {
					field.setAccessible(true);
				}
				
				initValues(request, clazz, field);
				
				if (paramsCount == values.length) {
					Object newObject = constructor.newInstance(values);
					field.set(clazz, newObject);
				} else {
					throw new IllegalArgumentException();
				}
			}
		}
	}
}
