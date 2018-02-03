package by.htp.itacademy.car.annotation.util;

import java.util.List;

import static by.htp.itacademy.car.annotation.util.ConstantValue.*;

public enum ListOfParametersEnum {
	
	EMPTY(null),
	LOG_IN(ALL_MAPS_OF_PARAMETERS.get(PARAMETERS_FOR_LOGIN));

	private List<String> list;

	ListOfParametersEnum(List<String> list) {
		this.list = list;
	}

	public List<String> getList() {
		return list;
	}
}
