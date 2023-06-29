package ch03_연산자;

public class Operator03 {
	
	public static void main(String[] args) {
		
		int a = 3;
		int b = 2;
		int c = 1;
		
		int max = 0;
		
		max = a < b ? b : a;
		max = max < c ? c : max;
		
		System.out.println(max);
		
		
		
		
//		System.out.println();

//		System.out.println(a < b && b < c ? c : (a < b && c < b ? b : a );
		
		
		
//		int result = a < b  && b < c  && a < c ? c : 0;
//		
//		System.out.println(result);
		
	}

}
