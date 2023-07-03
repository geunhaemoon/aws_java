package ch17_추상;

public class SmartDeviceMain {
	
	public static void main(String[] args) {
		SmartPhone phone = new SmartPhone("아이폰", 6.1, "010-4737-9949");
		Pad pad = new Pad("아이패드3",10.1, false);
		
//		SmartDevice device = new SmartDevice(null, 0);
		// 스마트폰과 패드의 공통상황에 대한 변수와 매소드를 모아둔 역할을 하고있다.
		//굳이 만들어 쓸 필요는 없지만 역할을 찾아보기위해 추상클래스를 만듬
		// smartDevice는 상속화 된 상황에서 구체화가 되어야 생성가능
		
		System.out.println(phone);
		System.out.println(pad);
		
		
		phone.connectedWiFi();
		pad.connectedWiFi();
	}
}
