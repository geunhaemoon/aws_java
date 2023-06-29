package ch06_반복;

public class for02 {
	public static void main(String[] args) {
		
		int num =10;
		System.out.println(num);
		
//		num = 20;
		//값을 바꾸는거지 새로운 선언은 불가
		
		for (int i = 0; i <10; i++) {
			//0으로 시작
			// 			반복 할 횟수
			
			System.out.println(i+1);			
		}
		
		String str = "코리아아이티";
		System.out.println(str.substring(0,3));
		//						0부터 3전까지
	}

}
