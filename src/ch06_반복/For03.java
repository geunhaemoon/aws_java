package ch06_반복;

import java.util.Iterator;

public class For03 {
	public static void main(String[] args) {
		
		for (int i = 0; i <5; i++) {
			for (int j = 0; j < i +1 ; j++) {
				System.out.print("*");
			}
			System.out.println();		
		}
		
		
		for (int i = 0; i <5; i++) {
			for (int j = 0; j <5-i; j++) {
				System.out.print("*");				
			}
			System.out.println();						
		}
		
		System.out.println("-----------------");
		
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5-1-i; j++) {
				System.out.print(" ");
			}
			
			for (int j2 = 0; j2 <i+1; j2++) {
				System.out.print("*");
			}
		
			System.out.println();
		}
		
		
		
		
	}

}
