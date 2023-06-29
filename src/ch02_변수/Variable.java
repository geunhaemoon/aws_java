package ch02_변수;

public class Variable {
	
	public static void main(String[] args) {
		boolean flag; //선언		자료형이 나오고 나서는 무조건 변수명
		flag = true; //초기화(대입)	변수명 
		System.out.println("FLAG : " + flag); //자바에서는 문자열을 합칠때 +를 사용함
		
		System.out.print("FLAG : "); // 위랑 동일하게 나옴
		System.out.println(flag);

		
		char lastName = '김'; //한줄로 선언과 초기화를 할 수 있다 
		System.out.println(lastName);
		
		int number = 100;
		System.out.println("번호: " +number);
		
		double pi = 3.14;
		System.out.println(pi);
		
		String name = "문근해";
		System.out.println(name);
		
		//Q
		String num1 = "10";
		int num2 =10;
		System.out.println("String : " + num1); // 10
		System.out.println("int : " + num2); // 10
		System.out.println(num1 + num2); //1010
		
		//자료형을 정수로 형변환시켜야함 
		System.out.println(Integer.parseInt(num1)+10); //이건 어려우니 다음에
		
		
		char num3 ='5';
		System.out.println(num3 + num2); // 63 ??? 왜 이런 숫자가 나오는지 아스키코드확인
		//int 단위가 더 크니까 char의 5를 정수로 강제변환되어 53이되어버린다.
		System.out.println((int)num3); //바꾸려는 자료형을 적으면 쉽게 변환가능 53
		System.out.println((double)num3); // 53.0
		
		
		 //1. 묵시적 형변환(업캐스팅 문자->정수->실수)
		int num4 = num3; 
		System.out.println(num4); //53 (int)를 명시하지않아도알아서바꿔짐
		 //2. 명시적 형변환 (다운캐스팅 실수->정수->문자)
		char num5 =  (char)num4;
		System.out.println(num5);
		
		// 데이터의 손실이 일어남 
		//큰것을 작은것으로 바꾸려할때 명시하지 않을땐 버그로 막힘
		//명시할땐 데이터 손실이 잃어나도괜찮다 생각하고 가능한 만큼만 변환함
		// 명시적 형변환 이후 묵시적 형변환을 다시 하면 데이터 손실이 잃어난 상황이라 원래값으로 돌아오지않음
		//
		
		

	}
}
