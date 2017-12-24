package by.htp.itacademy.car.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.itacademy.car.web.util.ResponseParameter;

public interface Action {
	/**
	 *
	 */
	ResponseParameter execute(HttpServletRequest request, HttpServletResponse response);
	
}
