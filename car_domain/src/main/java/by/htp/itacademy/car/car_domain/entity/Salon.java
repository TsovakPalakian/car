package by.htp.itacademy.car.car_domain.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Salon implements Entity, Serializable {
	
	private static final long serialVersionUID = -2398697008302262724L;
	
	private Long salonId;
	private String name;
	private Long locationId;
	private Long rentedCarId;
	
}
