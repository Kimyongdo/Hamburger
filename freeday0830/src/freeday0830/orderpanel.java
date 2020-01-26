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

	public static void totalPrice() { // ?? 아직 해석 못함.

		total = 0;
		for (int i = 0; i < table.getRowCount(); i++) {
			int n1 = Integer.parseInt(model.getValueAt(i, 3).toString());
			total += n1;
		}
		ttf.setText("총 금액 :  " + total + " 원");
	}

	public static void addRow(Object[] row) { // ?? 아직 해석 못함

		model.addRow(row);
		prices.add((int) row[3]);
		totalPrice();
	}

	public orderpanel() {
		// TODO Auto-generated constructor stub
		downpanleup = new JPanel(new GridLayout(2, 1));
		JPanel dpp = new JPanel();
		String[] menu = new String[] { "주문번호", "상품이름", "수량", "가격" };
		model = new DefaultTableModel(menu, 0);
		table = new JTable(model);

		/////////////////////// 셀 중앙정렬////////////////////////
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

		//////////////// 총금액////////////////////////
		JPanel dpp2 = new JPanel();
		ttf = new JTextField(12);
		ttf.setPreferredSize(new Dimension(20, 50));
		ttf.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		ttf.setHorizontalAlignment(JTextField.CENTER);
		ttf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		ttf.setOpaque(false);
		ttf.setEditable(false);
		ttf.setForeground(Color.BLACK);
		dpp2.add(ttf);
		downpanleup.add(dpp2);

		//////////////// 콤보박스 수량 늘리기/////////////////////////
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
		/////////////////// 콤보박스 테이블에 적용하기/////////////////
		TableColumn quantatiy = table.getColumnModel().getColumn(2);
		quantatiy.setCellEditor(new DefaultCellEditor(combobox));

		/////////////////// 주문하기 취소하기///////////////////////
		downpanledown = new JPanel(new GridLayout(1, 2));
		downpanledown.setBackground(Color.WHITE);
		downpanledownleft = new JPanel();
		ImageIcon cancel = new ImageIcon("images/cancle.png");
		cancel = new ImageIcon(cancel.getImage().getScaledInstance(150, 40, Image.SCALE_SMOOTH));
		JButton labelcancel = new JButton(cancel);
		labelcancel.setFocusPainted(false); // 클릭시 테두리 지우기
		labelcancel.setBorderPainted(false); // 외곽선 지우기
		labelcancel.setContentAreaFilled(false); // 투명하게
		labelcancel.setFocusPainted(false); // 클릭시 테두리 지우기
		labelcancel.setBorderPainted(false); // 외곽선 지우기
		downpanledownleft.add(labelcancel);

		////// 주문취소 누를 경우 0으로 돌아가기////
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
		labeldone.setFocusPainted(false); // 클릭시 테두리 지우기
		labeldone.setBorderPainted(false); // 외곽선 지우기
		labeldone.setBackground(Color.WHITE);
		labeldone.setFocusPainted(false); // 클릭시 테두리 지우기
		labeldone.setBorderPainted(false); // 외곽선 지우기
		labeldone.setContentAreaFilled(false); // 투명하게
		downpanledownright.add(labeldone);
		downpanledown.add(downpanledownleft);
		downpanledown.add(downpanledownright);

		
		//////////////주문완료 누르기/////////////
		///// 주문 했을 경우 종업원으로 이동하기 ////////
		labeldone.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int colNum=model.getColumnCount();//열 수
				int rowNum=model.getRowCount();//줄 수
				
				String[] row2 = new String[4];
					for(int k=0; k<colNum; k++) {

						row2[k]=""+model.getValueAt(rowNum-1, k);	//한줄씩 출력
							
					}
					
					client.model1.addRow(row2);				
				
			

			}
		});

	}


}

