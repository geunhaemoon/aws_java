package ch14_싱글톤;

import java.time.LocalDate;
import java.util.Date;

public class Samsung {
	
	private static Samsung instance;
	// 삼성을 담을수있는 스태틱 변수
	
	private String companyName;
	private int autoIncrementSerialNumber = LocalDate.now().getYear()*100000;
	
	//생성자로 바꿈
	//프라이빗으로 하면서 다른 곳에서 삼성을 생성 못하게 함.
	private Samsung() {
//		companyName = "SAMSUNG";  밑에 표현으로 표현가능
		companyName = Samsung.class.getSimpleName().toUpperCase();
		
	}
	
	//밖에서 사용할수있는 getinstance 스태틱 변수를 사용해야한다.
	public static Samsung getInstance() {
		if(instance == null) {
			instance = new Samsung();
		}
		return instance;
	}
	//여기까지 private , getinstance 싱글코드 만들때 유일한 객체 불러오는법
	
	public int getAutoIncrementSerialNumber() {
		return autoIncrementSerialNumber;
	}
	public void setAutoIncrementSerialNumber(int autoIncrementSerialNumber) {
		this.autoIncrementSerialNumber = autoIncrementSerialNumber;
	}
	public String getCompanyName() {
		return companyName;
	}
	
	

}
