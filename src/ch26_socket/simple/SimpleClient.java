package ch26_socket.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SimpleClient {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("클라이언트 실행");
		try {
										// ip , 포트번호
			Socket socket = new Socket("127.0.0.1", 8000);
			Thread inputThread = new Thread( () -> {
				
				try {
//				InputStream inputStream = socket.getInputStream();
//				InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
// 				위에 세 줄을 밑에 코드로 단축시킴  >>> BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))
					while(true){
						BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						String reqestBody = bufferedReader.readLine();
						System.out.println("내용: " + reqestBody);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			});
			inputThread.start();
			
			while(true) {
				PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
				System.out.print("입력: ");
				String input = scanner.nextLine();

				printWriter.println(input);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
