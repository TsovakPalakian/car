package by.htp.itacademy.car.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import by.htp.itacademy.car.web.annotation.exception.IllegalParameterException;
import by.htp.itacademy.car.web.annotation.processor.FillingInDataProcessor;
import by.htp.itacademy.car.web.command.impl.LogInAction;
import by.htp.itacademy.car.web.util.ConstantValue;

public class FillingInDataFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		FillingInDataProcessor fill = new FillingInDataProcessor();
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		try {
			
			fill.fillingInDataFromFormForFields(httpRequest, LogInAction.getInstance(), 
					ConstantValue.ALL_MAPS_OF_PARAMETERS.get(ConstantValue.PARAMETERS_FOR_LOGIN));
			
		} catch (IllegalArgumentException e) {
			
		} catch (IllegalAccessException e) {
			
		} catch (InstantiationException e) {
			
		} catch (IllegalParameterException e) {
			
		}
	}
}
