package org.example;

public class User {
	String username;
	 String password;
	 String name;
	 String email;
	
	public User(String username, String password, String name, String email) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
	}
}


	//("준일","1234","김준일","junil@gmail.com
//	User user = User.builder(User)
//			.username("준일")
//			.password("1234")
//			.name("김준일")
//			.email("junil@gmail.com")
//			.build();