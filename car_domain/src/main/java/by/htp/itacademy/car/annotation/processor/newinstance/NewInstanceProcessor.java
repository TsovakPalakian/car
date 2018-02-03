package by.htp.itacademy.car.annotation.processor.newinstance;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import by.htp.itacademy.car.annotation.NewInstance;
import by.htp.itacademy.car.annotation.processor.AnnotationProcessor;

public class NewInstanceProcessor extends AnnotationProcessor {
	
	private static final String NEW_INSTANCE_METHOD_NAME = "getInstance";
	
	public NewInstanceProcessor() {}
	
	public void newInstance(Object obj) 
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
				
				Annotation annotation = null;
				NewInstance newInst = null;
				
				try {
					if (field.get(obj) == null) {
						annotation = field.getAnnotation(NewInstance.class);
						newInst = (NewInstance) annotation;
						
						field.set(obj, getInstanceOfClass(newInst.clazz()));
					}
					
				} catch (IllegalAccessException e) {
				
					Method[] methods = newInst.clazz().getMethods();
					
					newSingletoneInstance(obj, field, newInst.clazz(), methods);
				}
			}
		}
	}
	private void newSingletoneInstance(Object obj, Field field, Class<?> clazz, Method[] methods) 
			throws Exception {
		
		for (Method method : methods) {
			if (NEW_INSTANCE_METHOD_NAME.equals(method.getName())) {
				
				Constructor<?> constructor = clazz.getDeclaredConstructor();
				constructor.setAccessible(true);
				Object newObj = constructor.newInstance();
				field.set(obj, newObj);
				newInstance(newObj);
			}
		}
	}
}
