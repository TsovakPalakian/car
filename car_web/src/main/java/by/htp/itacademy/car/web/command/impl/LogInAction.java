package by.htp.itacademy.car.web.command.impl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.itacademy.car.domain.annotation.Cryptographer;
import by.htp.itacademy.car.domain.annotation.FillingInData;
import by.htp.itacademy.car.domain.annotation.NewInstance;
import by.htp.itacademy.car.domain.annotation.Validation;
import by.htp.itacademy.car.domain.entity.User;
import by.htp.itacademy.car.service.UserService;
import by.htp.itacademy.car.service.exception.ServiceNoSuchUserException;
import by.htp.itacademy.car.service.impl.UserServiceImpl;
import by.htp.itacademy.car.web.command.Action;
import by.htp.itacademy.car.web.util.ResponseValue;

import static by.htp.itacademy.car.domain.annotation.util.ConstructorParametersEnum.TWO;
import static by.htp.itacademy.car.domain.annotation.util.RequestParametersEnum.LOG_IN;
import static by.htp.itacademy.car.web.util.AddressPage.*;
import static by.htp.itacademy.car.web.util.Parameter.*;

public class LogInAction implements Action {

	private LogInAction() {}

	private static class Singletone {
		private static final LogInAction INSTANCE = new LogInAction();
	}

	public static LogInAction getInstance() {
		return Singletone.INSTANCE;
	}
	
	@Validation
	@FillingInData(from = "form", listOfParameters = LOG_IN, numberOfParameters = TWO) 
	private User user;
	
	@NewInstance(clazz = UserServiceImpl.class)
	private UserService userService;

	@Override
	public ResponseValue execute(HttpServletRequest request, HttpServletResponse response) {

		//responseValue.setPageResponse("WEB-INF/page/jsp/log_in_page.jsp");
		//request.setAttribute(REQUEST_ATTRIBUTE_MSG, "Incorrect data entry");
		ResponseValue responseValue = authorisationUser(request, response, this.user);
		return responseValue;
	}

	private ResponseValue authorisationUser(HttpServletRequest request, HttpServletResponse response, User user) {

		ResponseValue responseValue = new ResponseValue(true);
		try {
			
			user = userService.logIn(user);
			inputCookie(response, user);

			if (user.getRole() == ROLE_USER_VALUE) {
				
				request.getSession().setAttribute(SESSION_ATTRIBUTE_USER, user);
				request.setAttribute(REQUEST_ATTRIBUTE_USER, request.getSession().getAttribute(SESSION_ATTRIBUTE_USER));
				
			} else if (user.getRole() == ROLE_ADMIN_VALUE) {
				
				request.getSession().setAttribute(REQUEST_ATTRIBUTE_ADMIN, user);
				request.setAttribute(REQUEST_ATTRIBUTE_ADMIN, request.getSession().getAttribute(SESSION_ATTRIBUTE_ADMIN));
				
			}
			responseValue.setPageResponse(PAGE_LOG_IN);
		} catch (ServiceNoSuchUserException e) {
			
			responseValue.setPageResponse(PAGE_LOG_IN);
			request.setAttribute(REQUEST_ATTRIBUTE_MSG_NAME, REQUEST_ATTRIBUTE_MSG_VALUE);
			
			return responseValue;
		}
		return responseValue;
	}

	private void inputCookie(HttpServletResponse response, User user) {
		response.addCookie(new Cookie(COOKIE_NAME_LOGIN, user.getLogin()));
		response.addCookie(new Cookie(COOKIE_NAME_PASSWORD, user.getPassword()));
	}	
}
