package by.htp.itacademy.car.web.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.itacademy.car.domain.entity.User;
import by.htp.itacademy.car.service.UserService;
import by.htp.itacademy.car.web.command.Action;
import by.htp.itacademy.car.web.util.ResponseParameter;
import lombok.extern.log4j.Log4j;

@Log4j
public class LogInAction implements Action {
	
	private User user;
	private UserService userService;
	private ResponseParameter responseParameter;
	
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
		
		
		
		return null;
	}
}
