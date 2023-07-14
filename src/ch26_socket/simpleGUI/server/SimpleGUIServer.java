package ch26_socket.simpleGUI.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import ch26_socket.simpleGUI.server.entity.Room;

public class SimpleGUIServer {

	public static List<ConnectedSocket> connectedSocketList = new ArrayList<>();
	public static List<Room> roomList = new ArrayList<>();
	
	public static void main(String[] args) {
		
		try {
			ServerSocket serverSocket = new ServerSocket(8000);
			System.out.println("[ 서 버 실 행 ] ");
			
			while(true) {
				Socket socket = serverSocket.accept();
				System.out.print("접속");
				ConnectedSocket connectedSocket = new ConnectedSocket(socket);
				connectedSocket.start();
				connectedSocketList.add(connectedSocket);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
