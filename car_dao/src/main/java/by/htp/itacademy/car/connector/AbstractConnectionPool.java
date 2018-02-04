package by.htp.itacademy.car.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractConnectionPool {

	private String url;
	private String login;
	private String password;
	
	protected AbstractConnectionPool() {}

	protected final Connection getConnectionAbstract(ConcurrentHashMap<Connection, Boolean> conn,
			Long connectionPoolSize, Long numberOfConnectionsUsed) throws DatabaseConnectionException {

		for (ConcurrentHashMap.Entry<Connection, Boolean> iter : conn.entrySet()) {
			if (!iter.getValue()) {
				conn.replace(iter.getKey(), true);
				numberOfConnectionsUsed++;
				return iter.getKey();
			} else if (numberOfConnectionsUsed == connectionPoolSize) {
				connectionPoolSize += 10;
				try {
					fillingConnectionPool(conn, connectionPoolSize);
				} catch (DatabaseConnectionException e) {
					e.printStackTrace();
				}
				getConnectionAbstract(conn, connectionPoolSize, numberOfConnectionsUsed);
			}
		}
		return null;
	}

	protected boolean putBackAbstract(Connection connection, ConcurrentHashMap<Connection, Boolean> conn,
			Long numberOfConnectionsUsed) throws DatabaseConnectionException {
		
		for (ConcurrentHashMap.Entry<Connection, Boolean> iter : conn.entrySet()) {
			if (iter.getKey() == connection) {
				conn.replace(iter.getKey(), false);
				numberOfConnectionsUsed--;
				return true;
			}
		}
		return false;
	}

	protected final boolean closeAbstract(ConcurrentHashMap<Connection, Boolean> conn) throws DatabaseConnectionException {
		boolean error = false;
		for (ConcurrentHashMap.Entry<Connection, Boolean> iter : conn.entrySet()) {
			try {
				iter.getKey().close();
			} catch (SQLException e) {
				error = true;
			}
		}
		return !error;
	}
	
	protected void initResource(String configFileName, String urlParam, String loginParam, String passwordParam,
			String driverNameParam) throws DatabaseConnectionException {

		if (configFileName == null) {
			throw new DatabaseConnectionException("The configuration file name can not be null");
		}
		if (urlParam == null) {
			throw new DatabaseConnectionException("The connection URL can not be null");
		}
		if (loginParam == null) {
			throw new DatabaseConnectionException("The connection login can not be null");
		}
		if (passwordParam == null) {
			throw new DatabaseConnectionException("The connection password can not be null");
		}
		if (driverNameParam == null) {
			throw new DatabaseConnectionException("The connection driver name can not be null");
		}

		ResourceBundle rb = ResourceBundle.getBundle(configFileName);

		url = rb.getString(urlParam);
		login = rb.getString(loginParam);
		password = rb.getString(passwordParam);

		String driver = rb.getString(driverNameParam);

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void fillingConnectionPool(ConcurrentHashMap<Connection, Boolean> connPool, Long size)
			throws DatabaseConnectionException {

		if (connPool == null || size == null) {
			throw new DatabaseConnectionException("The connection pool size can not be null");
		}

		for (int i = connPool.size(); i < size; i++) {
			try {
				connPool.put(DriverManager.getConnection(url, login, password), false);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
