package by.htp.itacademy.car.web.command.impl;

import javax.crypto.Cipher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.itacademy.car.domain.entity.User;
import by.htp.itacademy.car.service.UserService;
import by.htp.itacademy.car.web.annotation.Cryptographer;
import by.htp.itacademy.car.web.annotation.FillingOutData;
import by.htp.itacademy.car.web.annotation.NewInstance;
import by.htp.itacademy.car.web.annotation.Validation;
import by.htp.itacademy.car.web.annotation.exception.IllegalParameterException;
import by.htp.itacademy.car.web.command.Action;
import by.htp.itacademy.car.web.util.ResponseValue;
import by.htp.itacademy.car.web.util.encryption.CipherMachine;
import lombok.Setter;

import static by.htp.itacademy.car.web.annotation.util.ConstructorParametersEnum.*;

public class LogInAction implements Action {
	
	private static final String NAME_OF_THE_PARAMETERS_FOR_USER_LOGIN = "userLogIn";
	
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
			request.setAttribute("msg", "Incorrect data entry");
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
			@Cryptographer(name = "encrypt", fields = {"password"}) User user) {
		
		return null;
	}
}
