package by.htp.itacademy.car.car_domain.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location implements Entity, Serializable {

	private static final long serialVersionUID = 2395292988802715961L;
	
	private Long idLocation;
	private String address;
	private String link;
}
