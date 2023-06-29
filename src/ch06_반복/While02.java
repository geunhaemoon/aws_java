package ch06_반복;

public class While02 {
	public static void main(String[] args) {
		
		int i = 0;
		
		while(i < 10) {
			if(i % 2 == 0) {
				i++;
				continue;
				//다음 조건으로 넘어가라는 의미, 다음조건을 반복하러?
			}
			System.out.println(i);
			i++;
		}
	}

}
