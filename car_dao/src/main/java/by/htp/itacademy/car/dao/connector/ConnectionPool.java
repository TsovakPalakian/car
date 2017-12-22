package by.htp.itacademy.car.dao.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

public final class ConnectionPool {
	
	private final static String RESOURCE_BUNDLE_PARAMETER_CONFIG = "config";
	private final static String RESOURCE_BUNDLE_PARAMETER_URL = "db.url";
	private final static String RESOURCE_BUNDLE_PARAMETER_LOGIN = "db.login";
	private final static String RESOURCE_BUNDLE_PARAMETER_PASSWORD = "db.pass";
	private final static String RESOURCE_BUNDLE_PARAMETER_DRIVER_NAME = "db.driver.name";
	
	private final static Integer CONNECTION_POOL_INITIAL_SIZE = 10; 
	private final static Integer INITIAL_NUMBER_OF_CONNECTIONS_USED = 0;

	private final ConcurrentHashMap<Connection, Boolean> connections;
	private int size;
	private int numberOfConnection;

	private String url;
	private String login;
	private String password;

	private ConnectionPool() {
		this.size = CONNECTION_POOL_INITIAL_SIZE;
		this.numberOfConnection = INITIAL_NUMBER_OF_CONNECTIONS_USED;
		connections = new ConcurrentHashMap<Connection, Boolean>();
		initResource();
		fillingConnectionPool();
	}

	private static class Singleton {
		private static final ConnectionPool INSTANCE = new ConnectionPool();
	}

	public static ConnectionPool getInstance() {
		return Singleton.INSTANCE;
	}

	private void initResource() {
		ResourceBundle rb = ResourceBundle.getBundle(RESOURCE_BUNDLE_PARAMETER_CONFIG);

		url = rb.getString(RESOURCE_BUNDLE_PARAMETER_URL);
		login = rb.getString(RESOURCE_BUNDLE_PARAMETER_LOGIN);
		password = rb.getString(RESOURCE_BUNDLE_PARAMETER_PASSWORD);

		String driver = rb.getString(RESOURCE_BUNDLE_PARAMETER_DRIVER_NAME);

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void fillingConnectionPool() {
		for (int i = connections.size(); i < this.size; i++) {
			try {
				connections.put(DriverManager.getConnection(url, login, password), false);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public final Connection getConnection() {
		for (ConcurrentHashMap.Entry<Connection, Boolean> iter : connections.entrySet()) {
			if (!iter.getValue()) {
				connections.replace(iter.getKey(), true);
				numberOfConnection++;
				return iter.getKey();
			} else if (numberOfConnection == size) {
				size += 1;
				fillingConnectionPool();
				getConnection();
			}
		}
		return null;
	}

	public final boolean putBack(Connection connection) {
		for (ConcurrentHashMap.Entry<Connection, Boolean> iter : connections.entrySet()) {
			if (iter.getKey() == connection) {
				connections.replace(iter.getKey(), false);
				numberOfConnection--;
				return true;
			}
		}
		return false;
	}

	public final boolean close() {
		boolean error = false;
		for (ConcurrentHashMap.Entry<Connection, Boolean> iter : connections.entrySet()) {
			try {
				iter.getKey().close();
			} catch (SQLException e) {
				error = true;
			}
		}
		return !error;
	}
}

