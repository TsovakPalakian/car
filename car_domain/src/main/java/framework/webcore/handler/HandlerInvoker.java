package framework.webcore.handler;

import java.lang.reflect.InvocationTargetException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;

import framework.webcore.bean.Handler;
import framework.webcore.exception.IllegalParameterException;
import framework.webcore.exception.ValidationException;

public interface HandlerInvoker {

	Object invokeHandler(HttpServletRequest request, Handler handler)
			throws InvocationTargetException, IllegalAccessException, InvalidKeyException, SecurityException, ValidationException, 
			IllegalArgumentException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalParameterException;

}
