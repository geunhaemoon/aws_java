package ch11_문자열;

public class String04 {

	public static void main(String[] args) {
		String phone = "                 010.4737            9949                  ";
		
		
		String replacePhone = phone
				.replaceAll("-", "")
				.replaceAll(" ", "")
				.replaceAll("[.]", "");
		System.out.println(replacePhone);
		
		//앞뒤에 붙은 공백 없애주는 명령어 = trim
		String phone2 = phone.trim();
		System.out.println(phone2);
	}

}
