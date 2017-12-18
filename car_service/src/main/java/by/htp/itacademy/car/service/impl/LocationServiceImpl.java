package by.htp.itacademy.car.service.impl;

import java.util.Map;

import by.htp.itacademy.car.domain.entity.Entity;
import by.htp.itacademy.car.service.EntityService;
import by.htp.itacademy.car.service.exception.ServiceException;

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
