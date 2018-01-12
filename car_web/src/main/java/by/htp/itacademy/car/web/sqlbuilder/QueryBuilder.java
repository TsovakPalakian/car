package by.htp.itacademy.car.web.sqlbuilder;

public class QueryBuilder {
	
	private final Query query;

	public QueryBuilder() {
		this.query = new Query();
	}
	
	public QueryBuilder from() {
		this.query.append("FROM ");
		return this;
	}
}
