import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class MemberTest extends WindowAdapter implements ActionListener {
	JFrame f, fjoin, fmain_user, find_hsp;
	JButton btn_login, btn_create, btn_back, btn_fjoin_ok, btn_prev, btn_next, btn_join, btn_find, btn_logout,
			btn_hospital;
	JButton[] btn_Arr;
	JTextField Tfd, Tid, Tpwd, T_hospital, T_medical, T_name, T_date, T_address, T_contact, T_id, T_pwd, name, date_1,
			address, contact, hospital, medical, date_2;
	JLabel Lid, Lpwd, L_hospital, L_medical, L_name, L_date, L_address, L_contact, L_id, L_pwd, L_popup1, L_popup2,
			L_popup3, L_popup4, m_user, L_YearMonth, sun, mon, tue, wed, thu, fri, sat, Date_format, message_one,
			y_name, y_date, y_address, y_contact, y_hospital, y_medical, y_date_2, y_title;
	JDialog Popup;
	Checkbox doctor, user;
	Calendar date = Calendar.getInstance();
	Font btn_nomal;
	Border lineBorder;

	MemberTest() {
		f = new JFrame("병원 진료 예약 시스템");
		f.setSize(350, 500);
		f.getContentPane().setBackground(Color.getHSBColor(0, 0, 40)); // 프레임 배경색 지정
		f.setLayout(null);
		f.setResizable(false); // 창크기고정

		Lid = new JLabel("아이디 :");
		Lpwd = new JLabel("비밀번호 : ");
		btn_login = new JButton("접속");
		btn_join = new JButton("회원가입");
		btn_find = new JButton("아이디/비밀번호찾기");
		Tfd = new JTextField(46);
		Tid = new JTextField(20);
		Tpwd = new JTextField(20);
		Lid.setFont(btn_nomal);
		Lpwd.setFont(btn_nomal);

		Lid.setBounds(42, 300, 45, 25);
		Lpwd.setBounds(30, 335, 60, 25);
		Tid.setBounds(90, 300, 140, 25);
		Tpwd.setBounds(90, 335, 140, 25);
		btn_login.setBounds(240, 300, 60, 60);
		btn_join.setBounds(60, 370, 80, 25);
		btn_find.setBounds(160, 370, 140, 25);
		Tfd.setBounds(18, 420, 300, 25);// x, y, w,h

		Tfd.setEditable(false); // 텍스트필드에 입력못함
		f.add(Lid);
		f.add(Lpwd);
		f.add(Tid);
		f.add(Tpwd);
		f.add(btn_login);
		f.add(Tfd);
		f.add(btn_join);
		f.add(btn_find);
		btn_join.setBackground(Color.getHSBColor(0, 0, 40));
		btn_find.setBackground(Color.getHSBColor(0, 0, 40));
		btn_login.setBackground(Color.getHSBColor(0, 0, 40));
		btn_nomal = new Font("나눔고딕", Font.PLAIN, 12);
		btn_join.setFont(btn_nomal);
		btn_find.setFont(btn_nomal);
		btn_login.setFont(btn_nomal);

		btn_login.addActionListener(this);
		btn_join.addActionListener(this);

		f.setVisible(true); // 창을 화면에 나타낼 것인지 설정

	}

	public void join_choice() {
		fjoin = new JFrame("병원 진료 예약 시스템");
		fjoin.getContentPane().setBackground(Color.getHSBColor(0, 0, 40));
		fjoin.setLayout(null);
		fjoin.setSize(350, 540);
		fjoin.setResizable(false);
		CheckboxGroup group1 = new CheckboxGroup();
		doctor = new Checkbox(" 의사", group1, true);
		user = new Checkbox(" 환자", group1, true);
		doctor.setFont(btn_nomal);
		user.setFont(btn_nomal);
		JLabel Lmessage1 = new JLabel("[협력 병원에 소속된 의사인 경우만 '의사'에 Check]");
		L_id = new JLabel("아이디 : ");
		L_pwd = new JLabel("비밀번호 : ");
		L_name = new JLabel("이름 : ");
		L_date = new JLabel("생년월일 : ");
		L_address = new JLabel("주소 : ");
		L_contact = new JLabel("연락처 : ");
		T_name = new JTextField();
		T_date = new JTextField();
		T_address = new JTextField();
		T_contact = new JTextField();
		T_id = new JTextField();
		T_pwd = new JTextField();
		btn_create = new JButton("가입");
		btn_back = new JButton("돌아가기");
		btn_create.setFont(btn_nomal);
		btn_back.setFont(btn_nomal);
		btn_create.setBackground(Color.getHSBColor(0, 0, 40));
		btn_back.setBackground(Color.getHSBColor(0, 0, 40));
		Lmessage1.setFont(btn_nomal);
		L_id.setFont(btn_nomal);
		L_pwd.setFont(btn_nomal);
		L_name.setFont(btn_nomal);
		L_date.setFont(btn_nomal);
		L_address.setFont(btn_nomal);
		L_contact.setFont(btn_nomal);

		Lmessage1.setBounds(36, 40, 320, 25);
		doctor.setBounds(120, 80, 60, 25);
		user.setBounds(240, 80, 60, 25);
		L_id.setBounds(40, 120, 60, 25);
		L_pwd.setBounds(40, 160, 60, 25);
		L_name.setBounds(40, 200, 60, 25);
		L_date.setBounds(40, 240, 60, 25);
		L_address.setBounds(40, 280, 60, 25);
		L_contact.setBounds(40, 320, 60, 25);
		T_id.setBounds(120, 120, 180, 25);
		T_pwd.setBounds(120, 160, 180, 25);
		T_name.setBounds(120, 200, 180, 25);
		T_date.setBounds(120, 240, 180, 25);
		T_address.setBounds(120, 280, 180, 25);
		T_contact.setBounds(120, 320, 180, 25);
		btn_create.setBounds(40, 450, 120, 25);
		btn_back.setBounds(180, 450, 120, 25);
//

		fjoin.add(doctor);
		fjoin.add(user);
		fjoin.add(L_name);
		fjoin.add(L_date);
		fjoin.add(L_address);
		fjoin.add(L_contact);
		fjoin.add(Lmessage1);
		fjoin.add(L_id);
		fjoin.add(L_pwd);
		fjoin.add(T_id);
		fjoin.add(T_pwd);
		fjoin.add(T_name);
		fjoin.add(T_date);
		fjoin.add(T_address);
		fjoin.add(T_contact);

		fjoin.add(btn_create);
		fjoin.add(btn_back);
		btn_back.addActionListener(this);
		btn_create.addActionListener(this);
		fjoin.setVisible(true);

		doctor.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				L_hospital = new JLabel("소속 병원명 : ");
				L_medical = new JLabel("진료 과목명 : ");
				T_hospital = new JTextField();
				T_medical = new JTextField();
				L_hospital.setFont(btn_nomal);
				L_medical.setFont(btn_nomal);
				fjoin.add(T_hospital);
				fjoin.add(T_medical);
				fjoin.add(L_hospital);
				fjoin.add(L_medical);
				L_hospital.setBounds(40, 360, 100, 25);
				L_medical.setBounds(40, 400, 100, 25);
				T_hospital.setBounds(120, 360, 180, 25);
				T_medical.setBounds(120, 400, 180, 25);
			}
		});
		user.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				L_hospital.hide();
				L_medical.hide();
				T_hospital.hide();
				T_medical.hide();

			}
		});
	}

	public void main_hospital(MemberVo data) {
		fmain_user = new JFrame("병원 진료 예약 시스템");
		fmain_user.setResizable(false);
		fmain_user.setSize(1000, 700);
		fmain_user.getContentPane().setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
		fmain_user.setLayout(null);
		fmain_user.setVisible(true);
		m_user = new JLabel("" + data.getU_name() + "님, 반갑습니다.");
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
		y_title = new JLabel("[ 예 약 정 보 입 력 ]");
		y_name = new JLabel("이름 :");
		y_date = new JLabel("생년월일 :");
		y_address = new JLabel("주소 :");
		y_contact = new JLabel("연락처 :");
		y_hospital = new JLabel("병원명 :");
		y_medical = new JLabel("진료 과목 :");
		y_date_2 = new JLabel("예약 시간 :");

		btn_logout = new JButton("[접속종료]");
		Date_format = new JLabel();
		message_one = new JLabel(" ■ 희망하는 진료 예약일자를 선택해주세요");
		// -------------------------[실시간 시간 구하기]
		long systemTime = System.currentTimeMillis(); // 현재 시스템 시간 구하기
		SimpleDateFormat d_time = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		Date_format.setText(d_time.format(systemTime));
		Date_format.setFont(new Font("바른나눔고딕", Font.PLAIN, 14));
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
		btn_prev = new JButton("◀");
		btn_next = new JButton("▶");
		sun = new JLabel("SUN");
		mon = new JLabel("MON");
		tue = new JLabel("TUE");
		wed = new JLabel("WED");
		thu = new JLabel("THU");
		fri = new JLabel("FRI");
		sat = new JLabel("SAT");
		name = new JTextField();
		name.setEditable(false);
		date_1 = new JTextField();
		date_1.setEditable(false);
		address = new JTextField();
		address.setEditable(false);
		contact = new JTextField();
		contact.setEditable(false);
		hospital = new JTextField();
		medical = new JTextField();
		date_2 = new JTextField();
		btn_hospital = new JButton("[검색]");
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
		message_one.setFont(new Font("바른나눔고딕", Font.PLAIN, 14));
		p_left.add(Center_p);
		name.setBounds(130, 100, 160, 25);
		date_1.setBounds(130, 140, 160, 25);
		address.setBounds(130, 180, 160, 25);
		contact.setBounds(130, 220, 160, 25);
		hospital.setBounds(130, 260, 110, 25);
		medical.setBounds(130, 300, 160, 25);
		date_2.setBounds(130, 340, 160, 25);
		btn_hospital.setBounds(244, 260, 64, 25);
		btn_hospital.setFont(btn_nomal);
		btn_hospital.setBorderPainted(false);
		btn_hospital.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f));
		y_title.setBounds(86, 40, 200, 25); // 예약정보
		y_title.setFont(new Font("바른 나눔 고딕", Font.BOLD, 20));
		y_name.setBounds(40, 100, 200, 25);
		y_name.setFont(new Font("바른 나눔 고딕", Font.PLAIN, 14));
		y_date.setBounds(40, 140, 200, 25);
		y_date.setFont(new Font("바른 나눔 고딕", Font.PLAIN, 14));
		y_address.setBounds(40, 180, 200, 25);
		y_address.setFont(new Font("바른 나눔 고딕", Font.PLAIN, 14));
		y_contact.setBounds(40, 220, 200, 25);
		y_contact.setFont(new Font("바른 나눔 고딕", Font.PLAIN, 14));
		y_hospital.setBounds(40, 260, 200, 25);
		y_hospital.setFont(new Font("바른 나눔 고딕", Font.PLAIN, 14));
		y_medical.setBounds(40, 300, 200, 25);
		y_medical.setFont(new Font("바른 나눔 고딕", Font.PLAIN, 14));
		y_date_2.setBounds(40, 340, 200, 25);
		y_date_2.setFont(new Font("바른 나눔 고딕", Font.PLAIN, 14));
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
		Date_format.setFont(new Font("바른나눔고딕", Font.PLAIN, 16));
		btn_Arr = new JButton[42]; // 숫자넣어줄버튼들
		p_left.setBounds(40, 100, 530, 490);
		p_right.setBounds(600, 100, 340, 500);
		Center_p.setBounds(0, 180, 530, 310);//
		p_left.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
		p_right.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f));
		m_user.setBounds(740, 30, 240, 25);
		m_user.setFont(new Font("바른나눔고딕", Font.PLAIN, 14));
		btn_prev.setBorderPainted(false);
		btn_next.setBorderPainted(false);
		btn_logout.setBorderPainted(false);
		btn_logout.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		name.setText(" " + data.getU_name());
		date_1.setText(" " + data.getU_date());
		address.setText(" " + data.getU_address());
		contact.setText(" " + data.getU_contact());
		btn_hospital.addActionListener(this);
		// ---------------------[달력셋팅]

		date = Calendar.getInstance();
		L_YearMonth = new JLabel();
		L_YearMonth.setVisible(true);
		L_YearMonth.setBounds(220, 66, 140, 40);

		btn_prev.addActionListener(this);
		btn_next.addActionListener(this);

		p_left.add(L_YearMonth);
		// ---------------------
		Center_p.setLayout(new GridLayout(6, 7));
		for (int i = 0; i < btn_Arr.length; i++) {
			btn_Arr[i] = new JButton("");
			Center_p.add(btn_Arr[i]);
		}
		// ---------------------

	}

	public void setDays(Calendar date) {
		lineBorder = BorderFactory.createLineBorder(Color.getHSBColor(0.0f, 0.0f, 0.9f), 1);
		int year = date.get(Calendar.YEAR);
		int month = date.get(Calendar.MONTH);

		L_YearMonth.setText(year + " / " + (month + 1));
		Font YearMonth = new Font("바른나눔고딕", Font.BOLD, 24); // 글씨 폰트변경 위한 객체
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getActionCommand().contains("회원가입")) {
			f.hide();
			Tid.setText("");
			Tpwd.setText("");
			Tfd.setText("");
			join_choice();
		} else if (e.getActionCommand().contains("돌아가기")) {
			System.out.println("돌아가기");
			fjoin.dispose();
			f.show();
		} else if (e.getActionCommand().contains("확인")) {
			Popup.dispose();
		} else if (e.getActionCommand().contains("가입")) {
			String strid = T_id.getText();
			String strpwd = T_pwd.getText();
			String strname = T_name.getText();
			String strdate = T_date.getText();
			String straddress = T_address.getText();
			String strcontact = T_contact.getText();
			Popup = new JDialog(fjoin, "가입안내", true);
			L_popup1 = new JLabel();
			L_popup2 = new JLabel();
			L_popup3 = new JLabel();
			L_popup4 = new JLabel();
			btn_fjoin_ok = new JButton("확인");
			btn_fjoin_ok.setBounds(150, 150, 40, 25);
			L_popup1.setBounds(20, 60, 310, 25);
			L_popup2.setBounds(20, 80, 300, 25);
			L_popup3.setBounds(20, 100, 300, 25);
			L_popup4.setBounds(20, 120, 300, 25);
			Popup.setSize(350, 200);
			btn_fjoin_ok.addActionListener(this);

			Popup.add(L_popup1);
			Popup.add(L_popup2);
			Popup.add(L_popup3);
			Popup.add(L_popup4);

			Popup.add(btn_fjoin_ok);
			Popup.setLayout(null);

			// 공백불가...
			String[] strArr1 = { strid, strpwd, strdate, strname, straddress, strcontact };
			String[] strArr2 = { "아이디 ", "비밀번호 ", "이름", "생년월일 ", "주소 ", "연락처 " };
			int cnt = 0, k;
			for (k = 0; k < strArr1.length; k++) {
				if (strArr1[k].isEmpty()) {
					L_popup1.setText(L_popup1.getText() + strArr2[k]);
					cnt++;
				}

			}

			// 아디는 영어대소문자와 숫자만 입력가능함.
			for (int i = 0; i < strid.length(); i++) {
				char ch = strid.charAt(i);
				if ((ch < 'a' || ch > 'z') && (ch < 'A' || ch > 'Z') && (ch < '0' || ch > '9')) {
					if (L_popup1.getText().isEmpty()) {
						L_popup1.setText(L_popup1.getText() + "아이디는 영어 대소문자와 숫자만 입력할 수 있습니다.");
						T_id.setText("");
						break;
					} else {
						L_popup2.setText(L_popup2.getText() + "아이디는 영어 대소문자와 숫자만 입력할 수 있습니다.");
						T_id.setText("");
						break;
					}

				}

			}
			// 생년월일은 숫자만 입력 가능
			for (int i = 0; i < strdate.length(); i++) {
				char ch = strdate.charAt(i);
				if (ch < '0' || ch > '9') {
					if (L_popup1.getText().isEmpty()) {
						L_popup1.setText(L_popup1.getText() + "생년월일은 '-'를 제외한 숫자만 입력할 수 있습니다.");
						T_date.setText("");
						break;
					} else if (L_popup2.getText().isEmpty()) {
						L_popup2.setText(L_popup2.getText() + "생년월일은 '-'를 제외한 숫자만 입력할 수 있습니다.");
						T_date.setText("");
						break;
					}
				}
			} //

			if (strdate.length() != 8) {
				if (L_popup1.getText().isEmpty()) {
					L_popup1.setText(L_popup1.getText() + "생년월일은 8자리입니다. (ex : 20200602)");
					T_date.setText("");

				} else if (L_popup2.getText().isEmpty()) {
					L_popup2.setText(L_popup2.getText() + "생년월일은 8자리입니다. (ex : 20200602)");
					T_date.setText("");

				} else if (L_popup3.getText().isEmpty()) {
					L_popup3.setText(L_popup3.getText() + "생년월일은 8자리입니다. (ex : 20200602)");
					T_date.setText("");
				}
			}
			if ((k == strArr1.length) && (cnt != 0)) {
				L_popup1.setText(L_popup1.getText() + "는 공백 포함 불가");
				Popup.setVisible(true);
			} else if (!L_popup1.getText().isEmpty()) {
				Popup.setVisible(true);
			}
			cnt = 0;

			if (user.getState() == true) {

			} else {

			}
		}
		// -------------------------[로그인 검증]
		if (e.getActionCommand().contains("접속")) {
			MemberDAO oct = new MemberDAO();
			if (Tid.getText().isEmpty()) {
				Tfd.setText("  아이디를 입력해주세요.");
			} else if (Tpwd.getText().isEmpty()) {
				Tfd.setText("  비밀번호를 입력해주세요.");
			} else {
				ArrayList<MemberVo> list = oct.list(Tid.getText());
				MemberVo data = (MemberVo) list.get(0);
				if (data.getU_pwd().equals(Tpwd.getText())) {
					Tid.setText("");
					Tpwd.setText("");
					f.dispose();
					main_hospital(data);
				} else {
					Tfd.setText("  아이디와 비밀번호를 확인해주세요.");

				}
			}

		}
		if (e.getActionCommand().contains("◀")) {
			date.add(Calendar.MONDAY, -1);
		} else if (e.getActionCommand().contains("▶")) {
			date.add(Calendar.MONTH, 1);
		}
		setDays(date);

		if (e.getActionCommand().contains("검색")) {
			MemberDAO oct = new MemberDAO();
			ArrayList<MemberVo> hoslist = oct.hoslist(hospital.getText());

			find_hospital(hoslist);

		}

	}

	public void find_hospital(ArrayList<MemberVo> hoslist) {
		find_hsp = new JFrame("병원명 검색");
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

	public static void main(String args[]) {
		MemberTest ff = new MemberTest();

	}
}