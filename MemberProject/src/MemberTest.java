import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

public class MemberTest extends WindowAdapter implements ActionListener {
	Frame f, fjoin, fmain_user;
	Button btn_login, btn_join, btn_find, btn_create, btn_back, btn_fjoin_ok, btn_prev, btn_next;
	Button[] btn_Arr;
	TextField Tfd, Tid, Tpwd, T_hospital, T_medical, T_name, T_date, T_address, T_contact, T_id, T_pwd;
	Label Lid, Lpwd, L_hospital, L_medical, L_name, L_date, L_address, L_contact, L_id, L_pwd, L_popup1, L_popup2,
			L_popup3, L_popup4, m_user, L_YearMonth;
	Image img;
	Dialog Popup;
	Checkbox doctor, user;
	Calendar date = Calendar.getInstance();

	MemberTest() {
		f = new Frame("���� ���� ���� �ý���");
		f.setSize(350, 500);
		f.setBackground(Color.getHSBColor(0, 0, 40));
		f.setLayout(null);
		f.setResizable(false); // âũ�����

		Lid = new Label("���̵� :");
		Lpwd = new Label("��й�ȣ : ");

		Tfd = new TextField(46);
		Tid = new TextField(20);
		Tpwd = new TextField(20);
		btn_login = new Button("����");
		btn_join = new Button("ȸ������");
		btn_find = new Button("���̵�/��й�ȣã��");
		btn_create = new Button("����");
		btn_back = new Button("���");

		Lid.setBounds(52, 315, 45, 25);
		Lpwd.setBounds(40, 345, 60, 25);
		Tid.setBounds(100, 315, 140, 25);
		Tpwd.setBounds(100, 345, 140, 25);
		btn_login.setBounds(250, 312, 50, 60);
		btn_join.setBounds(60, 390, 80, 25);
		btn_find.setBounds(160, 390, 140, 25);
		Tfd.setBounds(20, 460, 310, 25);// x, y, w,h

		Tfd.setEditable(false); // �ؽ�Ʈ�ʵ忡 �Է¸���
		f.add(Lid);
		f.add(Tid);
		f.add(Lpwd);
		f.add(Tpwd);
		f.add(btn_login);
		f.add(Tfd);
		f.add(btn_join);
		f.add(btn_find);
		btn_login.addActionListener(this);
		btn_join.addActionListener(this);

		f.setVisible(true); // â�� ȭ�鿡 ��Ÿ�� ������ ����

	}

	public static void main(String args[]) {
		MemberTest ff = new MemberTest();

	}

	public void join_choice() {
		fjoin = new Frame("���� ���� ���� �ý���");
		fjoin.setBackground(Color.getHSBColor(0, 0, 40));
		fjoin.setLayout(null);
		fjoin.setSize(350, 540);
		fjoin.setResizable(false);
		CheckboxGroup group1 = new CheckboxGroup();
		doctor = new Checkbox(" �ǻ�", group1, true);
		user = new Checkbox(" ȯ��", group1, true);

		Label Lmessage1 = new Label("[���� ������ �Ҽӵ� �ǻ��� ��츸 '�ǻ�'�� Check]");
		L_id = new Label("���̵� : ");
		L_pwd = new Label("��й�ȣ : ");
		L_name = new Label("�̸� : ");
		L_date = new Label("������� : ");
		L_address = new Label("�ּ� : ");
		L_contact = new Label("����ó : ");
		T_name = new TextField();
		T_date = new TextField();
		T_address = new TextField();
		T_contact = new TextField();
		T_id = new TextField();
		T_pwd = new TextField();
		btn_create = new Button("����");
		btn_back = new Button("���ư���");

		doctor.setBounds(52, 90, 60, 25);
		user.setBounds(120, 90, 60, 25);
		Lmessage1.setBounds(40, 60, 320, 25);
		L_id.setBounds(40, 160, 60, 25);
		L_pwd.setBounds(40, 200, 60, 25);
		L_name.setBounds(40, 240, 60, 25);
		L_date.setBounds(40, 280, 60, 25);
		L_address.setBounds(40, 320, 60, 25);
		L_contact.setBounds(40, 360, 60, 25);
		T_id.setBounds(120, 160, 180, 25);
		T_pwd.setBounds(120, 200, 180, 25);
		T_name.setBounds(120, 240, 180, 25);
		T_date.setBounds(120, 280, 180, 25);
		T_address.setBounds(120, 320, 180, 25);
		T_contact.setBounds(120, 360, 180, 25);
		btn_create.setBounds(40, 480, 120, 25);
		btn_back.setBounds(180, 480, 120, 25);
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
				L_hospital = new Label("�Ҽ� ������ : ");
				L_medical = new Label("���� ����� : ");
				T_hospital = new TextField();
				T_medical = new TextField();
				fjoin.add(T_hospital);
				fjoin.add(T_medical);
				fjoin.add(L_hospital);
				fjoin.add(L_medical);
				L_hospital.setBounds(40, 400, 100, 25);
				L_medical.setBounds(40, 440, 100, 25);
				T_hospital.setBounds(120, 400, 180, 25);
				T_medical.setBounds(120, 440, 180, 25);
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
		fmain_user = new Frame();
		fmain_user.setSize(1000, 800);
		fmain_user.setBackground(Color.getHSBColor(0, 0, 40));
		fmain_user.setLayout(null);
		fmain_user.setVisible(true);
		m_user = new Label("[" + data.getU_name() + "��, �ݰ����ϴ�.]");
		Panel p_left = new Panel();
		Panel p_right = new Panel();
		Panel left_p = new Panel();
		Panel North_p = new Panel();
		Panel Center_p = new Panel();
		p_left.setVisible(true);
		p_right.setVisible(true);
		left_p.setVisible(true);
		North_p.setVisible(true);
		left_p.setLayout(null);
		Center_p = new Panel();
		fmain_user.add(m_user);
		fmain_user.add(p_left);
		fmain_user.add(p_right);
		btn_prev = new Button("��");
		btn_next = new Button("��");
		left_p.add(btn_prev);
		left_p.add(btn_next);
		p_left.add(left_p);
		left_p.add(North_p);
		left_p.add(Center_p);
		btn_prev.setBounds(100, 100, 40, 40);
		btn_next.setBounds(390, 100, 40, 40);
		btn_Arr = new Button[42]; // ���ڳ־��ٹ�ư��
		p_left.setBounds(40, 100, 540, 500);
		p_right.setBounds(620, 100, 340, 500);
		left_p.setBounds(0, 0, 530, 490);
		North_p.setBounds(0, 0, 530, 60);
		Center_p.setBounds(0, 180, 530, 310);//
		p_left.setBackground(Color.yellow);
		p_right.setBackground(Color.white);
		left_p.setBackground(Color.white);
		North_p.setBackground(Color.yellow);
		m_user.setBounds(820, 60, 240, 25);


		// ---------------------[�޷¼���]

		date = Calendar.getInstance();
		L_YearMonth = new Label();
		L_YearMonth.setVisible(true);
		L_YearMonth.setBounds(200, 100, 120, 40);

		btn_prev.addActionListener(this);
		btn_next.addActionListener(this);

		left_p.add(L_YearMonth);
		// ---------------------
		Center_p.setLayout(new GridLayout(6, 7));
		for (int i = 0; i < btn_Arr.length; i++) {
			btn_Arr[i] = new Button("");
			Center_p.add(btn_Arr[i]);
		}
		// ---------------------

	}

	public void setDays(Calendar date) {
		int year = date.get(Calendar.YEAR);
		int month = date.get(Calendar.MONTH);

		L_YearMonth.setText(year + "�� " + (month + 1) + "��");
		Font YearMonth = new Font("", Font.BOLD, 24); // �۾� ��Ʈ���� ���� ��ü
		L_YearMonth.setFont(YearMonth);
		Calendar sDay = Calendar.getInstance(); // ������

		sDay.set(year, month, 1);
		sDay.add(Calendar.DATE, -sDay.get(Calendar.DAY_OF_WEEK) + 1);

		for (int i = 0; i < btn_Arr.length; i++, sDay.add(Calendar.DATE, 1)) {
			int day = sDay.get(Calendar.DATE);
			btn_Arr[i].setLabel(day + "");
			System.out.println(day);

			if (sDay.get(Calendar.MONTH) != month) {
				btn_Arr[i].setBackground(Color.lightGray);
			} else {
				btn_Arr[i].setBackground(Color.getHSBColor(0, 20, 40));
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
			Popup = new Dialog(fjoin, "���Ծȳ�", true);
			L_popup1 = new Label();
			L_popup2 = new Label();
			L_popup3 = new Label();
			L_popup4 = new Label();
			btn_fjoin_ok = new Button("Ȯ��");
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
				Tfd.setText("���̵� �Է����ּ���.");
			} else if (Tpwd.getText().isEmpty()) {
				Tfd.setText("��й�ȣ�� �Է����ּ���.");
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
					Tfd.setText("���̵�� ��й�ȣ�� Ȯ�����ּ���.");

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