import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Main_Doctor {
	JLabel L_YearMonth;
	JButton[] btn_Arr;

	public void main_hospital_doctor(Hospital_Sql_Vo data) {
		JFrame fmain_user = new JFrame(data.getD_hospital() + " [" + data.getD_medical() + "]");
		fmain_user.getContentPane().setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
		fmain_user.setResizable(false);
		fmain_user.setSize(1000, 700);
		fmain_user.setLayout(null);
		fmain_user.setVisible(true);
		fmain_user.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JLabel m_doctor = new JLabel("" + data.getU_name() + "´Ô, ¹Ý°©½À´Ï´Ù.");
		m_doctor.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
		m_doctor.setBounds(740, 30, 240, 25);
		JButton btn_logout = new JButton("[Á¢¼ÓÁ¾·á]");
		btn_logout.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
		btn_logout.setBounds(880, 30, 100, 25);
		btn_logout.setBorderPainted(false);
		btn_logout.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 12));
		JPanel p_right = new JPanel();
		p_right.setLayout(null);
		JPanel right_north = new JPanel();
		right_north.setLayout(null);
		JPanel right_south = new JPanel();
		JLabel J_sun = new JLabel("SUN");
		JLabel J_mon = new JLabel("MON");
		JLabel J_tue = new JLabel("TUE");
		JLabel J_wed = new JLabel("WED");
		JLabel J_thu = new JLabel("THU");
		JLabel J_fri = new JLabel("FRI");
		JLabel J_sat = new JLabel("SAT");
		JPanel sun = new JPanel();
		sun.setLayout(null);
		J_sun.setBounds(16, 10, 40, 25);
		J_sun.setForeground(Color.white);
		J_sun.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 14));
		JPanel mon = new JPanel();
		mon.setLayout(null);
		J_mon.setBounds(12, 10, 40, 25);
		J_mon.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 14));
		J_mon.setForeground(Color.white);
		JPanel tue = new JPanel();
		tue.setLayout(null);
		J_tue.setBounds(14, 10, 40, 25);
		J_tue.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 14));
		J_tue.setForeground(Color.white);
		JPanel wed = new JPanel();
		wed.setLayout(null);
		J_wed.setBounds(14, 10, 40, 25);
		J_wed.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 14));
		J_wed.setForeground(Color.white);
		JPanel thu = new JPanel();
		thu.setLayout(null);
		J_thu.setBounds(14, 10, 40, 25);
		J_thu.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 14));
		J_thu.setForeground(Color.white);
		JPanel fri = new JPanel();
		fri.setLayout(null);
		J_fri.setBounds(18, 10, 40, 25);
		J_fri.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 14));
		J_fri.setForeground(Color.white);
		JPanel sat = new JPanel();
		sat.setLayout(null);
		J_sat.setBounds(16, 10, 40, 25);
		J_sat.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 14));
		J_sat.setForeground(Color.white);
		sun.setBackground(Color.red);
		sun.setBounds(10, 50, 60,40);
		mon.setBackground(Color.gray);
		mon.setBounds(72, 50, 58,40);
		tue.setBackground(Color.gray);
		tue.setBounds(132, 50, 58,40);
		wed.setBackground(Color.gray);
		wed.setBounds(192, 50, 58,40);
		thu.setBackground(Color.gray);
		thu.setBounds(252, 50, 58,40);
		fri.setBackground(Color.gray);
		fri.setBounds(312, 50, 58,40);
		sat.setBackground(Color.blue);
		sat.setBounds(372, 50, 58,40);
		right_south.setLayout(null);
		p_right.setBackground(Color.white);
		p_right.setBounds(510, 80, 440, 360);
		right_north.setBounds(10, 10, 420, 34);
		right_north.setBackground(Color.white);
		right_south.setBounds(10, 100, 420, 250);
		JButton btn_prev = new JButton("¢¸");
		JButton btn_next = new JButton("¢º");
		btn_prev.setBounds(100, 6, 50, 30);
		btn_next.setBounds(280, 6, 50, 30);
		btn_prev.setBackground(Color.white);
		btn_next.setBackground(Color.white);
		btn_prev.setBorderPainted(false);
		btn_next.setBorderPainted(false);
		btn_Arr = new JButton[42]; // ¼ýÀÚ³Ö¾îÁÙ¹öÆ°µé
		fmain_user.add(m_doctor);
		fmain_user.add(btn_logout);
		fmain_user.add(p_right);
		p_right.add(right_south);
		p_right.add(right_north);
		right_north.add(btn_prev);
		right_north.add(btn_next);
		p_right.add(sun);
		p_right.add(mon);
		p_right.add(tue);
		p_right.add(wed);
		p_right.add(thu);
		p_right.add(fri);
		p_right.add(sat);
		sun.add(J_sun);
		mon.add(J_mon);
		tue.add(J_tue);
		wed.add(J_wed);
		thu.add(J_thu);
		fri.add(J_fri);
		sat.add(J_sat);
		// ---------------------------------[´Þ·Â ¼³Á¤]
		Calendar date = Calendar.getInstance();
		L_YearMonth = new JLabel();
		L_YearMonth.setVisible(true);
		L_YearMonth.setBounds(170, 0, 140, 40);

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
		right_north.add(L_YearMonth);
		// ---------------------
		right_south.setLayout(new GridLayout(6, 7));
		for (int i = 0; i < btn_Arr.length; i++) {
			btn_Arr[i] = new JButton("");
			right_south.add(btn_Arr[i]);
			btn_Arr[i].setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 14));
		}
		// ---------------------
		setDays(date);
	}

	public void setDays(Calendar date) {
		Border lineBorder = BorderFactory.createLineBorder(Color.getHSBColor(0.0f, 0.0f, 0.9f), 1);
		int year = date.get(Calendar.YEAR);
		int month = date.get(Calendar.MONTH);
		L_YearMonth.setText(year + " / " + (month + 1));
		Font YearMonth = new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 20); // ±Û¾¾ ÆùÆ®º¯°æ À§ÇÑ °´Ã¼
		L_YearMonth.setFont(YearMonth);
		Calendar sDay = Calendar.getInstance(); // ½ÃÀÛÀÏ

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
				// »ö»ó º¯°æ Å¸ÀÔ float
			} else {
				btn_Arr[i].setBackground(Color.white);
			}
		}
	}

}
