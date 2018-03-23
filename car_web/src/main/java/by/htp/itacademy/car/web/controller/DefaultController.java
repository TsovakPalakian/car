package by.htp.itacademy.car.web.controller;

import javax.servlet.http.HttpSession;

import by.htp.itacademy.car.annotation.Controller;
import by.htp.itacademy.car.annotation.Mapping;
import by.htp.itacademy.car.annotation.PathVariable;
import by.htp.itacademy.car.annotation.PostMapping;
import by.htp.itacademy.car.annotation.ReqBody;
import by.htp.itacademy.car.annotation.ReqParam;
import by.htp.itacademy.car.annotation.util.ResponseEntity;
import by.htp.itacademy.car.domain.entity.User;


@Controller
@Mapping("/")
public class DefaultController {
	
	@PostMapping("welcome/{user}")
	public ResponseEntity<?> loadHomePage(
			@ReqParam(value = "userName", defaultValue = "Tsovak") String value, 
			@ReqParam(value = "userName1", defaultValue = "Tsovak") String value2,
			@PathVariable("name") String name, 
			@ReqBody User user,
			HttpSession session) {
		
		loadLanguage(session);	
//		System.out.println(value);
//		System.out.println(value2);
//		System.out.println(name);
//		System.out.println(user);
//		System.out.println(session.getAttribute("language"));
		
		
		return new ResponseEntity<>("index4");
	}
	
	private void loadLanguage(HttpSession session) {
		Object lang = session.getAttribute("language");
		if (lang == null) {
			session.setAttribute("language", "en");
		}
	}
}
