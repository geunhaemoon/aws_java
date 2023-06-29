package ch08_생성자;

import javax.print.DocFlavor.STRING;

public class StudentMain {
	public static void main(String[] args) {
		Student s1 = new Student("문근해",26,"진구");
		System.out.println(s1);
//		s1.name = "문근해";
//		s1.age = 30;
//		s1.address = "진구";
		
		System.out.println(s1.name);
		
	}

}
