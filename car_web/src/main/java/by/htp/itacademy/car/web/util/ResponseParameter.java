package by.htp.itacademy.car.web.util;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class ResponseParameter implements Serializable {
	
	private String pageResponse;
	private boolean stateResponse;
	
	public void chageResponse(String pageResponse, boolean stateResponse) {
		this.pageResponse = pageResponse;
		this.stateResponse = stateResponse;
	}
}
