package ch25_GUI;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUIMain1 extends JFrame {
	
	private final String ADMIN_USERNAME = "admin";
	private final String ADMIN_PASSWORD = "1234";
	

	private CardLayout mainCardLayout;
	
	private JPanel mainCardPanel;
	private JPanel loginPanel;
	private JPanel homePanel;
	private JTextField usernameTextField;
	private JTextField PasswordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
			GUIMain1 frame = new GUIMain1();
			frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public GUIMain1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		mainCardPanel = new JPanel();
		mainCardLayout = new CardLayout();
		mainCardPanel.setLayout(mainCardLayout);
		setContentPane(mainCardPanel);
		
		loginPanel = new JPanel();
		loginPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		loginPanel.setLayout(null);
		mainCardPanel.add(loginPanel);
	
	
		usernameTextField = new JTextField();
		usernameTextField.setBounds(121, 49, 185, 35);
		loginPanel.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		PasswordTextField = new JPasswordField();
		PasswordTextField.setBounds(121, 94, 185, 35);
		loginPanel.add(PasswordTextField);
		PasswordTextField.setColumns(10);
				
		
		JButton signinBtn = new JButton("Login");
		signinBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { 
				String username = usernameTextField.getText();
				String password = PasswordTextField.getText();
				if(!username.equals(ADMIN_USERNAME) || !password.equals(ADMIN_PASSWORD)) {
					JOptionPane.showMessageDialog(loginPanel, "사용자 정보가 일치하지 않습니다.", "로그인실패", JOptionPane.ERROR_MESSAGE);
													// 위치    내용   제목    아이콘종류
					return;
				}
				JOptionPane.showMessageDialog(loginPanel, "환영합니다", "로그인성공", JOptionPane.PLAIN_MESSAGE);
				mainCardLayout.show(mainCardPanel, "homePanel");
				
				}
		});
		signinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		signinBtn.setBounds(121, 179, 185, 35);
		loginPanel.add(signinBtn);
		

		
		/*<<< nextpage >>>*/
		homePanel = new JPanel();
		homePanel.setLayout(null);
		mainCardPanel.add(homePanel,"homePanel");
	}
}
