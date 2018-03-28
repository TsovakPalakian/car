package framework.connector;

public class DatabaseConnectionException extends Exception {

	private static final long serialVersionUID = 7535189139347015055L;

	public DatabaseConnectionException() {
		super();
	}

	public DatabaseConnectionException(String message, Throwable cause) {
		super(message, cause);
	}

	public DatabaseConnectionException(String message) {
		super(message);
	}

	public DatabaseConnectionException(Throwable cause) {
		super(cause);
	}
}
