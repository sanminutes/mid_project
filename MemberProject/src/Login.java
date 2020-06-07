import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class Login extends WindowAdapter {
	JButton[] btn_Arr;
	Font btn_nomal;
	JLabel L_YearMonth;

	public void main_hospital(MemberVo data) { // 로그인 성공시
		JFrame fmain_user = new JFrame("병원 진료 예약 시스템");
		btn_nomal = new Font("나눔바른고딕", Font.PLAIN, 12);
		fmain_user.setResizable(false);
		fmain_user.setSize(1000, 700);
		fmain_user.getContentPane().setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
		fmain_user.setLayout(null);
		fmain_user.setVisible(true);
		JLabel m_user = new JLabel("" + data.getU_name() + "님, 반갑습니다.");
		m_user.setFont(btn_nomal);
		Panel p_left = new Panel();
		Panel p_right = new Panel();
		Panel Center_p = new Panel();
		Panel title_sun = new Panel();
		Panel title_mon = new Panel();
		Panel title_tue = new Panel();
		Panel title_wed = new Panel();
		Panel title_thu = new Panel();
		Panel title_fri = new Panel();
		Panel title_sat = new Panel();
		JLabel y_title = new JLabel("[ 예 약 정 보 입 력 ]");
		JLabel y_name = new JLabel("이름 :");
		JLabel y_date = new JLabel("생년월일 :");
		JLabel y_address = new JLabel("주소 :");
		JLabel y_contact = new JLabel("연락처 :");
		JLabel y_hospital = new JLabel("병원명 :");
		JLabel y_medical = new JLabel("진료 과목 :");
		JLabel y_date_2 = new JLabel("예약 시간 :");

		JButton btn_logout = new JButton("[접속종료]");
		JLabel Date_format = new JLabel();
		JLabel message_one = new JLabel(" ■ 희망하는 진료 예약일자를 선택해주세요");
		// -------------------------[실시간 시간 구하기]
		long systemTime = System.currentTimeMillis(); // 현재 시스템 시간 구하기
		SimpleDateFormat d_time = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		Date_format.setText(d_time.format(systemTime));
		Date_format.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		Panel North = new Panel();
		Panel South = new Panel();
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
		Center_p = new Panel();
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
		JTextField hospital = new JTextField();
		JTextField medical = new JTextField();
		JTextField date_2 = new JTextField();
		JButton btn_hospital = new JButton("[검색]");
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
		p_right.add(date_2);
		p_right.add(btn_hospital);
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
		name.setBounds(130, 100, 160, 25);
		date_1.setBounds(130, 140, 160, 25);
		address.setBounds(130, 180, 160, 25);
		contact.setBounds(130, 220, 160, 25);
		hospital.setBounds(130, 260, 110, 25);
		medical.setBounds(130, 300, 160, 25);
		date_2.setBounds(130, 340, 160, 25);
		btn_hospital.setBounds(240, 260, 70, 25);
		btn_hospital.setFont(btn_nomal);
		btn_hospital.setBorderPainted(false);
		btn_hospital.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f));
		y_title.setBounds(94, 40, 200, 25); // 예약정보
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
		y_date_2.setBounds(40, 340, 200, 25);
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
		btn_logout.setBounds(880, 30, 100, 25);
		Date_format.setBounds(44, 30, 220, 25);
		Date_format.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
		btn_Arr = new JButton[42]; // 숫자넣어줄버튼들
		p_left.setBounds(40, 100, 530, 490);
		p_right.setBounds(600, 100, 340, 500);
		Center_p.setBounds(0, 180, 530, 310);//
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
		address.setText(" " + data.getU_address());
		contact.setText(" " + data.getU_contact());
		btn_hospital.addActionListener(new ActionListener() { // 병원 검색
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MemberDAO oct = new MemberDAO();
				ArrayList<MemberVo> hoslist = oct.hoslist(hospital.getText());

				find_hospital(hoslist);
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
			Center_p.add(btn_Arr[i]);
		}
		// ---------------------
		setDays(date);
	}

	public void find_hospital(ArrayList<MemberVo> hoslist) {

		JFrame find_hsp = new JFrame("병원명 검색");
		find_hsp.setSize(500, 200);
		find_hsp.setLayout(null);
		find_hsp.setVisible(true);

		String[][] str = new String[hoslist.size()][3];
		for (int i = 0; i < hoslist.size(); i++) {
			MemberVo hos_data = (MemberVo) hoslist.get(i);
			String h_name = hos_data.getH_name();
			String h_address = hos_data.getH_address();
			String h_contact = hos_data.getH_contact();
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					str[i][j] = h_name;
				} else if (j == 1) {
					str[i][j] = h_address;
				} else {
					str[i][j] = h_contact;
				}
			}

		}
		String header[] = { "병원명", "주소", "연락처" };
		DefaultTableModel model = new DefaultTableModel(str, header) {
			// J테이블 내 튜플 선택안되게 함
			public boolean isCellEditable(int i, int c) {
				return false;
			}

		};

		JTable table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);

		table.setFont(btn_nomal);
		find_hsp.add(scroll);
		find_hsp.setResizable(false);
		scroll.setBounds(0, 0, 490, 164);

	}

	public void setDays(Calendar date) {
		Border lineBorder = BorderFactory.createLineBorder(Color.getHSBColor(0.0f, 0.0f, 0.9f), 1);
		int year = date.get(Calendar.YEAR);
		int month = date.get(Calendar.MONTH);
		L_YearMonth.setText(year + " / " + (month + 1));
		Font YearMonth = new Font("나눔바른고딕", Font.BOLD, 24); // 글씨 폰트변경 위한 객체
		L_YearMonth.setFont(YearMonth);
		Calendar sDay = Calendar.getInstance(); // 시작일

		sDay.set(year, month, 1);
		sDay.add(Calendar.DATE, -sDay.get(Calendar.DAY_OF_WEEK) + 1);
		int check = 1;
		for (int i = 0; i < btn_Arr.length; i++, sDay.add(Calendar.DATE, 1)) {
			int day = sDay.get(Calendar.DATE);

			if (day == check) {
				btn_Arr[i].setLabel(day + "");
				btn_Arr[i].setBorder(lineBorder);

				check++;
			} else {
				btn_Arr[i].setLabel("");
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
    public void windowClosing(WindowEvent e) {
    	System.exit(0);
    }
}
