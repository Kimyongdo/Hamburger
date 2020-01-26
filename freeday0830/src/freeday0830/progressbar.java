package freeday0830;

import java.awt.BorderLayout;

import java.awt.Color;

import java.awt.Container;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;



import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JProgressBar;





public class progressbar extends JFrame {



	public progressbar() {

		setTitle("맛있게 조리하는 중");

		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



		Container contentPane = getContentPane();

		contentPane.setLayout(new BorderLayout());

		

		JProgressBar bar = new JProgressBar(0, 100);

		bar.setValue(0);

		bar.setStringPainted(true);

		bar.setForeground(Color.ORANGE);

		//bar.setBorderPainted(true);

		//bar.setIndeterminate(true);

		

		JButton btn = new JButton("조 리 하 기");

		btn.addActionListener(new ActionListener() {

			

			@Override

			public void actionPerformed(ActionEvent e) {



				new Thread(new Runnable() {

					

					@Override

					public void run() {

						synchronized (bar) {

							for (int i=0; i<=100; i++) {

								bar.setValue(i);

								try {

									Thread.sleep(20);

								} catch (Exception e1) {

									e1.printStackTrace();

								}

							}

						}

					} // run()

					

				}).start();

				

			}

		});

		

		contentPane.add(bar, BorderLayout.CENTER);

		contentPane.add(btn, BorderLayout.SOUTH);

		

		

		

		

		setLocationByPlatform(true);

		//setSize(400, 100);
		setBounds(550, 600, 400, 120);
		

		setVisible(true);

	}

	

	public static void main(String[] args) {

		new progressbar();

	}



}
