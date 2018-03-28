package by.htp.itacademy.car.dao.impl;

import by.htp.itacademy.car.dao.RentedCarDao;
import by.htp.itacademy.car.domain.entity.RentedCar;
import framework.webcore.annotation.initialization.Service;

@Service
public class RentedCarDaoImpl extends DaoImpl<RentedCar> implements RentedCarDao {

	private RentedCarDaoImpl() {
		super(RentedCar.class);
	}

	private static class Singletone {
		private static final RentedCarDaoImpl INSTANCE = new RentedCarDaoImpl();
	}

	public static RentedCarDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}

}
