package by.htp.itacademy.car.web.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ConstantValue {

	private ConstantValue() {
	}

	public static final String REQUEST_PARAM_ACTION = "command";
	public static final String PARAMETERS_FOR_LOGIN = "login";
	public static final String PARAMETERS_FOR_SIGNUP = "signup";

	public static final String PAGE_CATALOG_AUTO = "/catalog_auto.jsp";
	public static final String PAGE_HOME = "jsp/home_page.jsp";
	public static final String SESSION_ATTRIBUTE_USER = "user";
	public static final String REQUEST_ATTRIBUTE_MSG = "msg";

	public static final Map<String, List<String>> ALL_MAPS_OF_PARAMETERS = new ConcurrentHashMap<String, List<String>>();

	static {
		List<String> parametersForSignUp = new LinkedList<>();
		parametersForSignUp.add("name");
		parametersForSignUp.add("surname");
		parametersForSignUp.add("login");
		parametersForSignUp.add("password");
		parametersForSignUp.add("passport");
		parametersForSignUp.add("email");
		parametersForSignUp.add("phoneNumber");
		parametersForSignUp.add("driverLicence");
		ALL_MAPS_OF_PARAMETERS.put(PARAMETERS_FOR_SIGNUP, parametersForSignUp);
	}

	static {
		List<String> parametersForLogIn = new LinkedList<>();
		parametersForLogIn.add("login");
		parametersForLogIn.add("password");
		ALL_MAPS_OF_PARAMETERS.put(PARAMETERS_FOR_LOGIN, parametersForLogIn);
	}

	static {
		List<String> parametersForUpdateData = new LinkedList<>();
		parametersForUpdateData.add("new_password");
		parametersForUpdateData.add("gender");
		parametersForUpdateData.add("birthday");
		parametersForUpdateData.add("email");
		parametersForUpdateData.add("phoneNumber");
		parametersForUpdateData.add("driverLicence");
		ALL_MAPS_OF_PARAMETERS.put("customertoupdate", parametersForUpdateData);
	}

	public static final Map<String, String> REGEX_PARAMETERS = new ConcurrentHashMap<String, String>();

	static {
		REGEX_PARAMETERS.put("login", "[A-z0-9]{3,20}");
		REGEX_PARAMETERS.put("password", "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\\!\\@\\#\\$\\%\\^\\&\\*]).{8,100})");
		REGEX_PARAMETERS.put("name", "[A-Z]{1}[a-z]{0,100}");
		REGEX_PARAMETERS.put("surname", "[A-Z]{1}[a-z]{0,100}");
		REGEX_PARAMETERS.put("email", "^[a-zA-Z0-9.,_%+-]+@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,4}$");
		REGEX_PARAMETERS.put("passport", "[A-Z]{2}[0-9]{7}");
		REGEX_PARAMETERS.put("phoneNumber", "[\\+]{1}[0-9]{2,4}[0-9]+");
	}
}
