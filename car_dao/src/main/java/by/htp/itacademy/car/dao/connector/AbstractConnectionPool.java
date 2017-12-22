package by.htp.itacademy.car.dao.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractConnectionPool {
	
	private String url;
	private String login;
	private String password;

	protected void initResource(String config, String urlParam, String loginParam, 
			String passwordParam, String driverNameParam) {
		ResourceBundle rb = ResourceBundle.getBundle(config);

		url = rb.getString(url);
		login = rb.getString(login);
		password = rb.getString(password);

		String driver = rb.getString(driverNameParam);

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void fillingConnectionPool(ConcurrentHashMap<Connection, Boolean> connPool, Long size) {
		
		for (int i = connPool.size(); i < size; i++) {
			try {
				connPool.put(DriverManager.getConnection(url, login, password), false);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
