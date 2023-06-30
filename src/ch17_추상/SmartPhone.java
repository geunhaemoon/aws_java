package ch17_추상;

import lombok.ToString;

@ToString
public class SmartPhone extends SmartDevice implements Button {
	
	private String phoneNumber;
	
	//using field 사용해서 만듬
	public SmartPhone(String deviceName, double displaySize, String phoneNumber) {
		super(deviceName, displaySize);
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public void connectedWiFi(){
		System.out.println("스마트폰의 와이파이를 연결합니다.");
	}

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void volumUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void volumDown() {
		// TODO Auto-generated method stub
		
	} //

	
	
		
}
