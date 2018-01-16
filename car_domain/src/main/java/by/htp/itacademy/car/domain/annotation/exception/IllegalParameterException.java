package by.htp.itacademy.car.domain.annotation.exception;

@SuppressWarnings("serial")
public class IllegalParameterException extends Exception {

	public IllegalParameterException() {
		super();
	}

	public IllegalParameterException(String message, Throwable cause) {
		super(message, cause);
	}

	public IllegalParameterException(String message) {
		super(message);
	}

	public IllegalParameterException(Throwable cause) {
		super(cause);
	}
	
}
