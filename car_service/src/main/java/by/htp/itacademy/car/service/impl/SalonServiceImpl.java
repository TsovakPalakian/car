package by.htp.itacademy.car.service.impl;

import by.htp.itacademy.car.service.EntityService;

public class SalonServiceImpl implements EntityService {

	private SalonServiceImpl() {
	}

	private static class Singletone {
		private static final SalonServiceImpl INSTANCE = new SalonServiceImpl();
	}

	public static SalonServiceImpl getInstance() {
		return Singletone.INSTANCE;
	}
	

}
