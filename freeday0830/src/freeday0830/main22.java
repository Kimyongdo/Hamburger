package freeday0830;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.xml.ws.soap.AddressingFeature;

public class main22 extends JFrame {
	static int number =0;
	public main22() {
		
		ImageIcon icon = new ImageIcon("images/mainpicture.png"); // 각 아이콘 다른 참조변수
		icon=new ImageIcon(icon.getImage().getScaledInstance(500,965,Image.SCALE_SMOOTH));// 리사이징
		JButton fisrtbutton = new JButton(icon);
		fisrtbutton.setFocusPainted(false); //클릭시 테두리 지우기
		fisrtbutton.setBorderPainted(false); //외곽선 지우기
		fisrtbutton.setContentAreaFilled(false); //투명하게
		add(fisrtbutton);
		
		fisrtbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			fisrtbutton.setVisible(false); //버튼도 해줘야하는구만. 
			add(new mainpage());
			}
		});

		
		
		// Frame창 만들기
		pack();
		setTitle("맥도날드 키오스크"); // 제목
		setBounds(0, 0, 500, 1000); // 크기 위치
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 종료 완전종료
		// setResizable(false); //사이즈 크기 변경불가
		// setAlwaysOnTop(true); //항상 맨 앞
		setVisible(true); // 보이도록

		// 제목아이콘생성
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("images/ab_icon.png").getScaledInstance(100, 100, Image.SCALE_SMOOTH); // 리사이징
		setIconImage(img);
		
		
	}

	public static void main(String[] args) {
		new main22();
	}

}
