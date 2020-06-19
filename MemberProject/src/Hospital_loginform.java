import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Hospital_loginform {
	JFrame f_login;
	TextField Tid, Tpwd, Tfd;
	Checkbox doctor, user;
	Calendar date = Calendar.getInstance();
	Font btn_nomal;
	Hospital_sign TP = new Hospital_sign();
	Main_User SP = new Main_User();
	Main_Doctor MD = new Main_Doctor();

	Hospital_loginform() {
		// --------------------------------------------------[1. 로그인 화면을 위한 프레임 작성]
		f_login = new JFrame("병원 진료 예약 시스템");
		f_login.setSize(350, 500);
		f_login.setLayout(null);
		f_login.setVisible(true); // 창을 화면에 나타낼 것인지 설정
		f_login.setResizable(false); // 창크기고정
		f_login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f_login.getContentPane().setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f)); // 프레임 배경색 지정
		// --------------------------------------------------[프레임 내 UI 배치를 위한 작업]
		JLabel f_l_id = new JLabel("아이디 :");
		JLabel f_l_pwd = new JLabel("비밀번호 : ");
		JButton f_b_login = new JButton("접속");
		JButton f_b_signup = new JButton("회원가입");
		JButton f_b_find = new JButton("아이디/비밀번호찾기");
		JTextField f_t_message = new JTextField(46);
		JTextField f_t_id = new JTextField(20);
		JTextField f_t_pwd = new JTextField(20);
		JLabel img = new JLabel();

		btn_nomal = new Font("나눔바른고딕", Font.PLAIN, 12);
		// ---------------------------------------------------------------------------
		f_login.add(f_l_id);
		f_login.add(f_l_pwd);
		f_login.add(f_b_login);
		f_login.add(f_b_signup);
		f_login.add(f_b_find);
		f_login.add(f_t_message);
		f_login.add(f_t_id);
		f_login.add(f_t_pwd);
		f_login.add(img);
		// ---------------------------------------------------------------------------
		f_l_id.setBounds(42, 300, 45, 25);
		f_l_pwd.setBounds(30, 335, 60, 25);
		f_b_login.setBounds(240, 300, 60, 60);
		f_b_signup.setBounds(60, 370, 80, 25);
		f_b_find.setBounds(160, 370, 140, 25);
		f_t_message.setBounds(18, 420, 300, 25);// x, y, w,h
		f_t_id.setBounds(90, 300, 140, 25);
		f_t_pwd.setBounds(90, 335, 140, 25);
		img.setBounds(40, 80, 300, 200);
		img.setIcon(new ImageIcon("img/QPJ2SO6E.jpg"));
		// ---------------------------------------------------------------------------
		f_b_signup.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f));
		f_b_find.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f));
		f_b_login.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f));
		// ---------------------------------------------------------------------------
		f_l_id.setFont(btn_nomal);
		f_l_pwd.setFont(btn_nomal);
		f_b_signup.setFont(btn_nomal);
		f_b_find.setFont(btn_nomal);
		f_b_login.setFont(btn_nomal);
		// ---------------------------------------------------------------------------
		f_t_message.setEditable(false); // 텍스트필드에 입력못함
		// ---------------------------------------------------------------------------

		// f.setVisible(true)를 사용하게되면 프로세스에 남아 안꺼지는 경우가 있으므로 위와 같은 코드를 입력해주어야함.
		f_b_login.addActionListener(new ActionListener() { // 로그인 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// -------------------------[로그인 검증]
				Hospital_Sql oct = new Hospital_Sql();
				if (f_t_id.getText().isEmpty()) {
					f_t_message.setText("  아이디를 입력해주세요.");
				} else if (f_t_pwd.getText().isEmpty()) {
					f_t_message.setText("  비밀번호를 입력해주세요.");
				} else {
					ArrayList<Hospital_Sql_Vo> list = oct.list(f_t_id.getText());
					if (list.size() == 0) {
						f_t_message.setText("  해당 아이디는 존재하지 않습니다.");
					} else {
						Hospital_Sql_Vo data = (Hospital_Sql_Vo) list.get(0);
						if (data.getE().equals(f_t_pwd.getText())) {
							if (data.getG() == null && data.getF() != null) { // 환자
								f_login.dispose();
								SP.main_hospital_user(data);
							} else if (data.getG() != null && data.getF() == null) { // 의사
								if (data.getZ() == 2) {
									f_login.dispose();
									MD.main_hospital_doctor(data);
								} else {
								f_t_message.setText("현재 로그인 불가, 해당 병원 전산팀에 문의바람(신규)");
								}
							}

						} else {
							f_t_message.setText("  아이디와 비밀번호를 확인해주세요.");
						}
					}

				}
			}
		});
		// ---------------------------------------------------------------------------
		f_b_signup.addActionListener(new ActionListener() { // 회원 가입 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				f_login.dispose();
				TP.join_choice();
			}
		});
	}

	public static void main(String args[]) {
		Hospital_loginform ff = new Hospital_loginform();

	}
}