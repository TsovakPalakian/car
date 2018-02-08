package by.htp.itacademy.car.domain.entity;

import java.io.Serializable;
import java.util.Date;

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
public class RentedCar implements Entity, Serializable {

	private Long id;
	private String model;
	private Date year;
	private String transmition;
	private String wheelDrive;
	private String fuilType;
	private String color;
	private String image;
	private String description;
	private String readiness;
	private Accessory accessory;
	
}
