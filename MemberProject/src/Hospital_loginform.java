import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Hospital_loginform {
	JFrame f;
	TextField Tid, Tpwd, Tfd;
	Checkbox doctor, user;
	Calendar date = Calendar.getInstance();
	Font btn_nomal;
	Hospital_sign TP = new Hospital_sign();
	Main_User SP = new Main_User();
	Main_Doctor MD = new Main_Doctor();
	Hospital_loginform() {
		f = new JFrame("병원 진료 예약 시스템");
		f.setSize(350, 500);
		f.getContentPane().setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f)); // 프레임 배경색 지정
		f.setLayout(null);
		f.setResizable(false); // 창크기고정

		JLabel Lid = new JLabel("아이디 :");
		JLabel Lpwd = new JLabel("비밀번호 : ");
		JButton btn_login = new JButton("접속");
		JButton btn_join = new JButton("회원가입");
		JButton btn_find = new JButton("아이디/비밀번호찾기");
		JTextField Tfd = new JTextField(46);
		JTextField Tid = new JTextField(20);
		JTextField Tpwd = new JTextField(20);
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
		btn_join.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f));
		btn_find.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f));
		btn_login.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f));
		btn_nomal = new Font("나눔바른고딕", Font.PLAIN, 12);
		btn_join.setFont(btn_nomal);
		btn_find.setFont(btn_nomal);
		btn_login.setFont(btn_nomal);




		btn_login.addActionListener(new ActionListener() { // 로그인 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// -------------------------[로그인 검증]
				Hospital_Sql oct = new Hospital_Sql();
				if (Tid.getText().isEmpty()) {
					Tfd.setText("  아이디를 입력해주세요.");
				} else if (Tpwd.getText().isEmpty()) {
					Tfd.setText("  비밀번호를 입력해주세요.");
				} else {
					ArrayList<Hospital_Sql_Vo> list = oct.list(Tid.getText());
					if (list.size() == 0) {
						Tfd.setText("  해당 아이디는 존재하지 않습니다.");
					} else {
						Hospital_Sql_Vo data = (Hospital_Sql_Vo) list.get(0);
						if (data.getU_pwd().equals(Tpwd.getText())) {
							f.dispose();
							if(data.getD_number()==null&&data.getU_number()!=null) { //환자
								SP.main_hospital_user(data);
							}else if(data.getD_number()!=null&&data.getU_number()==null){ //의사
								MD.main_hospital_doctor(data);
								
								
							}

	

						}else {
							Tfd.setText("  아이디와 비밀번호를 확인해주세요.");
						}
					}

				}
			}
		});
		btn_join.addActionListener(new ActionListener() { // 회원 가입 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				f.dispose();
				TP.join_choice();
			}
		});

		f.setVisible(true); // 창을 화면에 나타낼 것인지 설정
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		// f.setVisible(true)를 사용하게되면 프로세스에 남아 안꺼지는 경우가 있으므로 위와 같은 코드를 입력해주어야함.
	}



	public static void main(String args[]) {
		Hospital_loginform ff = new Hospital_loginform();

	}
}