package by.htp.itacademy.car.connector.util;

public interface ConnectionParameters {
	final static String PROPERTY_FILE_NAME = "config";
	final static String CONFIG_PARAMETER_URL = "db.url";
	final static String CONFIG_PARAMETER_LOGIN = "db.login";
	final static String CONFIG_PARAMETER_PASSWORD = "db.pass";
	final static String CONFIG_PARAMETER_DRIVER_NAME = "db.driver.name";
	
	final static Long INITIAL_CONNECTION_POOL_SIZE = 10L; 
	final static Long INITIAL_NUMBER_OF_CONNECTIONS_USED = 0L;
}
