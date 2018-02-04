package by.htp.itacademy.car.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class Accessory implements Entity, Serializable {

	private Long id;
	private String name;
	private BigDecimal price;

}
