package by.htp.itacademy.car.service.exception;

@SuppressWarnings("serial")
public class ServiceNoSuchUserException extends Exception {

	public ServiceNoSuchUserException() {
		super();
	}

	public ServiceNoSuchUserException(String message) {
		super(message);
	}

	public ServiceNoSuchUserException(Throwable cause) {
		super(cause);
	}
	
	public ServiceNoSuchUserException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
