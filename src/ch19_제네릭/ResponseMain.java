package ch19_제네릭;

public class ResponseMain {

	public static void main(String[] args) {
		Response<String> response1 = new Response<String>(200, "회원가입 성공 !!");
//		System.out.println(response1);
		
		SignupUser signupUser = SignupUser.builder()
				.username("aaa")
				.password("1234")
				.name("문근해")
				.email("aaa@gmail.com")
				.build();
		
		Response<SignupUser> response2 = new Response<SignupUser>(400, signupUser);
//		System.out.println(response2);
		// 제네릭은 매번 자료형 변할 수 있고 생성되는 시점에서 결정이 됨
		
		AccountUser accountUser = AccountUser.builder()
				.username("aaa")
				.password("1234")
				.build();
		
		Response<AccountUser> response3 = new Response<AccountUser>(200, accountUser);
//		Response<?> response3 = new Response<AccountUser>(200, accountUser);
//		생성이 될때 만들어진 accountUser이 물음표의 값이 됨. ? = accountUser	
		
//		response3 = response2;		
		
		UpdateUser updateUser = UpdateUser.builder()
				.name("aaa")
				.password("1234")
				.address("부산")
				.phone("010-0000-0000")
				.build();
		

		Response<?> response4 = new Response<UpdateUser>(300, updateUser);
		
		printResponse(response3);

		} //main
	
//		public static Response<?> printResponse(Response<? extends AccountUser> response ) {
		public static Response<?> printResponse(Response<? super SignupUser> response ) {
			System.out.println(response);
			return response;
		}
	
		
	}//class


