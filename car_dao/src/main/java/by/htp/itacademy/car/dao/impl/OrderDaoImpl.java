package by.htp.itacademy.car.dao.impl;

import by.htp.itacademy.car.dao.OrderDao;
import by.htp.itacademy.car.domain.entity.Order;
import framework.webcore.annotation.initialization.Service;

@Service
public class OrderDaoImpl extends DaoImpl<Order> implements OrderDao {

	private OrderDaoImpl() {
		super(Order.class);
	}

	private static class Singletone {
		private static final OrderDaoImpl INSTANCE = new OrderDaoImpl();
	}

	public static OrderDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}
	
}
