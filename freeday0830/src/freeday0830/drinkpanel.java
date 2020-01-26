package freeday0830;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class drinkpanel extends JPanel{
	JPanel middlepanleCenter2;
	public drinkpanel() {
		middlepanleCenter2 = new JPanel();
		middlepanleCenter2.setLayout(new GridLayout(2, 2, 0, 0));
		JButton[] menuButton2 = new JButton[4];
		for (int i = 0; i < menuButton2.length; i++) {
			ImageIcon icondrink = new ImageIcon("images/drink" + (i + 1) + ".png");
			icondrink = new ImageIcon(icondrink.getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH));
			menuButton2[i] = new JButton(icondrink);
			menuButton2[i].setBorderPainted(false);
			menuButton2[i].setBackground(Color.WHITE);
			menuButton2[i].setFocusPainted(false);
			
			middlepanleCenter2.add(menuButton2[i]);
		}
		
		menuButton2[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String foodname = "콜라";
				main22.number++;
				int Q = 1;
				int price = 1800;
				Object[] row = { main22.number, foodname, Q, price };

				orderpanel.addRow(row);

			}
		});
		
		menuButton2[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String foodname = "사이다";
				main22.number++;
				int Q = 1;
				int price = 1800;
				Object[] row = { main22.number, foodname, Q, price };

				orderpanel.addRow(row);

			}
		});
		
		menuButton2[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String foodname = "환타";
				main22.number++;
				int Q = 1;
				int price = 1800;
				Object[] row = { main22.number, foodname, Q, price };

				orderpanel.addRow(row);

			}
		});
		
		menuButton2[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String foodname = "커피";
				main22.number++;
				int Q = 1;
				int price = 1500;
				Object[] row = { main22.number, foodname, Q, price };

				orderpanel.addRow(row);

			}
		});
	}
}
