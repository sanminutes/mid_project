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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Hospital_sign {
	JFrame f_signup;
	JLabel L_hospital, L_medical, L_idx, L_msg, L_hospitalx, L_medicalx;
	Font btn_nomal;
	JTextField T_id;
	JDialog Popup;
	JButton btn_hospital;
	String date_all, contact_all;

	static JTextField T_hospital;
	static JComboBox<String> T_medical;
	Hospital_Sql HS = new Hospital_Sql();
	Main_User lg = new Main_User();

	public void join_choice() { // È¸¿ø°¡ÀÔ
		// --------------------------------------------------[2. È¸¿ø°¡ÀÔÀ» À§ÇÑ ÇÁ·¹ÀÓ ÀÛ¼º]
		f_signup = new JFrame("º´¿ø Áø·á ¿¹¾à ½Ã½ºÅÛ");
		f_signup.getContentPane().setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f));
		f_signup.setLayout(null);
		f_signup.setSize(400, 540);	
		f_signup.setLocationRelativeTo(null);
		f_signup.setResizable(false);
		// ---------------------------------------------------------------------------
		JLabel Lmessage1 = new JLabel("[Çù·Â º´¿ø¿¡ ¼Ò¼ÓµÈ ÀÇ»çÀÎ °æ¿ì¸¸ 'ÀÇ»ç'¸¦ ¼±ÅÃÇØ ÁÖ½Ê½Ã¿ä.]");
		CheckboxGroup group1 = new CheckboxGroup();
		Checkbox doctor = new Checkbox(" ÀÇ»ç", group1, true);
		Checkbox user = new Checkbox(" È¯ÀÚ", group1, true);
		JLabel L_id = new JLabel("¾ÆÀÌµð : ");
		JLabel L_pwd = new JLabel("ºñ¹Ð¹øÈ£ : ");
		JLabel L_pwd_r = new JLabel("ºñ¹Ð¹øÈ£ È®ÀÎ : ");
		JLabel L_name = new JLabel("ÀÌ¸§ : ");
		JLabel L_date = new JLabel("ÁÖ¹Î¹øÈ£ : ");
		JLabel L_date_c = new JLabel("¦¡");
		JLabel L_contact = new JLabel("ÀüÈ­¹øÈ£ : ");
		JLabel L_contact_a = new JLabel("¦¡");
		JLabel L_contact_b = new JLabel("¦¡");
		// ---------------------------------------------------------------------------
		L_idx = new JLabel();
		JLabel L_pwdx = new JLabel();
		JLabel L_pwd_r_x = new JLabel();
		JLabel L_namex = new JLabel();
		JLabel L_datex = new JLabel();
		JLabel L_contactx = new JLabel();
		// ---------------------------------------------------------------------------
		T_id = new JTextField();
		JTextField T_pwd = new JTextField();
		JTextField T_pwd_r = new JTextField();
		JTextField T_name = new JTextField();
		JTextField T_date_a = new JTextField();
		JTextField T_date_b = new JTextField();
		JComboBox<String> T_contact_A = new JComboBox<String>();
		String[] contact_default = new String[] { "010", "02", "031", "032", "041", "042", "043", "044", "051", "052",
				"053", "054", "055", "061", "062", "063", "064" };
		for (int i = 0; i < contact_default.length; i++) {
			T_contact_A.addItem(contact_default[i]);
		}
		JTextField T_contact_B = new JTextField();
		JTextField T_contact_C = new JTextField();
		// ---------------------------------------------------------------------------
		JButton btn_create = new JButton("°¡ÀÔ");
		JButton btn_back = new JButton("µ¹¾Æ°¡±â");
		// --------------------------------------------------[3. È¸¿ø°¡ÀÔÀ» À§ÇÑ Popup ÇÁ·¹ÀÓ ÀÛ¼º]
		btn_nomal = new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12);
		Popup = new JDialog(f_signup, "º´¿ø Áø·á ¿¹¾à ½Ã½ºÅÛ", true);
		Popup.setLayout(null);
		L_msg = new JLabel();
		JButton ok = new JButton("È®ÀÎ");

		btn_create.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f));
		btn_back.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f));
		doctor.setFont(btn_nomal);
		user.setFont(btn_nomal);
		btn_create.setFont(btn_nomal);
		btn_back.setFont(btn_nomal);
		Lmessage1.setFont(btn_nomal);
		L_id.setFont(btn_nomal);
		L_pwd.setFont(btn_nomal);
		L_pwd_r.setFont(btn_nomal);
		L_name.setFont(btn_nomal);
		L_date.setFont(btn_nomal);
		L_contact.setFont(btn_nomal);
		L_contact_a.setFont(btn_nomal);
		L_contact_b.setFont(btn_nomal);
		L_msg.setFont(btn_nomal);
		L_date_c.setFont(btn_nomal);
		L_contact_a.setFont(btn_nomal);
		L_contact_b.setFont(btn_nomal);
		T_contact_A.setFont(btn_nomal);
		T_contact_B.setFont(btn_nomal);
		T_contact_C.setFont(btn_nomal);
		Lmessage1.setBounds(40, 40, 320, 25);
		doctor.setBounds(120, 80, 60, 25);
		user.setBounds(240, 80, 60, 25);
		L_id.setBounds(40, 120, 60, 25);
		L_idx.setBounds(40, 140, 300, 25);
		L_pwd.setBounds(40, 160, 60, 25);
		L_pwdx.setBounds(40, 180, 300, 25);
		L_pwd_r.setBounds(40, 200, 100, 25);
		L_pwd_r_x.setBounds(40, 220, 300, 25);
		L_name.setBounds(40, 240, 60, 25);
		L_namex.setBounds(40, 260, 300, 25);
		L_date.setBounds(40, 280, 60, 25);
		L_date_c.setBounds(224, 280, 20, 25);
		L_datex.setBounds(40, 300, 300, 25);
		L_contact.setBounds(40, 320, 60, 25);
		L_contact_a.setBounds(186, 320, 20, 25);
		L_contact_b.setBounds(270, 320, 20, 25);
		L_contactx.setBounds(40, 340, 300, 25);
		T_id.setBounds(120, 120, 230, 25);
		T_pwd.setBounds(120, 160, 230, 25);
		T_pwd_r.setBounds(120, 200, 230, 25);
		T_name.setBounds(120, 240, 230, 25);
		T_date_a.setBounds(120, 280, 90, 25);
		T_date_b.setBounds(250, 280, 100, 25);
		T_contact_A.setBounds(120, 320, 60, 25);
		T_contact_B.setBounds(205, 320, 60, 25);
		T_contact_C.setBounds(290, 320, 60, 25);
		btn_create.setBounds(40, 450, 120, 25);
		btn_back.setBounds(230, 450, 120, 25);
		L_msg.setBounds(70, 20, 200, 25);
		ok.setBounds(100, 60, 60, 25);
		ok.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));

		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Popup.dispose();
				f_signup.dispose();
				Hospital_loginform mt = new Hospital_loginform();
			}

		});
		Popup.setSize(300, 150);
		Popup.setLocationRelativeTo(null);

		f_signup.add(doctor);
		f_signup.add(user);
		f_signup.add(L_name);
		f_signup.add(L_date);
		f_signup.add(L_date_c);
		f_signup.add(L_pwd_r);
		f_signup.add(L_pwd_r_x);
		f_signup.add(L_contact);
		f_signup.add(L_contact_a);
		f_signup.add(L_contact_b);
		f_signup.add(L_contactx);
		f_signup.add(Lmessage1);
		f_signup.add(L_id);
		f_signup.add(L_pwd);
		f_signup.add(T_id);
		f_signup.add(T_pwd);
		f_signup.add(T_pwd_r);
		f_signup.add(T_name);
		f_signup.add(T_date_a);
		f_signup.add(T_date_b);
		f_signup.add(T_contact_A);
		f_signup.add(T_contact_B);
		f_signup.add(T_contact_C);
		f_signup.add(L_idx);
		f_signup.add(L_pwdx);
		f_signup.add(L_namex);
		f_signup.add(L_datex);

		f_signup.add(btn_create);
		f_signup.add(btn_back);
		Popup.add(L_msg);
		Popup.add(ok);

		T_id.addFocusListener(new FocusListener() { // ¾ÆÀÌµð À¯È¿¼º °Ë»ç
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				L_idx.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
				L_idx.setForeground(Color.red);

				for (int i = 0; i < T_id.getText().length(); i++) {
					if ((T_id.getText().charAt(i) < 'a' || T_id.getText().charAt(i) > 'z')
							&& (T_id.getText().charAt(i) < '0' || T_id.getText().charAt(i) > '9')) {
						L_idx.setText("5~20ÀÚÀÇ ¿µ¹® ¼Ò¹®ÀÚ, ¼ýÀÚ¸¸ »ç¿ë °¡´É.");
					} else {
						if (T_id.getText().length() < 5 || T_id.getText().length() > 20) {
							L_idx.setText("5~20ÀÚÀÇ ¿µ¹® ¼Ò¹®ÀÚ, ¼ýÀÚ¸¸ »ç¿ë °¡´É.");
						} else {
							if (i == T_id.getText().length() - 1) {
								Hospital_Sql dao = new Hospital_Sql();
								ArrayList<Hospital_Sql_Vo> list = dao.list(T_id.getText());
								if (list.size() == 0) {
									L_idx.setText("ÇØ´ç ¾ÆÀÌµð´Â °¡ÀÔ °¡´ÉÇÕ´Ï´Ù.");
									L_idx.setForeground(Color.blue);
								} else {
									L_idx.setText("ÇØ´ç ¾ÆÀÌµð´Â °¡ÀÔÇÒ ¼ö ¾ø½À´Ï´Ù.");
								}
							}
						}
					}
				}

				if (T_id.getText().isEmpty()) {
					L_idx.setText("ÇÊ¼ö Ç×¸ñÀÔ´Ï´Ù.");
				} else {

				}

			}
		});

		T_pwd.addFocusListener(new FocusListener() { // ºñ¹Ð¹øÈ£ À¯È¿¼º °Ë»ç

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent e) {
				L_pwdx.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
				L_pwdx.setForeground(Color.red);
				// TODO Auto-generated method stub
				if (T_pwd.getText().length() < 8 || T_pwd.getText().length() > 16) {
					L_pwdx.setText("8~16ÀÚ ¿µ¹® ´ë ¼Ò¹®ÀÚ, ¼ýÀÚ, Æ¯¼ö¹®ÀÚ¸¸ »ç¿ë °¡´É");
				} else {
					L_pwdx.setText("");
				}

				if (T_pwd.getText().isEmpty()) {
					L_pwdx.setText("ÇÊ¼ö Ç×¸ñÀÔ´Ï´Ù.");
				}
			}

		});
		T_pwd_r.addFocusListener(new FocusListener() { // ºñ¹Ð¹øÈ£ À¯È¿¼º °Ë»ç

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent e) {
				L_pwd_r_x.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
				L_pwd_r_x.setForeground(Color.red);
				// TODO Auto-generated method stub
				if (!T_pwd.getText().equals(T_pwd_r.getText())) {
					L_pwd_r_x.setText("ºñ¹Ð¹øÈ£°¡ µ¿ÀÏÇÏÁö ¾Ê½À´Ï´Ù.");
				} else {
					L_pwd_r_x.setText("");
				}
			}

		});

		T_name.addFocusListener(new FocusListener() { // ÀÌ¸§ À¯È¿¼º °Ë»ç

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				L_namex.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
				L_namex.setForeground(Color.red);
				for (int i = 0; i < T_name.getText().length(); i++) {
					if (T_name.getText().charAt(i) < '°¡' || T_name.getText().charAt(i) > 'ÆR') {
						L_namex.setText("ÇÑ±Û¸¸ ÀÔ·Â°¡´É(Æ¯¼ö±âÈ£, °ø¹é »ç¿ë ºÒ°¡)");
					} else {
						L_namex.setText("");
					}
				}
				if (T_name.getText().isEmpty()) {
					L_namex.setText("ÇÊ¼ö Ç×¸ñÀÔ´Ï´Ù.");

				}
			}

		});

		T_date_a.addFocusListener(new FocusListener() { // »ý³â¿ùÀÏ À¯È¿¼º °Ë»ç

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				L_datex.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
				L_datex.setForeground(Color.red);
				String A = T_date_a.getText();
				if (!A.isEmpty()) {
					for (int i = 0; i < A.length(); i++) {
						char ch = A.charAt(i);
						if ((ch < '0' || ch > '9') || (A.length() != 6)) {
							T_date_a.setText("");
							L_datex.setText("ÁÖ¹Î¹øÈ£ ¾ÕÀÚ¸®´Â 6ÀÚ¸®ÀÇ ¼ýÀÚÀÔ´Ï´Ù.");
						} else {
							L_datex.setText("");
						}
					}
				} else {
					L_datex.setText("ÇÊ¼ö Ç×¸ñÀÔ´Ï´Ù");
				}

			}

		});
		T_date_b.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				L_datex.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
				L_datex.setForeground(Color.red);
				String A = T_date_b.getText();
				if (!A.isEmpty()) {
					for (int i = 0; i < A.length(); i++) {
						char ch = A.charAt(i);
						if ((ch < '0' || ch > '9') || (A.length() != 7)) {
							T_date_b.setText("");
							L_datex.setText("ÁÖ¹Î¹øÈ£ µÞÀÚ¸®´Â 7ÀÚ¸®ÀÇ ¼ýÀÚÀÔ´Ï´Ù.");
						} else {
							L_datex.setText("");
						}
					}
				} else {
					L_datex.setText("ÇÊ¼ö Ç×¸ñÀÔ´Ï´Ù.");
				}
			}

		});
		T_contact_B.addFocusListener(new FocusListener() { // ¿¬¶ôÃ³ À¯È¿¼º °Ë»ç

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				L_contactx.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
				L_contactx.setForeground(Color.red);
				String A = T_contact_B.getText();
				if (!A.isEmpty()) {
					for (int i = 0; i < A.length(); i++) {
						char ch = A.charAt(i);
						if ((ch < '0' || ch > '9') || (A.length() != 4)) {
							T_contact_B.setText("");
							L_contactx.setText("ÀüÈ­¹øÈ£´Â 8ÀÚ¸®ÀÇ ¼ýÀÚÀÔ´Ï´Ù. (Áö¿ª¹øÈ£ Á¦¿Ü)");
						} else {
							L_contactx.setText("");
						}
					}
				} else {
					L_contactx.setText("ÇÊ¼ö Ç×¸ñÀÔ´Ï´Ù.");

				}
			}

		});
		T_contact_C.addFocusListener(new FocusListener() { // ¿¬¶ôÃ³ À¯È¿¼º °Ë»ç

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				L_contactx.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
				L_contactx.setForeground(Color.red);
				String A = T_contact_C.getText();
				if (!A.isEmpty()) {
					for (int i = 0; i < A.length(); i++) {
						char ch = A.charAt(i);
						if ((ch < '0' || ch > '9') || (A.length() != 4)) {
							T_contact_C.setText("");
							L_contactx.setText("ÀüÈ­¹øÈ£´Â 8ÀÚ¸®ÀÇ ¼ýÀÚÀÔ´Ï´Ù. (Áö¿ª¹øÈ£ Á¦¿Ü)");
						} else {
							L_contactx.setText("");
						}
					}
				} else {
					L_contactx.setText("ÇÊ¼ö Ç×¸ñÀÔ´Ï´Ù.");

				}
			}

		});
		btn_back.addActionListener(new ActionListener() { // µ¹¾Æ°¡±â

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				f_signup.dispose();
				Hospital_loginform MT = new Hospital_loginform();
			}

		});
		btn_create.addActionListener(new ActionListener() { // °¡ÀÔ ¹öÆ°

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// ¾ÆÀÌµð Á¦¾àÁ¶°Ç
				if (T_id.getText().isEmpty()) {
					L_idx.setText("ÇÊ¼ö Ç×¸ñÀÔ´Ï´Ù.");
					L_idx.setForeground(Color.red);
					L_idx.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
				}
				if (T_pwd.getText().isEmpty()) {
					L_pwdx.setText("ÇÊ¼ö Ç×¸ñÀÔ´Ï´Ù.");
					L_pwdx.setForeground(Color.red);
					L_pwdx.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
				}
				if (T_pwd_r.getText().isEmpty()) {
					L_pwd_r_x.setText("ÇÊ¼ö Ç×¸ñÀÔ´Ï´Ù.");
					L_pwd_r_x.setForeground(Color.red);
					L_pwd_r_x.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
				}
				if (T_name.getText().isEmpty()) {
					L_namex.setText("ÇÊ¼ö Ç×¸ñÀÔ´Ï´Ù.");
					L_namex.setForeground(Color.red);
					L_namex.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
				}
				if (T_date_a.getText().isEmpty()) {
					L_datex.setText("ÇÊ¼ö Ç×¸ñÀÔ´Ï´Ù.");
					L_datex.setForeground(Color.red);
					L_datex.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
				}
				if (T_date_b.getText().isEmpty()) {
					L_datex.setText("ÇÊ¼ö Ç×¸ñÀÔ´Ï´Ù.");
					L_datex.setForeground(Color.red);
					L_datex.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
				}
				if (T_contact_B.getText().isEmpty()) {
					L_contactx.setText("ÇÊ¼ö Ç×¸ñÀÔ´Ï´Ù.");
					L_contactx.setForeground(Color.red);
					L_contactx.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
				}
				if (T_contact_C.getText().isEmpty()) {
					L_contactx.setText("ÇÊ¼ö Ç×¸ñÀÔ´Ï´Ù.");
					L_contactx.setForeground(Color.red);
					L_contactx.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
				}
				date_all = T_date_a.getText() + "-" + T_date_b.getText(); // ÁÖ¹Î¹øÈ£ ¾Õ+µÞÀÚ¸® (13)
				contact_all = T_contact_A.getSelectedItem().toString() + "-" + T_contact_B.getText() + "-"
						+ T_contact_C.getText();
				if (group1.getSelectedCheckbox().toString().contains("È¯ÀÚ")) {
					// ¶óµð¿À ¹Ú½º 1¹øÀÌ È¯ÀÚÀÎÁö È®ÀÎÇÏ´Â ÄÚµå

					if (L_idx.getText() == "ÇØ´ç ¾ÆÀÌµð´Â °¡ÀÔ °¡´ÉÇÕ´Ï´Ù." && L_pwdx.getText().isEmpty()
							&& L_pwd_r_x.getText().isEmpty() && L_namex.getText().isEmpty()
							&& L_datex.getText().isEmpty() && L_contactx.getText().isEmpty()) {
						if (HS.insertuser(T_id.getText(), T_pwd.getText(), T_name.getText(), date_all,
								contact_all) == true) {
							L_msg.setText("È¸¿ø°¡ÀÔÀÌ ¿Ï·áµÇ¾ú½À´Ï´Ù.");
							Popup.setVisible(true);
							Popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

						}
					}
				} else if (group1.getSelectedCheckbox().toString().contains("ÀÇ»ç")) {
					// ¶óµð¿À ¹Ú½º 2¹øÀÌ ÀÇ»çÀÎÁö È®ÀÎÇÏ´Â ÄÚµå

					if (T_hospital.getText().isEmpty()) {
						L_hospitalx.setText("ÇÊ¼ö Ç×¸ñÀÔ´Ï´Ù.");
						L_hospitalx.setForeground(Color.red);
						L_hospitalx.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
					}
					T_hospital.addFocusListener(new FocusListener() {

						@Override
						public void focusGained(FocusEvent e) {
							// TODO Auto-generated method stub

						}

						@Override
						public void focusLost(FocusEvent e) {
							// TODO Auto-generated method stub
							if (!T_hospital.getText().isEmpty()) {
								L_hospitalx.setText("");
							}
						}

					});

					if (L_idx.getText() == "ÇØ´ç ¾ÆÀÌµð´Â °¡ÀÔ °¡´ÉÇÕ´Ï´Ù." && L_pwdx.getText().isEmpty()
							&& L_pwd_r_x.getText().isEmpty() && L_namex.getText().isEmpty()
							&& L_datex.getText().isEmpty() && L_contactx.getText().isEmpty()
							&& L_hospitalx.getText().isEmpty() && L_medicalx.getText().isEmpty()) {
						if (HS.insertdoctor(T_id.getText(), T_pwd.getText(), T_name.getText(), date_all, contact_all,
								T_hospital.getText(), T_medical.getSelectedItem().toString()) == true) {
							L_msg.setText("È¸¿ø°¡ÀÔÀÌ ¿Ï·áµÇ¾ú½À´Ï´Ù.");
							Popup.setVisible(true);
							Popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						}
					}
				}

			}

		});
		f_signup.setVisible(true);
		f_signup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		doctor.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) { // ÀÇ»ç¿¡ Ã¼Å©ÇÑ °æ¿ì
				// TODO Auto-generated method stub

				L_hospital = new JLabel("¼Ò¼Ó º´¿ø¸í : ");
				L_hospitalx = new JLabel();
				L_medical = new JLabel("Áø·á °ú¸ñ¸í : ");
				L_medicalx = new JLabel();
				T_hospital = new JTextField();
				T_hospital.setEditable(false);
				T_medical = new JComboBox();
				T_medical.addItem("¸ÕÀú º´¿øÀ» ¼±ÅÃÇÏ¼¼¿ä");
				T_medical.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
				btn_hospital = new JButton("[°Ë»ö]");
				L_hospital.setFont(btn_nomal);
				L_medical.setFont(btn_nomal);
				btn_hospital.setFont(btn_nomal);
				f_signup.add(T_hospital);
				f_signup.add(T_medical);
				f_signup.add(L_hospital);
				f_signup.add(L_medical);
				f_signup.add(L_hospitalx);
				f_signup.add(L_medicalx);
				f_signup.add(btn_hospital);
				L_hospital.setBounds(40, 360, 100, 25);
				L_hospitalx.setBounds(40, 380, 100, 25);
				L_medical.setBounds(40, 400, 100, 25);
				L_medicalx.setBounds(40, 420, 100, 25);
				T_hospital.setBounds(120, 360, 170, 25);
				T_medical.setBounds(120, 400, 230, 25);
				btn_hospital.setBounds(290, 360, 70, 25);
				btn_hospital.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f));
				btn_hospital.setBorderPainted(false);
				btn_hospital.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						ArrayList<Hospital_Sql_Vo> hoslist = HS.hoslist(T_hospital.getText());
						lg.find_hospital(1);

					}

				});
			}
		});
		user.addItemListener(new ItemListener() { // È¯ÀÚ¿¡ Ã¼Å©ÇÑ °æ¿ì
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				L_hospital.hide();
				L_medical.hide();
				T_hospital.hide();
				T_medical.hide();
				L_hospitalx.hide();
				L_medicalx.hide();
				btn_hospital.hide();

			}
		});
	}
}
