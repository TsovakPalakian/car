package by.htp.itacademy.car.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.itacademy.car.domain.entity.User;

import static by.htp.itacademy.car.web.util.Parameter.*;

public class CommandFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String command = ((HttpServletRequest) request).getParameter(REQUEST_PARAMETER_ACTION);
		HttpSession session = ((HttpServletRequest) request).getSession();
		User user = (User) session.getAttribute(SESSION_ATTRIBUTE_USER);
		
		if (checkUserAccess(user, command)) {
			chain.doFilter(request, response);
		} else {
			((HttpServletRequest) request).setAttribute(REQUEST_ATTRIBUTE_MSG, MESSAGE_NO_ACCESS);
			((HttpServletRequest) request).setAttribute(REQUEST_ATTRIBUTE_USER, user);
			((HttpServletResponse) response).sendRedirect(PAGE_HOME);
		} 
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}
	
	private boolean checkUserAccess(User user, String command) throws IOException, ServletException {
		return true;
	}
}
