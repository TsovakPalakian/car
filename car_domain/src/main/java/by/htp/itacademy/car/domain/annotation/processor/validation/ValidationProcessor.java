package by.htp.itacademy.car.domain.annotation.processor.validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.htp.itacademy.car.domain.annotation.Validation;
import by.htp.itacademy.car.domain.annotation.exception.IllegalParameterException;
import by.htp.itacademy.car.domain.annotation.processor.AnnotationProcessor;
import by.htp.itacademy.car.domain.annotation.util.ConstantValue;

public abstract class ValidationProcessor extends AnnotationProcessor {
	
	public ValidationProcessor() {}
	
	
	public void chekAnnotation(Object obj) 
			throws Exception {
		
		for (Field field : getDeclaredFields(obj)) {
			if (field.isAnnotationPresent(Validation.class)) {
				field.setAccessible(true);
				validator(field.get(obj), ConstantValue.REGEX_PARAMETERS);
			}
		}
	}
	
	public void validator(Object obj, Map<String, String> regexParameters)
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
	
	public Map<String, Object> getValuesFromEntity(Object obj) 
			throws Exception {
		
		if (obj == null) {
			throw new IllegalArgumentException(); 
		}
		
		Map<String, Object> fieldNameAndValue = new ConcurrentHashMap<String, Object>();
		
		Field[] fields = getDeclaredFields(obj);
		
		for (Field field : fields) {
			field.setAccessible(true);
			if (field.get(obj) != null) {
				fieldNameAndValue.put(field.getName(), field.get(obj)); 
			}
		}
		return fieldNameAndValue;
	}
}
