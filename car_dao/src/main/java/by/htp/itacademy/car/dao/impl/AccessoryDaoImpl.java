package by.htp.itacademy.car.dao.impl;

import by.htp.itacademy.car.dao.EntityDao;
import by.htp.itacademy.car.dao.exception.DaoException;
import by.htp.itacademy.car.domain.entity.Entity;

public class AccessoryDaoImpl implements EntityDao {

	private AccessoryDaoImpl() {
	}

	private static class Singletone {
		private static final AccessoryDaoImpl INSTANCE = new AccessoryDaoImpl();
	}

	public static AccessoryDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}
	
	@Override
	public Entity select(String query) throws DaoException {
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
