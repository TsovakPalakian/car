package by.htp.itacademy.car.dao.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

import static by.htp.itacademy.car.dao.connector.ResourceParameter.*;

public final class JDBCConnectionPool extends AbstractConnectionPool implements IConnection {

	private JDBCConnectionPool() {
		fillingConnectionPool();
	}

	private static class Singleton {
		private static final JDBCConnectionPool INSTANCE = new JDBCConnectionPool();
	}

	public static JDBCConnectionPool getInstance() {
		return Singleton.INSTANCE;
	}

	public final Connection getConnection() {
		for (ConcurrentHashMap.Entry<Connection, Boolean> iter : CONNECTIONS.entrySet()) {
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

