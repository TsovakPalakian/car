package by.htp.itacademy.car.dao.connector;

import java.sql.Connection;
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
		return getAbstractConnection(CONNECTIONS, connectionPoolSize, numberOfConnectionsUsed);
	}
	
	@Override
	public boolean putBack(Connection connection) throws DatabaseConnectionException {
		return putBackAbstract(connection, CONNECTIONS, numberOfConnectionsUsed);
	}

	@Override
	public final boolean close() throws DatabaseConnectionException {
		return closeAbstract(CONNECTIONS);
	}
}

