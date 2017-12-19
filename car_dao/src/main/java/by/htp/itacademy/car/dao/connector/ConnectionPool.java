package by.htp.itacademy.car.dao.connector;

import java.sql.Connection;
import java.util.concurrent.ConcurrentHashMap;

public final class ConnectionPool {
	
	private ConcurrentHashMap<Connection, Boolean> connections;
	private int size;
	private int numberOfConnection;
	
	
}
