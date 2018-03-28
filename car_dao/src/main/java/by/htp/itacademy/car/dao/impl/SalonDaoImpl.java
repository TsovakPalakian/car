package by.htp.itacademy.car.dao.impl;

import by.htp.itacademy.car.dao.SalonDao;
import by.htp.itacademy.car.domain.entity.Salon;
import framework.webcore.annotation.initialization.Service;

@Service
public class SalonDaoImpl extends DaoImpl<Salon> implements SalonDao {

	private SalonDaoImpl() {
		super(Salon.class);
	}

	private static class Singletone {
		private static final SalonDaoImpl INSTANCE = new SalonDaoImpl();
	}

	public static SalonDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}

}
