package org.newtest0710;

import lombok.ToString;

@ToString
public class CarMain {
	
	public static void main(String[] args) {
		Car car = new Car("현대자동차", "그랜저", "화이트");
		System.out.println(car);
	}

}
