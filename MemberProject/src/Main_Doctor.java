import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Main_Doctor implements ActionListener {
	JLabel L_YearMonth, daily;
	JButton[] btn_Arr;
	DefaultTableModel model, model2, model3;
	JTable table;
	JScrollPane Scroll, Scroll_d;
	String d_number, date_2, d_hospital, daily_date, u_name, u_date;
	int year, month;
	JFrame fmain_doctor;
	CheckboxGroup group1;
	Hospital_Sql HS = new Hospital_Sql();
	JComboBox<String> comboBox;
	JPanel p_left;

	public void main_hospital_doctor(Hospital_Sql_Vo data) {
		fmain_doctor = new JFrame(data.getI() + " [" + data.getJ() + "]");
		fmain_doctor.getContentPane().setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
		fmain_doctor.setResizable(false);
		fmain_doctor.setSize(1000, 700);
		fmain_doctor.setLayout(null);
		fmain_doctor.setVisible(true);
		fmain_doctor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JLabel m_doctor = new JLabel("" + data.getA() + "��, �ݰ����ϴ�.");
		m_doctor.setFont(new Font("�����ٸ����", Font.PLAIN, 12));
		m_doctor.setBounds(740, 30, 240, 25);
		JButton btn_logout = new JButton("[��������]");
		btn_logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JDialog exit = new JDialog(fmain_doctor, "���� �ȳ�", true);
				exit.setBounds(20, 40, 220, 150);
				exit.setLayout(null);
				JLabel msg_1 = new JLabel("���� �Ͻðڽ��ϱ�?");
				msg_1.setBounds(50, 20, 140, 25);
				msg_1.setFont(new Font("�����ٸ����", Font.PLAIN, 14));
				JButton yes = new JButton("��");
				yes.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						System.exit(0);
					}

				});
				yes.setBounds(20, 60, 60, 25);
				yes.setFont(new Font("�����ٸ����", Font.PLAIN, 14));
				yes.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
				JButton no = new JButton("�ƴϿ�");
				no.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						exit.dispose();
					}

				});
				no.setBounds(100, 60, 80, 25);
				no.setFont(new Font("�����ٸ����", Font.PLAIN, 14));
				no.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
				exit.add(msg_1);
				exit.add(yes);
				exit.add(no);
				exit.setVisible(true);

			}

		});

		btn_logout.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
		btn_logout.setBounds(880, 30, 100, 25);
		btn_logout.setBorderPainted(false);
		btn_logout.setFont(new Font("�����ٸ����", Font.BOLD, 12));
		JPanel p_right = new JPanel();
		JPanel left = new JPanel();
		left.setBounds(30, 80, 448, 360);
		left.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
		p_left = new JPanel();
		p_right.setLayout(null);
		JPanel right_north = new JPanel();
		right_north.setLayout(null);
		JPanel right_south = new JPanel();
		JPanel south = new JPanel();
		south.setLayout(null);
		south.setBounds(30, 490, 920, 150);
		JLabel J_sun = new JLabel("SUN");
		JLabel J_mon = new JLabel("MON");
		JLabel J_tue = new JLabel("TUE");
		JLabel J_wed = new JLabel("WED");
		JLabel J_thu = new JLabel("THU");
		JLabel J_fri = new JLabel("FRI");
		JLabel J_sat = new JLabel("SAT");
		JPanel sun = new JPanel();
		sun.setLayout(null);
		J_sun.setBounds(16, 10, 40, 25);
		J_sun.setForeground(Color.white);
		J_sun.setFont(new Font("�����ٸ����", Font.BOLD, 14));
		JPanel mon = new JPanel();
		mon.setLayout(null);
		J_mon.setBounds(12, 10, 40, 25);
		J_mon.setFont(new Font("�����ٸ����", Font.BOLD, 14));
		J_mon.setForeground(Color.white);
		JPanel tue = new JPanel();
		tue.setLayout(null);
		J_tue.setBounds(14, 10, 40, 25);
		J_tue.setFont(new Font("�����ٸ����", Font.BOLD, 14));
		J_tue.setForeground(Color.white);
		JPanel wed = new JPanel();
		wed.setLayout(null);
		J_wed.setBounds(14, 10, 40, 25);
		J_wed.setFont(new Font("�����ٸ����", Font.BOLD, 14));
		J_wed.setForeground(Color.white);
		JPanel thu = new JPanel();
		thu.setLayout(null);
		J_thu.setBounds(14, 10, 40, 25);
		J_thu.setFont(new Font("�����ٸ����", Font.BOLD, 14));
		J_thu.setForeground(Color.white);
		JPanel fri = new JPanel();
		fri.setLayout(null);
		J_fri.setBounds(18, 10, 40, 25);
		J_fri.setFont(new Font("�����ٸ����", Font.BOLD, 14));
		J_fri.setForeground(Color.white);
		JPanel sat = new JPanel();
		sat.setLayout(null);
		J_sat.setBounds(16, 10, 40, 25);
		J_sat.setFont(new Font("�����ٸ����", Font.BOLD, 14));
		J_sat.setForeground(Color.white);
		sun.setBackground(Color.red);
		sun.setBounds(10, 50, 60, 40);
		mon.setBackground(Color.gray);
		mon.setBounds(72, 50, 58, 40);
		tue.setBackground(Color.gray);
		tue.setBounds(132, 50, 58, 40);
		wed.setBackground(Color.gray);
		wed.setBounds(192, 50, 58, 40);
		thu.setBackground(Color.gray);
		thu.setBounds(252, 50, 58, 40);
		fri.setBackground(Color.gray);
		fri.setBounds(312, 50, 58, 40);
		sat.setBackground(Color.blue);
		sat.setBounds(372, 50, 58, 40);
		right_south.setLayout(null);
		p_right.setBackground(Color.white);
		p_right.setBounds(510, 80, 440, 360);
		p_left.setBounds(4, 40, 440, 320);
		right_north.setBounds(10, 10, 420, 34);
		right_north.setBackground(Color.white);
		right_south.setBounds(10, 100, 420, 250);
		JButton btn_prev = new JButton("��");
		JButton btn_next = new JButton("��");
		btn_prev.setBounds(100, 6, 50, 30);
		btn_next.setBounds(280, 6, 50, 30);
		btn_prev.setBackground(Color.white);
		btn_next.setBackground(Color.white);
		btn_prev.setBorderPainted(false);
		btn_next.setBorderPainted(false);
		btn_Arr = new JButton[42]; // ���ڳ־��ٹ�ư��
		fmain_doctor.add(m_doctor);
		fmain_doctor.add(btn_logout);
		fmain_doctor.add(p_right);
		fmain_doctor.add(left);
		fmain_doctor.add(south);
		south.setBackground(Color.white);
		left.add(p_left);
		left.setLayout(null);
		p_right.add(right_south);
		p_right.add(right_north);
		right_north.add(btn_prev);
		right_north.add(btn_next);
		p_right.add(sun);
		p_right.add(mon);
		p_right.add(tue);
		p_right.add(wed);
		p_right.add(thu);
		p_right.add(fri);
		p_right.add(sat);
		sun.add(J_sun);
		mon.add(J_mon);
		tue.add(J_tue);
		wed.add(J_wed);
		thu.add(J_thu);
		fri.add(J_fri);
		sat.add(J_sat);
		group1 = new CheckboxGroup();
		Checkbox m_result = new Checkbox("��ü", group1, true);
		Checkbox d_result = new Checkbox("���", group1, true);
		m_result.setFont(new Font("�����ٸ����", Font.PLAIN, 14));
		d_result.setFont(new Font("�����ٸ����", Font.PLAIN, 14));
		m_result.setBounds(340, 10, 50, 25);
		d_result.setBounds(400, 10, 50, 25);
		left.add(m_result);
		left.add(d_result);

		long systemTime = System.currentTimeMillis(); // ���� �ý��� �ð� ���ϱ�
		SimpleDateFormat d_time = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
		daily_date = d_time.format(systemTime);
		daily = new JLabel();
		if (daily.getText().isEmpty()) {
			daily.setText("[" + daily_date + "���� ������Ȳ" + "]");
		}
		daily.setBounds(4, 8, 300, 25);
		daily.setFont(new Font("�����ٸ����", Font.PLAIN, 20));
		left.add(daily);
		JLabel find_schedule = new JLabel("[���� ���� ����]");
		fmain_doctor.add(find_schedule);
		find_schedule.setFont(new Font("�����ٸ����", Font.PLAIN, 20));
		find_schedule.setBounds(30, 460, 500, 25);
		// ---------------------------------[�޷� ����]
		Calendar date = Calendar.getInstance();
		L_YearMonth = new JLabel();
		L_YearMonth.setVisible(true);
		L_YearMonth.setBounds(170, 0, 140, 40);

		btn_prev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				date.add(Calendar.MONDAY, -1);
				setDays(date);
			}

		});
		btn_next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				date.add(Calendar.MONTH, 1);
				setDays(date);
			}

		});
		right_north.add(L_YearMonth);
		right_south.setLayout(new GridLayout(6, 7));
		for (int i = 0; i < btn_Arr.length; i++) {
			btn_Arr[i] = new JButton("");
			right_south.add(btn_Arr[i]);
			btn_Arr[i].setFont(new Font("�����ٸ����", Font.PLAIN, 14));
		}
		setDays(date);

		// --------------------------------------------------------------------[J���̺� ������
		// ���� �ڵ�]
		String userColumn[] = { "��ȣ", "����", "����ð�", "�̸�", "�ֹι�ȣ", "����", "����ó" };
		String column[] = { "��ȣ", "����", "�������", "����ð�", "�̸�", "�ֹι�ȣ", "����", "����ó", "�����" };
		String doctorColumn[] = { "��ȣ", "����", "�湮����", "����μ�", "�����", "����", "��û����" };

		model = new DefaultTableModel(userColumn, 0) {
			public boolean isCellEditable(int i, int c) {
				if (c == 0 || c >= 2 && c <= 6) {
					return false;
				}
				return true;
			}

		};
		model2 = new DefaultTableModel(column, 0) {
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};
		model3 = new DefaultTableModel(doctorColumn, 0) {
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};
		table = new JTable(model);
		JTable table_d = new JTable(model3);
		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub4
				String date_d = null, date_f = null;
				if (e.getClickCount() == 2) {
					DefaultTableModel model_d = (DefaultTableModel) table_d.getModel();
					model_d.setNumRows(0);
					int row = table.getSelectedRow();
					if (group1.getSelectedCheckbox().toString().contains("��ü")) {
						System.out.println("����");
						date_d = daily.getText().replaceAll("[^0-9]", ""); // J���̺� ��µ� ������ ������ �Ǵ� ��¥ ����
						date_f = String.valueOf(table.getValueAt(row, 2)); // J���̺� �� ����ð� ����
					} else {
						System.out.println("����");
						date_d = daily.getText().replaceAll("[^0-9]", ""); // J���̺� ��µ� ������ ������ �Ǵ� ��¥ ����
						date_f = String.valueOf(table.getValueAt(row, 1)); // J���̺� �� ����ð� ����
					}
				}
				ArrayList<Hospital_Sql_Vo> schedule_check = HS.schedule_check(date_f, date_d, data.getH(), daily_date);
				int cnt = 1;
				for (int i = 0; i < schedule_check.size(); i++) {
					Hospital_Sql_Vo user_schedule_check = (Hospital_Sql_Vo) schedule_check.get(i);
					u_name = user_schedule_check.getA(); // �̸�
					u_date = user_schedule_check.getB(); // �������
					String s_date_2 = user_schedule_check.getC(); // ���೯¥
					String s_date_3 = user_schedule_check.getD(); // ����ð�
					String medical_f = user_schedule_check.getE(); // �������
					String d_name = user_schedule_check.getF(); // �����
					String disease = user_schedule_check.getG(); // ����
					String etc = user_schedule_check.getH(); // ����
					model3.addRow(
							new Object[] { cnt++, etc, s_date_2 + " " + s_date_3, medical_f, d_name, disease, "" });
					find_schedule.setText("[" + u_name + "(" + u_date + ")" + "���� ���� ���� ����" + "]");
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		daily_result(data.getG(), daily_date); // ����ð�

		Scroll = new JScrollPane(table);
		Scroll_d = new JScrollPane(table_d);
		p_left.add(Scroll);
		p_left.setLayout(null);
		south.add(Scroll_d);
		south.setLayout(null);
		Scroll.setBounds(0, 0, 440, 320);
		Scroll_d.setBounds(0, 0, 920, 150);
		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
		table_d.setAutoResizeMode(table.AUTO_RESIZE_OFF);
		table_d.getColumnModel().getColumn(0).setPreferredWidth(50); // J���̺� �� �Ӽ��鰣�� ���� ����
		table_d.getColumnModel().getColumn(1).setPreferredWidth(80);
		table_d.getColumnModel().getColumn(2).setPreferredWidth(120);
		table_d.getColumnModel().getColumn(3).setPreferredWidth(200);
		table_d.getColumnModel().getColumn(4).setPreferredWidth(60);
		table_d.getColumnModel().getColumn(5).setPreferredWidth(400);
		table_d.getColumnModel().getColumn(6).setPreferredWidth(100);
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		table_d.getColumn("��ȣ").setCellRenderer(dtcr);
		table_d.getColumn("����").setCellRenderer(dtcr);
		table_d.getColumn("�湮����").setCellRenderer(dtcr);
		table_d.getColumn("����μ�").setCellRenderer(dtcr);
		table_d.getColumn("�����").setCellRenderer(dtcr);
		table_d.getColumn("����").setCellRenderer(dtcr);
		table_d.getColumn("��û����").setCellRenderer(dtcr);
		DefaultTableModel model_d = (DefaultTableModel) table_d.getModel();
		model_d.setNumRows(0);

		for (int i = 0; i < btn_Arr.length; i++) {
			btn_Arr[i].addActionListener(this);
		}
		// -----------------------------------------------------------------------------------
		d_number = data.getG();
//		d_hospital = data.getH();
		m_result.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				String daily_r = daily.getText().replaceAll("[^0-9]", "");
				daily_result(d_number, daily_r); // ���� ��¥
			}

		});
		d_result.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				String daily_r = daily.getText().replaceAll("[^0-9]", "");
				daily_result(d_number, daily_r);
			}

		});

	}

	public void setDays(Calendar date) {
		Border lineBorder = BorderFactory.createLineBorder(Color.getHSBColor(0.0f, 0.0f, 0.9f), 1);
		year = date.get(Calendar.YEAR);
		month = date.get(Calendar.MONTH);
		L_YearMonth.setText(year + " / " + (month + 1));
		Font YearMonth = new Font("�����ٸ����", Font.PLAIN, 20); // �۾� ��Ʈ���� ���� ��ü
		L_YearMonth.setFont(YearMonth);
		Calendar sDay = Calendar.getInstance(); // ������

		sDay.set(year, month, 1);
		sDay.add(Calendar.DATE, -sDay.get(Calendar.DAY_OF_WEEK) + 1);
		int check = 1;
		for (int i = 0; i < btn_Arr.length; i++, sDay.add(Calendar.DATE, 1)) {
			btn_Arr[i].setEnabled(true);
			int day = sDay.get(Calendar.DATE);

			if (day == check) {
				btn_Arr[i].setLabel(day + "");
				btn_Arr[i].setBorder(lineBorder);

				check++;
			} else {
				btn_Arr[i].setLabel("");
				btn_Arr[i].setBorder(lineBorder);
				btn_Arr[i].setEnabled(false);
			}

			if (sDay.get(Calendar.MONTH) != month) {
				btn_Arr[i].setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
				// ���� ���� Ÿ�� float
			} else {
				btn_Arr[i].setBackground(Color.white);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String month_r = Integer.toString(month + 1);
		String day_r = e.getActionCommand().toString();
		if (month_r.length() != 2) {
			month_r = "0" + month_r;
		}
		if (day_r.length() != 2) {
			day_r = "0" + day_r;
		}
		date_2 = Integer.toString(year) + month_r + day_r;
		daily.setText("[" + date_2 + "���� ������Ȳ" + "]");
		daily_result(d_number, date_2);

	}

	public void daily_result(String doctor_n, String date_day) {
		int sel = 0;
		if (group1.getSelectedCheckbox().toString().contains("��ü")) {
			table.setModel(model2);
			table.getColumnModel().getColumn(0).setPreferredWidth(50); // J���̺� �� �Ӽ��鰣�� ���� ����
			table.getColumnModel().getColumn(2).setPreferredWidth(80);
			table.getColumnModel().getColumn(3).setPreferredWidth(200);
			table.getColumnModel().getColumn(4).setPreferredWidth(60);
			table.getColumnModel().getColumn(5).setPreferredWidth(70);
			table.getColumnModel().getColumn(6).setPreferredWidth(120);
			table.getColumnModel().getColumn(7).setPreferredWidth(300);
			table.getColumnModel().getColumn(8).setPreferredWidth(100);
			DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
			dtcr.setHorizontalAlignment(SwingConstants.CENTER);
			table.getColumn("��ȣ").setCellRenderer(dtcr);
			table.getColumn("����").setCellRenderer(dtcr);
			table.getColumn("�������").setCellRenderer(dtcr);
			table.getColumn("����ð�").setCellRenderer(dtcr);
			table.getColumn("�̸�").setCellRenderer(dtcr);
			table.getColumn("�ֹι�ȣ").setCellRenderer(dtcr);
			table.getColumn("����ó").setCellRenderer(dtcr);
			table.getColumn("�����").setCellRenderer(dtcr);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setNumRows(0);
			sel = 1;
		} else if (group1.getSelectedCheckbox().toString().contains("���")) {
			table.setModel(model);
			table.getColumnModel().getColumn(0).setPreferredWidth(50); // J���̺� �� �Ӽ��鰣�� ���� ����
			table.getColumnModel().getColumn(1).setPreferredWidth(60);
			table.getColumnModel().getColumn(2).setPreferredWidth(60);
			table.getColumnModel().getColumn(3).setPreferredWidth(80);
			table.getColumnModel().getColumn(4).setPreferredWidth(120);
			table.getColumnModel().getColumn(5).setPreferredWidth(300);
			table.getColumnModel().getColumn(6).setPreferredWidth(100);

			DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
			dtcr.setHorizontalAlignment(SwingConstants.CENTER);
			table.getColumn("��ȣ").setCellRenderer(dtcr);
			table.getColumn("����").setCellRenderer(dtcr);
			table.getColumn("����ð�").setCellRenderer(dtcr);
			table.getColumn("�̸�").setCellRenderer(dtcr);
			table.getColumn("�ֹι�ȣ").setCellRenderer(dtcr);
			table.getColumn("����ó").setCellRenderer(dtcr);
			DefaultTableModel model2 = (DefaultTableModel) table.getModel();
			model2.setNumRows(0);
			sel = 2;
		}
		ArrayList<Hospital_Sql_Vo> user_schedule = HS.user_schedule(doctor_n, date_day, sel);
		int cnt = 1, nnt = 1;
		for (int i = 0; i < user_schedule.size(); i++) {
			Hospital_Sql_Vo user_schedule_info = (Hospital_Sql_Vo) user_schedule.get(i);
			String date = user_schedule_info.getA(); // ����ð�
			String name = user_schedule_info.getB(); // �̸�
			String date_a = user_schedule_info.getC(); // �������
			String disease = user_schedule_info.getD(); // ����
			String contact = user_schedule_info.getE(); // ����ó
			String etc = user_schedule_info.getF();
			String d_name = user_schedule_info.getG(); // �����
			String medical = user_schedule_info.getH(); // �������
			System.out.println();
			model.addRow(new Object[] { cnt++, etc, date, name, date_a, disease, contact });
			model2.addRow(new Object[] { nnt++, etc, medical, date, name, date_a, disease, contact, d_name });
			// --------------------------JTabel�ȿ� �޺��ڽ� ����

			// �ϴ� �޺��ڽ����� �����
			comboBox = new JComboBox<String>();
			comboBox.addItem("������");
			comboBox.addItem("����Ϸ�");
			comboBox.addItem("�������");
			comboBox.setFont(new Font("�����ٸ����", Font.PLAIN, 12));
			// ���̺��� �ϳ��� column(��, ĭ) ������ ������
			TableColumn columnA = table.getColumnModel().getColumn(1);
			columnA.setCellEditor(new DefaultCellEditor(comboBox));
			comboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if (comboBox.getSelectedItem().toString().equals("����Ϸ�")) {
						JDialog msg = new JDialog(fmain_doctor, "Ȯ��", true);
						msg.setBounds(20, 40, 300, 150);
						msg.setLayout(null);
						JLabel msg_1 = new JLabel("["+comboBox.getSelectedItem().toString()+"]�� �����Ͻðڽ��ϱ�?");
						msg_1.setBounds(50, 20, 300, 25);
						msg_1.setFont(new Font("�����ٸ����", Font.PLAIN, 14));
						JButton yes = new JButton("��");
						yes.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								System.exit(0);
							}

						});
						yes.setBounds(60, 60, 60, 25);
						yes.setFont(new Font("�����ٸ����", Font.PLAIN, 14));
						yes.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
						JButton no = new JButton("�ƴϿ�");
						no.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								msg.dispose();
							}

						});
						no.setBounds(140, 60, 80, 25);
						no.setFont(new Font("�����ٸ����", Font.PLAIN, 14));
						no.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
						msg.add(msg_1);
						msg.add(yes);
						msg.add(no);
						msg.setVisible(true);
						
					} else if (comboBox.getSelectedItem().toString().contentEquals("�������")) {
						System.out.println("����");
					}
				}

			});
			// -------------------------------------------------

		}
		cnt = 0;
		nnt = 0;

	}

}
