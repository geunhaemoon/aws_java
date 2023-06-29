package ch04_입력;

import java.util.Scanner;

public class Input02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		/*
		 * 이름(name):
		 * 나이(age):
		 * 연락처(phone):
		 * 주소(address):
		 * 성별(gender):
		 * 
		 * 고객님의 이름은 000이고 나이는 00세입니다.
		 * 연락처는 010-0000-0000이며 주소는 부산 동래구 사직동입니다.
		 * 성별은 여자입니다.
		 * */
		
		
		/*
			System.out.print("이름 : ");
			String name = scanner.next();
			System.out.print("나이: ");
			String age = scanner.next();
			System.out.print("연락처: ");
			String phone = scanner.next();
			System.out.print("주소: ");
			String address = scanner.next();
			System.out.print("성별: ");	
			String gender = scanner.next();
			
			System.out.println("고객님의 이름은 "+name +"이고 나이는 " +age + "세입니다.\n 연락처는 " +phone +"이며 주소는 " 
								+address +"입니다. \n성별은 "+gender +"입니다.");
		*/
		
		String name = "";
		int age =0;
		String phone ="";
		String address="";
		String gender="";
		
		System.out.print("이름: ");
		name = scanner.next();
		System.out.print("나이: ");
		age = scanner.nextInt();
		System.out.print("연락처: ");
		phone = scanner .next();
		System.out.print("주소: ");
		scanner.nextLine();
		address = scanner.nextLine();
		System.out.print("성별: ");
		gender = scanner.next();
		
		System.out.println("고객님의 이름은 "+name +"이고 나이는 " +age + "세입니다.");
		System.out.println("연락처는"+ phone +" 이며 주소는 " + address +"입니다.");
		System.out.println("성별은" +gender +"입니다.");
		
		//next은 엔터와 스페이스 무시 nextline은 엔터와 스페이스 무시하지 않음.
		
		
		
		

	}
}
