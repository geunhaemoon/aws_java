package ch18_빌더;

public class KoreaUserMain {

	public static void main(String[] args) {
		KoreaUser koreaUser = KoreaUser.builder().userId(1).build();
		KoreaUser koreaUser2 = new koreaUser(1,null,null,null,null); //비효율
		KoreaUser koreaUser3 = new KoreaUser();
		KoreaUser3.setUSerId(1);//
		
		
//		KoreaUser koreaUser = KoreaUser.builder()
//				.userId(1)
//				.username("aaa")
//				.password("1234")
//				.name("문근해")
//				.email("aaa@gamil.com")
//				.build();
		
		//KoreaUser koreaUser = KoreaUser.builder().build(); 
		//로도 사용 가능
		
	}

}
