package freeday0830;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class hamburget extends JPanel {
	JPanel middlepanleCenter1;

	public hamburget() {
		// TODO Auto-generated constructor stub
		middlepanleCenter1 = new JPanel();
		middlepanleCenter1.setLayout(new GridLayout(2, 2, 0, 0));
		JButton[] menuButton = new JButton[4];
		for (int i = 0; i < menuButton.length; i++) {
			ImageIcon iconhamberuger = new ImageIcon("images/00" + (i + 1) + ".png");
			iconhamberuger = new ImageIcon(iconhamberuger.getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH));
			menuButton[i] = new JButton(iconhamberuger);
			menuButton[i].setBorderPainted(false);
			menuButton[i].setBackground(Color.WHITE);
			menuButton[i].setFocusPainted(false);
			middlepanleCenter1.add(menuButton[i]);

		}
		/// 눌렀을 경우 이 값이 jtable로 이동하도록
		menuButton[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String foodname = "맥스스파이시 버거";
				main22.number++;
				int Q = 1;
				int price = 5100;
				Object[] row = { main22.number, foodname, Q, price };

				orderpanel.addRow(row);

			}
		});

		menuButton[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String foodname = "더블1955 버거";
				main22.number++;
				int Q = 1;
				int price = 6100;
				Object[] row = { main22.number, foodname, Q, price };

				orderpanel.addRow(row);

			}
		});
		
		menuButton[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String foodname = "그륄드머쉬룸 버거";
				main22.number++;
				int Q = 1;
				int price = 7600;
				Object[] row = { main22.number, foodname, Q, price };

				orderpanel.addRow(row);

			}
		});
		
		
		menuButton[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String foodname = "골든에그치즈 버거";
				main22.number++;
				int Q = 1;
				int price = 7800;
				Object[] row = { main22.number, foodname, Q, price };

				orderpanel.addRow(row);

			}
		});
	}
}
