package by.htp.itacademy.car.web.command;

import javax.servlet.http.HttpServletRequest;

import by.htp.itacademy.car.dao.connector.ResourceParameter;

public interface Action {
	/**
	 *
	 */
	ResourceParameter execute(HttpServletRequest request);
	
}
