package by.htp.itacademy.car.domain.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class Salon implements Entity, Serializable {
	
	private Long salonId;
	private String name;
	private Location location;
	private RentedCar rentedCar;
	
}
