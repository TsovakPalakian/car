package by.htp.itacademy.car.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.itacademy.car.web.command.EnumAction;
import by.htp.itacademy.car.web.util.ResponseParameter;

import static by.htp.itacademy.car.web.util.Parameter.*;

public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1974009855854795944L;

	public Controller() {
		
	}

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
		
		ResponseParameter responseParam = EnumAction.valueOf(command.toUpperCase()).getAction().execute(request);
		
		if (responseParam.isStateResponse()) {
			response.getWriter().println(responseParam.getPageResponse());
		} else {
			request.getRequestDispatcher(responseParam.getPageResponse()).forward(request, response);
		}
	}
}
