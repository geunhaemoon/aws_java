package org.newtest0710;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> names = Arrays.asList(new String[] {"강대협", "김수현","진채희", "김두영" });
		List<Integer> score = Arrays.asList(new Integer[] {95,80,85});
		
		System.out.println("[성적 정보]");
		
		for (int i = 0; i < 3; i++) {
			System.out.println("이름: "+ names.get(i) + "점수: " + score.get(i));
		}
	}

}
