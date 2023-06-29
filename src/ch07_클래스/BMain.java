package ch07_클래스;

public class BMain {
	public static void main(String[] args) {
		B b1 = new B();
		b1.test1(); //함수의 호출, 반환이 없음
		int num1 = b1.test2(); //정수값, 값이 반환됨. 그래서 int에 담을수있음
		System.out.println(num1);
		System.out.println(b1.test2());
		
		if(b1.test3()) {
			System.out.println("if문을 실행.");
		}
		
		b1.test4("문근해", 26);
		b1.test4(26, "문근해");
		

		
		
	} //main
}

