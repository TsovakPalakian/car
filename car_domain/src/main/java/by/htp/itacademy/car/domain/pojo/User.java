package by.htp.itacademy.car.domain.pojo;

import java.io.Serializable;

import by.htp.itacademy.car.domain.exception.DomainException;
import lombok.Data;

@Data
@SuppressWarnings("serial")
public class User implements Serializable {
	
	private Long id;
	private String name;
	private String surname;
	private String login;
	private transient String password;
	private String passport;
	private String phoneNumber;
	private String email;
	private String driverLicense;
	private Integer role;
	
	public boolean userHasLoginAndPassword(User user) throws DomainException {
//		if (this.login == null && this.password == null) {
//			throw new DomainException("Login or password can not be null!");
//		}
//		
//		boolean hasLogin = this.login.equals(user.getLogin());
//		boolean hasPassword = this.password.equals(user.getPassword());
		return false;//hasLogin && hasPassword;
	} 
}
