package ch04_입력;

import java.util.Scanner;
// next는, line 문자열 string 전용 //next 사용시 띄워쓰기 불가능
public class Input01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		scanner.next(); //next 입력을 기다리고있음		
		
		System.out.print("첫번째 입력 : ");
		String input1 = scanner.nextLine();
		System.out.println("첫번째 출력: " +input1);	
		
		System.out.print("두번째 입력 : ");
		String input2 =scanner.nextLine();
		System.out.println("두번째 출력: " +input2);
		
		System.out.println("입력완료.");
		

		
	}

}

