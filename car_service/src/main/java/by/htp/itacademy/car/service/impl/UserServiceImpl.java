package by.htp.itacademy.car.service.impl;

import java.util.List;

import by.htp.itacademy.car.dao.EntityDao;
import by.htp.itacademy.car.dao.exception.DaoException;
import by.htp.itacademy.car.dao.impl.UserDaoImpl;
import by.htp.itacademy.car.domain.entity.User;
import by.htp.itacademy.car.service.UserService;
import by.htp.itacademy.car.service.exception.ServiceException;
import by.htp.itacademy.car.service.exception.ServiceNoSuchUserException;
import lombok.extern.log4j.Log4j;

@Log4j
public class UserServiceImpl implements UserService {
	
	private static final String LOG_ERROR = " ERROR: ";
	
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

	@Override
	public List<User> logIn(User user) throws ServiceNoSuchUserException {
		// TODO Auto-generated method stub
		return null;
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
