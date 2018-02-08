package by.htp.itacademy.car.dao;

import by.htp.itacademy.car.dao.exception.DaoException;

public interface IDao<T> {
	
	T get(Long id) throws DaoException;
	
	void add(T item);
	
	void delete(Long id);
	
	void update(T item);
}
