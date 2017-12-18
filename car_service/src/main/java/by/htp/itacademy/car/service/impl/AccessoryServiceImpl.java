package by.htp.itacademy.car.service.impl;

import java.util.Map;

import by.htp.itacademy.car.domain.entity.Entity;
import by.htp.itacademy.car.service.EntityService;
import by.htp.itacademy.car.service.exception.ServiceException;

public class AccessoryServiceImpl implements EntityService {

	private AccessoryServiceImpl() {
	}

	private static class Singletone {
		private static final AccessoryServiceImpl INSTANCE = new AccessoryServiceImpl();
	}

	public static AccessoryServiceImpl getInstance() {
		return Singletone.INSTANCE;
	}

}
