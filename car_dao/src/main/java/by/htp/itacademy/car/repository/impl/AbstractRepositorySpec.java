package by.htp.itacademy.car.repository.impl;

import java.util.Collection;
import java.util.Collections;

import by.htp.itacademy.car.repository.RepositorySpec;
import by.htp.itacademy.car.repository.Specification;

public abstract class AbstractRepositorySpec<T> implements RepositorySpec<T> {

	@Override
	public T get(T item) {
		return null;
	}

	@Override
	public void add(T item) {
		add(Collections.singletonList(item));
	}

	@Override
	public void add(Iterable<T> items) {
		
	}

	@Override
	public void update(T item) {
		
	}

	@Override
	public void delete(T item) {
		
	}

	@Override
	public Collection<T> get(Specification<T> specification) {
		return null;
	}

	@Override
	public void add(Specification<T> specification) {
		
	}

	@Override
	public void delete(Specification<T> specification) {
		
	}

	@Override
	public void update(Specification<T> specification) {
		
	}
}
