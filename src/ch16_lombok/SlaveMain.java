package ch16_lombok;

public class SlaveMain {
	public static void main(String[] args) {
		Slave slave = new Slave("문근해", 25);
		Slave slave2 = new Slave("문근해", 25);
	
		System.out.println(slave.equals(slave2));
		
		// 
	}
}
