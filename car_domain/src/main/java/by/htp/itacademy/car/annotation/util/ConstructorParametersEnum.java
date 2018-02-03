package by.htp.itacademy.car.annotation.util;

public enum ConstructorParametersEnum {
	
	ZERO  (0), 
	ONE   (1), 
	TWO   (2), 
	THREE (3), 
	FOUR  (4), 
	FIVE  (5), 
	SIX   (6), 
	SEVEN (7), 
	EIGHT (8), 
	NINE  (9), 
	TEN   (10);

	private int count;
	
	ConstructorParametersEnum(int count) {
		this.count = count;
	}

	public int getCount() {
		return count;
	}
}
