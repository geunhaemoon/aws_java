package ch10_배열;

import java.util.Iterator;

public class CustomerArrayMain {
	
	public static void main(String[] args) {
		Customer[] customers = new Customer[10];
		//10명을 담을 수 있는 공간을 만든것임.
		
		
//		Customer customer1 = new Customer("김준일", "Gold");
//		Customer customer2 = new Customer("이동헌", "Silver");
//		Customer customer3 = new Customer("문근해", "Vip");
		
		customers[0] = new Customer("김준일", "Gold");
		customers[1]= new Customer("이동헌", "Silver");
		customers[2] = new Customer("문근해", "Vip");
		
		
//		for (int i = 0; i < customers.length; i++) {
//			if(customers[i] != null) {
//				customers[i].showInfo();
//			}
//		}

		for (int i = 0; i < customers.length; i++) {
			if(customers[i] == null) {
				continue;				
			}
			customers[i].showInfo();
		}
		
//		customer1.showInfo();
//		customer2.showInfo();
//		customer3.showInfo();
	}

}
