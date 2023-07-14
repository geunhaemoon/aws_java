package org.newtest0710;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class ProductMain {

	    public static void main(String[] args) {

	        Gson gson = new GsonBuilder().setPrettyPrinting().create();

	        Product product = new Product(2001, "laptop", "Samsung GalaxyBook", 1400000);

	        System.out.println(gson.toJson(product));
	    }
}


