package ch05_조건;

import java.util.Scanner;

public class IfScore {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		int score =0;
		System.out.print("점수 입력 : ");
		score = scanner.nextInt();
		
		if(score<0 || score>100){
			System.out.println("잘못된 입력입니다");
		}else if(score>89) {
			System.out.println("A학점입니다");
		}else if(score>79){
			System.out.println("B학점입니다.");			
		}else if(score>69){
			System.out.println("C학점입니다.");
		}else if(score>59) {
			System.out.println("D학점입니다.");
		}else {
			System.out.println("F학점입니다.");
		}
		
		
		
	
	}

}
