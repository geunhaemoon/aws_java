package ch26_socket.simpleGUI.client.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SendMessage {
	private String fromUsername; //보낸이
	private String toUsername; // 받는이
	private String messageBody; //내용
}
 