package ch03_연산자;

public class Operator01 {
	// main + ctrl 하면 밑에 뜸
	public static void main(String[] args) {
		System.out.println(3 / 2); //연산자는 항상 앞뒤로 띄워줘야함 (가독성) //정수로들어가서 1로나옴
		System.out.println(3 / 2.0); // 1.5
		
		/*
		int num = 10;
		
		System.out.println(num++); // 10
		// ++ : 지금 증가되는것이 아니라 다음 차례에 증가됨
		System.out.println(num); // 11
		 */
		
		int num = 10;	
		
		System.out.println(num++); //10
		System.out.println(num++); //11
		System.out.println(num); //12
		System.out.println(--num); //11
		System.out.println(num++); //11
		System.out.println(num); //12
		
		
		
		
		
		
		
	}
}
