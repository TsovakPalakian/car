package by.htp.itacademy.car.sqlbuilder;

public class Query {
	
	private final StringBuilder sqlQuery;
	
	public Query() {
		sqlQuery = new StringBuilder();
	}
	
	public final Query append(String expression) {
		sqlQuery.append(expression);
		return this;
	}
	
	public final String getSQLQuery() {
		return sqlQuery.toString();
	}
}
