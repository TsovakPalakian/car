package by.htp.itacademy.car.service.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = -8355639682421781074L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}
	
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
