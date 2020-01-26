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
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;




public class orderpanel extends JPanel {
	static DataInputStream dis;
	static DataOutputStream dos;
	JPanel downpanleup;
	JPanel downpanledown;
	JPanel downpanledownleft;
	JPanel downpanledownright;
	static DefaultTableModel model;
	static JTable table;
	static int total, row;
	static ArrayList<Integer> prices = new ArrayList<>();
	static JTextField ttf;
	static int orderNumber;

	public static void totalPrice() { // ?? ���� �ؼ� ����.

		total = 0;
		for (int i = 0; i < table.getRowCount(); i++) {
			int n1 = Integer.parseInt(model.getValueAt(i, 3).toString());
			total += n1;
		}
		ttf.setText("�� �ݾ� :  " + total + " ��");
	}

	public static void addRow(Object[] row) { // ?? ���� �ؼ� ����

		model.addRow(row);
		prices.add((int) row[3]);
		totalPrice();
	}

	public orderpanel() {
		// TODO Auto-generated constructor stub
		downpanleup = new JPanel(new GridLayout(2, 1));
		JPanel dpp = new JPanel();
		String[] menu = new String[] { "�ֹ���ȣ", "��ǰ�̸�", "����", "����" };
		model = new DefaultTableModel(menu, 0);
		table = new JTable(model);

		/////////////////////// �� �߾�����////////////////////////
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
		scroll.setPreferredSize(new Dimension(450, 80));
		dpp.add(scroll, BorderLayout.CENTER);
		downpanleup.add(dpp);

		//////////////// �ѱݾ�////////////////////////
		JPanel dpp2 = new JPanel();
		ttf = new JTextField(12);
		ttf.setPreferredSize(new Dimension(20, 50));
		ttf.setFont(new Font("���� ���", Font.BOLD, 20));
		ttf.setHorizontalAlignment(JTextField.CENTER);
		ttf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		ttf.setOpaque(false);
		ttf.setEditable(false);
		ttf.setForeground(Color.BLACK);
		dpp2.add(ttf);
		downpanleup.add(dpp2);

		//////////////// �޺��ڽ� ���� �ø���/////////////////////////
		JComboBox<Integer> combobox = new JComboBox<>();
		for (int i = 1; i < 11; i++) {
			combobox.addItem(i);
		}
		combobox.setSelectedIndex(0);
		combobox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				int row = table.getSelectedRow();
				if (row == -1)
					return;
				int n1 = Integer.parseInt(model.getValueAt(row, 2).toString());
				model.setValueAt(n1 * prices.get(row), row, 3);
				totalPrice();

			}
		});
		/////////////////// �޺��ڽ� ���̺� �����ϱ�/////////////////
		TableColumn quantatiy = table.getColumnModel().getColumn(2);
		quantatiy.setCellEditor(new DefaultCellEditor(combobox));

		/////////////////// �ֹ��ϱ� ����ϱ�///////////////////////
		downpanledown = new JPanel(new GridLayout(1, 2));
		downpanledown.setBackground(Color.WHITE);
		downpanledownleft = new JPanel();
		ImageIcon cancel = new ImageIcon("images/cancle.png");
		cancel = new ImageIcon(cancel.getImage().getScaledInstance(150, 40, Image.SCALE_SMOOTH));
		JButton labelcancel = new JButton(cancel);
		labelcancel.setFocusPainted(false); // Ŭ���� �׵θ� �����
		labelcancel.setBorderPainted(false); // �ܰ��� �����
		labelcancel.setContentAreaFilled(false); // �����ϰ�
		labelcancel.setFocusPainted(false); // Ŭ���� �׵θ� �����
		labelcancel.setBorderPainted(false); // �ܰ��� �����
		downpanledownleft.add(labelcancel);

		////// �ֹ���� ���� ��� 0���� ���ư���////
		labelcancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				model.setNumRows(0);
				totalPrice();
			}
		});

		downpanledownright = new JPanel();
		ImageIcon done = new ImageIcon("images/done.png");
		done = new ImageIcon(done.getImage().getScaledInstance(150, 40, Image.SCALE_SMOOTH));
		JButton labeldone = new JButton(done);
		labeldone.setFocusPainted(false); // Ŭ���� �׵θ� �����
		labeldone.setBorderPainted(false); // �ܰ��� �����
		labeldone.setBackground(Color.WHITE);
		labeldone.setFocusPainted(false); // Ŭ���� �׵θ� �����
		labeldone.setBorderPainted(false); // �ܰ��� �����
		labeldone.setContentAreaFilled(false); // �����ϰ�
		downpanledownright.add(labeldone);
		downpanledown.add(downpanledownleft);
		downpanledown.add(downpanledownright);

		
		//////////////�ֹ��Ϸ� ������/////////////
		///// �ֹ� ���� ��� ���������� �̵��ϱ� ////////
		labeldone.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int colNum=model.getColumnCount();//�� ��
				int rowNum=model.getRowCount();//�� ��
				
				String[] row2 = new String[4];
					for(int k=0; k<colNum; k++) {

						row2[k]=""+model.getValueAt(rowNum-1, k);	//���پ� ���
							
					}
					
					client.model1.addRow(row2);				
				
			

			}
		});

	}


}

