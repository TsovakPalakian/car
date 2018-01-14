package by.htp.itacademy.car.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.connector.DatabaseConnectionException;
import by.htp.itacademy.car.dao.connector.ConnectionPool;
import by.htp.itacademy.car.web.command.EnumAction;
import by.htp.itacademy.car.web.util.ResponseValue;

import static by.htp.itacademy.car.web.util.Parameter.*;

@SuppressWarnings("serial")
public class Controller extends HttpServlet {

	public Controller() {}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String command = request.getParameter(REQUEST_PARAMETER_ACTION);
		
		System.out.println(command);
		
		ResponseValue responseValue = EnumAction.valueOf(command.toUpperCase()).getAction().execute(request, response);
		
		if (responseValue.isStateResponse()) {
			response.getWriter().println(responseValue.getPageResponse());
		} else {
			request.getRequestDispatcher(responseValue.getPageResponse()).forward(request, response);
		}
	}

	@Override
	public void destroy() {
		super.destroy();
		try {
			ConnectionPool.getInstance().close();
		} catch (DatabaseConnectionException e) {
			
		}
	}
	
	
}
