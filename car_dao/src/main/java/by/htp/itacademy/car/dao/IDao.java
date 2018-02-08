package by.htp.itacademy.car.dao;

public interface IDao<T> {
	
	T get(Long id);
	
	void add(T item);
	
	void delete(Long id);
	
	void update(T item);
}
