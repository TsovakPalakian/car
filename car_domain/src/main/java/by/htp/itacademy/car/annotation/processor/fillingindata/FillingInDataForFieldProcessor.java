package by.htp.itacademy.car.annotation.processor.fillingindata;

import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;

import by.htp.itacademy.car.annotation.FillingInData;

public class FillingInDataForFieldProcessor extends FillingInDataProcessor {

	@Override
	public void fillingInDataFromFormForFields(HttpServletRequest request, Object obj) throws Exception {
		for (Field field : getDeclaredFields(obj)) {
			if (field.isAnnotationPresent(FillingInData.class)) {
				if (!field.isAccessible()) {
					field.setAccessible(true);
				}
				System.out.println("field: " + field);
				initValues(request, field);
				
				if (paramsCount == values.length) {
					Object newObject = constructor.newInstance(values);
					System.out.println(newObject);
					field.set(obj, newObject);
				} else {
					throw new IllegalArgumentException();
				}
			}
		}
	}
	
}
