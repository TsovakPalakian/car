package by.htp.itacademy.car.repository;

import java.util.Collection;

public interface RepositorySpec<T> extends Repository<T>{
	
	Collection<T> get(Specification<T> specification);
	
	void add(Specification<T> specification);
	
	void delete(Specification<T> specification);
	
	void update(Specification<T> specification);
}
