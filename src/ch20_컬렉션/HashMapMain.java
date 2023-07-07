package ch20_컬렉션;

import java.util.HashMap;
import java.util.Map.Entry;

//클래스 또한 자료형
public class HashMapMain {
	public static void main(String[] args) {
		HashMap<String, String> strMap = new HashMap<>();
		strMap.put("username","aaa");
		strMap.put("password","1234");
		strMap.put("name","문근해");
		// hash에 의해서 정리가 됨
		System.out.println(strMap);
		System.out.println(strMap.get("username"));
		
		System.out.println("================");
		for(Entry<String, String> entry : strMap.entrySet()) {
			
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		} // 위아래 둘다 자료형 빼내는 법 , 엔트리 쓰는걸 더 선호함
		System.out.println("=================");
		for(String key : strMap.keySet()) {
			System.out.println(strMap.get(key));
		}
		//

		
	}//main
}//class