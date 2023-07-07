package org.example;



public class Casting {
	public static void main(String[] args) {
		Program[] programs = new Program[2];
		programs[0] = new Java();
		programs[1] = new C();
	
//		for (int i = 0; i < programs.length; i++) {
//			programs[0].develop();
//			programs[1].develop();
//		}
		
		for (int i = 0; i < programs.length; i++) {
			programs[1].develop();
			if(programs[0].getClass() == Java.class) {
				Java java = (Java) programs[0];
			}else if(programs[1].getClass() == C.class) {
				C c = (C)programs[1];
				c.defineStructure();
			}
		}
	}
}
