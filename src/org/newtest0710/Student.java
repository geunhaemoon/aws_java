package org.newtest0710;

public class Student {
	private String studentName;
	public Student(String studentName) {
		this.studentName = studentName;
	}
	public void showStudent() {
		System.out.println("이름을 입력하세요: " + studentName);
	}
}
