package by.htp.itacademy.car.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.connector.DatabaseConnectionException;
import by.htp.itacademy.car.dao.connector.ConnectionPool;
import by.htp.itacademy.car.web.command.Action;
import by.htp.itacademy.car.web.command.EnumAction;
import by.htp.itacademy.car.web.util.ResponseValue;
import lombok.extern.log4j.Log4j;

import static by.htp.itacademy.car.web.util.Parameter.*;

@Log4j
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
		String commandToUpperCase = command.toUpperCase();
		System.out.println(commandToUpperCase);
		
		Action action = EnumAction.valueOf(commandToUpperCase).getAction();
		ResponseValue responseValue = action.execute(request, response);
		
		PrintWriter printWriter = response.getWriter();
		if (responseValue.isStateResponse()) {
			printWriter.println(responseValue.getPageResponse());
		} 
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(responseValue.getPageResponse());
		dispatcher.forward(request, response);
	}

	@Override
	public void destroy() {
		super.destroy();
		try {
			ConnectionPool.getInstance().close();
		} catch (DatabaseConnectionException e) {
			log.error("The connections have not been closed! " + e.getMessage());
		}
	}
	
	
}
