package by.htp.itacademy.car.dao.connector;

import java.sql.Connection;

public interface IConnection {
	
	Connection getConnection();
	
	boolean putBack(Connection connection);
	
	boolean close();
	
}
