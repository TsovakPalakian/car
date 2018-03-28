package framework;

import framework.classcore.helper.ConstantHelper;

public interface FrameworkConstant {
	
	static final String ENCODING = "UTF-8";
	static final String ADVANCED_ENCRYPTION_STANDARD = "AES";
	static final String WEB_INF_CLASSES = "/WEB-INF/classes/";
	
	static final String CLASS_PREFIX = ".class";
	static final String JAR_FILE_PREFIX = ".jar";
	static final String JAR = "jar";
	static final String CONFIG_PREFIX = ".properties";
	static final String FILE = "file";
	static final String EMPTY_STRING = "";
	static final String DOT = ".";
	static final String SLASH = "/";
	
	static final String SERVLET_REGISTRATION_JSP = "jsp";
	static final String SERVLET_REGISTRATION_DEFAULT = "default";
	
	static final String CONSTANT_PROPERTIES = "const.properties";
	static final String HOME_PAGE = ConstantHelper.getString("web_inf.home_page", "/WEB-INF/pages/jsp/index.jsp");
	static final String PATH_PAGES = ConstantHelper.getString("web_inf.path_of_pages", "/WEB-INF/pages/");
	static final String PACKAGE_CLASSES = ConstantHelper.getString("web_inf.package_of_classes", "/WEB-INF/classes/");
	static final String METHOD_NAME = ConstantHelper.getString("web_inf.method_name", "getInstance");
}
