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
import static by.htp.itacademy.car.domain.annotation.util.RequestParametersEnum.LOG_IN;;

public class LogInAction implements Action {

	private LogInAction() {}

	private static class Singletone {
		private static final LogInAction INSTANCE = new LogInAction();
	}

	public static LogInAction getInstance() {
		return Singletone.INSTANCE;
	}
	
	private static final String NAME_OF_THE_PARAMETERS_FOR_USER_LOGIN = "userLogIn";
	public static final String REQUEST_ATTRIBUTE_MSG = "msg";

	@Validation
	@FillingInData(from = "form", listOfParameters = LOG_IN, numberOfParameters = TWO) 
	private User user;
	
	@NewInstance(clazz = UserServiceImpl.class)
	private UserService userService;

	@Override
	public ResponseValue execute(HttpServletRequest request, HttpServletResponse response) {

		ResponseValue responseValue = null;
		//responseValue.setPageResponse("WEB-INF/page/jsp/log_in_page.jsp");
		//request.setAttribute(REQUEST_ATTRIBUTE_MSG, "Incorrect data entry");
		//fillingInData(this.user);
		System.out.println("User hashCode: " + user.hashCode());
		responseValue = authorisationUser(request, response, this.user);
		return responseValue;
	}

//	@FillingInData
//	private void fillingInData(
//
//			@FillingInData(name = "form", listOfParameters = LOG_IN, numberOfParameters = TWO) 
//			@Validation User user) {
//		
//		this.user = user;
//	}

	private ResponseValue authorisationUser(HttpServletRequest request, HttpServletResponse response, User user) {

		ResponseValue responseValue = new ResponseValue(true);
		try {
			System.out.println("user result: " + user);
			user = userService.logIn(user);
			System.out.println("user: " + user);
			inputCookie(response, user);

			if (user.getRole() == null) {
				request.getSession().setAttribute("user", user);
				request.setAttribute("user", request.getSession().getAttribute("user"));
			} else if (user.getRole() == 1) {
				request.getSession().setAttribute("admin", user);
				request.setAttribute("admin", request.getSession().getAttribute("admin"));
			}
			responseValue.setPageResponse("WEB-INF/page/jsp/log_in_page.jsp");
		} catch (ServiceNoSuchUserException e) {
			responseValue.setPageResponse("WEB-INF/page/jsp/log_in_page.jsp");
			request.setAttribute(REQUEST_ATTRIBUTE_MSG, "There is no user with such login.");
			return responseValue;
		}
		return responseValue;
	}

	private void inputCookie(HttpServletResponse response, User user) {
		response.addCookie(new Cookie("logIn", user.getLogin()));
		response.addCookie(new Cookie("password", user.getPassword()));
	}	
}
