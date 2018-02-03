package by.htp.itacademy.car.dao.connector;

public final class ConnectionParameters {
	protected final static String PROPERTY_FILE_NAME = "config";
	protected final static String CONFIG_PARAMETER_URL = "db.url";
	protected final static String CONFIG_PARAMETER_LOGIN = "db.login";
	protected final static String CONFIG_PARAMETER_PASSWORD = "db.pass";
	protected final static String CONFIG_PARAMETER_DRIVER_NAME = "db.driver.name";
	
	protected final static Long INITIAL_CONNECTION_POOL_SIZE = 10L; 
	protected final static Long INITIAL_NUMBER_OF_CONNECTIONS_USED = 0L;
}
