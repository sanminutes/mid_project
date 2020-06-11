import java.awt.BorderLayout;
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
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class Main_User implements ActionListener {
	JButton[] btn_Arr;
	Font btn_nomal;
	JLabel L_YearMonth;
	String result_h, result_i;
	JTextField hospital, date_2;
	JComboBox<String> doctor;
	JComboBox<String> medical;
	int year, month;
	JTable table;
	JScrollPane Scroll;
	JPanel P;
	Hospital_Sql oct = new Hospital_Sql();
	Vector<String> userColumn = new Vector<String>();
	DefaultTableModel model;
	String result_name, result_address;
	SimpleDateFormat d_time;
	long systemTime;

	public void main_hospital_user(Hospital_Sql_Vo data) { // 로그인 성공시
		JFrame fmain_user = new JFrame("병원 진료 예약 시스템");
		btn_nomal = new Font("나눔바른고딕", Font.PLAIN, 12);
		fmain_user.setResizable(false);
		fmain_user.setSize(1050, 700);
		fmain_user.getContentPane().setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
		fmain_user.setLayout(null);
		fmain_user.setVisible(true);
		fmain_user.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JLabel m_user = new JLabel("" + data.getU_name() + "님, 반갑습니다.");
		m_user.setFont(btn_nomal);
		JPanel p_left = new JPanel();
		JPanel p_right = new JPanel();
		JPanel Center_p = new JPanel();
		JPanel title_sun = new JPanel();
		JPanel title_mon = new JPanel();
		JPanel title_tue = new JPanel();
		JPanel title_wed = new JPanel();
		JPanel title_thu = new JPanel();
		JPanel title_fri = new JPanel();
		JPanel title_sat = new JPanel();
		JLabel y_title = new JLabel("[ 예 약 정 보 입 력 ]");
		JLabel y_name = new JLabel("이름 :");
		JLabel y_date = new JLabel("생년월일 :");
		JLabel y_address = new JLabel("주소 :");
		JLabel y_contact = new JLabel("연락처 :");
		JLabel y_hospital = new JLabel("병원명 :");
		JLabel y_medical = new JLabel("진료 과목 :");
		JLabel y_date_2 = new JLabel("예약 시간 :");
		JLabel y_doctor = new JLabel("담당 의사 :");
		JLabel y_date3 = new JLabel("예약 날짜 :");

		JButton btn_logout = new JButton("[접속종료]");
		JLabel Date_format = new JLabel();
		JLabel message_one = new JLabel(" ■ 희망하는 진료 예약일자를 선택해주세요");
		// -------------------------[실시간 시간 구하기]
		systemTime = System.currentTimeMillis(); // 현재 시스템 시간 구하기
		d_time = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		Date_format.setText(d_time.format(systemTime));
		Date_format.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		JPanel North = new JPanel();
		JPanel South = new JPanel();
		North.setLayout(null);
		South.setLayout(null);
		title_sun.setLayout(null);
		title_mon.setLayout(null);
		title_tue.setLayout(null);
		title_wed.setLayout(null);
		title_thu.setLayout(null);
		title_fri.setLayout(null);
		title_sat.setLayout(null);
		title_mon.setVisible(true);
		title_tue.setVisible(true);
		title_wed.setVisible(true);
		title_thu.setVisible(true);
		title_fri.setVisible(true);
		title_sat.setVisible(true);
		p_left.setVisible(true);
		p_right.setVisible(true);
		p_right.setLayout(null);
		p_left.setLayout(null);
		Center_p = new JPanel();
		fmain_user.add(m_user);
		fmain_user.add(p_left);
		fmain_user.add(p_right);
		fmain_user.add(btn_logout);
		fmain_user.add(Date_format);
		JButton btn_prev = new JButton("◀");
		JButton btn_next = new JButton("▶");
		JLabel sun = new JLabel("SUN");
		JLabel mon = new JLabel("MON");
		JLabel tue = new JLabel("TUE");
		JLabel wed = new JLabel("WED");
		JLabel thu = new JLabel("THU");
		JLabel fri = new JLabel("FRI");
		JLabel sat = new JLabel("SAT");
		JTextField name = new JTextField();
		name.setEditable(false);
		JTextField date_1 = new JTextField();
		date_1.setEditable(false);
		JTextField address = new JTextField();
		address.setEditable(false);
		JTextField contact = new JTextField();
		contact.setEditable(false);
		hospital = new JTextField();
		hospital.setEditable(false);
		medical = new JComboBox<String>();
		medical.addItem("먼저 병원을 선택하세요");
		medical.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		medical.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				doctor.removeAllItems();
				Hospital_Sql HS = new Hospital_Sql();
				ArrayList<Hospital_Sql_Vo> doctor_list = HS.doctor_list(result_name, result_address,
						e.getItem().toString());
				for (int i = 0; i < doctor_list.size(); i++) {
					Hospital_Sql_Vo doctor_info = (Hospital_Sql_Vo) doctor_list.get(i);
					String doctor_name = doctor_info.getU_id();
					doctor.addItem(doctor_name);
				}
				if (doctor_list.size() == 0) {
					doctor.addItem("예약 가능한 의사가 없습니다");
				}
			}

		});
		doctor = new JComboBox<String>();
		doctor.addItem("선택할 수 없습니다");
		doctor.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		doctor.setEditable(false);

		date_2 = new JTextField();
		JTextField date_3 = new JTextField();
		JButton btn_hospital = new JButton("[찾기]");
		date_2.setEditable(false);
		p_left.add(btn_prev);
		p_left.add(btn_next);
		p_left.add(North);
		North.add(message_one);
		fmain_user.add(South);
		p_left.add(title_sun);
		p_left.add(title_mon);
		p_left.add(title_tue);
		p_left.add(title_wed);
		p_left.add(title_thu);
		p_left.add(title_fri);
		p_left.add(title_sat);
		title_sun.add(sun);
		title_mon.add(mon);
		title_tue.add(tue);
		title_wed.add(wed);
		title_thu.add(thu);
		title_fri.add(fri);
		title_sat.add(sat);
		p_right.add(y_title);
		p_right.add(y_name);
		p_right.add(y_date);
		p_right.add(y_address);
		p_right.add(y_contact);
		p_right.add(y_hospital);
		p_right.add(y_medical);
		p_right.add(y_date_2);
		p_right.add(name); // 텍스트필드
		p_right.add(date_1);
		p_right.add(address);
		p_right.add(contact);
		p_right.add(hospital);
		p_right.add(medical);
		p_right.add(date_3);
		p_right.add(btn_hospital);
		p_right.add(y_date3);
		p_right.add(y_doctor);
		p_right.add(doctor);
		p_right.add(date_2);
		sun.setForeground(Color.white);
		mon.setForeground(Color.white);
		tue.setForeground(Color.white);
		wed.setForeground(Color.white);
		thu.setForeground(Color.white);
		fri.setForeground(Color.white);
		sat.setForeground(Color.white);
		message_one.setBounds(10, 8, 300, 25);
		message_one.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		p_left.add(Center_p);
		name.setBounds(130, 100, 210, 25);
		date_1.setBounds(130, 140, 210, 25);
		address.setBounds(130, 180, 210, 25);
		contact.setBounds(130, 220, 210, 25);
		hospital.setBounds(130, 260, 160, 25);
		medical.setBounds(130, 300, 210, 25);
		doctor.setBounds(130, 340, 210, 25);
		date_2.setBounds(130, 380, 210, 25);
		date_3.setBounds(130, 420, 210, 25);

		btn_hospital.setBounds(290, 260, 70, 25);
		btn_hospital.setFont(btn_nomal);
		btn_hospital.setBorderPainted(false);
		btn_hospital.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f));
		y_title.setBounds(124, 40, 200, 25); // 예약정보
		y_title.setFont(new Font("나눔바른고딕", Font.BOLD, 20));
		y_name.setBounds(40, 100, 200, 25);
		y_name.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		y_date.setBounds(40, 140, 200, 25);
		y_date.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		y_address.setBounds(40, 180, 200, 25);
		y_address.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		y_contact.setBounds(40, 220, 200, 25);
		y_contact.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		y_hospital.setBounds(40, 260, 200, 25);
		y_hospital.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		y_medical.setBounds(40, 300, 200, 25);
		y_medical.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		y_doctor.setBounds(40, 340, 200, 25);
		y_doctor.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		y_date3.setBounds(40, 380, 200, 25);
		y_date3.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		y_date_2.setBounds(40, 420, 200, 25);
		y_date_2.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		btn_prev.setBounds(100, 70, 60, 30);
		btn_next.setBounds(380, 70, 60, 30);
		North.setBounds(4, 0, 570, 40);
		South.setBounds(40, 590, 530, 4);
		btn_logout.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
		btn_prev.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
		btn_next.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
		North.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f));
		South.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f));
		title_sun.setBounds(4, 131, 72, 50);
		title_mon.setBounds(78, 131, 73, 50);
		title_tue.setBounds(153, 131, 73, 50);
		title_wed.setBounds(228, 131, 73, 50);
		title_thu.setBounds(303, 131, 73, 50);
		title_fri.setBounds(378, 131, 73, 50);
		title_sat.setBounds(453, 131, 73, 50);
		sun.setBounds(23, 14, 30, 25);
		mon.setBounds(23, 14, 30, 25);
		tue.setBounds(23, 14, 30, 25);
		wed.setBounds(23, 14, 30, 25);
		thu.setBounds(23, 14, 30, 25);
		fri.setBounds(23, 14, 30, 25);
		sat.setBounds(23, 14, 30, 25);

		title_sun.setBackground(Color.red);
		title_mon.setBackground(Color.gray);
		title_tue.setBackground(Color.gray);
		title_wed.setBackground(Color.gray);
		title_thu.setBackground(Color.gray);
		title_fri.setBackground(Color.gray);
		title_sat.setBackground(Color.blue);
		btn_logout.setBounds(910, 30, 100, 25);
		Date_format.setBounds(44, 30, 220, 25);
		Date_format.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
		btn_Arr = new JButton[42]; // 숫자넣어줄버튼들
		p_left.setBounds(40, 100, 530, 490);
		p_right.setBounds(600, 100, 390, 500);
		Center_p.setBounds(0, 180, 530, 310);
		Center_p.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
		p_left.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
		p_right.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f));
		m_user.setBounds(740, 30, 240, 25);
		m_user.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		btn_prev.setBorderPainted(false);
		btn_next.setBorderPainted(false);
		btn_logout.setBorderPainted(false);
		btn_logout.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		name.setText(" " + data.getU_name());
		date_1.setText(" " + data.getU_date());
		if (data.getU_address() == null) {
			address.setText(" ");
		} else {
			address.setText(" " + data.getU_address());
		}

		contact.setText(" " + data.getU_contact());
		btn_hospital.addActionListener(new ActionListener() { // 병원 검색
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				find_hospital(2);
			}

		});
		// ---------------------[달력셋팅]

		Calendar date = Calendar.getInstance();
		L_YearMonth = new JLabel();
		L_YearMonth.setVisible(true);
		L_YearMonth.setBounds(220, 66, 140, 40);

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

		p_left.add(L_YearMonth);
		// ---------------------
		Center_p.setLayout(new GridLayout(6, 7));
		for (int i = 0; i < btn_Arr.length; i++) {
			btn_Arr[i] = new JButton("");
			btn_Arr[i].addActionListener(this);
			Center_p.add(btn_Arr[i]);
		}
		// ---------------------
		setDays(date);
	}

	public void find_hospital(int select_n) {
		JFrame find_hsp = new JFrame("병원명 검색");
		find_hsp.setSize(700, 300);
		find_hsp.setResizable(false);
		find_hsp.setLayout(null);
		find_hsp.setVisible(true);
		JTextField find_hospital = new JTextField();
		JLabel hos_name = new JLabel("병원명 :");
		hos_name.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		JButton h_btn = new JButton("검색");
		h_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ------------------------------- Jtable에 생성된 정보 초기화 하기 위한 코드
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setNumRows(0);
				// ---------------------------------------------------------------

				ArrayList<Hospital_Sql_Vo> hoslist = oct.hoslist(find_hospital.getText());
				for (int i = 0; i < hoslist.size(); i++) {
					Hospital_Sql_Vo hos_data = (Hospital_Sql_Vo) hoslist.get(i);
					String name = hos_data.getU_name();
					String address = hos_data.getU_address();
					String contact = hos_data.getU_contact();
					model.addRow(new Object[] { name, address, contact });
				}
			}

		});
		userColumn.clear(); // 해당 클래스에서 검색을 연속해서 누를경우 컬럼이 중복으로 증가해서 시작전에 초기화함
		userColumn.addElement("병원명");
		userColumn.addElement("주소");
		userColumn.addElement("전화번호");

		model = new DefaultTableModel(userColumn, 0) {
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};
		table = new JTable(model);
		table.setLayout(null);
		table.getColumnModel().getColumn(0).setPreferredWidth(150); // J테이블 내 속성들간의 간격 조절
		table.getColumnModel().getColumn(1).setPreferredWidth(450);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				result_name = (String) table.getValueAt(row, 0);
				result_address = (String) table.getValueAt(row, 1);
				Hospital_Sql HS = new Hospital_Sql();
				ArrayList<Hospital_Sql_Vo> medical_list = HS.medical_list(result_name, result_address);
				String[] strArr = new String[medical_list.size()];

				if (select_n == 1) {
					Hospital_sign.T_medical.removeAllItems();
				} else if (select_n == 2) {
					medical.removeAllItems();
				}
				for (int i = 0; i < medical_list.size(); i++) {
					Hospital_Sql_Vo medical_info = (Hospital_Sql_Vo) medical_list.get(i);
					String h_medical = medical_info.getU_id();
					strArr[i] = h_medical;
					if (select_n == 1) { // 회원가입시
						find_hsp.dispose();
						Hospital_sign.T_hospital.setText(result_name);
						Hospital_sign.T_medical.addItem(strArr[i]);
					} else if (select_n == 2) { // 예약시
						find_hsp.dispose();
						hospital.setText(result_name);
						medical.addItem(strArr[i]);

					}
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

		P = new JPanel();
		P.setLayout(new BorderLayout());
		Scroll = new JScrollPane(table);
		P.add(Scroll, BorderLayout.CENTER);
		P.setBounds(4, 0, 680, 200);
		find_hospital.setBounds(245, 220, 200, 25);
		hos_name.setBounds(200, 220, 60, 25);
		h_btn.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		h_btn.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f));
		h_btn.setBounds(450, 220, 60, 25);

		find_hsp.add(P);
		find_hsp.add(find_hospital);
		find_hsp.add(hos_name);
		find_hsp.add(h_btn);
		find_hsp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	public void setDays(Calendar date) {
		Border lineBorder = BorderFactory.createLineBorder(Color.getHSBColor(0.0f, 0.0f, 0.9f), 1);
		year = date.get(Calendar.YEAR);
		month = date.get(Calendar.MONTH);
		L_YearMonth.setText(year + " / " + (month + 1));
		Font YearMonth = new Font("나눔바른고딕", Font.BOLD, 24); // 글씨 폰트변경 위한 객체
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
				btn_Arr[i].setEnabled(false);
				btn_Arr[i].setBorder(lineBorder);
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

		// ----------------------[오늘의 날짜 구하기]
		String B = d_time.format(systemTime);
		int restr = Integer.parseInt(B.replaceAll("[^0-9]", ""));
		// ----------------------[월 자릿수 2자리로 만들기]
		String month_f = (Integer.toString(month + 1));
		if (month_f.length() < 2) {
			month_f = "0" + month_f;
		}
		//-----------------------[일 자릿수 2자리로 만들기]
		String day_f = e.getActionCommand().toString();
		if (day_f.length() < 2) {
			day_f = "0" + day_f;
		}
		//-----------------------[달력을 눌렀을 때 표시되는 날짜]
		String A = year +"년 "+ month_f+"월 " + day_f+"일";
		int flec = Integer.parseInt(A.replaceAll("[^0-9]", ""));
		//----------------------------------------------
		
		if(restr>flec) {
			System.out.println("오늘 날짜보다 이전으로는 예약이 불가합니다.");
		}else if(restr==flec) {
			System.out.println("당일 예약은 불가합니다. 최소 하루전 예약 부탁드립니다.");
		}else {
			date_2.setText(A);
		}
		

	}
}
