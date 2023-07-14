package org.newtest0710;

public class Car {
	private String company;
	private String model;
	private String color;
	public Car(String company, String model, String color) {
		this.company = company;
		this.model = model;
		this.color = color;
	}
	@Override
	public String toString() {
		return  "[자동차 정보}  제조사 : " +company + " / 모델명: " 
				+ model+ " / 색상: "+color;
	}
}

