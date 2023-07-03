package ch13_스태틱;

import java.util.Arrays;

public class MessageUtilMain {

	private int a;
	
	public static void main(String[] args) {
//		Arrays.
		MessageUtilMain messageUtilMain = new MessageUtilMain();
		
		System.out.println(messageUtilMain.a);
		
//		Array01.main(null);
		
		MessageUtil messageUtil2 = new MessageUtil();
		
		
		MessageUtil messageUtil = new MessageUtil();
		
//		messageUtil.sendMail();
//		messageUtil.sendFile();  //file 인텔리체 //바로 접근이 가능한것이 스태틱??????
	
		MessageUtil.sendFile();
		System.out.println();
		
		MessageUtil.data = "안녕";
		System.out.println(MessageUtil.data );
		
		System.out.println(messageUtil.data);
		// 같은 값이 출력됨. 스태틱은 공유되는 개념이다.  
	}
	
	
}
