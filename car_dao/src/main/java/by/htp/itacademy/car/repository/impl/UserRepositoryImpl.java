package by.htp.itacademy.car.repository.impl;

import java.util.Collection;

import by.htp.itacademy.car.domain.pojo.User;
import by.htp.itacademy.car.repository.Specification;
import by.htp.itacademy.car.repository.sqlspecification.SqlSpecification;

public class UserRepositoryImpl extends AbstractRepositorySpec<User> {

	@Override
	public User get(User item) {
		return super.get(item);
	}

	@Override
	public void add(User item) {
		super.add(item);
	}

	@Override
	public void add(Iterable<User> items) {
		super.add(items);
	}

	@Override
	public void update(User item) {
		super.update(item);
	}

	@Override
	public void delete(User item) {
		super.delete(item);
	}

	@Override
	public Collection<User> get(Specification<User> specification) {
		final SqlSpecification<User> sqlSpecification = (SqlSpecification<User>) specification;
		sqlSpecification.toSqlQuery();
		return null;
	}

	@Override
	public void add(Specification<User> specification) {
		super.add(specification);
	}

	@Override
	public void delete(Specification<User> specification) {
		super.delete(specification);
	}

	@Override
	public void update(Specification<User> specification) {
		super.update(specification);
	}
}
