package by.htp.itacademy.car.web.command.impl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.itacademy.car.domain.entity.User;
import by.htp.itacademy.car.service.UserService;
import by.htp.itacademy.car.service.exception.ServiceNoSuchUserException;
import by.htp.itacademy.car.web.annotation.Cryptographer;
import by.htp.itacademy.car.web.annotation.FillingOutData;
import by.htp.itacademy.car.web.annotation.NewInstance;
import by.htp.itacademy.car.web.annotation.Validation;
import by.htp.itacademy.car.web.annotation.exception.IllegalParameterException;
import by.htp.itacademy.car.web.command.Action;
import by.htp.itacademy.car.web.util.ResponseValue;
import lombok.Setter;

import static by.htp.itacademy.car.web.annotation.util.ConstructorParametersEnum.*;

public class LogInAction implements Action {
	
	private static final String NAME_OF_THE_PARAMETERS_FOR_USER_LOGIN = "userLogIn";
	public static final String REQUEST_ATTRIBUTE_MSG = "msg";
	
	@Setter 
	private User user;
	
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
	public ResponseValue execute(HttpServletRequest request, HttpServletResponse response) {
		
		ResponseValue responseValue = new ResponseValue(true);
		User user = null;
		try {
			user = createUser(this.user);
		} catch (IllegalParameterException e) {
			responseValue.setPageResponse("WEB-INF/page/jsp/log_in_page.jsp");
			request.setAttribute(REQUEST_ATTRIBUTE_MSG, "Incorrect data entry");
			return responseValue;
		}
		
		return null;
	}
	
	private User createUser (
			
			@NewInstance
			@FillingOutData(
					name = "form",
					nameOfParameters = NAME_OF_THE_PARAMETERS_FOR_USER_LOGIN, 
					numberOfParameters = TWO)
			@Validation 
			User user) 
					throws IllegalParameterException {
		
		return user;
	}
	
	private ResponseValue authorisationUser(
			HttpServletRequest request,
			HttpServletResponse response,
			@Cryptographer(name = "encrypt", fields = {"password"}) User user) {
		
		ResponseValue responseValue = new ResponseValue(true);
		try {
			user = userService.logIn(user);
			if (user.getRole() == 0) {
				inputCookie(response);
			} else if (user.getRole() == 1) {
				
			}
		} catch (ServiceNoSuchUserException e) {
			responseValue.setPageResponse("WEB-INF/page/jsp/log_in_page.jsp");
			request.setAttribute(REQUEST_ATTRIBUTE_MSG, "There is no user with such login.");
			return responseValue;
		}
		return null;
	}
	
	private void inputCookie(HttpServletResponse response) {
		response.addCookie(new Cookie("logIn", this.user.getLogin()));
		response.addCookie(new Cookie("password", this.user.getPassword()));
	}
}
