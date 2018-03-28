package by.htp.itacademy.car.web.util;

public interface Parameter {
	
	static final String REQUEST_PARAMETER_ACTION = "command";
	static final String SESSION_ATTRIBUTE_USER = "user";
	static final String REQUEST_ATTRIBUTE_USER = "user";
	static final String SESSION_ATTRIBUTE_ADMIN = "admin";
	static final String REQUEST_ATTRIBUTE_ADMIN = "admin";
	static final String REQUEST_ATTRIBUTE_MSG = "msg";
	
	static final String SESSION_PARAMETER_USER = "user";
	
	static final String MESSAGE_NO_ACCESS = "Sorry, but you do not have access to this page!";
	static final String MESSAGE_NO_USER_WITH_SUCH_LOGIN = "There is no user with such login!";
	static final String MESSAGE_INCORRECT_DATA_ENTRY = "Incorrect data entry!";
	
	static final String COOKIE_NAME_LOGIN = "login";
	static final String COOKIE_NAME_PASSWORD = "password";
	
	static final Integer ROLE_USER_VALUE = 0;
	static final Integer ROLE_ADMIN_VALUE = 1;
	
}
