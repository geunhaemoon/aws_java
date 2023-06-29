package ch08_생성자;

public class Student {
	
	//(final)은 원래 생략되어있음
	String name;
	int age;
	String address;
	
//	Student() {
//		System.out.println("NoArgsConstructor");
//		System.out.println("학생 한명을 생성합니다.");
//
//	}
	
	Student(String name, int age, String address){
		System.out.println("AllArgsConstructor");
		this.name = name;
		this.age = age;
		this.address = address;
		//새로운 값을 넣으면 this가 주소가 됨
	}
	
	
	Student(String name){
		//필수생성자
		System.out.println("RequiredArgsContructor");
		this.name = name;
	}

}
