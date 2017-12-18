package by.htp.itacademy.car.service.impl;

import by.htp.itacademy.car.service.EntityService;

public class RentedCarServiceImpl implements EntityService {

	private RentedCarServiceImpl() {
	}

	private static class Singletone {
		private static final RentedCarServiceImpl INSTANCE = new RentedCarServiceImpl();
	}

	public static RentedCarServiceImpl getInstance() {
		return Singletone.INSTANCE;
	}
	

}
