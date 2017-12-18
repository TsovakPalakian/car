package by.htp.itacademy.car.service.impl;

import by.htp.itacademy.car.service.EntityService;

public class LocationServiceImpl implements EntityService {

	private LocationServiceImpl() {
	}

	private static class Singletone {
		private static final LocationServiceImpl INSTANCE = new LocationServiceImpl();
	}

	public static LocationServiceImpl getInstance() {
		return Singletone.INSTANCE;
	}

}
