package ch11_문자열;

public class String02 {
	public static void main(String[] args) {
		String phone = "010-9988-1916";
		
		int index = phone.indexOf("-");
		int lastIndex = phone.lastIndexOf("-");
		
		System.out.println(index);
		System.out.println(lastIndex);
		
		// ex) 9988 짜르기
//		String midNumber = phone.substring(4, 8);
//		System.out.println(midNumber);
//		
		String midNumber = phone.substring(index+1, lastIndex);
		System.out.println(midNumber);
		
		boolean findFlag = phone.contains("010");
		
		
	}//main

}
