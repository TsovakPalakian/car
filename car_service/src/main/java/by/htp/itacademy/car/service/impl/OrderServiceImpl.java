package by.htp.itacademy.car.service.impl;

import java.util.Map;

import by.htp.itacademy.car.domain.entity.Entity;
import by.htp.itacademy.car.service.EntityService;
import by.htp.itacademy.car.service.exception.ServiceException;

public class OrderServiceImpl implements EntityService {

	private OrderServiceImpl() {
	}

	private static class Singletone {
		private static final OrderServiceImpl INSTANCE = new OrderServiceImpl();
	}

	public static OrderServiceImpl getInstance() throws ServiceException {
		return Singletone.INSTANCE;
	}
	

}
