package by.htp.itacademy.car.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class Order implements Entity, Serializable {

	private Long id;
	private Date pickUpDate;
	private Date dropOffDate;
	private String status;
	private BigDecimal totalPrice;
	private Location pickUpLocationId;
	private Location dropOffLocationId;
	private User userId;
	private RentedCar rentedCarId;
	private Accessory accessoryId;
	
}
