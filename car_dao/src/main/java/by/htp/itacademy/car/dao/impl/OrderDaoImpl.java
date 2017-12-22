package by.htp.itacademy.car.dao.impl;

import java.util.Map;

import by.htp.itacademy.car.dao.EntityDao;
import by.htp.itacademy.car.dao.exception.DaoException;
import by.htp.itacademy.car.domain.entity.Entity;

public class OrderDaoImpl implements EntityDao {

	private OrderDaoImpl() {
	}

	private static class Singletone {
		private static final OrderDaoImpl INSTANCE = new OrderDaoImpl();
	}

	public static OrderDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}
	
	@Override
	public Map<Long, Entity> select(Entity entity) throws DaoException {
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
