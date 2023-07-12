package ch26_socket.simpleGUI.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ch26_socket.simpleGUI.client.SimpleGUIClient;
import ch26_socket.simpleGUI.client.dto.RequestBodyDto;
import ch26_socket.simpleGUI.client.dto.SendMessage;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConnectedSocket extends Thread {
	
	private final Socket socket;
	private String username;
	
	@Override
	public void run() {
		while(true) {
			try {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String requestBody = bufferedReader.readLine();
				
				requestCcontroller(requestBody); 

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void requestCcontroller(String requestBody) {
		Gson gson = new Gson();
		
		
		String resource = gson.fromJson(requestBody, RequestBodyDto.class).getResource();

		
		switch(resource) {
			case "join" :
				username =(String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
				
				SimpleGUIServer.connectedSocketList.forEach(ConnectedSocket -> {
					List<String> usernameList = new ArrayList<>();
					SimpleGUIServer.connectedSocketList.forEach(con ->{
						usernameList.add(con.username);
					});
					
					RequestBodyDto<List<String>> updateUserListDto = new RequestBodyDto<List<String>>("updateUserList", usernameList);
					RequestBodyDto<String> joinMessageDto = new RequestBodyDto<String>("showMessage", username +"님이 들어왔습니다.");
					
					ServerSender.getInstance().send(ConnectedSocket.socket, updateUserListDto);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ServerSender.getInstance().send(ConnectedSocket.socket, joinMessageDto);
				});
				
				break;
		
			case "sendMessage":
				TypeToken<RequestBodyDto<SendMessage>> typeToken =new TypeToken<RequestBodyDto<SendMessage>>(){};
				
				// 타입을 정확히 명시해라
				RequestBodyDto<SendMessage> requestBodyDto = gson.fromJson(requestBody, typeToken.getType());
				SendMessage sendMessage = requestBodyDto.getBody();
				
				SimpleGUIServer.connectedSocketList.forEach(conectedSocket -> {
					RequestBodyDto<String> dto =
							new RequestBodyDto<String>("showMessage", sendMessage.getFromUsername()+": " + sendMessage.getMessageBody());
					ServerSender.getInstance().send(conectedSocket.socket, dto);
				});
				
				break;
		}
	}
	
	
}






//				반복 돌리는법 for문 3개, 셋 중 아무거나 써도 똑같음
//				SimpleGUIServer.connectedSocketList.forEach(connectedSocket->{
//				});			
//				for (ConnectedSocket connectedSocket : SimpleGUIServer.connectedSocketList) {
//				}
//				for (int i = 0; i < SimpleGUIServer.connectedSocketList.size(); i++) {
//				}










