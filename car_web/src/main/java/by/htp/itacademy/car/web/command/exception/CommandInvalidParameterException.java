package by.htp.itacademy.car.web.command.exception;

@SuppressWarnings("serial")
public class CommandInvalidParameterException extends Exception {

	public CommandInvalidParameterException() {
		super();
	}

	public CommandInvalidParameterException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommandInvalidParameterException(String message) {
		super(message);
	}

	public CommandInvalidParameterException(Throwable cause) {
		super(cause);
	}
	
}
