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
		
		ImageIcon icon = new ImageIcon("images/mainpicture.png"); // �� ������ �ٸ� ��������
		icon=new ImageIcon(icon.getImage().getScaledInstance(500,965,Image.SCALE_SMOOTH));// ������¡
		JButton fisrtbutton = new JButton(icon);
		fisrtbutton.setFocusPainted(false); //Ŭ���� �׵θ� �����
		fisrtbutton.setBorderPainted(false); //�ܰ��� �����
		fisrtbutton.setContentAreaFilled(false); //�����ϰ�
		add(fisrtbutton);
		
		fisrtbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			fisrtbutton.setVisible(false); //��ư�� ������ϴ±���. 
			add(new mainpage());
			}
		});

		
		
		// Frameâ �����
		pack();
		setTitle("�Ƶ����� Ű����ũ"); // ����
		setBounds(0, 0, 500, 1000); // ũ�� ��ġ
		setDefaultCloseOperation(EXIT_ON_CLOSE); // ���� ��������
		// setResizable(false); //������ ũ�� ����Ұ�
		// setAlwaysOnTop(true); //�׻� �� ��
		setVisible(true); // ���̵���

		// ��������ܻ���
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("images/ab_icon.png").getScaledInstance(100, 100, Image.SCALE_SMOOTH); // ������¡
		setIconImage(img);
		
		
	}

	public static void main(String[] args) {
		new main22();
	}

}
