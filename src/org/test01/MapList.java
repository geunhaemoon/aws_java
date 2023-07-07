package org.test01;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapList {
	
	public static void main(String[] args) {
		List<Map<String, Object>> customers = new ArrayList<Map<String, Object>>();
		
		
		customers.put("name","홍길동");
		customers.put("rating","vip");
		customers.put("age","30");
		customers.put("name","김기영");
		customers.put("rating","gold");
		customers.put("age","35");

		
		for(Map<String, Object> customer : customers) {
			customers.get(key);
			System.out.println(customers);

		}
	}
}
