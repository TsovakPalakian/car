package by.htp.itacademy.car.car_service.impl;

import java.util.Map;

import by.htp.itacademy.car.car_domain.entity.Entity;
import by.htp.itacademy.car.car_service.EntityService;

public class SalonServiceImpl implements EntityService {

	private SalonServiceImpl() {
	}

	private static class Singletone {
		private static final SalonServiceImpl INSTANCE = new SalonServiceImpl();
	}

	public static SalonServiceImpl getInstance() {
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
