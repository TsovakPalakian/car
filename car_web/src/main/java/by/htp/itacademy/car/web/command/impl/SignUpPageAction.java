package by.htp.itacademy.car.web.command.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.itacademy.car.web.command.Action;
import by.htp.itacademy.car.web.util.ResponseParameter;

public class SignUpPageAction implements Action {

	private SignUpPageAction() {
		
	}

	private static class Singletone {
		private static final SignUpPageAction INSTANCE = new SignUpPageAction();
	}
	
	public static SignUpPageAction getInstance() {
		return Singletone.INSTANCE;
	}
	
	@Override
	public ResponseParameter execute(HttpServletRequest request) {
		return null;
	}
}
