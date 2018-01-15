package by.htp.itacademy.car.web.annotation.processor.fillingindata;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import by.htp.itacademy.car.web.annotation.FillingInData;
import by.htp.itacademy.car.web.annotation.exception.IllegalParameterException;

public class FillingInDataForFieldProcessor extends FillingInDataProcessor {
	
	public void fillingInDataFromFormForFields(HttpServletRequest request, Object obj) 
			throws SecurityException, ClassNotFoundException, IllegalParameterException, InstantiationException, 
				IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		for (Field field : getDeclaredFields(obj)) {
			if (field.isAnnotationPresent(FillingInData.class)) {
				if (!field.isAccessible()) {
					field.setAccessible(true);
				}
				
				initValues(request, obj, field);
				
				if (paramsCount == values.length) {
					Object newObject = constructor.newInstance(values);
					field.set(obj, newObject);
				} else {
					throw new IllegalArgumentException();
				}
			}
		}
	}

	@Override
	public void fillingInDataFromFormForParameters(HttpServletRequest request, Object obj)
			throws IllegalParameterException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, SecurityException, ClassNotFoundException, InstantiationException {
		// TODO Auto-generated method stub
		
	}
}
