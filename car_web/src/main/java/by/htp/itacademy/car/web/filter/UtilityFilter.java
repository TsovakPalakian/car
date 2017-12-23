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

public class UtilityFilter implements Filter {

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected FilterChain chain;
	protected HttpSession session;
	protected FilterConfig filterConfig;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		/*this.request = (HttpServletRequest) request;
		this.response = (HttpServletResponse) response;
		this.chain = chain;
		this.session = this.request.getSession();*/
		System.out.println(request);
		System.out.println(response);
		System.out.println(chain);
		System.out.println(((HttpServletRequest)request).getSession());
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}
}
