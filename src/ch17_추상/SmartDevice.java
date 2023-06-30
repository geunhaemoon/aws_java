package ch17_추상;

import lombok.AllArgsConstructor;
import lombok.Data;
	

@AllArgsConstructor
@Data
public abstract class SmartDevice {
	private String deviceName;
	private double displaySize;
	
//	public void connectedWiFi() {}	
	//			추상매소드 
	public abstract void connectedWiFi();
}

//껍데기만 존재하게된 디바이스