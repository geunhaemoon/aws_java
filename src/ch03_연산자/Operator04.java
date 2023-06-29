package ch03_연산자;

public class Operator04 {
	
	public static void main(String[] args) {
		
		int score = 65;
		

		//선생님이한거
		String result = score < 0 || score >100 ? "X" 
				: score > 89 ? "A" 
				: score > 79 ? "B" 
				: score > 69 ? "C" 
				: score > 59 ? "D" 
				: "F";
						
		System.out.println(result);
						
	
		
		
		// 내가한거
		System.out.println(score >= 90 ? "A" 
				:(score <= 89 && score >= 80 ? "B"
				:(score <= 79 && score >= 70 ? "C"
				:(score <=69 && score >=60 ? "D" 
				: "F"))));

		

		
		
		
	}

}
