package by.htp.itacademy.car.web.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.htp.itacademy.car.web.exception.CommandInvalidParameterException;

public class Validator {
	
	private static final String NAME_REGEX = "[A-Z]{1}[a-z]{0,100}";
	private static final String LOGIN_REGEX = "[A-z0-9]{3,20}";
    private static final String PASSWORD_REGEX = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\\!\\@\\#\\$\\%\\^\\&\\*]).{8,100})";
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9.,_%+-]+@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,4}$";
    private static final String PASSPORT_REGEX = "[A-Z]{2}[0-9]{7}";
    private static final String PHONE_NUMBER_REGEX = "[\\+]{1}[0-9]{2,4}[0-9]+";
	
    private static Pattern pattern;
    private static Matcher matcher;
    
	private Validator() {};
	
		
}
