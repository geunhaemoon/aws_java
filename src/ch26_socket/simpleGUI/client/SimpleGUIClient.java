package ch26_socket.simpleGUI.client;

import java.awt.EventQueue;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

import javax.swing.DefaultListModel;
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
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;

	private JScrollPane userListScrollPane;
	private DefaultListModel<String> userListModel;
	private JList userList;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleGUIClient frame = SimpleGUIClient.getInstance();
//					SimpleGUIClient frame = new SimpleGUIClient();// 이렇게 이제 못함 (왜??) 
					frame.setVisible(true);
					
					ClientReceiver clientReceiver = new ClientReceiver();
					clientReceiver.start();
					
					RequestBodyDto<String> requestBodyDto = new RequestBodyDto<String>("join", frame.username);
					ClientSender.getInstance().send(requestBodyDto);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// public 에서 private로 바꿈
	public SimpleGUIClient() {
			
		username = JOptionPane.showInputDialog(contentPane,"아이디를 입력하세요.");
		
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 300, 200);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					SendMessage sendMessage = SendMessage.builder()
							.fromUsername(username)
							.messageBody(textField.getText())
							.build();
																					//	메세지내용 , 데이터
					RequestBodyDto<SendMessage> requestBodyDto = new RequestBodyDto<>("sendMessage", sendMessage);
					
					ClientSender.getInstance().send(requestBodyDto);
					textField.setText(""); 
					
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
		textField.setBounds(12, 216, 410, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		userListScrollPane = new JScrollPane();
		userListScrollPane.setBounds(324, 10, 98, 200);
		contentPane.add(userListScrollPane);
		
		userListModel = new DefaultListModel<>();
		userList = new JList(userListModel);
		userListScrollPane.setViewportView(userList);
		
		
	}
}
