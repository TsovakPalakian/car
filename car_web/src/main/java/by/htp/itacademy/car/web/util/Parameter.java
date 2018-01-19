package by.htp.itacademy.car.web.util;

public final class Parameter {
	
	private Parameter() {}
	
	public static final String REQUEST_PARAMETER_ACTION = "command";
	public static final String SESSION_ATTRIBUTE_USER = "user";
	public static final String REQUEST_ATTRIBUTE_USER = "user";
	public static final String SESSION_ATTRIBUTE_ADMIN = "admin";
	public static final String REQUEST_ATTRIBUTE_ADMIN = "admin";
	public static final String REQUEST_ATTRIBUTE_MSG = "msg";
	
	public static final String MESSAGE_NO_ACCESS = "Sorry, but you do not have access to this page!";
	public static final String MESSAGE_NO_USER_WITH_SUCH_LOGIN = "There is no user with such login!";
	
	public static final String COOKIE_NAME_LOGIN = "login";
	public static final String COOKIE_NAME_PASSWORD = "password";
	
	public static final Integer ROLE_USER_VALUE = 0;
	public static final Integer ROLE_ADMIN_VALUE = 1;
	
}
