package by.htp.itacademy.car.domain.entity.dto;

import java.io.Serializable;

import by.htp.itacademy.car.domain.entity.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class UserDTOLP implements Entity, Serializable {
	
	private String login;
	private String password;
	
}
