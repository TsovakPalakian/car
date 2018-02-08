package by.htp.itacademy.car.dao.impl;

import java.util.List;

import by.htp.itacademy.car.dao.AccessoryDao;
import by.htp.itacademy.car.dao.exception.DaoException;
import by.htp.itacademy.car.domain.entity.Accessory;

public class AccessoryDaoImpl extends DaoImpl<Accessory> implements AccessoryDao {

	private AccessoryDaoImpl() {
		super(Accessory.class);
	}

	private static class Singletone {
		private static final AccessoryDaoImpl INSTANCE = new AccessoryDaoImpl();
	}

	public static AccessoryDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}

	
	@Override
	public List<Accessory> getAll() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
