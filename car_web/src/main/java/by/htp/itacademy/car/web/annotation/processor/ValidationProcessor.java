package by.htp.itacademy.car.web.annotation.processor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.htp.itacademy.car.web.annotation.exception.IllegalParameterException;
import by.htp.itacademy.car.web.util.ConstantValue;

public final class ValidationProcessor implements AnnotationProcessor {
	
	public ValidationProcessor() {}
	
	public static void validator(Object obj, Map<String, String> regexParameters)
			throws Exception {
		
		Map<String, Object> fieldNameAndValue = getValuesFromEntity(obj);
		
		for (Entry<String, String> regex : regexParameters.entrySet()) {
			for (Entry<String, Object> value : fieldNameAndValue.entrySet()) {
				
				if (regex.getKey().contains((value.getKey()))) {
					
					Pattern pattern = Pattern.compile(regex.getValue());
					Matcher matcher = pattern.matcher(value.getValue().toString());
					if (!matcher.matches()) {
						throw new IllegalParameterException();
					}
				}
			}
		}
	}
	
	public static void chekAnnotation(Object obj, Class<? extends Annotation> clazz) 
			throws Exception {
		
		for (Field field : Methods.getDeclaredFields(obj)) {
			if (field.isAnnotationPresent(clazz)) {
				field.setAccessible(true);
				validator(field.get(obj), ConstantValue.REGEX_PARAMETERS);
			}
			
		}
	}
	
	public static Map<String, Object> getValuesFromEntity(Object obj) 
			throws Exception {
		
		if (obj == null) {
			throw new IllegalArgumentException(); 
		}
		
		Map<String, Object> fieldNameAndValue = new ConcurrentHashMap<String, Object>();
		
		Field[] fields = Methods.getDeclaredFields(obj);
		
		for (Field field : fields) {
			field.setAccessible(true);
			if (field.get(obj) != null) {
				fieldNameAndValue.put(field.getName(), field.get(obj)); 
			}
		}
		return fieldNameAndValue;
	}
}
