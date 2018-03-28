package by.htp.itacademy.car.service.impl;

import by.htp.itacademy.car.service.LocationService;
import by.htp.itacademy.car.service.exception.ServiceException;
import framework.webcore.annotation.initialization.Service;

@Service
public class LocationServiceImpl implements LocationService {

	private LocationServiceImpl() {
	}

	private static class Singletone {
		private static final LocationServiceImpl INSTANCE = new LocationServiceImpl();
	}

	public static LocationServiceImpl getInstance() throws ServiceException {
		return Singletone.INSTANCE;
	}

}
