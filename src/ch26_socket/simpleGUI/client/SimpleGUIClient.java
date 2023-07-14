package ch26_socket.simpleGUI.client;

import java.awt.CardLayout;
import java.awt.EventQueue;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ch26_socket.simpleGUI.client.dto.RequestBodyDto;
import ch26_socket.simpleGUI.client.dto.SendMessage;
import lombok.Getter;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
 

@Getter
public class SimpleGUIClient extends JFrame {
	
	private static SimpleGUIClient instance;
	public static SimpleGUIClient getInstance() {
		if(instance == null) {
			instance = new SimpleGUIClient();
		}
		return instance;
	}
	

	private String username;
	private Socket socket;
	
	private CardLayout mainCardLayout;
	private JPanel mainCardPanel;
	
	private JPanel chattingRoomPanel;
	private JScrollPane roomListScrollPanel;
	private DefaultListModel<String> roomListModel;
	private JList roomList;
	
	private JTextField chattingText;
	private JTextArea chattingTextArea;
	private JList messageUserList;
	private JPanel chattingRoomListPanel;

	private JScrollPane messageTextField;
	private DefaultListModel<String> userListModel;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					SimpleGUIClient frame = new SimpleGUIClient();// 이렇게 이제 못함 (왜??) 
					SimpleGUIClient frame = SimpleGUIClient.getInstance();
					frame.setVisible(true);
					
					ClientReceiver clientReceiver = new ClientReceiver();
					clientReceiver.start();
					
					RequestBodyDto<String> requestBodyDto = new RequestBodyDto<String>("connection", frame.username);
					ClientSender.getInstance().send(requestBodyDto);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// public 에서 private로 바꿈
	public SimpleGUIClient() {
			
		username = JOptionPane.showInputDialog(chattingRoomPanel,"아이디를 입력하세요.");
		
		if (Objects.isNull(username)) {
			System.exit(0);
		}
		if (username.isBlank()) {
			System.exit(0);
		}
		try { //접속 지점
			socket = new Socket("127.0.0.1", 8000);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		mainCardLayout = new CardLayout();
		mainCardPanel = new JPanel();
		mainCardPanel.setLayout(mainCardLayout);
		setContentPane(mainCardPanel);
		
		chattingRoomListPanel = new JPanel();
		chattingRoomListPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		chattingRoomListPanel.setLayout(null);
		mainCardPanel.add(chattingRoomListPanel, "chattingRoomListPanel");
		
		
		JButton createRoomButton = new JButton("방만들기");
		createRoomButton.setBounds(10,10,100,30);
		createRoomButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String roomName = JOptionPane.showInputDialog(chattingRoomListPanel, "방 제목을 입력하세요.");
				if(Objects.isNull(roomName)) {
					return;
				}
				if(roomName.isBlank()) {
					JOptionPane.showConfirmDialog(chattingRoomListPanel, "방 제목을 입력하세요.", "방 만들기 실패", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				for (int i = 0; i < roomListModel.size(); i++) {
					if(roomListModel.get(i).equals(roomName)) {
						JOptionPane.showConfirmDialog(chattingRoomListPanel, "이미 존재하는 방제목입니다.", "방 만들기 실패", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				
				RequestBodyDto<String> requestBodyDto = new RequestBodyDto<String>("createRoom", roomName);
				ClientSender.getInstance().send(requestBodyDto);
				mainCardLayout.show(mainCardPanel,"chattingRoomPanel");
				requestBodyDto = new RequestBodyDto<String>("join", roomName);
				ClientSender.getInstance().send(requestBodyDto);
			}
		});
		chattingRoomListPanel.add(createRoomButton);

		
		roomListScrollPanel = new JScrollPane();
		roomListScrollPanel.setBounds(10, 50, 410, 200);
		chattingRoomListPanel.add(roomListScrollPanel);
		
		roomListModel = new DefaultListModel<String>();
		roomList = new JList(roomListModel);
		roomList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					String roomName = roomListModel.get(roomList.getSelectedIndex());
					mainCardLayout.show(mainCardPanel,"chattingRoomPanel");
					RequestBodyDto<String> requestBodyDto = new RequestBodyDto<String>("join", roomName);
					ClientSender.getInstance().send(requestBodyDto);
				}
			}
		});
		roomListScrollPanel.setViewportView(roomList);

		
		chattingRoomPanel = new JPanel();
		chattingRoomPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		chattingRoomPanel.setLayout(null);
		mainCardPanel.add(chattingRoomPanel,"chattingRoomPanel");
		
		JScrollPane chattingScrollPane = new JScrollPane();
		chattingScrollPane.setBounds(12, 10, 300, 200);
		chattingRoomPanel.add(chattingScrollPane);
		
		chattingTextArea = new JTextArea();
		chattingScrollPane.setViewportView(chattingTextArea);
		
		chattingText = new JTextField();
		chattingText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					SendMessage sendMessage = SendMessage.builder()
							.fromUsername(username)
							.messageBody(chattingText.getText())
							.build();
																					//	메세지내용 , 데이터
					RequestBodyDto<SendMessage> requestBodyDto = new RequestBodyDto<>("sendMessage", sendMessage);
					
					ClientSender.getInstance().send(requestBodyDto);
					chattingText.setText(""); 
					
					//필요없어짐 지워도됨 대신 위에 코드 두줄 생성
//					try {
//						PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
//						printWriter.println(username + ": " + textField.getText());
//					} catch (IOException e1) {
//						e1.printStackTrace();
//					}finally {
//						textField.setText("");
//					}
				}
			}
		});
		chattingText.setBounds(12, 216, 410, 35);
		chattingRoomPanel.add(chattingText);
		chattingText.setColumns(10);
		
		messageTextField = new JScrollPane();
		messageTextField.setBounds(324, 10, 98, 200);
		chattingRoomPanel.add(messageTextField);
		
		userListModel = new DefaultListModel<>();
		messageUserList = new JList(userListModel);
		messageTextField.setViewportView(messageUserList);
				
		
	}
}

//프로젝트

// 방 나가는거 만들기 
// 디자인 자유 
// 접속했을때 누군지 뜨게 만들기
// 방 입장시 방제목 뜨게하기
// 방 나가기 버튼  >> 내가 이 방의 리스트에서 제거되면 됨
// 방장이면 이름 옆에 (방장) 표시 붙이기
// 방장이 방을 나가면  1.방장을 다음사람에게 방장주기 or 2. 모든사람이 다 로비로 나가게되기

//
// 리스트 인원 중에 더블클릭하면 그 사람 이름 뜨게하기, 안눌렀을땐 전체 표시 뜨게하기  JLable 사용? 
// 그 사람 눌렀을때는 그 사람한테만 가게하기
// 메세지 한번 보내고나면 다시 전체로 바뀌게. 기본 조건은 전체로 뜨게하기



