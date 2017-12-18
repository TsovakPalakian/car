package by.htp.itacademy.car.car_domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Entity, Serializable {

	private static final long serialVersionUID = 2902931410838985262L;
	
	private Long orderId;
	private Date pickUpDate;
	private Date dropOffDate;
	private String status;
	private BigDecimal totalPrice;
	private Long pickUpLocationId;
	private Long dropOffLocationId;
	private Long userId;
	private Long rentedCarId;
	private Long accessoryId;
	
}
