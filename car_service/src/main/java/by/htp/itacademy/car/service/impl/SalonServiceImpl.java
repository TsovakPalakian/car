package by.htp.itacademy.car.service.impl;

import by.htp.itacademy.car.service.SalonService;
import by.htp.itacademy.car.service.exception.ServiceException;
import framework.webcore.annotation.initialization.Service;

@Service
public class SalonServiceImpl implements SalonService {

	private SalonServiceImpl() {
	}

	private static class Singletone {
		private static final SalonServiceImpl INSTANCE = new SalonServiceImpl();
	}

	public static SalonServiceImpl getInstance() throws ServiceException {
		return Singletone.INSTANCE;
	}
	

}
