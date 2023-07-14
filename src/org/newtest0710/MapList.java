package org.newtest0710;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MapList {
	public static void main(String[] args) {
		List<String> colors = null;
		List<String> sizes = null;
		Map<String, List<String>> options = new HashMap<>();
		
		Map<String, Object> option1 = new HashMap<String, Object>();
		option1.put("color", "red");
		option1.put("size", "SS");
		
		options.add(option1);
		
		Map<String, Object> option2 = new HashMap<String, Object>();
		option1.put("color", "green");
		option1.put("size", "M");
		
		options.add(option1);
		for(Map.Entry<String, List<String>> entry : options.entrySet()) {
			
		}
	}

}
