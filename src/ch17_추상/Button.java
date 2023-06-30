package ch17_추상;

public interface Button {
	public int buttonCount = 4;
			  // 스태틱상수
	
	public void powerOn();
	public void powerOff();
	public void volumUp();
	public void volumDown();
	
}

//interface 의 특징
//인터페이스 안에 적는건 다 추상 메소드이다. 
// 일반변수 사용 X 추상 변수만 사용가능

// 다중구현 가능
// 다중 상속 X

//인터페이스 = 부속 , 부품 
//스마트폰 > 폰 >스마트폰 관계가 서로 성립 : 쌍방향 추상클래스 사용가능

// 스마트폰 > 카메라 o 카메라 >스마트폰 x  : 단방향 인터페이스로 만들어야함

//일반 상속은 잘 안씀, 기존에 있던 기능을 조금 보안할때정도 일반상속사용