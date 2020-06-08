import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class membership {
	JFrame fjoin;
	JLabel L_hospital, L_medical, L_idx, L_msg;
	Font btn_nomal;
	JTextField T_hospital, T_medical, T_id;
	JDialog Popup;

	public void join_choice() { // 회원가입
		fjoin = new JFrame("병원 진료 예약 시스템");
		btn_nomal = new Font("나눔바른고딕", Font.PLAIN, 12);
		fjoin.getContentPane().setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f));
		fjoin.setLayout(null);
		fjoin.setSize(350, 540);
		fjoin.setResizable(false);
		CheckboxGroup group1 = new CheckboxGroup();
		Checkbox doctor = new Checkbox(" 의사", group1, true);
		Checkbox user = new Checkbox(" 환자", group1, true);
		doctor.setFont(btn_nomal);
		user.setFont(btn_nomal);
		JLabel Lmessage1 = new JLabel("[협력 병원에 소속된 의사인 경우만 '의사'에 Check]");
		JLabel L_id = new JLabel("아이디 : ");
		L_idx = new JLabel();
		JLabel L_pwd = new JLabel("비밀번호 : ");
		JLabel L_pwdx = new JLabel();
		JLabel L_name = new JLabel("이름 : ");
		JLabel L_namex = new JLabel();
		JLabel L_date = new JLabel("생년월일 : ");
		JLabel L_datex = new JLabel();
		JLabel L_address = new JLabel("주소 : ");
		JLabel L_contact = new JLabel("연락처 : ");
		JLabel L_contactx = new JLabel("");
		JTextField T_name = new JTextField();
		JTextField T_date = new JTextField(" 숫자만 입력가능(ex 20200608)");
		T_date.setForeground(Color.LIGHT_GRAY);
		JTextField T_address = new JTextField();
		JTextField T_contact = new JTextField();
		T_id = new JTextField();
		JTextField T_pwd = new JTextField();
		JButton btn_create = new JButton("가입");
		JButton btn_back = new JButton("돌아가기");
		Popup = new JDialog(fjoin, "병원 진료 예약 시스템", true);
		L_msg = new JLabel();
		btn_create.setFont(btn_nomal);
		btn_back.setFont(btn_nomal);
		btn_create.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f));
		btn_back.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f));
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
		L_id.setBounds(40, 120, 60, 25);
		L_idx.setBounds(40, 140, 300, 25);
		L_pwd.setBounds(40, 160, 60, 25);
		L_pwdx.setBounds(40, 180, 300, 25);
		L_name.setBounds(40, 200, 60, 25);
		L_namex.setBounds(40, 220, 300, 25);
		L_date.setBounds(40, 240, 60, 25);
		L_datex.setBounds(40, 260, 300, 25);
		L_address.setBounds(40, 280, 60, 25);
		L_contact.setBounds(40, 320, 60, 25);
		L_contactx.setBounds(40, 340, 300, 25);
		T_id.setBounds(120, 120, 180, 25);
		T_pwd.setBounds(120, 160, 180, 25);
		T_name.setBounds(120, 200, 180, 25);
		T_date.setBounds(120, 240, 180, 25);
		T_address.setBounds(120, 280, 180, 25);
		T_contact.setBounds(120, 320, 180, 25);
		btn_create.setBounds(40, 450, 120, 25);
		btn_back.setBounds(180, 450, 120, 25);
		Popup.setLayout(null);
		L_msg.setBounds(70,20,200,25);
		L_msg.setFont(new Font("나눔바른고딕",Font.PLAIN,14));
		
		Popup.setSize(300, 150);
		Popup.setLocation(24, 150);

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
		fjoin.add(L_idx);
		fjoin.add(L_pwdx);
		fjoin.add(L_namex);
		fjoin.add(L_datex);
		fjoin.add(L_contactx);
		fjoin.add(btn_create);
		fjoin.add(btn_back);
		Popup.add(L_msg);
		L_msg.setVisible(true);

		T_id.addFocusListener(new FocusListener() { // 아이디 유효성 검사
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				L_idx.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
				L_idx.setForeground(Color.red);

				for (int i = 0; i < T_id.getText().length(); i++) {
					if ((T_id.getText().charAt(i) < 'a' || T_id.getText().charAt(i) > 'z')
							&& (T_id.getText().charAt(i) < '0' || T_id.getText().charAt(i) > '9')) {
						L_idx.setText("5~20자의 영문 소문자, 숫자만 사용 가능.");
					} else {
						if (T_id.getText().length() < 5 || T_id.getText().length() > 20) {
							L_idx.setText("5~20자의 영문 소문자, 숫자만 사용 가능.");
						} else {
							if (i == T_id.getText().length() - 1) {
								MemberDAO dao = new MemberDAO();
								ArrayList<MemberVo> list = dao.list(T_id.getText());
								if (list.size() == 0) {
									L_idx.setText("해당 아이디는 가입 가능합니다.");
									L_idx.setForeground(Color.blue);
								} else {
									L_idx.setText("해당 아이디는 가입할 수 없습니다.");
								}
							}
						}
					}
				}

				if (T_id.getText().isEmpty()) {
					L_idx.setText("필수 항목입니다.");
				} else {

				}

			}
		});

		T_pwd.addFocusListener(new FocusListener() { // 비밀번호 유효성 검사

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent e) {
				L_pwdx.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
				L_pwdx.setForeground(Color.red);
				// TODO Auto-generated method stub
				if (T_pwd.getText().length() < 8 || T_pwd.getText().length() > 16) {
					L_pwdx.setText("8~16자 영문 대 소문자, 숫자, 특수문자만 사용 가능");
				} else {
					L_pwdx.setText("");
				}

				if (T_pwd.getText().isEmpty()) {
					L_pwdx.setText("필수 항목입니다.");
				}
			}

		});

		T_name.addFocusListener(new FocusListener() { // 이름 유효성 검사

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				L_namex.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
				L_namex.setForeground(Color.red);
				for (int i = 0; i < T_name.getText().length(); i++) {
					if (T_name.getText().charAt(i) < '가' || T_name.getText().charAt(i) > '힣') {
						L_namex.setText("한글만 입력가능(특수기호, 공백 사용 불가)");
					} else {
						L_namex.setText("");
					}
				}
				if (T_name.getText().isEmpty()) {
					L_namex.setText("필수 항목입니다.");

				}
			}

		});

		T_date.addFocusListener(new FocusListener() { // 생년월일 유효성 검사

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				T_date.setText("");
				T_date.setForeground(Color.black);
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

				L_datex.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
				L_datex.setForeground(Color.red);
				for (int i = 0; i < T_date.getText().length(); i++) {
					if (T_date.getText().charAt(i) < '0' || T_date.getText().charAt(i) > '9') {
						L_datex.setText("생년월일은 8자리로 숫자만 입력가능");
					} else {
						if (T_date.getText().length() != 8) {
							L_datex.setText("생년월일은 8자리로 숫자만 입력가능");
						} else {
							L_datex.setText("");
						}
					}
				}
				if (T_date.getText().isEmpty()) {
					L_datex.setText("필수 항목입니다.");

				}
			}

		});

		T_contact.addFocusListener(new FocusListener() { // 연락처 유효성 검사

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				L_contactx.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
				L_contactx.setForeground(Color.red);
				for (int i = 0; i < T_contact.getText().length(); i++) {
					if (T_contact.getText().charAt(i) < '0' || T_contact.getText().charAt(i) > '9') {
						L_contactx.setText("연락처는 -를 제외한 숫자만 입력가능");
					} else {
						if (T_contact.getText().length() < 10 || T_contact.getText().length() > 11) {
							L_contactx.setText("연락처는 -를 제외한 숫자만 입력가능");
						} else {
							L_contactx.setText("");
						}
					}
				}
				if (T_contact.getText().isEmpty()) {
					L_contactx.setText("필수 항목입니다.");

				}
			}

		});

		btn_back.addActionListener(new ActionListener() { // 돌아가기
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fjoin.dispose();
				MemberTest MT = new MemberTest();
			}

		});
		btn_create.addActionListener(new ActionListener() { // 가입 버튼
			private MemberVo memberVo;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 아이디 제약조건
				if (T_id.getText().isEmpty()) {
					L_idx.setText("필수 항목입니다.");
					L_idx.setForeground(Color.red);
					L_idx.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
				}
				if (T_pwd.getText().isEmpty()) {
					L_pwdx.setText("필수 항목입니다.");
					L_pwdx.setForeground(Color.red);
					L_pwdx.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
				}
				if (T_name.getText().isEmpty()) {
					L_namex.setText("필수 항목입니다.");
					L_namex.setForeground(Color.red);
					L_namex.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
				}
				if (T_date.getText().equals(" 숫자만 입력가능(ex 20200608)")) {
					L_datex.setText("필수 항목입니다.");
					L_datex.setForeground(Color.red);
					L_datex.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
				}
				if (T_contact.getText().isEmpty()) {
					L_contactx.setText("필수 항목입니다.");
					L_contactx.setForeground(Color.red);
					L_contactx.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
				}
				if (L_idx.getText() == "해당 아이디는 가입 가능합니다." && L_pwdx.getText().isEmpty() && L_namex.getText().isEmpty()
						&& L_datex.getText().isEmpty() && L_contactx.getText().isEmpty()) {
					MemberDAO md = new MemberDAO();
					if(md.insertMember(T_id.getText(), T_pwd.getText(), T_name.getText(),
							Integer.parseInt(T_date.getText()), T_address.getText(), T_contact.getText())==true) {
						L_msg.setText("회원가입이 완료되었습니다.");
						Popup.setVisible(true);
						
					};

				}
			}

		});
		fjoin.setVisible(true);

		doctor.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) { // 의사에 체크한 경우
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
		user.addItemListener(new ItemListener() { // 환자에 체크한 경우
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
}
