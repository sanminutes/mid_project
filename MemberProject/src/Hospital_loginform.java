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
		// --------------------------------------------------[1. �α��� ȭ���� ���� ������ �ۼ�]
		f_login = new JFrame("���� ���� ���� �ý���");
		f_login.setSize(350, 500);
		f_login.setLayout(null);
		f_login.setVisible(true); // â�� ȭ�鿡 ��Ÿ�� ������ ����
		f_login.setResizable(false); // âũ�����
		f_login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f_login.getContentPane().setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f)); // ������ ���� ����
		// --------------------------------------------------[������ �� UI ��ġ�� ���� �۾�]
		JLabel f_l_id = new JLabel("���̵� :");
		JLabel f_l_pwd = new JLabel("��й�ȣ : ");
		JButton f_b_login = new JButton("����");
		JButton f_b_signup = new JButton("ȸ������");
		JButton f_b_find = new JButton("���̵�/��й�ȣã��");
		JTextField f_t_message = new JTextField(46);
		JTextField f_t_id = new JTextField(20);
		JTextField f_t_pwd = new JTextField(20);
		JLabel img = new JLabel();

		btn_nomal = new Font("�����ٸ����", Font.PLAIN, 12);
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
		f_t_message.setEditable(false); // �ؽ�Ʈ�ʵ忡 �Է¸���
		// ---------------------------------------------------------------------------

		// f.setVisible(true)�� ����ϰԵǸ� ���μ����� ���� �Ȳ����� ��찡 �����Ƿ� ���� ���� �ڵ带 �Է����־����.
		f_b_login.addActionListener(new ActionListener() { // �α��� ��ư
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// -------------------------[�α��� ����]
				Hospital_Sql oct = new Hospital_Sql();
				if (f_t_id.getText().isEmpty()) {
					f_t_message.setText("  ���̵� �Է����ּ���.");
				} else if (f_t_pwd.getText().isEmpty()) {
					f_t_message.setText("  ��й�ȣ�� �Է����ּ���.");
				} else {
					ArrayList<Hospital_Sql_Vo> list = oct.list(f_t_id.getText());
					if (list.size() == 0) {
						f_t_message.setText("  �ش� ���̵�� �������� �ʽ��ϴ�.");
					} else {
						Hospital_Sql_Vo data = (Hospital_Sql_Vo) list.get(0);
						if (data.getE().equals(f_t_pwd.getText())) {
							if (data.getG() == null && data.getF() != null) { // ȯ��
								f_login.dispose();
								SP.main_hospital_user(data);
							} else if (data.getG() != null && data.getF() == null) { // �ǻ�
								if (data.getZ() == 2) {
									f_login.dispose();
									MD.main_hospital_doctor(data);
								} else {
								f_t_message.setText("���� �α��� �Ұ�, �ش� ���� �������� ���ǹٶ�(�ű�)");
								}
							}

						} else {
							f_t_message.setText("  ���̵�� ��й�ȣ�� Ȯ�����ּ���.");
						}
					}

				}
			}
		});
		// ---------------------------------------------------------------------------
		f_b_signup.addActionListener(new ActionListener() { // ȸ�� ���� ��ư
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