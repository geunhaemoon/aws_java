package ch14_싱글톤;

import java.time.LocalDate;
import java.util.Date;

public class FactoryMain {
	public static void main(String[] args) {
//		Samsung samsung = new Samsung();
		//싱글톤이란 유일한 객체를 하나만 만드는것
		//객체란 new 붙이면 계속 만들어지지만 그것을 막는것이 싱글폰
		//어디서나 쉽게 접근하게 하기 위해서 사용
		
	//앞에서 프라이빗을 사용하게 되면서 new Samsung(); 사용 X 
		//그래서 대신 생성해줄 명령어 getInstance 사용
	Samsung samsung = Samsung.getInstance();
	System.out.println(samsung.getCompanyName());
	
		
		SamsungFactory factory1 = new SamsungFactory();
		SamsungFactory factory2 = new SamsungFactory();
		
		factory1.produce("갤럭시").showInfo();
		factory2.produce("갤럭시s2").showInfo();
		factory1.produce("갤럭시s3").showInfo();
	
	}

}
