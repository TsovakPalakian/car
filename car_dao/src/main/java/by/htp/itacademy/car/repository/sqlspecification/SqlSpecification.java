package by.htp.itacademy.car.repository.sqlspecification;

import by.htp.itacademy.car.repository.Specification;

public interface SqlSpecification<T> extends Specification<T> {
	
	String toSqlQuery();
	
}
