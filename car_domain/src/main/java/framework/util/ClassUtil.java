package framework.util;

public class ClassUtil {
	public static ClassLoader getClassLoader() {
		return Thread.currentThread().getContextClassLoader();
	}

	public static Class<?> loadClass(String className) {
		return loadClass(className, true, getClassLoader());
	}
	
	public static Class<?> loadClass(String className, boolean isInit) {
		return loadClass(className, isInit, getClassLoader());
	}

	public static Class<?> loadClass(String className, boolean isInit, ClassLoader classLoader) {
		Class<?> cls = null;
		try {
			cls = Class.forName(className, true, classLoader);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return cls;
	}
}
