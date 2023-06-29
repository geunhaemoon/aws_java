package ch03_연산자;

/*
 
 논리연산자
 1. &&	:	and	(그리고)	곱
 	true && false => false
 2. ||	:	or	(또는)		합
  	true || false => true
 3. !	:	not	(부정)		반전
 	!(ture || fasle) => false
 
 
 * */


public class Operator02 {

	public static void main(String[] args) {
		
		int year = 1999;
		//4를 나눴을때 4의배수 
		
//		이건 왜 안되징
//		System.out.println(year % 4);
//		
//		true == 0;

		
		System.out.println(year % 4 == 0);
		
		System.out.println(year % 100 != 0);

		System.out.println(year % 400 == 0);
		
		
		System.out.println(year % 4 == 0 && year % 100 != 0 || year % 400 ==0);

		// 조건 연산자 ?  >>> 앞에 조건이 참이면 결과1 아니면 결과2 / 결과1과 2의 상태는 같아야함 정수면 정수 문자값이면 문자값 
		System.out.println(year % 4 == 0 && year % 100 != 0 || year % 400 ==0 ? 1 : 0);
		
		int result = 10 + 1;
		System.out.println(result);

		
		boolean result2 = year % 4 == 0 && year % 100 != 0 || year % 400 ==0;
		System.out.println(result2);
		
		String result3 = year % 4 == 0 && year % 100 != 0 || year % 400 ==0 ? "1" : "0";
		System.out.println(result3);
		
		
		
		
		
//		if (year % 4 == 0 && year % 100 != 0 || year % 400 ==0) {
//			System.out.println(1);
//		} else{
//			System.out.println(0);
//		}
//		참이면 1 출력 아니면 0출력 
		
		/*
		//final 상수값임. 변화불가능함. 초기화를 시켜줘야함.
		final int MAX = 100;
		final int MIN = 0;
		int num = -10;
		
		System.out.println(MAX < num); //false
		System.out.println(MIN < num || MAX > num);  // || 또는의 의미를 가짐 , 둘 중 하나라도 맞으면 참
		System.out.println(MIN < num && MAX > num);  //  && 그리고의 의미를 가짐, 둘 다 맞아야 참
		
		*/	




	}

}
