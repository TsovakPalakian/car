package by.htp.itacademy.car.domain.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class Location implements Entity, Serializable {

	private Long id;
	private String address;
	private String link;
	
}
