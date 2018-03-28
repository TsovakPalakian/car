package by.htp.itacademy.car.dao.impl;

import by.htp.itacademy.car.dao.LocationDao;
import by.htp.itacademy.car.domain.entity.Location;
import framework.webcore.annotation.initialization.Service;

@Service
public class LocationDaoImpl extends DaoImpl<Location> implements LocationDao {

	private LocationDaoImpl() {
		super(Location.class);
	}

	private static class Singletone {
		private static final LocationDaoImpl INSTANCE = new LocationDaoImpl();
	}

	public static LocationDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}
	
}
