package by.htp.itacademy.car.sqlbuilder;

/**
 * @author Tsovak Palakian
 *
 */
public class QueryBuilder {
	
	private final Query query;

	public QueryBuilder() {
		this.query = new Query();
	}
	
	public QueryBuilder from() {
		this.query.append("FROM ");
		return this;
	}

	@Override
	public String toString() {
		return query.toString();
	}
	
	
}
