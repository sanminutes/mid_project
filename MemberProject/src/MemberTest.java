import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class MemberTest extends WindowAdapter implements ActionListener {
	JFrame f, fjoin, fmain_user;
	JButton btn_login, btn_create, btn_back, btn_fjoin_ok, btn_prev, btn_next, btn_join, btn_find;
	JButton[] btn_Arr;
	JTextField Tfd, Tid, Tpwd, T_hospital, T_medical, T_name, T_date, T_address, T_contact, T_id, T_pwd;
	JLabel Lid, Lpwd, L_hospital, L_medical, L_name, L_date, L_address, L_contact, L_id, L_pwd, L_popup1, L_popup2,
			L_popup3, L_popup4, m_user, L_YearMonth, sun, mon, tue, wed, thu, fri, sat;
	JDialog Popup;
	Checkbox doctor, user;
	Calendar date = Calendar.getInstance();
	Font btn_nomal;
	Border lineBorder;

	MemberTest() {
		f = new JFrame("���� ���� ���� �ý���");
		f.setSize(350, 500);
		f.getContentPane().setBackground(Color.getHSBColor(0, 0, 40)); // ������ ���� ����
		f.setLayout(null);
		f.setResizable(false); // âũ�����

		Lid = new JLabel("���̵� :");
		Lpwd = new JLabel("��й�ȣ : ");
		btn_login = new JButton("����");
		btn_join = new JButton("ȸ������");
		btn_find = new JButton("���̵�/��й�ȣã��");
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

		Tfd.setEditable(false); // �ؽ�Ʈ�ʵ忡 �Է¸���
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
		btn_nomal = new Font("�������", Font.PLAIN, 12);
		btn_join.setFont(btn_nomal);
		btn_find.setFont(btn_nomal);
		btn_login.setFont(btn_nomal);

		btn_login.addActionListener(this);
		btn_join.addActionListener(this);

		f.setVisible(true); // â�� ȭ�鿡 ��Ÿ�� ������ ����

	}

	public static void main(String args[]) {
		MemberTest ff = new MemberTest();

	}

	public void join_choice() {
		fjoin = new JFrame("���� ���� ���� �ý���");
		fjoin.getContentPane().setBackground(Color.getHSBColor(0, 0, 40));
		fjoin.setLayout(null);
		fjoin.setSize(350, 540);
		fjoin.setResizable(false);
		CheckboxGroup group1 = new CheckboxGroup();
		doctor = new Checkbox(" �ǻ�", group1, true);
		user = new Checkbox(" ȯ��", group1, true);
		doctor.setFont(btn_nomal);
		user.setFont(btn_nomal);
		JLabel Lmessage1 = new JLabel("[���� ������ �Ҽӵ� �ǻ��� ��츸 '�ǻ�'�� Check]");
		L_id = new JLabel("���̵� : ");
		L_pwd = new JLabel("��й�ȣ : ");
		L_name = new JLabel("�̸� : ");
		L_date = new JLabel("������� : ");
		L_address = new JLabel("�ּ� : ");
		L_contact = new JLabel("����ó : ");
		T_name = new JTextField();
		T_date = new JTextField();
		T_address = new JTextField();
		T_contact = new JTextField();
		T_id = new JTextField();
		T_pwd = new JTextField();
		btn_create = new JButton("����");
		btn_back = new JButton("���ư���");
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
				L_hospital = new JLabel("�Ҽ� ������ : ");
				L_medical = new JLabel("���� ����� : ");
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
		fmain_user = new JFrame();
		fmain_user.setSize(1000, 700);
		fmain_user.getContentPane().setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
		fmain_user.setLayout(null);
		fmain_user.setVisible(true);
		m_user = new JLabel("[" + data.getU_name() + "��, �ݰ����ϴ�.]");
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
		p_left.setLayout(null);
		Center_p = new Panel();
		fmain_user.add(m_user);
		fmain_user.add(p_left);
		fmain_user.add(p_right);
		btn_prev = new JButton("��");
		btn_next = new JButton("��");
		sun = new JLabel("SUN");
		mon = new JLabel("MON");
		tue = new JLabel("TUE");
		wed = new JLabel("WED");
		thu = new JLabel("THU");
		fri = new JLabel("FRI");
		sat = new JLabel("SAT");
		p_left.add(btn_prev);
		p_left.add(btn_next);
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
		sun.setForeground(Color.white);
		mon.setForeground(Color.white);
		tue.setForeground(Color.white);
		wed.setForeground(Color.white);
		thu.setForeground(Color.white);
		fri.setForeground(Color.white);
		sat.setForeground(Color.white);
		p_left.add(Center_p);
		btn_prev.setBounds(100, 20, 60, 30);
		btn_next.setBounds(380, 20, 60, 30);
		btn_prev.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
		btn_next.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
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
		title_sat.setBackground(Color.blue);;
		btn_Arr = new JButton[42]; // ���ڳ־��ٹ�ư��
		p_left.setBounds(40, 100, 530, 490);
		p_right.setBounds(620, 100, 340, 500);
		Center_p.setBounds(0, 180, 530, 310);//
		p_left.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
		p_right.setBackground(Color.white);
		m_user.setBounds(800, 30, 240, 25);

		// ---------------------[�޷¼���]

		date = Calendar.getInstance();
		L_YearMonth = new JLabel();
		L_YearMonth.setVisible(true);
		L_YearMonth.setBounds(220, 16, 140, 40);

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
		Font YearMonth = new Font("�ٸ��������", Font.BOLD, 24); // �۾� ��Ʈ���� ���� ��ü
		L_YearMonth.setFont(YearMonth);
		Calendar sDay = Calendar.getInstance(); // ������

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
				// ���� ���� Ÿ�� float
			} else {
				btn_Arr[i].setBackground(Color.white);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getActionCommand().contains("ȸ������")) {
			f.hide();
			Tid.setText("");
			Tpwd.setText("");
			Tfd.setText("");
			join_choice();
		} else if (e.getActionCommand().contains("���ư���")) {
			System.out.println("���ư���");
			fjoin.dispose();
			f.show();
		} else if (e.getActionCommand().contains("Ȯ��")) {
			Popup.dispose();
		} else if (e.getActionCommand().contains("����")) {
			String strid = T_id.getText();
			String strpwd = T_pwd.getText();
			String strname = T_name.getText();
			String strdate = T_date.getText();
			String straddress = T_address.getText();
			String strcontact = T_contact.getText();
			Popup = new JDialog(fjoin, "���Ծȳ�", true);
			L_popup1 = new JLabel();
			L_popup2 = new JLabel();
			L_popup3 = new JLabel();
			L_popup4 = new JLabel();
			btn_fjoin_ok = new JButton("Ȯ��");
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

			// ����Ұ�...
			String[] strArr1 = { strid, strpwd, strdate, strname, straddress, strcontact };
			String[] strArr2 = { "���̵� ", "��й�ȣ ", "�̸�", "������� ", "�ּ� ", "����ó " };
			int cnt = 0, k;
			for (k = 0; k < strArr1.length; k++) {
				if (strArr1[k].isEmpty()) {
					L_popup1.setText(L_popup1.getText() + strArr2[k]);
					cnt++;
				}

			}

			// �Ƶ�� �����ҹ��ڿ� ���ڸ� �Է°�����.
			for (int i = 0; i < strid.length(); i++) {
				char ch = strid.charAt(i);
				if ((ch < 'a' || ch > 'z') && (ch < 'A' || ch > 'Z') && (ch < '0' || ch > '9')) {
					if (L_popup1.getText().isEmpty()) {
						L_popup1.setText(L_popup1.getText() + "���̵�� ���� ��ҹ��ڿ� ���ڸ� �Է��� �� �ֽ��ϴ�.");
						T_id.setText("");
						break;
					} else {
						L_popup2.setText(L_popup2.getText() + "���̵�� ���� ��ҹ��ڿ� ���ڸ� �Է��� �� �ֽ��ϴ�.");
						T_id.setText("");
						break;
					}

				}

			}
			// ��������� ���ڸ� �Է� ����
			for (int i = 0; i < strdate.length(); i++) {
				char ch = strdate.charAt(i);
				if (ch < '0' || ch > '9') {
					if (L_popup1.getText().isEmpty()) {
						L_popup1.setText(L_popup1.getText() + "��������� '-'�� ������ ���ڸ� �Է��� �� �ֽ��ϴ�.");
						T_date.setText("");
						break;
					} else if (L_popup2.getText().isEmpty()) {
						L_popup2.setText(L_popup2.getText() + "��������� '-'�� ������ ���ڸ� �Է��� �� �ֽ��ϴ�.");
						T_date.setText("");
						break;
					}
				}
			} //

			if (strdate.length() != 8) {
				if (L_popup1.getText().isEmpty()) {
					L_popup1.setText(L_popup1.getText() + "��������� 8�ڸ��Դϴ�. (ex : 20200602)");
					T_date.setText("");

				} else if (L_popup2.getText().isEmpty()) {
					L_popup2.setText(L_popup2.getText() + "��������� 8�ڸ��Դϴ�. (ex : 20200602)");
					T_date.setText("");

				} else if (L_popup3.getText().isEmpty()) {
					L_popup3.setText(L_popup3.getText() + "��������� 8�ڸ��Դϴ�. (ex : 20200602)");
					T_date.setText("");
				}
			}
			if ((k == strArr1.length) && (cnt != 0)) {
				L_popup1.setText(L_popup1.getText() + "�� ���� ���� �Ұ�");
				Popup.setVisible(true);
			} else if (!L_popup1.getText().isEmpty()) {
				Popup.setVisible(true);
			}
			cnt = 0;

			if (user.getState() == true) {

			} else {

			}
		}
		// -------------------------[�α��� ����]
		if (e.getActionCommand().contains("����")) {
			MemberDAO oct = new MemberDAO();
			if (Tid.getText().isEmpty()) {
				Tfd.setText("  ���̵� �Է����ּ���.");
			} else if (Tpwd.getText().isEmpty()) {
				Tfd.setText("  ��й�ȣ�� �Է����ּ���.");
			} else {
				ArrayList<MemberVo> list = oct.list(Tid.getText());
				MemberVo data = (MemberVo) list.get(0);
				if (data.getU_pwd().equals(Tpwd.getText())) {
					Tid.setText("");
					Tpwd.setText("");
					f.dispose();
					list.clear();
					main_hospital(data);
				} else {
					Tfd.setText("  ���̵�� ��й�ȣ�� Ȯ�����ּ���.");

				}
			}

		}
		if (e.getActionCommand().contains("��")) {
			date.add(Calendar.MONDAY, -1);
		} else if (e.getActionCommand().contains("��")) {
			date.add(Calendar.MONTH, 1);
		}
		setDays(date);
	}
}