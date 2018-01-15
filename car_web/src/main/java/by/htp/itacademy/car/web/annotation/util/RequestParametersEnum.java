package by.htp.itacademy.car.web.annotation.util;

import java.util.List;

import static by.htp.itacademy.car.web.util.ConstantValue.*;

public enum RequestParametersEnum {
	
	EMPTY(null),
	LOG_IN(ALL_MAPS_OF_PARAMETERS.get(PARAMETERS_FOR_LOGIN));

	private List<String> list;

	RequestParametersEnum(List<String> list) {
		this.list = list;
	}

	public List<String> getList() {
		return list;
	}
}
