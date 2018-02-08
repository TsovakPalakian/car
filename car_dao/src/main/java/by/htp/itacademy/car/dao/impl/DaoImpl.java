package by.htp.itacademy.car.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import by.htp.itacademy.car.dao.IDao;
import lombok.Getter;

public abstract class DaoImpl<T> implements IDao<T> {

	@PersistenceContext
	@Getter
	private EntityManager entityManager;
	private  final Class<T> clazz; 
	
	public DaoImpl(Class<T> clazz){
		this.clazz = clazz;
	}
	
	@Override
	public T get(Long id) {
		return entityManager.find(clazz, id);
	}

	@Override
	public void add(T item) {
		entityManager.persist(item);
	}

	@Override
	public void delete(Long id) {
		entityManager.remove(id);		
	}

	@Override
	public void update(T item) {
		entityManager.merge(item);		
	}
	
}
