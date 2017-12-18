package by.htp.itacademy.car.service.impl;

import by.htp.itacademy.car.service.EntityService;

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
