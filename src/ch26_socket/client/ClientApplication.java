package ch26_socket.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientApplication extends JFrame {

	private Socket socket;
	
	private JPanel mainPanel;
	private JTextField ipTextField;
	private JTextField portTextField;
	private JTextField messageTextFidld;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientApplication frame = new ClientApplication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientApplication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 551);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		
		
		/*<<< 채팅 내용 >>>*/
		JScrollPane chattextAreaScrollPane = new JScrollPane();
		chattextAreaScrollPane.setBounds(12, 10, 334, 441);
		mainPanel.add(chattextAreaScrollPane);
		
		JTextArea chatTextArea = new JTextArea();
		chatTextArea.setEditable(false);
		chattextAreaScrollPane.setViewportView(chatTextArea);
		
		/*<<< 채팅 연결 >>>*/
		ipTextField = new JTextField();
		ipTextField.setBounds(358, 13, 263, 32);
		mainPanel.add(ipTextField);
		ipTextField.setColumns(10);
		
		portTextField = new JTextField();
		portTextField.setBounds(358, 55, 263, 32);
		mainPanel.add(portTextField);
		portTextField.setColumns(10);
		
		JButton connectedButton = new JButton("접속");
		connectedButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String serverIp = ipTextField.getText();
				String serverPort = portTextField.getText();
				
				if(serverIp.isBlank() || serverPort.isBlank()) {
					JOptionPane.showMessageDialog(
							mainPanel,
							"IP와 PORT번호를 입력해주세요",
							"접속 오류",
							JOptionPane.ERROR_MESSAGE);
					return;
				
				}	
				try {
					socket = new Socket(serverIp, Integer.parseInt(serverPort));
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		connectedButton.setBounds(358, 97, 263, 32);
		mainPanel.add(connectedButton);
		
		/*<<< 접 속 자 >>>*/
		JScrollPane connectedUserScrollPane = new JScrollPane();
		connectedUserScrollPane.setBounds(358, 139, 263, 312);
		mainPanel.add(connectedUserScrollPane);
		
		JList connectedUserList = new JList();
		connectedUserScrollPane.setViewportView(connectedUserList);
		
		/*<<< 메세지입력 및 전송 >>>*/
		messageTextFidld = new JTextField();
		messageTextFidld.setBounds(12, 461, 495, 41);
		messageTextFidld.setEditable(false);
		mainPanel.add(messageTextFidld);
		messageTextFidld.setColumns(10);
		
		JButton messageSendButton = new JButton("전송");
		messageSendButton.setBounds(524, 461, 97, 41);
		messageSendButton.setEnabled(false);
		mainPanel.add(messageSendButton);
	}
}
