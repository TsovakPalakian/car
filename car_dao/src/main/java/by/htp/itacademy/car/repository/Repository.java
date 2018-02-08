package by.htp.itacademy.car.repository;

public interface Repository<T> {
	
	T get(T item);
	
	void add(T item);
	
	void add(Iterable<T> items);
	
	void update(T item);
	
	void delete(T item);
}
