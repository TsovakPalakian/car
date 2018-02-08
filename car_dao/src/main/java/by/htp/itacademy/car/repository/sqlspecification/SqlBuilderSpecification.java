package by.htp.itacademy.car.repository.sqlspecification;

import by.htp.itacademy.car.sqlbuilder.QueryBuilder;

public class SqlBuilderSpecification<T> implements SqlSpecification<T>{

	private QueryBuilder queryBuilder;

	public SqlBuilderSpecification(QueryBuilder queryBuilder) {
		this.queryBuilder = queryBuilder;
	}

	@Override
	public String toSqlQuery() {
		return queryBuilder.toString();
	}
}
