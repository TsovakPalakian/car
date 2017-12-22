package by.htp.itacademy.car.service.impl;

import by.htp.itacademy.car.service.OrderService;
import by.htp.itacademy.car.service.exception.ServiceException;

public class OrderServiceImpl implements OrderService {

	private OrderServiceImpl() {
	}

	private static class Singletone {
		private static final OrderServiceImpl INSTANCE = new OrderServiceImpl();
	}

	public static OrderServiceImpl getInstance() throws ServiceException {
		return Singletone.INSTANCE;
	}
	

}
