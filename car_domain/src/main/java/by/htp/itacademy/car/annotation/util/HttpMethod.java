package by.htp.itacademy.car.annotation.util;

import java.util.HashMap;
import java.util.Map;

public enum HttpMethod {

	GET, POST, PUT, DELETE;

	private static final Map<String, HttpMethod> mappings = new HashMap<String, HttpMethod>(8);

	static {
		for (HttpMethod httpMethod : values()) {
			mappings.put(httpMethod.name(), httpMethod);
		}
	}

	public static HttpMethod resolve(String method) {
		return (method != null ? mappings.get(method) : null);
	}

	public boolean matches(String method) {
		return (this == resolve(method));
	}

}
