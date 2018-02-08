package by.htp.itacademy.car.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class FillingInDataFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
//		System.out.println("FillingInDataFilter");
//		
//		//FillingInDataProcessor fillingParams = new FillingInDataForParameterProcessor();
//		FillingInDataProcessor fillingFields = new FillingInDataForFieldProcessor();
//		ValidationProcessor validationProcessor = new ValidationProcessor();
//		
//		NewInstanceProcessor newInstancePro = new NewInstanceProcessor();
//		HttpServletRequest httpRequest = (HttpServletRequest) request;
//			
//		try {
//			LogInAction la = LogInAction.getInstance();
//			System.out.println("LogInAction:                               " + LogInAction.getInstance());
//			//UserServiceImpl usi = UserServiceImpl.getInstance();
//			//System.out.println("UserServiceImpl:                           " + UserServiceImpl.getInstance());
//			newInstancePro.newInstance(la);
//			//newInstancePro.newInstance(usi);
//			//fillingParams.fillingInDataFromFormForParameters(httpRequest, LogInAction.getInstance());
//			fillingFields.fillingInDataFromFormForFields(httpRequest, LogInAction.getInstance());
//			validationProcessor.chekAnnotation(LogInAction.getInstance());
//			
//		}catch (IllegalParameterException e) {
//			request.setAttribute(REQUEST_ATTRIBUTE_MSG, MESSAGE_INCORRECT_DATA_ENTRY);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		chain.doFilter(request, response);
	}
}
