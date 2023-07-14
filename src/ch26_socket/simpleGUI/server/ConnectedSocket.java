package ch26_socket.simpleGUI.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ch26_socket.simpleGUI.client.dto.RequestBodyDto;
import ch26_socket.simpleGUI.client.dto.SendMessage;
import ch26_socket.simpleGUI.server.entity.Room;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConnectedSocket extends Thread {

	private final Socket socket;
	private String username;
	private Gson gson;

	@Override
	public void run() {
		gson = new Gson();

		while (true) {
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

		String resource = gson.fromJson(requestBody, RequestBodyDto.class).getResource();

		switch (resource) {
		case "connection":
			connection(requestBody);
			break;

		case "createRoom":
			createRoom(requestBody);
			break;

		case "join":
			join(requestBody);
			break;

		case "sendMessage":
			sendMessage(requestBody);
			break;
		}

	}

	private void connection(String requestBody) {

		username = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();

		List<String> roomNameList = new ArrayList<>();
		SimpleGUIServer.roomList.forEach(room -> {
			roomNameList.add(room.getRoomName());
		});

		RequestBodyDto<List<String>> upDateRoomlistRequestBodyDto = new RequestBodyDto<List<String>>("updateRoomList",
				roomNameList);

		SimpleGUIServer.connectedSocketList.forEach(con -> {
			ServerSender.getInstance().send(con.socket, upDateRoomlistRequestBodyDto);
		});

	}

	private void createRoom(String requestBody) {
		String roomName = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();

		Room newRoom = Room.builder().roomName(roomName).owner(username).userList(new ArrayList<ConnectedSocket>())
				.build();

		SimpleGUIServer.roomList.add(newRoom);

		List<String> roomNameList = new ArrayList<>();
		SimpleGUIServer.roomList.forEach(room -> {
			roomNameList.add(room.getRoomName());
		});

		RequestBodyDto<List<String>> upDateRoomlistRequestBodyDto = new RequestBodyDto<List<String>>("updateRoomList",
				roomNameList);

		SimpleGUIServer.connectedSocketList.forEach(con -> {
			ServerSender.getInstance().send(con.socket, upDateRoomlistRequestBodyDto);
		});
	}

	private void join(String requestBody) {
		String roomName = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();

		SimpleGUIServer.roomList.forEach(room -> {
			if (room.getRoomName().equals(roomName)) {
				room.getUserList().add(this); // 자신을 리스트에 추가 this

				List<String> usernameList = new ArrayList<>();

//					room.getUserList().forEach(con -> {
//						usernameList.add(con.username);
//					});

				room.getUserList().forEach(connectedSocket -> {
					RequestBodyDto<List<String>> updateUserListDto = new RequestBodyDto<List<String>>("updateUserList",
							usernameList);
					RequestBodyDto<String> joinMessageDto = new RequestBodyDto<String>("showMessage",
							username + "님이 들어왔습니다.");

					ServerSender.getInstance().send(connectedSocket.socket, updateUserListDto);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ServerSender.getInstance().send(connectedSocket.socket, joinMessageDto);
				});
			}
		});

	}

	private void sendMessage(String requestBody) {
		TypeToken<RequestBodyDto<SendMessage>> typeToken = new TypeToken<RequestBodyDto<SendMessage>>() {
		};

		// 타입을 정확히 명시해라
		RequestBodyDto<SendMessage> requestBodyDto = gson.fromJson(requestBody, typeToken.getType());
		SendMessage sendMessage = requestBodyDto.getBody();

		SimpleGUIServer.roomList.forEach(room -> {
			if (room.getUserList().contains(this)) {
				room.getUserList().forEach(connectedSocket -> {
					RequestBodyDto<String> dto = new RequestBodyDto<String>("showMessage",
							sendMessage.getFromUsername() + ": " + sendMessage.getMessageBody());
					ServerSender.getInstance().send(connectedSocket.socket, dto);
				});

			}
			;
		});

//			SimpleGUIServer.connectedSocketList.forEach(connectedSocket -> {
//				RequestBodyDto<String> dto =
//						new RequestBodyDto<String>("showMessage", sendMessage.getFromUsername()+": " + sendMessage.getMessageBody());
//				ServerSender.getInstance().send(connectedSocket.socket, dto);
//			});
	}

}

//				반복 돌리는법 for문 3개, 셋 중 아무거나 써도 똑같음
//				SimpleGUIServer.connectedSocketList.forEach(connectedSocket->{
//				});			
//				for (ConnectedSocket connectedSocket : SimpleGUIServer.connectedSocketList) {
//				}
//				for (int i = 0; i < SimpleGUIServer.connectedSocketList.size(); i++) {
//				}
