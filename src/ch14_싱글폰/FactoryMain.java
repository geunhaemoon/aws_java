package ch14_싱글폰;

public class FactoryMain {
	public static void main(String[] args) {
		Samsung samsung = new Samsung();
		//싱글폰이란 유일한 객체를 하나만 만드는것
		//객체란 new 붙이면 계속 만들어지지만 그것을 막는것이 싱글폰
		//어디서나 쉽게 접근하게 하기 위해서 사용
		
		SamsungFactory factory1 = new SamsungFactory(samsung);
		SamsungFactory factory2 = new SamsungFactory(samsung);
		
		factory1.produce("갤럭시").showInfo();
		factory2.produce("갤럭시s2").showInfo();
		factory1.produce("갤럭시s3").showInfo();
	
	}

}
