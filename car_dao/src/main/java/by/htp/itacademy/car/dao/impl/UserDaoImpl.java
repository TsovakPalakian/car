package by.htp.itacademy.car.dao.impl;

import by.htp.itacademy.car.dao.UserDao;
import by.htp.itacademy.car.domain.entity.User;

public class UserDaoImpl extends DaoImpl<User> implements UserDao {

	private UserDaoImpl() {
		super(User.class);
	}

	private static class Singletone {
		private static final UserDaoImpl INSTANCE = new UserDaoImpl();
	}

	public static UserDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}
	
}
