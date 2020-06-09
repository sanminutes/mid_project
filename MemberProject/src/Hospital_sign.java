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
	JFrame fjoin;
	JLabel L_hospital, L_medical, L_idx, L_msg, L_hospitalx, L_medicalx;
	Font btn_nomal;
	JTextField T_id;
	JDialog Popup;
	JButton btn_hospital;

	static JTextField T_hospital;
	static JComboBox<String> T_medical;

	public void join_choice() { // È¸¿ø°¡ÀÔ
		fjoin = new JFrame("º´¿ø Áø·á ¿¹¾à ½Ã½ºÅÛ");
		btn_nomal = new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12);
		fjoin.getContentPane().setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f));
		fjoin.setLayout(null);
		fjoin.setSize(350, 540);
		fjoin.setResizable(false);
		CheckboxGroup group1 = new CheckboxGroup();
		Checkbox doctor = new Checkbox(" ÀÇ»ç", group1, true);
		Checkbox user = new Checkbox(" È¯ÀÚ", group1, true);
		doctor.setFont(btn_nomal);
		user.setFont(btn_nomal);
		JLabel Lmessage1 = new JLabel("[Çù·Â º´¿ø¿¡ ¼Ò¼ÓµÈ ÀÇ»çÀÎ °æ¿ì¸¸ 'ÀÇ»ç'¿¡ Check]");
		JLabel L_id = new JLabel("¾ÆÀÌµð : ");
		L_idx = new JLabel();
		JLabel L_pwd = new JLabel("ºñ¹Ð¹øÈ£ : ");
		JLabel L_pwdx = new JLabel();
		JLabel L_name = new JLabel("ÀÌ¸§ : ");
		JLabel L_namex = new JLabel();
		JLabel L_date = new JLabel("»ý³â¿ùÀÏ : ");
		JLabel L_datex = new JLabel();
		JLabel L_address = new JLabel("ÁÖ¼Ò : ");
		JLabel L_contact = new JLabel("¿¬¶ôÃ³ : ");
		JLabel L_contactx = new JLabel("");
		JTextField T_name = new JTextField();
		JTextField T_date = new JTextField(" ¼ýÀÚ¸¸ ÀÔ·Â°¡´É(ex 20200608)");
		T_date.setForeground(Color.LIGHT_GRAY);
		JTextField T_address = new JTextField();
		JTextField T_contact = new JTextField();
		T_id = new JTextField();
		JTextField T_pwd = new JTextField();
		JButton btn_create = new JButton("°¡ÀÔ");
		JButton btn_back = new JButton("µ¹¾Æ°¡±â");
		Popup = new JDialog(fjoin, "º´¿ø Áø·á ¿¹¾à ½Ã½ºÅÛ", true);
		L_msg = new JLabel();
		JButton ok = new JButton("È®ÀÎ");
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
		L_msg.setBounds(70, 20, 200, 25);
		L_msg.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
		ok.setBounds(100, 60, 60, 25);
		ok.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));

		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Popup.dispose();
				fjoin.dispose();
				Hospital_loginform mt = new Hospital_loginform();
			}

		});
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

		T_date.addFocusListener(new FocusListener() { // »ý³â¿ùÀÏ À¯È¿¼º °Ë»ç

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				T_date.setText("");
				T_date.setForeground(Color.black);
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

				L_datex.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
				L_datex.setForeground(Color.red);
				for (int i = 0; i < T_date.getText().length(); i++) {
					if (T_date.getText().charAt(i) < '0' || T_date.getText().charAt(i) > '9') {
						L_datex.setText("»ý³â¿ùÀÏÀº 8ÀÚ¸®·Î ¼ýÀÚ¸¸ ÀÔ·Â°¡´É");
					} else {
						if (T_date.getText().length() != 8) {
							L_datex.setText("»ý³â¿ùÀÏÀº 8ÀÚ¸®·Î ¼ýÀÚ¸¸ ÀÔ·Â°¡´É");
						} else {
							L_datex.setText("");
						}
					}
				}
				if (T_date.getText().isEmpty()) {
					L_datex.setText("ÇÊ¼ö Ç×¸ñÀÔ´Ï´Ù.");

				}
			}

		});

		T_contact.addFocusListener(new FocusListener() { // ¿¬¶ôÃ³ À¯È¿¼º °Ë»ç

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				L_contactx.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
				L_contactx.setForeground(Color.red);
				for (int i = 0; i < T_contact.getText().length(); i++) {
					if (T_contact.getText().charAt(i) < '0' || T_contact.getText().charAt(i) > '9') {
						L_contactx.setText("¿¬¶ôÃ³´Â -¸¦ Á¦¿ÜÇÑ ¼ýÀÚ¸¸ ÀÔ·Â°¡´É");
					} else {
						if (T_contact.getText().length() < 10 || T_contact.getText().length() > 11) {
							L_contactx.setText("¿¬¶ôÃ³´Â -¸¦ Á¦¿ÜÇÑ ¼ýÀÚ¸¸ ÀÔ·Â°¡´É");
						} else {
							L_contactx.setText("");
						}
					}
				}
				if (T_contact.getText().isEmpty()) {
					L_contactx.setText("ÇÊ¼ö Ç×¸ñÀÔ´Ï´Ù.");

				}
			}

		});

		btn_back.addActionListener(new ActionListener() { // µ¹¾Æ°¡±â
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fjoin.dispose();
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
				if (T_name.getText().isEmpty()) {
					L_namex.setText("ÇÊ¼ö Ç×¸ñÀÔ´Ï´Ù.");
					L_namex.setForeground(Color.red);
					L_namex.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
				}
				if (T_date.getText().equals(" ¼ýÀÚ¸¸ ÀÔ·Â°¡´É(ex 20200608)")) {
					L_datex.setText("ÇÊ¼ö Ç×¸ñÀÔ´Ï´Ù.");
					L_datex.setForeground(Color.red);
					L_datex.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
				}
				if (T_contact.getText().isEmpty()) {
					L_contactx.setText("ÇÊ¼ö Ç×¸ñÀÔ´Ï´Ù.");
					L_contactx.setForeground(Color.red);
					L_contactx.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
				}
				if (group1.getSelectedCheckbox().toString().contains("È¯ÀÚ")) {
					// ¶óµð¿À ¹Ú½º 1¹øÀÌ È¯ÀÚÀÎÁö È®ÀÎÇÏ´Â ÄÚµå

					if (L_idx.getText() == "ÇØ´ç ¾ÆÀÌµð´Â °¡ÀÔ °¡´ÉÇÕ´Ï´Ù." && L_pwdx.getText().isEmpty()
							&& L_namex.getText().isEmpty() && L_datex.getText().isEmpty()
							&& L_contactx.getText().isEmpty()) {
						Hospital_Sql md = new Hospital_Sql();
						if (md.inseruser(T_id.getText(), T_pwd.getText(), T_name.getText(),
								Integer.parseInt(T_date.getText()), T_address.getText(), T_contact.getText()) == true) {
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
							&& L_namex.getText().isEmpty() && L_datex.getText().isEmpty()
							&& L_contactx.getText().isEmpty() && L_hospitalx.getText().isEmpty()
							&& L_medicalx.getText().isEmpty()) {
						System.out.println("¿©±â´Â?");
						Hospital_Sql md = new Hospital_Sql();
						if (md.insertdoctor(T_id.getText(), T_pwd.getText(), T_name.getText(),
								Integer.parseInt(T_date.getText()), T_address.getText(), T_contact.getText(),
								T_hospital.getText(), T_medical.getSelectedItem().toString()) == true) {
							L_msg.setText("È¸¿ø°¡ÀÔÀÌ ¿Ï·áµÇ¾ú½À´Ï´Ù.");
							Popup.setVisible(true);
							Popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						}
					}
				}

			}

		});
		fjoin.setVisible(true);
		fjoin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		doctor.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) { // ÀÇ»ç¿¡ Ã¼Å©ÇÑ °æ¿ì
				// TODO Auto-generated method stub

				L_hospital = new JLabel("¼Ò¼Ó º´¿ø¸í : ");
				L_hospitalx = new JLabel();
				L_medical = new JLabel("Áø·á °ú¸ñ¸í : ");
				L_medicalx = new JLabel();
				Main_User lg = new Main_User();
				T_hospital = new JTextField();
				T_medical = new JComboBox();
				T_medical.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 14));
				System.out.println();
				btn_hospital = new JButton("[°Ë»ö]");
				L_hospital.setFont(btn_nomal);
				L_medical.setFont(btn_nomal);
				btn_hospital.setFont(btn_nomal);
				fjoin.add(T_hospital);
				fjoin.add(T_medical);
				fjoin.add(L_hospital);
				fjoin.add(L_medical);
				fjoin.add(L_hospitalx);
				fjoin.add(L_medicalx);
				fjoin.add(btn_hospital);
				L_hospital.setBounds(40, 360, 100, 25);
				L_hospitalx.setBounds(40, 380, 100, 25);
				L_medical.setBounds(40, 400, 100, 25);
				L_medicalx.setBounds(40, 420, 100, 25);
				T_hospital.setBounds(120, 360, 120, 25);
				T_medical.setBounds(120, 400, 180, 25);
				btn_hospital.setBounds(240, 360, 70, 25);
				btn_hospital.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f));
				btn_hospital.setBorderPainted(false);

				btn_hospital.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Hospital_Sql oct = new Hospital_Sql();
						ArrayList<Hospital_Sql_Vo> hoslist = oct.hoslist(T_hospital.getText());
						Main_User lg = new Main_User();
						lg.find_hospital(hoslist);

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
