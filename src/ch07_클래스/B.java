package ch07_클래스;

public class B {
	
	//반환 x 매개변수x
	void test1() {
		System.out.println("test1 메소드 호출");
	}
	
	//반환(정수) 매개변수x
	int test2() {
		System.out.println("test2 메소드 호출");
		return 100;
	}
	
	// 반환(논리) 매개변수x
	boolean test3() {
		System.out.println("test3 메소드 서비스를 실행합니다.");
//		return true;
		return test2() == 100;
	
	}
	
	//
	void test4(String name, int age) {
		System.out.println("이름: "+name);
		System.out.println("나이: "+age);
	}
	
/*	 이건 안되는데 아래껀 됨
 * 오버로딩 : 매개변수의 자료형 종류순서가 다르면 똑같은 매소드를 쓸 수 있음
 * int - return 이랑 상관 없음 
	void test4(String name, int score) {
		System.out.println("나의 이름: " +name);
		System.out.println("나의 점수: " +score);
	}
*/	
	void test4(int age, String name) {
		System.out.println("나의 이름: " +name);
		System.out.println("나의 나이: " +age);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
