package by.htp.itacademy.car.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Accessory implements Entity, Serializable {

	private static final long serialVersionUID = -5957895850562799609L;
	
	private Long accessoryId;
	private String name;
	private BigDecimal price;

}
