package by.htp.itacademy.car.web.controller;

import javax.servlet.http.HttpSession;

import static by.htp.itacademy.car.web.util.CarConstant.*;

public abstract class AbstractLanguageController {

	protected String fetchLanguage(HttpSession session) {
		String language = (String)  session.getAttribute(REQUEST_ACTION_LANGUAGE);
		if (!LANGLIST.contains(language)) {
			language = LANGUAGE_RU;
		}
		return language;
	}
}
