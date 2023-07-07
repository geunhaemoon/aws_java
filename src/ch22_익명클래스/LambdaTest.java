package ch22_익명클래스;

public class LambdaTest {

	public static void main(String[] args) {
		GrantedAuthorities authorities2 = new GrantedAuthorities() {
			
			@Override
			public String getAuthority() {
				System.out.println("권한 출력");
				return "ROLE_USER";
			}
		};
		
		//가능하려면 인터페이스 안에 추상메소드가 하나만 있어야함
		
		
//		GrantedAuthorities authorities = () -> {
//			System.out.println("권한 출력"); 
//			return "ROLE_USER";
//		};
		
		GrantedAuthorities authorities = () -> "ROLE_USER";
		
		
		//default 일반메소드를 사용할때
		//accept 추상메소드 
		//람다식은 매개변수의 자료형을 생략할수있다
		// 매개변수가 하나인 경우에는 생략가능, 가로는있어야야함
		
		
		// class B extends A 계속 쓰는 상황에서 상속
		// class ? extends A 
		//new A(); 익명클래스 이번만 쓰는 추상 
		// 새로운 메소드를 추가는 가능한데 못쓴다 다운캐스팅이 안됨 그래서 못씀 
		// 그 위에 상속된것이 있으면 가능할지도...?
		
		
	}
}
