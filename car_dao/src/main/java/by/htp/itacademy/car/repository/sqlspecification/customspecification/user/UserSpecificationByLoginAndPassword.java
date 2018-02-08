package by.htp.itacademy.car.repository.sqlspecification.customspecification.user;

import by.htp.itacademy.car.domain.pojo.User;
import by.htp.itacademy.car.repository.sqlspecification.SqlSpecification;

public class UserSpecificationByLoginAndPassword implements SqlSpecification<User> {

	private String login;
	private String password;
	
	public UserSpecificationByLoginAndPassword(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	@Override
	public String toSqlQuery() {
		return String.format("SELECT * FROM user WHERE user.login='%s' and user.password='%s'", this.login, this.password);
	}
	
}
