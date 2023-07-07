package org.example;

public class UserMain {
	
	public static void main(String[] args) {
		User user = new User("junil","1234","김준일","junil@gmail.com");
		
	System.out.println("[사용자 정보]");	
	System.out.println("username: "+user.username);
	System.out.println("password: "+user.password);
	System.out.println("name: " + user.name);
	System.out.println("email: "+ user.email);
	}
}