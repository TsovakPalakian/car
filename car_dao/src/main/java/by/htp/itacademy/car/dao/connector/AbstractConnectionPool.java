package by.htp.itacademy.car.dao.connector;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static by.htp.itacademy.car.dao.connector.ResourceParameter.*;

public abstract class AbstractConnectionPool {
	
	private String url;
	private String login;
	private String password;
	
	protected void initResource() {
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
	
	protected void fillingConnectionPool() {
		for (int i = CONNECTIONS.size(); i < this.size; i++) {
			try {
				CONNECTIONS.put(DriverManager.getConnection(url, login, password), false);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
