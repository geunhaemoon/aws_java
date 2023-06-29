package ch09_접근지정자;

public class StudentMain2 {
	public static void main(String[] args) {
		Student2 s = new Student2();
		
//		s.name = "문근해" // 이렇게 바로입력하면 캡슐화가 안됨 사용 x
		
		s.setName("문근해");
		System.out.println(s.getName());
	}

}
