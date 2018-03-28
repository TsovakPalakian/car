package by.htp.itacademy.car.web.controller;

import javax.servlet.http.HttpSession;

import by.htp.itacademy.car.service.UserService;
import framework.webcore.annotation.controller.Controller;
import framework.webcore.annotation.controller.Mapping;
import framework.webcore.annotation.controller.method.GetMapping;
import framework.webcore.annotation.initialization.AutoInit;
import framework.webcore.bean.View;
import framework.webcore.http.HttpStatus;

@Controller
@Mapping("/")
public class DefaultController {
	
	@AutoInit
	private UserService userService;
	
	@GetMapping
	public View<?> load(HttpSession session) {
		System.out.println("was called GET method");
		loadLanguage(session);
		return new View<>("/", HttpStatus.NOT_MODIFIED);
	}
	
	private void loadLanguage(HttpSession session) {
		Object lang = session.getAttribute("language");
		if (lang == null) {
			session.setAttribute("language", "en");
		}
	}
}
