package ch20_컬렉션;

import java.util.Iterator;

import ch06_반복.For01;
import lombok.Builder;

public class CustomArrayList<T> {
	
	private String[] array;
	
	public CustomArrayList() {
		array = new String[0];
	}
	
	public void add(String str) {
		 String[] newArray = new String[array.length + 1];
		 for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		 newArray[array.length] = str;
		 array = newArray;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("[");
		for(String str : array) {
			builder.append(str + ",");
		}
//		for (int i = 0; i < array.length; i++) {
//			builder.append(array[i] + ",");
//		}
// 이렇게 길게 써지는걸 27-30으로 정리가능
		
		public void add(int index, String str) {
			String[] newArray = new String[(array.length)+1];
			
			for(int i = 0; i < index; i++) {
				newArray[i] = array[i];
			}
			newArray[index] =str;
			for (int i = index; i < array.length; i++) {
				
			}
			array = newArray;
				
		}
		
		
		builder.delete(builder.lastIndexOf(","), builder.length());
		builder.append("]");
		
		return builder.toString();
	}
	
	
	
		
	
	
	
	
}//class
