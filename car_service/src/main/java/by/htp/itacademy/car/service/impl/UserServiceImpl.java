package by.htp.itacademy.car.service.impl;

import by.htp.itacademy.car.service.UserService;
import by.htp.itacademy.car.service.exception.ServiceException;

public class UserServiceImpl implements UserService {

	private UserServiceImpl() {
	}

	private static class Singletone {
		private static final UserServiceImpl INSTANCE = new UserServiceImpl();
	}

	public static UserServiceImpl getInstance() throws ServiceException {
		return Singletone.INSTANCE;
	}

}
