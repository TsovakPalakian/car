package by.htp.itacademy.car.dao.exception;

public class DaoException extends Exception {

	private static final long serialVersionUID = -8240089860051822427L;

	public DaoException() {
		super();
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}
	
	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
