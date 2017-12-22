package by.htp.itacademy.car.dao.connector;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;

import static by.htp.itacademy.car.dao.connector.ResourceParameter.*;

public final class JDBCConnectionPool extends AbstractConnectionPool implements IConnection {

	private Long connectionPoolSize = CONNECTION_POOL_INITIAL_SIZE;
	private Long numberOfConnectionsUsed = INITIAL_NUMBER_OF_CONNECTIONS_USED;
	
	private final static ConcurrentHashMap<Connection, Boolean> CONNECTIONS = new ConcurrentHashMap<Connection, Boolean>();
	
	private JDBCConnectionPool() {
		initResource(JDBC_RESOURCE_BUNDLE_PARAMETER_CONFIG, JDBC_RESOURCE_BUNDLE_PARAMETER_URL, JDBC_RESOURCE_BUNDLE_PARAMETER_LOGIN, 
				JDBC_RESOURCE_BUNDLE_PARAMETER_PASSWORD, JDBC_RESOURCE_BUNDLE_PARAMETER_DRIVER_NAME);
		
		fillingConnectionPool(CONNECTIONS, CONNECTION_POOL_INITIAL_SIZE);
	}

	private static class Singleton {
		private static final JDBCConnectionPool INSTANCE = new JDBCConnectionPool();
	}

	public static JDBCConnectionPool getInstance() {
		return Singleton.INSTANCE;
	}

	@Override
	public final Connection getConnection() {
		for (ConcurrentHashMap.Entry<Connection, Boolean> iter : CONNECTIONS.entrySet()) {
			if (!iter.getValue()) {
				CONNECTIONS.replace(iter.getKey(), true);
				numberOfConnectionsUsed++;
				return iter.getKey();
			} else if (numberOfConnectionsUsed == connectionPoolSize) {
				connectionPoolSize += 10;
				fillingConnectionPool(CONNECTIONS, connectionPoolSize);
				getConnection();
			}
		}
		return null;
	}

	@Override
	public final boolean putBack(Connection connection) {
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
	public final boolean close() {
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

