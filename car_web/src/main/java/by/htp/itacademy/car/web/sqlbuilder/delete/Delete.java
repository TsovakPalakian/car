package by.htp.itacademy.car.web.sqlbuilder.delete;

import by.htp.itacademy.car.domain.entity.Entity;
import by.htp.itacademy.car.web.sqlbuilder.Query;
import by.htp.itacademy.car.web.sqlbuilder.QueryBuilder;

public final class Delete extends QueryBuilder {
	
	private Query query;
	private Entity entity;
	
	public Delete(Query query) {
		this.query = query;
		this.query.append("DELETE ");
	}
	
	public Delete(Query query, Entity entity) {
		this(query);
		this.entity = entity;
	}
}
