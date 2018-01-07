package by.htp.itacademy.car.web.annotation.util;

public enum ConstructorParametersEnum {
	
	ZERO  ((byte) 0), 
	ONE   ((byte) 1), 
	TWO   ((byte) 2), 
	THREE ((byte) 3), 
	FOUR  ((byte) 4), 
	FIVE  ((byte) 5), 
	SIX   ((byte) 6), 
	SEVEN ((byte) 7), 
	EIGHT ((byte) 8), 
	NINE  ((byte) 9), 
	TEN   ((byte) 10);

	private byte count;
	
	ConstructorParametersEnum(byte count) {
		this.count = count;
	}

	public byte getCount() {
		return count;
	}
}
