package by.htp.itacademy.car.service.impl;

import by.htp.itacademy.car.service.EntityService;

public class UserServiceImpl implements EntityService {

	private UserServiceImpl() {
	}

	private static class Singletone {
		private static final UserServiceImpl INSTANCE = new UserServiceImpl();
	}

	public static UserServiceImpl getInstance() {
		return Singletone.INSTANCE;
	}

}
