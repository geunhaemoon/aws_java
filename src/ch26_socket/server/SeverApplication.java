package ch26_socket.server;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SeverApplication {
	
	public static ServerSocket serverSocket;
	public static int port;
		
	public static void main(String[] args) {
	
		Thread connectionThread = null;
		
		System.out.println("[서버 프로그램 실행]");
		
		while(true) {
			Scanner scanner = new Scanner(System.in);
			
			int selectedMenu = 0;
			//메뉴 선택에 대한 변수
			System.out.println("1. 서버켜기");			
			System.out.println("2. 서버끄기");
			System.out.print("선택: ");
			
			try {
				selectedMenu = scanner.nextInt();
				//숫자만 받을수 있게 nextInt 지정해줘서 예외상황에 대한 만들기
			} catch (InputMismatchException e) {
				System.out.println("숫자만 입력 가능합니다.");
				continue;
			}
				
			
			switch (selectedMenu) {
			case 1:
				if (serverSocket != null) {
					System.out.println("이미 서버가 실행중입니다.");
					break;
				}
				System.out.println("서버의 포트번호를 입력하세요: ");
				
				try {
					port = scanner.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("숫자만 입력 가능합니다.");
					continue;
				}
									// 뉴 스레드 시작
				connectionThread = new Thread(() -> {
					try {
						serverSocket = new ServerSocket(port);
						
							//interrupted 가 트루인 상태가 되면 반복을 멈춤, 기다리지(accept)않고 자동으로 소멸시킴
						while(!Thread.interrupted()) {
							Socket socket = serverSocket.accept();
							System.out.println("접속 ! !");
							System.out.println(socket.getInetAddress().getHostAddress());
						}
					}catch (BindException e) {
						System.out.println("이미 사용중인 포트번호입니다.");
					} catch (SocketException e) {
						System.out.println("서버의 연결이 종료되었습니다.");
					} catch (IOException e) {
						e.printStackTrace();
					}
				},"connetionThread");
				
				connectionThread.start();
				//이게 호출되어야만 시작이 가능함.
						 
				break;

			case 2:
				if (serverSocket  == null) {
					System.out.println("서버가 실행중이지 않습니다.");
					break;
				}
				try {
					serverSocket.close();
				} catch (IOException e) {}
				
				connectionThread.interrupt();
				//강제로 스레드를 종료시키기위해서 사용
				//interrupt >> 먼저 작동 시키게하는 명령어
				
				try {
					connectionThread.join();
					//join 앞에꺼 다 실행될때까지 기다려줌
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("프로그램 종료");
				return; // main 메소드에 리턴을 걸어서 멈춰줌
				
			default:
				System.out.println("다시 선택하세요.");
			}//switch		
		}//while
	}//main
}//class
