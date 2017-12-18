package by.htp.itacademy.car.service.impl;

import java.util.Map;

import by.htp.itacademy.car.domain.entity.Entity;
import by.htp.itacademy.car.service.EntityService;

public class RentedCarServiceImpl implements EntityService {

	private RentedCarServiceImpl() {
	}

	private static class Singletone {
		private static final RentedCarServiceImpl INSTANCE = new RentedCarServiceImpl();
	}

	public static RentedCarServiceImpl getInstance() {
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
