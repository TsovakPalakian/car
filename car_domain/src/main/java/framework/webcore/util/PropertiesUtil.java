package framework.webcore.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static framework.FrameworkConstant.*;

import framework.util.ClassUtil;
import framework.util.ObjectUtils;

public class PropertiesUtil {
	
	public static Properties loadProperties(String constantsPath) {
		Properties properties = new Properties();
		InputStream inputStream = null;
		
		try {
			if (ObjectUtils.isEmptyString(constantsPath)) {
				throw new IllegalArgumentException("Configuration file can not be null!");
			}
			
			if (constantsPath.lastIndexOf(CONFIG_PREFIX) == -1) {
				constantsPath += CONFIG_PREFIX;
			}
			
			inputStream = ClassUtil.getClassLoader().getResourceAsStream(constantsPath);
			
			if (ObjectUtils.isNotNullObject(inputStream)) {
				properties.load(inputStream);
			}
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {}
		}
		return properties;
	}
	
	public static String getString(Properties properties, String key) {
		String value = "";
		if (properties.contains(key)) {
			value = properties.getProperty(key);
		}
		return value;
	}
	
	public static String getString(Properties properties, String key, String defaultValue) {
		String value = defaultValue;
		if (properties.containsKey(key)) {
			value = properties.getProperty(key);
		}
		return value;
	}
}
