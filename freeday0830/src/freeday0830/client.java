package freeday0830;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;



public class client extends JFrame {
	// �������
	JTextArea ta;
	JTextField tfMsg;
	JButton btnSend;

	Socket socket;
	DataInputStream dis;
	static DataOutputStream dos;
	JTextField times;
	JTable table;
	static DefaultTableModel model1;

	public client() {
		JPanel two = new JPanel(new GridLayout(2, 1));
		JPanel one1 = new JPanel(new BorderLayout());
		JPanel one11 = new JPanel();
		JPanel one12 = new JPanel(new GridLayout(2, 1));
		JPanel one121 = new JPanel();
		JPanel one122 = new JPanel();
		JPanel one13 = new JPanel();
		////////////////// ���� �� �ð��г�///////////////////////
		times = new JTextField();
		times.setOpaque(false);
		times.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		times.setHorizontalAlignment(JTextField.LEFT);
		times.setForeground(Color.BLACK);
		times.setFont(new Font("����", Font.TRUETYPE_FONT, 12));
		one11.add(times);
		one1.add(one11, BorderLayout.NORTH);
		two.add(one1);
		add(two);
		////////////////////////////////////////////////////

		//////////////////// JTable/////////////////////////
		String[] menu = new String[] { "�ֹ���ȣ", "��ǰ�̸�", "����", "����" };
		model1 = new DefaultTableModel(menu, 0);
		table = new JTable(model1);
		DefaultTableCellRenderer centerCell = new DefaultTableCellRenderer();
		centerCell.setHorizontalAlignment(JLabel.CENTER);

		for (int i = 0; i < table.getColumnCount(); i++) {

			table.getColumnModel().getColumn(i).setCellRenderer(centerCell);

		}
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		JScrollPane scroll = new JScrollPane(table);
		scroll.getViewport().setBackground(Color.WHITE);
		scroll.setPreferredSize(new Dimension(450, 200));

		one121.add(scroll, BorderLayout.CENTER);
		one12.add(one121);
		one1.add(one12);
		two.add(one1);
		add(two);

		//////////////////// ä��â/////////////////////////
		ta = new JTextArea();
		ta.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(ta);
		scrollPane.setPreferredSize(new Dimension(450,100));
		
		one122.add(scrollPane, BorderLayout.CENTER);
		one12.add(one122);
		one1.add(one12);
		two.add(one1);
		add(two);

		tfMsg = new JTextField(35);
		btnSend = new JButton("����");
		JPanel one1222 = new JPanel();
		one1222.add(tfMsg,BorderLayout.CENTER);
		one1222.add(btnSend, BorderLayout.EAST);
		one122.add(one1222, BorderLayout.SOUTH);
		one12.add(one122);
		one1.add(one12);
		two.add(one1);
		add(two);
		
		/////////////////////////�����ϱ��ư /////////////////////////////
		ImageIcon iconcook1 = new ImageIcon("images/chaeso1.png");
		iconcook1 = new ImageIcon(iconcook1.getImage().getScaledInstance(450, 150, Image.SCALE_SMOOTH));
		// ���콺 �÷��� ��
		ImageIcon iconcook2 = new ImageIcon("images/googi1.png");
		iconcook2 = new ImageIcon(iconcook2.getImage().getScaledInstance(450, 150, Image.SCALE_SMOOTH));
		// ���콺 Ŭ������ ��
		ImageIcon iconcook3 = new ImageIcon("images/god1.png");
		iconcook3 = new ImageIcon(iconcook3.getImage().getScaledInstance(450, 150, Image.SCALE_SMOOTH));
		JButton cookbutton = new JButton(iconcook1);
		cookbutton.setRolloverIcon(iconcook2);
		cookbutton.setPressedIcon(iconcook3);
		cookbutton.setPreferredSize(new Dimension(450,150));
		cookbutton.setBorderPainted(false);
		cookbutton.setBackground(Color.WHITE);
		cookbutton.setFocusPainted(false);
		
		cookbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				progressbar pro = new progressbar();
				
				
			}
		});
		
		one13.add(cookbutton);
		one1.add(one13, BorderLayout.SOUTH);
		two.add(one1);
		add(two);
		
		
		//////////////////////////////////////////////////////////////////
		btnSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				sendMessage();
			}
		});

//		msgPanel.add(tfMsg, BorderLayout.CENTER);
//		msgPanel.add(btnSend, BorderLayout.EAST);
//		add(msgPanel, BorderLayout.SOUTH);

		tfMsg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);

				int keyCode = e.getKeyCode();

				switch (keyCode) {
				case KeyEvent.VK_ENTER:
					sendMessage();
					break;
				}
			}
		});

		ClientThread clientThread = new ClientThread();
		clientThread.setDaemon(true);
		clientThread.start();

		// ��������ܻ���
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("images/ab_icon.png").getScaledInstance(100, 100, Image.SCALE_SMOOTH); // ������¡
		setIconImage(img);
		setTitle("�Ƶ����� ������");
		setBounds(500, 0, 500, 1000);
		setVisible(true);
		
		
		

	}///////////////////// ������/////////////////////////////////
	
	
	///////////////�ֹ�---->���������� ���� ��//////////////////////////
	

	
	
	class MyPanel extends JPanel{ 
		//����̹��� ��ü�������� 
		Image img1; 

		public MyPanel() { 
		Toolkit toolkit= Toolkit.getDefaultToolkit(); 
		img1= toolkit.getImage("images/1111.gif"); 
		} 
		@Override 
		protected void paintComponent(Graphics g) { 
		g.drawImage(img1, 0, 0, this); 
		} } 
		

	class ClientThread extends Thread {
		@Override
		public void run() {
			try {
				socket = new Socket("127.0.0.1", 10001);
				ta.append("�߰� �䱸������ �����߽��ϴ�.\n");

				// ����� ���� Stream�����
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());

				while (true) {
					// ����(Server) ������ �о����
					String msg = dis.readUTF();
					ta.append("[��] : " + msg + "\n");
					ta.setCaretPosition(ta.getText().length());
				}
			} catch (UnknownHostException e) {
				ta.append("Ű����ũ �ּҰ� �̻��մϴ�.");
				ta.setCaretPosition(ta.getText().length());
			} catch (IOException e) {
				ta.append("Ű����ũ�� ������ ���������ϴ�.");
				ta.setCaretPosition(ta.getText().length());
			}
		}
	}

	void sendMessage() {
		String msg = tfMsg.getText();
		tfMsg.setText("");

		ta.append("[������] : " + msg + "\n");
		ta.setCaretPosition(ta.getText().length());

		Thread t = new Thread() {
			@Override
			public void run() {
				try {
					dos.writeUTF(msg);
					dos.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		t.start();
	}




}