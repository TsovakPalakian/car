package framework.webcore;

import static framework.FrameworkConstant.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import framework.webcore.bean.Handler;
import framework.webcore.bean.View;
import framework.webcore.exception.IllegalParameterException;
import framework.webcore.exception.ValidationException;
import framework.webcore.handler.HandlerInvoker;
import framework.webcore.handler.HandlerMapping;
import framework.webcore.http.HttpStatus;
import framework.webcore.util.InstanceFactory;
import framework.webcore.util.WebUtil;
import framework.webcore.view.ViewResolver;

@SuppressWarnings("serial")
public class DispatcherServlet extends HttpServlet {

	private HandlerMapping handlerMapping = InstanceFactory.getHandlerMapping();
	private HandlerInvoker handlerInvoker = InstanceFactory.getHandlerInvoker();
	private ViewResolver viewResolver = InstanceFactory.getViewResolver();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(ENCODING);
		
		String reqMethod = request.getMethod();
		String requestPath = request.getServletPath();

		WebUtil.startHomePage(request, response, reqMethod, requestPath);

		Handler handler = handlerMapping.getHandler(requestPath, reqMethod);
		if (handler == null) {
			WebUtil.sendError(response, HttpServletResponse.SC_NOT_FOUND, "url is wrong");
			return;
		}

		ApplicationContext.init(request, response);
		try {
			Object invokeResult = null;
			View<?> view = null;
			try {
				invokeResult = handlerInvoker.invokeHandler(request, handler);
			} catch (ValidationException | IllegalParameterException e) {
				view = new View<>(HttpStatus.BAD_REQUEST);
				invokeResult = view;
			} catch (Exception e) {
				view = new View<>(HttpStatus.EXPECTATION_FAILED);
				invokeResult = view;
			}

			viewResolver.resolveView(request, response, invokeResult);
		} finally {
			ApplicationContext.destory();
		}
	}
}
