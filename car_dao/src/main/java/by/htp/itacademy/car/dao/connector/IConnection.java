package by.htp.itacademy.car.dao.connector;

import java.sql.Connection;

public interface IConnection {
	
	Connection getConnection() throws DatabaseConnectionException;
	
	boolean putBack(Connection connection) throws DatabaseConnectionException;
	
	boolean close() throws DatabaseConnectionException;
	
}
