package ch20_컬렉션;

import java.util.ArrayList;
import java.util.LinkedList;

public class StringArrayListMain {
	
	public static void main(String[] args) {
		CustomArrayList list = new CustomArrayList();
		
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		
		
		
		// 새로운 배열을 만들어서 1번 자리에 f를 넣고 나머지 한칸씩 미루기
		list.add(1, "f");

//		ArrayList list1 = new ArrayList<>();
		
//		list1.add("a");
//		list1.add("b");
//		list1.add("c");
//		list1.add("d");
//		list1.add("e");
//		list1.add(,"f");
		
		
		
		System.out.println(list);
		System.out.println(list.remove());
		System.out.println(list);
		System.out.println(list.remove(3));
		System.out.println(list);
		
		System.out.println("========================");
		
		
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("a");
		arrayList.add("b");
		arrayList.add("c");
		arrayList.add("d");
		arrayList.add("e");
		arrayList.add(1, "f");
		
		System.out.println(arrayList);
		System.out.println(arrayList.remove(3));
		System.out.println(arrayList);
		arrayList.set(0, "h");
		System.out.println(arrayList);
		
		LinkedList<String> linkedList = new LinkedList<>();
		// 앞에변수에 스트링으로 잡혀져있으면 뒤에는 생략가능 (대입시에만)	
		
		
		
	}
	
	
	
}
