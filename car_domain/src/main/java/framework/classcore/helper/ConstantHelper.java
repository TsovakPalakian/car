package framework.classcore.helper;

import java.util.Properties;

import static framework.FrameworkConstant.*;
import framework.webcore.util.PropertiesUtil;

public class ConstantHelper {
	
	private static final Properties constantProperties = PropertiesUtil.loadProperties(CONSTANT_PROPERTIES);
	
	public static String getString(String key) {
		return PropertiesUtil.getString(constantProperties, key);
	}
	
	public static String getString(String key, String defaultValue) {
		return PropertiesUtil.getString(constantProperties, key, defaultValue);
	}
}
