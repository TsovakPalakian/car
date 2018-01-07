package by.htp.itacademy.car.web.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.itacademy.car.domain.entity.User;
import by.htp.itacademy.car.service.UserService;
import by.htp.itacademy.car.web.annotation.FillingOutData;
import by.htp.itacademy.car.web.annotation.NewInstance;
import by.htp.itacademy.car.web.annotation.Validation;
import by.htp.itacademy.car.web.command.Action;
import by.htp.itacademy.car.web.util.ResponseParameter;

import static by.htp.itacademy.car.web.annotation.util.ConstructorParametersEnum.*;

public class LogInAction implements Action {
	
	@NewInstance
	@FillingOutData(name = "userLogIn", value = TWO)
	@Validation
	private User userFromForm;
	
	@NewInstance
	private User userFromDb;
	
	@NewInstance
	private UserService userService;
	
	private LogInAction() {}

	private static class Singletone {
		private static final LogInAction INSTANCE = new LogInAction();
	}
	
	public static LogInAction getInstance() {
		return Singletone.INSTANCE;
	}
	
	@Override
	public ResponseParameter execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		ResponseParameter responseParameter = new ResponseParameter(true);
		
		
		
		return null;
	}
}
