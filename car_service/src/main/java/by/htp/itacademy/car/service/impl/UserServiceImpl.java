package by.htp.itacademy.car.service.impl;

import by.htp.itacademy.car.dao.EntityDao;
import by.htp.itacademy.car.dao.impl.UserDaoImpl;
import by.htp.itacademy.car.service.UserService;
import by.htp.itacademy.car.service.exception.ServiceException;
import lombok.extern.log4j.Log4j;

@Log4j
public class UserServiceImpl implements UserService {
	
	private EntityDao dao;
	
	private UserServiceImpl() {
		dao = UserDaoImpl.getInstance();
	}

	private static class Singletone {
		private static final UserServiceImpl INSTANCE = new UserServiceImpl();
	}

	public static UserServiceImpl getInstance() {
		return Singletone.INSTANCE;
	}
	
	
}
