package ch24_쓰레드;

import java.util.Iterator;

public class TheadMain {
	
	public static void main(String[] args) {
		Thread thread1 = new Thread(() -> {
			System.out.print("스레드 이름: " + Thread.currentThread().getName());
			for (int i = 0; i < 50; i++) {
				System.out.print(Thread.currentThread().getName() +":");
								// 스레드에 스테틱 영역이 있음. 실행중인 스레드가 current스레드로 잡힘
				System.out.println(i);
				try {
					Thread.sleep(2000); // 실행하고 2000초씩 쉬게함
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "1번 스레드");
		
		
		Thread thread2 = new Thread(() -> {
			System.out.print("스레드 이름: " + Thread.currentThread().getName());
			for (int i = 0; i < 50; i++) {
				System.out.print(Thread.currentThread().getName() +":");
				System.out.println(i);
				
			}
		}, "2번 스레드");
		
//		Thread thread3 = new Thread(new ThreadTest(), "3번 스레드");
//		Thread thread4 = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				System.out.println("4번 스레드 실행");
//			}
//		}, "4번 스레드");
		

		thread1.start();
		try {
			thread1.join(); // 끝날때까지 대기시킴
		} catch (InterruptedException e) {
			e.printStackTrace(); 
		}
		thread2.start(); // 스레드 안에 들어있는 객체
//		thread3.start();
//		thread4.start();
		
		//먼저 안착되는것이 먼저 표시됨.
	
	}

}
