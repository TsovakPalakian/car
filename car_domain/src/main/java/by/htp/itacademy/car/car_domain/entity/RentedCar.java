package by.htp.itacademy.car.car_domain.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentedCar implements Entity, Serializable {

	private static final long serialVersionUID = 7374239477802439416L;
	
	private Long rentedCarId;
	private String model;
	private Date year;
	private String transmition;
	private String wheelDrive;
	private String fuilType;
	private String color;
	private String image;
	private String description;
	private String readiness;
	private Long accessoryId;
	
}
