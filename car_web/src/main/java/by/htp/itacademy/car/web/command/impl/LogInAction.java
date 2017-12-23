package by.htp.itacademy.car.web.command.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.itacademy.car.web.command.Action;
import by.htp.itacademy.car.web.util.ResponseParameter;

public class LogInAction implements Action {

	private LogInAction() {
		
	}

	private static class Singletone {
		private static final LogInAction INSTANCE = new LogInAction();
	}
	
	public static LogInAction getInstance() {
		return Singletone.INSTANCE;
	}
	
	@Override
	public ResponseParameter execute(HttpServletRequest request) {
		return null;
	}
}
