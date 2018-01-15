package by.htp.itacademy.car.web.annotation.processor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import by.htp.itacademy.car.web.annotation.NewInstance;

public final class NewInstanceProcessor extends AnnotationProcessor {
	
	private static final String NEW_INSTANCE_METHOD_NAME = "getInstance";
	
	NewInstanceProcessor() {}
	
	protected void newInstance(Object obj) 
			throws Exception {
		
		if (obj == null) {
			throw new NullPointerException("The instance of a class cannot to be null.");
		}
		
		checkOfField(obj);
		
	}
	
	private void checkOfField(Object obj) 
			throws Exception {
		
		for (Field field : getDeclaredFields(obj)) {
			field.setAccessible(true);
			
			if (field.isAnnotationPresent(NewInstance.class)) {
				try {

					field.set(obj, getInstanceOfField(field).newInstance());
				
				} catch (IllegalAccessException e) {
				
					Method[] methods = field.getType().getMethods();
					
					newSingletoneInstance(obj, field, methods);
					
				}
			}
		}
	}
	private void newSingletoneInstance(Object obj, Field field, Method[] methods) 
			throws Exception {
		
		for (Method method : methods) {
			if (NEW_INSTANCE_METHOD_NAME.equals(method.getName())) {
				
				Constructor<?> constructor = field.getType().getDeclaredConstructor();
				constructor.setAccessible(true);
				field.set(obj, constructor.newInstance());
			
			}
		}
	}
}
