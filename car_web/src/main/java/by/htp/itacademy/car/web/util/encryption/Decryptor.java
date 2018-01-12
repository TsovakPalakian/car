package by.htp.itacademy.car.web.util.encryption;

public class Decryptor extends CipherMachine {

	private Decryptor() {}
	
	private String getDecryptData(int[] dataArrayInt, int[] keyArrayInt) {
		char[] dataDecryptArrayChar = new char[dataArrayInt.length];
		for(int i = 0, l = dataArrayInt.length; i < l; i++) {
			dataDecryptArrayChar[i] = (char) (dataArrayInt[i] - keyArrayInt[i]);
		}
		return new String(dataDecryptArrayChar);
	}
	
	public String decrypt(String data) {
		return getDecryptData(converterDataIntoAnArrayOfIntegers(data), 
				converterKeyIntoAnArrayOfIntegers());
	}
}
