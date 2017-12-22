package by.htp.itacademy.car.service.impl;

import by.htp.itacademy.car.service.RentedCarService;
import by.htp.itacademy.car.service.exception.ServiceException;

public class RentedCarServiceImpl implements RentedCarService {

	private RentedCarServiceImpl() {
	}

	private static class Singletone {
		private static final RentedCarServiceImpl INSTANCE = new RentedCarServiceImpl();
	}

	public static RentedCarServiceImpl getInstance() throws ServiceException {
		return Singletone.INSTANCE;
	}
	

}
