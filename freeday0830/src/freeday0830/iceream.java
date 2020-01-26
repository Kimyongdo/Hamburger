package freeday0830;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class iceream extends JPanel {
	JPanel middlepanleCenter3;

	public iceream() {
		// TODO Auto-generated constructor stub
		middlepanleCenter3 = new JPanel();
		middlepanleCenter3.setLayout(new GridLayout(2, 2, 0, 0));
		JButton[] menuButton3 = new JButton[4];
		for (int i = 0; i < menuButton3.length; i++) {
			ImageIcon iconicream = new ImageIcon("images/icream" + (i + 1) + ".png");
			iconicream = new ImageIcon(iconicream.getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH));
			menuButton3[i] = new JButton(iconicream);
			menuButton3[i].setBorderPainted(false);
			menuButton3[i].setBackground(Color.WHITE);
			menuButton3[i].setFocusPainted(false);
			middlepanleCenter3.add(menuButton3[i]);
		}

		menuButton3[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String foodname = "맥플러리";
				main22.number++;
				int Q = 1;
				int price = 3100;
				Object[] row = { main22.number, foodname, Q, price };

				orderpanel.addRow(row);

			}
		});

		menuButton3[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String foodname = "콘파이";
				main22.number++;
				int Q = 1;
				int price = 1600;
				Object[] row = { main22.number, foodname, Q, price };

				orderpanel.addRow(row);

			}
		});

		menuButton3[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String foodname = "프라이";
				main22.number++;
				int Q = 1;
				int price = 1200;
				Object[] row = { main22.number, foodname, Q, price };

				orderpanel.addRow(row);

			}
		});

		menuButton3[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String foodname = "오징어";
				main22.number++;
				int Q = 1;
				int price = 1200;
				Object[] row = { main22.number, foodname, Q, price };

				orderpanel.addRow(row);

			}
		});
	}
}
