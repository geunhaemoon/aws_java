package ch14_싱글톤;

public class SamsungFactory {
//	
//	private Samsung samsung;
//	
//	public SamsungFactory(Samsung samsung) {
//		this.samsung = samsung;
//	}
//	
	
	public Galaxy produce(String model) {
//		System.out.println(samsung.getCompanyName()+"에서 스마트폰을 생성합니다."); //스태틱변수를 그대로 들고와서 사용
		System.out.println(Samsung.getInstance().getCompanyName()+"에서 스마트폰을 생성합니다.");
		int newSerialNumber = Samsung.getInstance().getAutoIncrementSerialNumber()+1; 
		//
		return new Galaxy(newSerialNumber, model);
	}
	
	public void showCompanyName() {
		System.out.println("회사명"+  Samsung.getInstance().getCompanyName());
	}
	
}
