package ch07_클래스.overloading;

public class Phone {
	
	public void send() {
		System.out.println("전송");
	}
	
	public void send(String message) {
		System.out.println("전송내용: " +  message);
	}
	
	public void send (String number, String message) {
		System.out.println(number + "에게" + message + "내용 전송");
	}
	
	public void sen(String message, int count) {
		System.out.println(message + "내용" + count + "번 전송");
		
	}
}


/*

폰이라는 객체안에 샌드라는 변수명이 많이 있음 
매개변수가 다 다르게 생김 자료형이 다 다름 변수명은 중요하지않음



*/
