package ch10_배열;

public class Customer {
	private String name;
	private String rating;
	
	//퍼블릭을 안붙이면 같은 패키지안에서만 가능 다른 패키지끼리도 하려면 퍼블릭붙여야함
	public Customer(String name, String rating) {
		this.name =name;
		this.rating = rating;
		
	}
	
	public void showInfo() {
		System.out.println("고객명: " + name);
		System.out.println("고객등급: " +rating);
		System.out.println();
	}
}
