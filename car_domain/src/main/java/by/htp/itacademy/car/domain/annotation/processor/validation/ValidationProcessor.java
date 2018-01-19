package by.htp.itacademy.car.domain.annotation.processor.validation;

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

public class ValidationProcessor extends AnnotationProcessor {
	
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
	
	private <T> void validator(T t, Map<String, String> regexParameters)
			throws Exception {
		
		Map<String, Object> fieldNameAndValue = getFieldNameAndValue(t);
		
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
	
	private <T> Map<String, Object> getFieldNameAndValue(T t) 
			throws Exception {
		
		if (t == null) {
			throw new IllegalArgumentException(); 
		}
		
		Map<String, Object> fieldNameAndValue = new ConcurrentHashMap<String, Object>();
		
		Field[] fields = getDeclaredFields(t);
		
		for (Field field : fields) {
			field.setAccessible(true);
			if (field.get(t) != null) {
				fieldNameAndValue.put(field.getName(), field.get(t)); 
			}
		}
		return fieldNameAndValue;
	}
}
