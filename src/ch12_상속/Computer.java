package ch12_상속;

public class Computer extends Product {
	private String type;

	
//	public Computer() {
//		super("",10);
//		System.out.println("컴퓨터 객체 생성");
//
//	}
	
	
	public Computer(String model, int price) {
		super(model, price);
	}

	
	public Computer(String model, int price, String type) {
		super(model, price); // 컴퓨터 객체의 부모객체 불러오는것..? 
		this.type = type;
	}


	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	
}
