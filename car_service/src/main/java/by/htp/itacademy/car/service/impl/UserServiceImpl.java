package by.htp.itacademy.car.service.impl;

import java.util.Map;

import by.htp.itacademy.car.domain.entity.Entity;
import by.htp.itacademy.car.service.EntityService;
import by.htp.itacademy.car.service.exception.ServiceException;

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
