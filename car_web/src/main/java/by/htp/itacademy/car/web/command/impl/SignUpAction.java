package by.htp.itacademy.car.web.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.itacademy.car.web.command.Action;
import by.htp.itacademy.car.web.util.ResponseParameter;

public class SignUpAction implements Action {

	private SignUpAction() {
		
	}

	private static class Singletone {
		private static final SignUpAction INSTANCE = new SignUpAction();
	}
	
	public static SignUpAction getInstance() {
		return Singletone.INSTANCE;
	}
	
	@Override
	public ResponseParameter execute(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}
}
