package freeday0830;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class server extends JPanel {
	JTextArea ta;
	JTextField tfMsg;
	JButton btnSend;

	ServerSocket serverSocket;
	Socket socket;
	static DataInputStream dis;
	static DataOutputStream dos;
	JPanel msgPanel;

	public server() {
		ta = new JTextArea();
		ta.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(ta);
		
		
		msgPanel = new JPanel();
		msgPanel.setLayout(new BorderLayout());
		JPanel east = new JPanel();

		tfMsg = new JTextField(15);
		tfMsg.setPreferredSize(new Dimension(500,25));
		tfMsg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tfMsg.setText("");
			}
		});
		btnSend = new JButton("전송");
		btnSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				sendMessage();
			}
		});
		msgPanel.add(scrollPane, BorderLayout.CENTER);
		east.add(tfMsg, BorderLayout.CENTER);
		east.add(btnSend, BorderLayout.EAST);
		msgPanel.add(east, BorderLayout.SOUTH);

		// msgPanel.add(btnSend, BorderLayout.EAST);

		add(msgPanel, BorderLayout.SOUTH);

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

		ServerThread serverThread = new ServerThread();
		serverThread.setDaemon(true);
		serverThread.start();

	}// 생성자


	
	
	class ServerThread extends Thread {
		@Override
		public void run() {
			try {
				serverSocket = new ServerSocket(10001);
				ta.append("호출하기를 눌러주세요.\n");
				socket = serverSocket.accept();

				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());

				while (true) {
					String msg = dis.readUTF();
					ta.append("[종업원] : " + msg + "\n");
					ta.setCaretPosition(ta.getText().length());
				}

			} catch (IOException e) {
				ta.append("고객님이 나갔습니다.");
				ta.setCaretPosition(ta.getText().length());
			}
		}
	}
	
	

	void sendMessage() {

		String msg = tfMsg.getText();
		tfMsg.setText("");

		ta.append("[고객] : " + msg + "\n");
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
