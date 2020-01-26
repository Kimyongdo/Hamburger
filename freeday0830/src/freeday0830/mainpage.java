package freeday0830;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.soap.AddressingFeature;

public class mainpage extends JPanel {
	JPanel secondpanel0;
	JPanel secondpanel1;
	JPanel secondpanel2;
	static DefaultTableModel model;
	static JTable table;
	JLabel labelname;
	JButton clientbutton;
	JTextField tf;
	JTextArea ta;
	Font font;
	CardLayout c1 = new CardLayout();

	public mainpage() {

		// 총 패널 - 그리드 3칸으로 균할등분
		JPanel totalpanel = new JPanel(new GridLayout(3, 1));
		this.setBackground(Color.WHITE);

		// 위 패널
		//////////////////// 클릭시 이미지 바뀜////////////////////
		JPanel uppanel = new JPanel(new BorderLayout());
		// 이미지 기본
		ImageIcon iconsgg = new ImageIcon("images/sgg.png");
		iconsgg = new ImageIcon(iconsgg.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH));
		// 마우스 올렸을 때
		ImageIcon iconsgg1 = new ImageIcon("images/1111.png");
		iconsgg1 = new ImageIcon(iconsgg1.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH));
		// 마우스 클릭했을 때
		ImageIcon iconsgg2 = new ImageIcon("images/2222.png");
		iconsgg2 = new ImageIcon(iconsgg2.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH));
		JButton button1 = new JButton(iconsgg);
		//////////////////////////////////////////////////////

		button1.setRolloverIcon(iconsgg1);
		button1.setPressedIcon(iconsgg2);
		button1.setOpaque(true);
		button1.setBackground(Color.WHITE);
		button1.setFocusPainted(false); // 클릭시 테두리 지우기
		button1.setBorderPainted(false); // 외곽선 지우기
		button1.setContentAreaFilled(false); // 투명하게
		button1.setFocusPainted(false);
		uppanel.add(button1, BorderLayout.CENTER);

		///////////////클라이언트 여는 문////////////////////////
		
		JPanel uppanel2 = new JPanel(new GridLayout(1, 2));
		ImageIcon iconserver = new ImageIcon("images/server.png");
		iconserver = new ImageIcon(iconserver.getImage().getScaledInstance(270, 100, Image.SCALE_SMOOTH));
		clientbutton = new JButton(iconserver);
		clientbutton.setBorderPainted(false);
		clientbutton.setBackground(Color.WHITE);
		clientbutton.setFocusPainted(false);
		clientbutton.setPreferredSize(new Dimension(250, 100));
		clientbutton.setOpaque(true);
		clientbutton.setBackground(Color.WHITE);
		uppanel2.add(clientbutton);
		
		clientbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new client();
				
			}
		});
		//////////////////////////////////////////////////
		
		////////////////서버 여는 문///////////////////////////
		server sv = new server();
		uppanel2.add(sv.msgPanel);
		uppanel.add(uppanel2, BorderLayout.SOUTH);
		totalpanel.add(uppanel);
		add(totalpanel);
		///////////////////////////////////////////////////

		////////////////// 중간패널 /////////////////////////

		///////////// 왼쪽 총 메뉴 선택 공간///////////////////////
		JPanel middlepanle = new JPanel();
		middlepanle.setBackground(Color.WHITE);
	
		JPanel middlepanleWest = new JPanel(new GridLayout(3, 1));
		
		ImageIcon hamburger = new ImageIcon("images/list1.png");
		hamburger = new ImageIcon(hamburger.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		JButton middlepanleWest1 = new JButton(hamburger);
		middlepanleWest1.setBorderPainted(false);
		middlepanleWest1.setBackground(Color.WHITE);
		middlepanleWest1.setFocusPainted(false);
		middlepanleWest.add(middlepanleWest1);
		ImageIcon drink = new ImageIcon("images/list2.png");
		drink = new ImageIcon(drink.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		JButton middlepanleWest2 = new JButton(drink);
		middlepanleWest2.setBorderPainted(false);
		middlepanleWest2.setBackground(Color.WHITE);
		middlepanleWest2.setFocusPainted(false);
		middlepanleWest.add(middlepanleWest2);
		ImageIcon icecream = new ImageIcon("images/list3.png");
		icecream = new ImageIcon(icecream.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		JButton middlepanleWest3 = new JButton(icecream);
		middlepanleWest3.setBorderPainted(false);
		middlepanleWest3.setBackground(Color.WHITE);
		middlepanleWest3.setFocusPainted(false);
		middlepanleWest.add(middlepanleWest3);
		middlepanle.add(middlepanleWest, BorderLayout.WEST);

		/////////////// 4가지 종류의 음식이 나온다//////////////////
		JPanel middlepanleCenter = new JPanel(c1);
		// 햄버거
		hamburget ham = new hamburget();
		// 음료수
		drinkpanel dp = new drinkpanel();
		// 디저트
		iceream ic = new iceream();

		///////////// 왼쪽 리스트를 누르면 카드레이아웃으로 변환하여 보여준다//////////////
		middlepanleWest1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				c1.show(middlepanleCenter, "1");
			}
		});

		middlepanleWest2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				c1.show(middlepanleCenter, "2");
			}
		});

		middlepanleWest3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				c1.show(middlepanleCenter, "3");
			}
		});

		middlepanleCenter.add(ham.middlepanleCenter1, "1");
		middlepanleCenter.add(dp.middlepanleCenter2, "2");
		middlepanleCenter.add(ic.middlepanleCenter3, "3");
		c1.show(middlepanleCenter, "1");

		middlepanle.add(middlepanleCenter, BorderLayout.CENTER);

		middlepanle.setBackground(Color.WHITE);
		totalpanel.add(middlepanle);
		add(totalpanel);

		////////////////// 아래패널 /////////////////////////
		
		JPanel downpanle = new JPanel(new GridLayout(2, 1));
		
		/////////////////// JTable/////////////////////////////
		orderpanel op = new orderpanel();
		downpanle.add(op.downpanleup, BorderLayout.CENTER);
		downpanle.add(op.downpanledown, BorderLayout.SOUTH);
		
	
		totalpanel.add(downpanle);
		add(totalpanel);

//		

	}// 생성자

}// 클래스생성자


