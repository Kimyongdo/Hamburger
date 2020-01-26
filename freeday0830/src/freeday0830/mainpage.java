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

		// �� �г� - �׸��� 3ĭ���� ���ҵ��
		JPanel totalpanel = new JPanel(new GridLayout(3, 1));
		this.setBackground(Color.WHITE);

		// �� �г�
		//////////////////// Ŭ���� �̹��� �ٲ�////////////////////
		JPanel uppanel = new JPanel(new BorderLayout());
		// �̹��� �⺻
		ImageIcon iconsgg = new ImageIcon("images/sgg.png");
		iconsgg = new ImageIcon(iconsgg.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH));
		// ���콺 �÷��� ��
		ImageIcon iconsgg1 = new ImageIcon("images/1111.png");
		iconsgg1 = new ImageIcon(iconsgg1.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH));
		// ���콺 Ŭ������ ��
		ImageIcon iconsgg2 = new ImageIcon("images/2222.png");
		iconsgg2 = new ImageIcon(iconsgg2.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH));
		JButton button1 = new JButton(iconsgg);
		//////////////////////////////////////////////////////

		button1.setRolloverIcon(iconsgg1);
		button1.setPressedIcon(iconsgg2);
		button1.setOpaque(true);
		button1.setBackground(Color.WHITE);
		button1.setFocusPainted(false); // Ŭ���� �׵θ� �����
		button1.setBorderPainted(false); // �ܰ��� �����
		button1.setContentAreaFilled(false); // �����ϰ�
		button1.setFocusPainted(false);
		uppanel.add(button1, BorderLayout.CENTER);

		///////////////Ŭ���̾�Ʈ ���� ��////////////////////////
		
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
		
		////////////////���� ���� ��///////////////////////////
		server sv = new server();
		uppanel2.add(sv.msgPanel);
		uppanel.add(uppanel2, BorderLayout.SOUTH);
		totalpanel.add(uppanel);
		add(totalpanel);
		///////////////////////////////////////////////////

		////////////////// �߰��г� /////////////////////////

		///////////// ���� �� �޴� ���� ����///////////////////////
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

		/////////////// 4���� ������ ������ ���´�//////////////////
		JPanel middlepanleCenter = new JPanel(c1);
		// �ܹ���
		hamburget ham = new hamburget();
		// �����
		drinkpanel dp = new drinkpanel();
		// ����Ʈ
		iceream ic = new iceream();

		///////////// ���� ����Ʈ�� ������ ī�巹�̾ƿ����� ��ȯ�Ͽ� �����ش�//////////////
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

		////////////////// �Ʒ��г� /////////////////////////
		
		JPanel downpanle = new JPanel(new GridLayout(2, 1));
		
		/////////////////// JTable/////////////////////////////
		orderpanel op = new orderpanel();
		downpanle.add(op.downpanleup, BorderLayout.CENTER);
		downpanle.add(op.downpanledown, BorderLayout.SOUTH);
		
	
		totalpanel.add(downpanle);
		add(totalpanel);

//		

	}// ������

}// Ŭ����������


