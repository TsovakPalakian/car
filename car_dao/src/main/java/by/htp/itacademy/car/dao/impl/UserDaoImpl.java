package by.htp.itacademy.car.dao.impl;

import java.util.List;

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
	public List<Entity> select(Entity entity) throws DaoException {
		return null;
	}

	@Override
	public boolean insert(Entity entity) throws DaoException {
		return false;

	}

	@Override
	public boolean update(Entity entity) throws DaoException {
		return false;

	}

	@Override
	public boolean delete(Entity entity) throws DaoException {
		return false;

	}

}
