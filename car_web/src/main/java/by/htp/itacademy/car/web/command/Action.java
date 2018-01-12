package by.htp.itacademy.car.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.itacademy.car.web.util.ResponseValue;

public interface Action {
	/**
	 *
	 */
	ResponseValue execute(HttpServletRequest request, HttpServletResponse response);
	
}
