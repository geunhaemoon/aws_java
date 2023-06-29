package ch06_반복;

import java.util.Iterator;

public class For01 {
	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 4, 5, 6};
		
		for (int i = 0; i < 6; i++)System.out.println(numbers[i]); 
		//		1		2 5		4 7			3 6		
//			변수선언과 초기화
//						조건이 참일시 실행되는것은 출력
//									
		for (int i = 0; i < 6; i++) {
			System.out.println(numbers[i]); 
			System.out.println("i: " +i);
		}
		
		System.out.println("-----------------------------------");
		
//		for (int i = 0, j=0; i < 6; i++, j++)System.out.println(numbers[i]);
		
		
	}
}
