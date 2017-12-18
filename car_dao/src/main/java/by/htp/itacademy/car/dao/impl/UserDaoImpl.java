package by.htp.itacademy.car.dao.impl;

import java.util.Map;

import by.htp.itacademy.car.dao.EntityDao;
import by.htp.itacademy.car.dao.exception.DaoException;
import by.htp.itacademy.car.domain.entity.Entity;

public class UserDaoImpl implements EntityDao {

	private UserDaoImpl() {
	}

	private static class Singletone {
		private static final UserDaoImpl INSTANCE = new UserDaoImpl();
	}

	public static UserDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}
	
	@Override
	public Map<Long, Entity> select(String query) throws DaoException {
		return null;
	}

	@Override
	public void insert(Entity entity) throws DaoException {

	}

	@Override
	public void update(Entity entity) throws DaoException {

	}

	@Override
	public void delete(Entity entity) throws DaoException {

	}

}
