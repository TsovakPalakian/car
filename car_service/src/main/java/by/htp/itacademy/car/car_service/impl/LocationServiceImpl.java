package by.htp.itacademy.car.car_service.impl;

import java.util.Map;

import by.htp.itacademy.car.car_domain.entity.Entity;
import by.htp.itacademy.car.car_service.EntityService;

public class LocationServiceImpl implements EntityService {

	private LocationServiceImpl() {
	}

	private static class Singletone {
		private static final LocationServiceImpl INSTANCE = new LocationServiceImpl();
	}

	public static LocationServiceImpl getInstance() {
		return Singletone.INSTANCE;
	}
	
	@Override
	public void insert(Entity entity) {
		
	}

	@Override
	public Map<Long, Entity> select(String query) {
		return null;
	}

	@Override
	public void update(Entity entity) {
		
	}

	@Override
	public void delete(Entity entity) {
		
	}

}
