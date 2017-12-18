package by.htp.itacademy.car.car_domain.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Entity, Serializable {
	
	private static final long serialVersionUID = -2781003932706380906L;
	
	private Long userId;
	private String login;
	private String password;
	private String title;
	private String name;
	private String surname;
	private String phoneNumber;
	private String email;
	private String driverLicense;
	private String role;
	
}
