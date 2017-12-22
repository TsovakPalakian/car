package by.htp.itacademy.car.service.impl;

import by.htp.itacademy.car.service.AccessoryService;
import by.htp.itacademy.car.service.exception.ServiceException;

public class AccessoryServiceImpl implements AccessoryService {

	private AccessoryServiceImpl() {
	}

	private static class Singletone {
		private static final AccessoryServiceImpl INSTANCE = new AccessoryServiceImpl();
	}

	public static AccessoryServiceImpl getInstance() throws ServiceException {
		return Singletone.INSTANCE;
	}

}
