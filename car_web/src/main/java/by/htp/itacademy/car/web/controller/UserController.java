package by.htp.itacademy.car.web.controller;

import javax.servlet.http.HttpSession;

import by.htp.itacademy.car.domain.entity.User;
import by.htp.itacademy.car.service.UserService;
import by.htp.itacademy.car.service.exception.ServiceException;
import by.htp.itacademy.car.service.exception.ServiceNoSuchUserException;
import framework.webcore.annotation.controller.Controller;
import framework.webcore.annotation.controller.Mapping;
import framework.webcore.annotation.controller.method.PostMapping;
import framework.webcore.annotation.controller.parameter.ReqBody;
import framework.webcore.annotation.initialization.AutoInit;
import framework.webcore.annotation.validation.Validate;
import framework.webcore.bean.View;
import framework.webcore.http.HttpStatus;

import static by.htp.itacademy.car.web.util.Parameter.*;

@Controller
@Mapping("user")
public class UserController {

	@AutoInit
	private UserService userService;

	@PostMapping("login")
	public View<User> login(@ReqBody @Validate User user, HttpSession session) {
		View<User> view = null;
		try {
			User userFromDB = userService.logIn(user);
			session.setAttribute(SESSION_ATTRIBUTE_USER, userFromDB);
			view = new View<>(userFromDB, HttpStatus.OK);
		} catch (ServiceNoSuchUserException e) {
			view = new View<>(HttpStatus.UNAUTHORIZED);
		}
		return view;
	}

	@PostMapping
	public View<User> signup(@ReqBody @Validate User user, HttpSession session) {
		View<User> view = null;
		try {
			userService.signUp(user);
			view = new View<>(user, HttpStatus.OK);
		} catch (ServiceException e) {
			view = new View<>(HttpStatus.BAD_REQUEST);
		}
		return view;
	}
	
	public void logout(HttpSession session) {
		session.setAttribute(SESSION_PARAMETER_USER, null);
	}
}
