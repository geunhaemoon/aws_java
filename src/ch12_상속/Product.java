package ch12_상속;

public class Product {
	private String model;
	private int price;
	
//	public Product() {
//		System.out.println("상품 객체 생성");
//	}
	
	//게터 세터 만들어야함
	// 알트 + 쉬프트 + s 

	
	
	public Product(String model, int price) {
//		super(); 생략되어있음
		this.model = model;
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

	
	
}
