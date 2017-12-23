package by.htp.itacademy.car.web.command.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.itacademy.car.web.command.Action;
import by.htp.itacademy.car.web.util.ResponseParameter;

public class LogOutAction implements Action {

	private LogOutAction() {
		
	}

	private static class Singletone {
		private static final LogOutAction INSTANCE = new LogOutAction();
	}
	
	public static LogOutAction getInstance() {
		return Singletone.INSTANCE;
	}
	
	@Override
	public ResponseParameter execute(HttpServletRequest request) {
		return null;
	}
}
