package by.htp.itacademy.car.service.impl;

import java.util.Map;

import by.htp.itacademy.car.domain.entity.Entity;
import by.htp.itacademy.car.service.EntityService;
import by.htp.itacademy.car.service.exception.ServiceException;

public class RentedCarServiceImpl implements EntityService {

	private RentedCarServiceImpl() {
	}

	private static class Singletone {
		private static final RentedCarServiceImpl INSTANCE = new RentedCarServiceImpl();
	}

	public static RentedCarServiceImpl getInstance() {
		return Singletone.INSTANCE;
	}
	

}
