package by.htp.itacademy.car.domain.dto;

import java.io.Serializable;

import by.htp.itacademy.car.domain.entity.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class UserDto implements Entity, Serializable {
	
	private Long id;
	private String login;
	private transient String password;
	
	public UserDto(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
}
