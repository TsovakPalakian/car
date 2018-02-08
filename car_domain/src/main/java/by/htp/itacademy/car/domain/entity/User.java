package by.htp.itacademy.car.domain.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class User implements Entity, Serializable {
	
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
	
}
