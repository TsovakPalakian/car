package by.htp.itacademy.car.web.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.itacademy.car.web.command.Action;
import by.htp.itacademy.car.web.util.ResponseValue;

public class LogInPageAction  implements Action {

	private LogInPageAction() {
		
	}

	private static class Singletone {
		private static final LogInPageAction INSTANCE = new LogInPageAction();
	}
	
	public static LogInPageAction getInstance() {
		return Singletone.INSTANCE;
	}
	
	@Override
	public ResponseValue execute(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}
}
