package ch25_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUIMain2 extends JFrame {

	private JPanel mainCardPane;
	private CardLayout mainCardLayout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMain2 frame = new GUIMain2();
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
	public GUIMain2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		/* <<<  mainCardPane >>> */
		mainCardPane = new JPanel();
		mainCardLayout = new CardLayout(0,0); 
				
		mainCardPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 
		mainCardPane.setLayout(mainCardLayout);
		
		setContentPane(mainCardPane);
		
		
		
		/* <<< subPanel1 >>> */
		JPanel subPanel1 = new JPanel();
		mainCardPane.add(subPanel1, "subPanel1");
		subPanel1.setLayout(null);
		
		JButton SubPanel2ShowBtn = new JButton("2번째페이지");
		SubPanel2ShowBtn.setBounds(300, 125, 125, 25);
		subPanel1.add(SubPanel2ShowBtn);
		
		SubPanel2ShowBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCardLayout.show(mainCardPane, "subPanel2"); 
				// 메인카드팬에 들어가있는 것들 중에 섭패널2에 적용
			}
		});
		
		/* <<< subPanel2 >>> */
		JPanel subPanel2 = new JPanel();
		mainCardPane.add(subPanel2, "subPanel2");
		subPanel2.setLayout(null);
		
		JButton SubPanel3ShowBtn = new JButton("3번째 페이지");
		SubPanel3ShowBtn.setBounds(300, 125, 125, 25);
		subPanel2.add(SubPanel3ShowBtn);
		
		SubPanel3ShowBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCardLayout.show(mainCardPane, "subPanel3");
			}
		});
		
		
		JButton SubPanel1ShowBtn = new JButton("1번째 페이지");
		SubPanel1ShowBtn.setBounds(0, 125, 125, 25);
		subPanel2.add(SubPanel1ShowBtn);
		
		SubPanel1ShowBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCardLayout.show(mainCardPane, "subPanel1");
			}
		});
		
		/*<<< subPanel3 >>>*/
		JPanel subPanel3 = new JPanel();
		mainCardPane.add(subPanel3, "subPanel3");
		subPanel3.setLayout(null);
		
		JButton SubPanel2ShowBtn2 = new JButton("2번째 페이지");
		SubPanel2ShowBtn2.setBounds(0, 125, 125, 25);
		subPanel3.add(SubPanel2ShowBtn2);
	
		SubPanel2ShowBtn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCardLayout.show(mainCardPane, "subPanel2");
			}
		});
	}

}
