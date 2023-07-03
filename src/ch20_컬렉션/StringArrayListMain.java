package ch20_컬렉션;

import java.util.ArrayList;

public class StringArrayListMain {
	
	public static void main(String[] args) {
		CustomArrayList list = new CustomArrayList();
		
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		
		
		// 새로운 배열을 만들어서 1번 자리에 f를 넣고 나머지 한칸씩 미루기
//		list.add(1, "f");s

		ArrayList list1 = new ArrayList<>();
		
		list1.add("a");
		list1.add("b");
		list1.add("c");
		list1.add("d");
		list1.add("e");
		list1.add(4,"f");
		
		
		
		System.out.println(list1);
		
		

		
		
	}
	
	
	
	
}
