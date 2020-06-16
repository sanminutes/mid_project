import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Main_Doctor implements ActionListener {
	JLabel L_YearMonth, daily;
	JButton[] btn_Arr;
	Vector<String> userColumn = new Vector<String>();
	DefaultTableModel model;
	JTable table;
	JScrollPane Scroll;
	String d_number, date_2;
	int year, month;
	JFrame fmain_doctor;
	Hospital_Sql HS = new Hospital_Sql();

	public void main_hospital_doctor(Hospital_Sql_Vo data) {
		fmain_doctor = new JFrame(data.getD_hospital() + " [" + data.getD_medical() + "]");
		fmain_doctor.getContentPane().setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
		fmain_doctor.setResizable(false);
		fmain_doctor.setSize(1000, 700);
		fmain_doctor.setLayout(null);
		fmain_doctor.setVisible(true);
		fmain_doctor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JLabel m_doctor = new JLabel("" + data.getU_name() + "님, 반갑습니다.");
		m_doctor.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		m_doctor.setBounds(740, 30, 240, 25);
		JButton btn_logout = new JButton("[접속종료]");

		btn_logout.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
		btn_logout.setBounds(880, 30, 100, 25);
		btn_logout.setBorderPainted(false);
		btn_logout.setFont(new Font("나눔바른고딕", Font.BOLD, 12));
		JPanel p_right = new JPanel();
		JPanel left = new JPanel();
		left.setBounds(30, 80, 448, 360);
		left.setBackground(Color.white);
		JPanel p_left = new JPanel();
		p_right.setLayout(null);
		JPanel right_north = new JPanel();
		right_north.setLayout(null);
		JPanel right_south = new JPanel();
		JPanel south = new JPanel();
		south.setLayout(null);
		south.setBounds(30, 460, 600, 180);
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
		J_sun.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		JPanel mon = new JPanel();
		mon.setLayout(null);
		J_mon.setBounds(12, 10, 40, 25);
		J_mon.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		J_mon.setForeground(Color.white);
		JPanel tue = new JPanel();
		tue.setLayout(null);
		J_tue.setBounds(14, 10, 40, 25);
		J_tue.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		J_tue.setForeground(Color.white);
		JPanel wed = new JPanel();
		wed.setLayout(null);
		J_wed.setBounds(14, 10, 40, 25);
		J_wed.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		J_wed.setForeground(Color.white);
		JPanel thu = new JPanel();
		thu.setLayout(null);
		J_thu.setBounds(14, 10, 40, 25);
		J_thu.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		J_thu.setForeground(Color.white);
		JPanel fri = new JPanel();
		fri.setLayout(null);
		J_fri.setBounds(18, 10, 40, 25);
		J_fri.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		J_fri.setForeground(Color.white);
		JPanel sat = new JPanel();
		sat.setLayout(null);
		J_sat.setBounds(16, 10, 40, 25);
		J_sat.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
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
		JButton btn_prev = new JButton("◀");
		JButton btn_next = new JButton("▶");
		btn_prev.setBounds(100, 6, 50, 30);
		btn_next.setBounds(280, 6, 50, 30);
		btn_prev.setBackground(Color.white);
		btn_next.setBackground(Color.white);
		btn_prev.setBorderPainted(false);
		btn_next.setBorderPainted(false);
		btn_Arr = new JButton[42]; // 숫자넣어줄버튼들
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
		CheckboxGroup group1 = new CheckboxGroup();
		Checkbox h_result = new Checkbox("전체", group1, true);
		Checkbox m_result = new Checkbox("과목별", group1, true);
		Checkbox d_result = new Checkbox("담당별", group1, true);
		h_result.setBounds(310, 50, 40, 25);
		m_result.setBounds(360, 50, 60, 25);
		d_result.setBounds(420, 50, 60, 25);
		fmain_doctor.add(h_result);
		fmain_doctor.add(m_result);
		fmain_doctor.add(d_result);
		
//		h_result.addItemListener(new ItemListener() { // 전체
//
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//		});
//		m_result.addItemListener(new ItemListener() { // 과목별
//
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//		});
//		d_result.addItemListener(new ItemListener() { // 담당별
//
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//		});
//		
		long systemTime = System.currentTimeMillis(); // 현재 시스템 시간 구하기
		SimpleDateFormat d_time = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
		String daily_date = d_time.format(systemTime);
		System.out.println(daily_date);
		daily = new JLabel();
		if (daily.getText().isEmpty()) {
			daily.setText("■ " + daily_date + "일자 예약현황" + " ■");
		}
		daily.setBounds(4, 8, 300, 25);
		daily.setFont(new Font("나눔바른고딕", Font.PLAIN, 20));
		left.add(daily);
		// ---------------------------------[달력 설정]
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
		// ---------------------
		right_south.setLayout(new GridLayout(6, 7));
		for (int i = 0; i < btn_Arr.length; i++) {
			btn_Arr[i] = new JButton("");
			right_south.add(btn_Arr[i]);
			btn_Arr[i].setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		}
		// ---------------------
		setDays(date);

		userColumn.clear(); // 해당 클래스에서 검색을 연속해서 누를경우 컬럼이 중복으로 증가해서 시작전에 초기화함
		userColumn.addElement("번호");
		userColumn.addElement("예약시간");
		userColumn.addElement("이름");
		userColumn.addElement("생년월일");
		userColumn.addElement("주소");
		userColumn.addElement("연락처");

		model = new DefaultTableModel(userColumn, 0) {
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};
		daily_result(data.getD_number(), daily_date);

		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(50); // J테이블 내 속성들간의 간격 조절
		table.getColumnModel().getColumn(1).setPreferredWidth(60);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);
		table.getColumnModel().getColumn(4).setPreferredWidth(300);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumn("번호").setCellRenderer(dtcr);
		table.getColumn("예약시간").setCellRenderer(dtcr);
		table.getColumn("이름").setCellRenderer(dtcr);
		table.getColumn("생년월일").setCellRenderer(dtcr);
		table.getColumn("연락처").setCellRenderer(dtcr);
		Scroll = new JScrollPane(table);
		p_left.add(Scroll);
		p_left.setLayout(null);
		Scroll.setBounds(0, 0, 440, 320);
		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
	

		for (int i = 0; i < btn_Arr.length; i++) {
			btn_Arr[i].addActionListener(this);
		}
		d_number = data.getD_number();
	}

	public void setDays(Calendar date) {
		Border lineBorder = BorderFactory.createLineBorder(Color.getHSBColor(0.0f, 0.0f, 0.9f), 1);
		year = date.get(Calendar.YEAR);
		month = date.get(Calendar.MONTH);
		L_YearMonth.setText(year + " / " + (month + 1));
		Font YearMonth = new Font("나눔바른고딕", Font.PLAIN, 20); // 글씨 폰트변경 위한 객체
		L_YearMonth.setFont(YearMonth);
		Calendar sDay = Calendar.getInstance(); // 시작일

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
				// 색상 변경 타입 float
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
		daily.setText("■ " + date_2 + "일자 예약현황" + " ■");

		// ------------------------------- Jtable에 생성된 정보 초기화 하기 위한 코드
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setNumRows(0);
		// ---------------------------------------------------------------
		daily_result(d_number, date_2);
	}

	public void daily_result(String doctor_n, String date_day) {
		System.out.println(doctor_n);
		System.out.println(date_day);
		ArrayList<Hospital_Sql_Vo> user_schedule = HS.user_schedule(doctor_n, date_day);
		int cnt = 1;
		for (int i = 0; i < user_schedule.size(); i++) {
			Hospital_Sql_Vo user_schedule_info = (Hospital_Sql_Vo) user_schedule.get(i);
			String date = user_schedule_info.getU_number();
			String name = user_schedule_info.getU_name();
			int date_a = user_schedule_info.getU_date();
			String address = user_schedule_info.getU_address();
			String contact = user_schedule_info.getU_contact();
			model.addRow(new Object[] { cnt++, date, name, date_a, address, contact });
		}
		cnt = 0;
	}

}
