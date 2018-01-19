package by.htp.itacademy.car.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import by.htp.itacademy.car.domain.annotation.processor.AnnotationProcessor;
import by.htp.itacademy.car.domain.annotation.processor.fillingindata.FillingInDataForFieldProcessor;
import by.htp.itacademy.car.domain.annotation.processor.fillingindata.FillingInDataForParameterProcessor;
import by.htp.itacademy.car.domain.annotation.processor.fillingindata.FillingInDataProcessor;
import by.htp.itacademy.car.domain.annotation.processor.newinstance.NewInstanceProcessor;
import by.htp.itacademy.car.domain.annotation.processor.validation.ValidationProcessor;
import by.htp.itacademy.car.service.impl.UserServiceImpl;
import by.htp.itacademy.car.web.command.impl.LogInAction;

public class FillingInDataFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("FillingInDataFilter");
		
		//FillingInDataProcessor fillingParams = new FillingInDataForParameterProcessor();
		FillingInDataProcessor fillingFields = new FillingInDataForFieldProcessor();
		ValidationProcessor validationProcessor = new ValidationProcessor();
		
		NewInstanceProcessor newInstancePro = new NewInstanceProcessor();
		HttpServletRequest httpRequest = (HttpServletRequest) request;
			
		try {
			LogInAction la = LogInAction.getInstance();
			System.out.println("LogInAction:                               " + LogInAction.getInstance());
			//UserServiceImpl usi = UserServiceImpl.getInstance();
			//System.out.println("UserServiceImpl:                           " + UserServiceImpl.getInstance());
			newInstancePro.newInstance(la);
			//newInstancePro.newInstance(usi);
			//fillingParams.fillingInDataFromFormForParameters(httpRequest, LogInAction.getInstance());
			fillingFields.fillingInDataFromFormForFields(httpRequest, LogInAction.getInstance());
			validationProcessor.chekAnnotation(LogInAction.getInstance());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		chain.doFilter(request, response);
	}
}
