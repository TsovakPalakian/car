package by.htp.itacademy.car.dao.connector;

import java.sql.Connection;
import java.util.concurrent.ConcurrentHashMap;

public final class ResourceParameter {
	protected final static String RESOURCE_BUNDLE_PARAMETER_CONFIG = "config";
	protected final static String RESOURCE_BUNDLE_PARAMETER_URL = "db.url";
	protected final static String RESOURCE_BUNDLE_PARAMETER_LOGIN = "db.login";
	protected final static String RESOURCE_BUNDLE_PARAMETER_PASSWORD = "db.pass";
	protected final static String RESOURCE_BUNDLE_PARAMETER_DRIVER_NAME = "db.driver.name";
	
	protected final static Integer CONNECTION_POOL_INITIAL_SIZE = 10; 
	protected final static Integer INITIAL_NUMBER_OF_CONNECTIONS_USED = 0;

	protected final static ConcurrentHashMap<Connection, Boolean> CONNECTIONS = new ConcurrentHashMap<Connection, Boolean>();
}
