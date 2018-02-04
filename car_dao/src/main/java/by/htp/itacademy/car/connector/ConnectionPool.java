package by.htp.itacademy.car.connector;

import static by.htp.itacademy.car.connector.util.ConnectionParameters.*;

import java.sql.Connection;
import java.util.concurrent.ConcurrentHashMap;

public final class ConnectionPool extends AbstractConnectionPool implements IConnection {

	private Long connectionPoolSize = INITIAL_CONNECTION_POOL_SIZE;
	private Long numberOfConnectionsUsed = INITIAL_NUMBER_OF_CONNECTIONS_USED;
	
	private final static ConcurrentHashMap<Connection, Boolean> CONNECTIONS = new ConcurrentHashMap<Connection, Boolean>();
	
	private ConnectionPool() {
		try {
			initResource(PROPERTY_FILE_NAME, CONFIG_PARAMETER_URL, CONFIG_PARAMETER_LOGIN,
					CONFIG_PARAMETER_PASSWORD, CONFIG_PARAMETER_DRIVER_NAME);
			
			fillingConnectionPool(CONNECTIONS, INITIAL_CONNECTION_POOL_SIZE);
		} catch (DatabaseConnectionException e) {
			e.printStackTrace();
		}
	}

	private static class Singleton {
		private static final ConnectionPool INSTANCE = new ConnectionPool();
	}

	public static ConnectionPool getInstance() {
		return Singleton.INSTANCE;
	}

	@Override
	public final Connection getConnection() throws DatabaseConnectionException {
		return getConnectionAbstract(CONNECTIONS, connectionPoolSize, numberOfConnectionsUsed);
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

