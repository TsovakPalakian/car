package by.htp.itacademy.car.sqlbuilder.exception;

@SuppressWarnings("serial")
public class IncorrectQueryException extends Exception {
	
	public IncorrectQueryException(String message) {
		super(message);
	}
	
	public IncorrectQueryException(Throwable cause) {
		super(cause);
	}
	
	public IncorrectQueryException(String message, Throwable cause) {
		super(message, cause);
	}
}
