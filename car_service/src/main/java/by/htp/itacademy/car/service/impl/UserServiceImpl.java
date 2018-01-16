package by.htp.itacademy.car.service.impl;

import java.util.List;

import by.htp.itacademy.car.dao.EntityDao;
import by.htp.itacademy.car.dao.exception.DaoException;
import by.htp.itacademy.car.dao.impl.UserDaoImpl;
import by.htp.itacademy.car.domain.annotation.NewInstance;
import by.htp.itacademy.car.domain.entity.User;
import by.htp.itacademy.car.service.UserService;
import by.htp.itacademy.car.service.exception.ServiceException;
import by.htp.itacademy.car.service.exception.ServiceNoSuchUserException;
import lombok.extern.log4j.Log4j;

@Log4j
public class UserServiceImpl implements UserService {
	private static final Integer FIRST_ELEMENT_FROM_LIST_OF_USERS = 0;
	private static final String LOG_ERROR = " ERROR: ";
	
	@NewInstance(clazz = UserDaoImpl.class)
	private EntityDao dao;
	
	private UserServiceImpl() {
		//dao = UserDaoImpl.getInstance();
	}

	private static class Singletone {
		private static final UserServiceImpl INSTANCE = new UserServiceImpl();
	}

	public static UserServiceImpl getInstance() {
		return Singletone.INSTANCE;
	}

	@Override
	public User logIn(User user) throws ServiceNoSuchUserException {
		User userFromDB = null;
		try {
			System.out.println("1 : " + dao);
			System.out.println("2 : " + dao.select(user));
			userFromDB = (User) dao.select(user).get(FIRST_ELEMENT_FROM_LIST_OF_USERS);
			log.info("User " + userFromDB.getLogin() + " LOGIN - userId: " + userFromDB.getUserId());
		} catch (DaoException e) {
			log.error(LOG_ERROR + e.getMessage());
			throw new ServiceNoSuchUserException();
		}
		return userFromDB;
	}

	@Override
	public boolean signUp(User user) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeUser(User user) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUserData(User user) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getUser(List<String> conditions) throws ServiceNoSuchUserException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
