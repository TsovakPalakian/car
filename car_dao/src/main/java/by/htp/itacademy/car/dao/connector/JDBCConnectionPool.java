package by.htp.itacademy.car.dao.connector;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;

import by.htp.connector.AbstractConnectionPool;
import by.htp.connector.DatabaseConnectionException;
import by.htp.connector.IConnection;

import static by.htp.itacademy.car.dao.connector.ResourceParameter.*;

public final class JDBCConnectionPool extends AbstractConnectionPool implements IConnection {

	private Long connectionPoolSize = CONNECTION_POOL_INITIAL_SIZE;
	private Long numberOfConnectionsUsed = INITIAL_NUMBER_OF_CONNECTIONS_USED;
	
	private final static ConcurrentHashMap<Connection, Boolean> CONNECTIONS = new ConcurrentHashMap<Connection, Boolean>();
	
	private JDBCConnectionPool() {
		try {
			initResource(JDBC_RESOURCE_BUNDLE_PARAMETER_CONFIG, JDBC_RESOURCE_BUNDLE_PARAMETER_URL, 
					JDBC_RESOURCE_BUNDLE_PARAMETER_LOGIN, JDBC_RESOURCE_BUNDLE_PARAMETER_PASSWORD, 
					JDBC_RESOURCE_BUNDLE_PARAMETER_DRIVER_NAME);
			
			fillingConnectionPool(CONNECTIONS, CONNECTION_POOL_INITIAL_SIZE);
		} catch (DatabaseConnectionException e) {
			e.printStackTrace();
		}
	}

	private static class Singleton {
		private static final JDBCConnectionPool INSTANCE = new JDBCConnectionPool();
	}

	public static JDBCConnectionPool getInstance() {
		return Singleton.INSTANCE;
	}

	@Override
	public final Connection getConnection() throws DatabaseConnectionException {
		for (ConcurrentHashMap.Entry<Connection, Boolean> iter : CONNECTIONS.entrySet()) {
			if (!iter.getValue()) {
				CONNECTIONS.replace(iter.getKey(), true);
				numberOfConnectionsUsed++;
				return iter.getKey();
			} else if (numberOfConnectionsUsed == connectionPoolSize) {
				connectionPoolSize += 10;
				try {
					fillingConnectionPool(CONNECTIONS, connectionPoolSize);
				} catch (DatabaseConnectionException e) {
					e.printStackTrace();
				}
				getConnection();
			}
		}
		return null;
	}
	
	@Override
	public boolean putBack(Connection connection) throws DatabaseConnectionException {
		for (ConcurrentHashMap.Entry<Connection, Boolean> iter : CONNECTIONS.entrySet()) {
			if (iter.getKey() == connection) {
				CONNECTIONS.replace(iter.getKey(), false);
				numberOfConnectionsUsed--;
				return true;
			}
		}
		return false;
	}

	@Override
	public final boolean close() throws DatabaseConnectionException {
		boolean error = false;
		for (ConcurrentHashMap.Entry<Connection, Boolean> iter : CONNECTIONS.entrySet()) {
			try {
				iter.getKey().close();
			} catch (SQLException e) {
				error = true;
			}
		}
		return !error;
	}
}

