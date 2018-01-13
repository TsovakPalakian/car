package by.htp.itacademy.car.domain.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class User implements Entity, Serializable {
	
	private Long userId;
	private String name;
	private String surname;
	private String login;
	private String password;
	private String passport;
	private String phoneNumber;
	private String email;
	private String driverLicense;
	private Integer role;

	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
}
