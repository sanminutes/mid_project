import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Main_User implements ActionListener {
	JButton[] btn_Arr;
	Font btn_nomal;
	JLabel L_YearMonth;
	String result_h, result_i, result_name, result_address, h_medical, tmp;
	String[] date_Arr;
	JTextField hospital, date_2, disease;
	JComboBox<String> doctor, medical, date_3;
	int year, month, A, B;
	JTable table;
	JScrollPane Scroll;
	JPanel P, right_2;
	Hospital_Sql HS = new Hospital_Sql();
	Vector<String> userColumn = new Vector<String>();
	DefaultTableModel model;
	SimpleDateFormat d_time;
	long systemTime;
	int restr, d_number;
	boolean checkP, checkP2;

	public void main_hospital_user(Hospital_Sql_Vo data) { // 로그인 성공시
		JFrame fmain_user = new JFrame("병원 진료 예약 시스템");
		btn_nomal = new Font("나눔바른고딕", Font.PLAIN, 12);
		fmain_user.setResizable(false);
		fmain_user.setSize(1050, 700);
		fmain_user.setLocationRelativeTo(null);
		fmain_user.getContentPane().setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
		fmain_user.setLayout(null);
		fmain_user.setVisible(true);
		fmain_user.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JLabel m_user = new JLabel("" + data.getA() + "님, 반갑습니다.");
		m_user.setFont(btn_nomal);
		JPanel p_left = new JPanel();
		JPanel p_right = new JPanel();
		JPanel Center_p = new JPanel();
		JPanel title_sun = new JPanel();
		JPanel title_mon = new JPanel();
		JPanel title_tue = new JPanel();
		JPanel title_wed = new JPanel();
		JPanel title_thu = new JPanel();
		JPanel title_fri = new JPanel();
		JPanel title_sat = new JPanel();
		JLabel y_title = new JLabel("[예약 정보 입력란]");
		JLabel y_name = new JLabel("이름 :");
		JLabel y_date = new JLabel("생년월일 :");
		JLabel y_contact = new JLabel("연락처 :");
		JLabel y_hospital = new JLabel("병원명 :");
		JLabel y_medical = new JLabel("진료 과목 :");
		JLabel y_date_2 = new JLabel("예약 시간 :");
		JLabel y_doctor = new JLabel("담당 의사 :");
		JLabel y_date3 = new JLabel("예약 날짜 :");
		JLabel y_disease = new JLabel("증상기재 :");
		JButton btn_myinfo = new JButton();
		btn_myinfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame user_info = new JFrame("병원 예약 관리 시스템");
				user_info.setLayout(null);
				user_info.setSize(600, 300);
				user_info.setLocationRelativeTo(null);
				user_info.setVisible(true);
				user_info.setResizable(false);
				JButton my_info = new JButton("비밀번호 변경");
				JLabel line = new JLabel("──────────");
				JButton my_schedule = new JButton("예약 조회");
				JButton schedule_find = new JButton("이전 예약 조회");
				user_info.add(my_info);
				user_info.add(line);
				user_info.add(my_schedule);
				user_info.add(schedule_find);
				my_info.setBounds(20, 60, 120, 25);
				line.setBounds(20, 90, 160, 25);
				my_schedule.setBounds(20, 120, 120, 25);
				schedule_find.setBounds(20, 150, 120, 25);
				my_info.setBorderPainted(false);
				my_info.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.94f));
				my_info.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
				line.setForeground(Color.white);
				my_schedule.setBorderPainted(false);
				my_schedule.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.94f));
				my_schedule.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
				schedule_find.setBorderPainted(false);
				schedule_find.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.94f));
				schedule_find.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
				JPanel right = new JPanel();
				right.setBackground(Color.white);
				user_info.add(right);
				right.setBounds(160, 22, 400, 220);
				right.setLayout(null);
				JLabel msg = new JLabel("좌측에서 원하시는 메뉴를 선택하세요.");
				msg.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
				right.add(msg);
				msg.setBounds(110, 100, 260, 25);
				my_info.addActionListener(new ActionListener() { // 비밀번호 변경
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						msg.setVisible(false);
						A = 1;
						if (B == 0) {
							right.setVisible(true);
						} else {
							right_2.setVisible(false);
							right.setVisible(true);
						}
						JLabel id = new JLabel("아이디 :");
						JLabel pwd = new JLabel("현재 비밀번호 :");
						JLabel r_pwd = new JLabel("변경 비밀번호 :");
						JLabel r_pwd2 = new JLabel("비밀번호 확인");
						JTextField id_x = new JTextField(data.getD());
						JTextField pwd_x = new JTextField();
						JTextField r_pwd_x = new JTextField();
						JTextField r_pwd2_x = new JTextField();
						JButton ok = new JButton("변경");
						right.add(id);
						right.add(pwd);
						right.add(r_pwd);
						right.add(r_pwd2);
						right.add(id_x);
						right.add(pwd_x);
						right.add(r_pwd_x);
						right.add(r_pwd2_x);
						right.add(ok);
						id.setBounds(50, 20, 100, 25);
						pwd.setBounds(50, 60, 100, 25);
						r_pwd.setBounds(50, 100, 100, 25);
						r_pwd2.setBounds(50, 140, 100, 25);
						id_x.setBounds(160, 20, 200, 25);
						pwd_x.setBounds(160, 60, 200, 25);
						r_pwd_x.setBounds(160, 100, 200, 25);
						r_pwd2_x.setBounds(160, 140, 200, 25);
						ok.setBounds(280, 180, 80, 25);
						id.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
						pwd.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
						r_pwd.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
						r_pwd2.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
						id_x.setEditable(false);
						ok.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.94f));
						ok.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
						ok.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								JDialog warning = new JDialog(user_info, "확인", true);
								JLabel msg = new JLabel();
								msg.setFont(new Font("나눔바른고딕",Font.PLAIN,14));
								warning.setLayout(null);
								msg.setBounds(38, 40, 360, 25);
								warning.setSize(400, 140);
								warning.setLocationRelativeTo(null);
								warning.add(msg);
								ArrayList<Hospital_Sql_Vo> list = HS.list(id_x.getText());
								Hospital_Sql_Vo data = (Hospital_Sql_Vo) list.get(0);
								if (pwd_x.getText().isEmpty() || r_pwd_x.getText().isEmpty()
										|| r_pwd2_x.getText().isEmpty()) {
									msg.setText("8~16자 영문 대 소문자, 숫자, 특수문자만 사용 가능합니다.");
									warning.setVisible(true);
								} else if (!r_pwd_x.getText().equals(r_pwd2_x.getText())) {
									msg.setText("변경하실 비밀번호를 확인하시고 입력해주시기 바랍니다.");
									r_pwd_x.setText("");
									r_pwd2_x.setText("");
									warning.setVisible(true);
								} else if (!data.getE().equals(pwd_x.getText())) {
									msg.setText("현재 비밀번호가 올바르지 않으므로 확인해주시기 바랍니다.");
									pwd_x.setText("");
									warning.setVisible(true);
								} else if (data.getE().equals(r_pwd_x.getText())) {
									msg.setText("현재 비밀번호와 같은 비밀번호로는 변경이 불가능합니다.");
									r_pwd_x.setText("");
									r_pwd2_x.setText("");
									warning.setVisible(true);
								} else { // 조건에 다 맞을때
									if (HS.update_pwd(id_x.getText(), data.getE(), r_pwd_x.getText()) == true) {
										System.out.println("ㅇㅇㅇㅇ?");
										JDialog ok_in = new JDialog(user_info, "변경 안내", true);
										JLabel ok_in_l = new JLabel("변경이 완료 되었습니다.");
										JButton ok_in_btn = new JButton("확인");
										ok_in.setLayout(null);
										ok_in.setSize(200, 140);
										ok_in.setLocationRelativeTo(null);
										ok_in.add(ok_in_l);
										ok_in.add(ok_in_btn);
										ok_in_l.setBounds(20, 20, 180, 25);
										ok_in_btn.setBounds(60, 60, 60, 25);
										ok_in_l.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
										ok_in_btn.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));

										ok_in_btn.addActionListener(new ActionListener() {
											@Override
											public void actionPerformed(ActionEvent e) {
												// TODO Auto-generated method stub
												System.out.println("돼냐");
												pwd_x.setText("");
												r_pwd_x.setText("");
												r_pwd2_x.setText("");
												ok_in.dispose();
											}

										});

										ok_in.setVisible(true);
									}
								}

							}
						});

					}
				});

				my_schedule.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						right_2 = new JPanel();
						right_2.setLayout(null);
						right_2.setBackground(Color.white);
						B = 1;
						if (A == 0) {
							right_2.setVisible(true);
						} else {
							right.setVisible(false);
							right_2.setVisible(true);
						}
						right_2.setBounds(160, 22, 400, 220);
						String schedule_column[] = { "번호", "예약병원명", "진료과", "담당의", "날짜", "시간", "증상" };
						model = new DefaultTableModel(schedule_column, 0) {
							public boolean isCellEditable(int i, int c) {
								return false;
							}
						};
						table = new JTable(model);
						int row = table.getSelectedRow();
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setNumRows(0);
						table.addMouseListener(new MouseListener() {
							@Override
							public void mouseClicked(MouseEvent e) {

								// TODO Auto-generated method stub
								if (e.getClickCount() == 2) {
									int row = table.getSelectedRow();
									String del_hospital = (String) table.getValueAt(row, 1);
									String del_medical = (String) table.getValueAt(row, 2);
									String del_doctor = (String) table.getValueAt(row, 3);
									String del_date2 = (String) table.getValueAt(row, 4);
									String del_date3 = (String) table.getValueAt(row, 5);
									JDialog cancel = new JDialog(user_info, "예약 취소 안내", true);
									JLabel cancel_hospital = new JLabel("　병원명 : " + del_hospital);
									JLabel cancel_medical = new JLabel("　진료과 : " + del_medical);
									JLabel cancel_doctor = new JLabel("　담당의 : " + del_doctor);
									JLabel cancel_date2 = new JLabel("　　날짜 : " + del_date2);
									JLabel cancel_date3 = new JLabel("　　시간 : " + del_date3);
									JLabel cancel_msg_A = new JLabel("한번 취소된 예약은 되돌릴 수 없습니다.");
									JLabel cancel_msg_B = new JLabel("그래도 예약을 취소하시겠습니까?");
									JLabel cancel_msg_C = new JLabel("─────────────────");
									JButton yes = new JButton("네");
									JButton no = new JButton("아니요");
									cancel.setSize(270, 300);
									cancel.setLocationRelativeTo(null);
									cancel.setLayout(null);
									cancel_hospital.setBounds(20, 20, 280, 25);
									cancel_hospital.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
									cancel_medical.setBounds(20, 40, 280, 25);
									cancel_medical.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
									cancel_doctor.setBounds(20, 60, 280, 25);
									cancel_doctor.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
									cancel_date2.setBounds(20, 80, 280, 25);
									cancel_date2.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
									cancel_date3.setBounds(20, 100, 280, 25);
									cancel_date3.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
									cancel_msg_C.setBounds(20, 120, 260, 25);
									cancel_msg_A.setBounds(20, 140, 260, 25);
									cancel_msg_A.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
									cancel_msg_B.setBounds(20, 160, 260, 25);
									cancel_msg_B.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
									yes.setBounds(30, 200, 80, 25);
									yes.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
									no.setBounds(140, 200, 80, 25);
									no.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
									cancel.add(cancel_hospital);
									cancel.add(cancel_medical);
									cancel.add(cancel_doctor);
									cancel.add(cancel_date2);
									cancel.add(cancel_date3);
									cancel.add(cancel_msg_A);
									cancel.add(cancel_msg_B);
									cancel.add(cancel_msg_C);
									cancel.add(yes);
									cancel.add(no);
									yes.addActionListener(new ActionListener() {
										@Override
										public void actionPerformed(ActionEvent e) {
											// TODO Auto-generated method stub
											if (HS.delete_t(data.getF(), del_hospital, del_doctor, del_date2,
													del_date3) == true) {
												model.setNumRows(0);
												ArrayList<Hospital_Sql_Vo> u_schedule = HS.u_schedule(data.getF(), tmp);
												int cnt = 1;
												for (int i = 0; i < u_schedule.size(); i++) {
													Hospital_Sql_Vo user_sd = (Hospital_Sql_Vo) u_schedule.get(i);
													String hospital = user_sd.getA();
													String medical = user_sd.getB();
													String doctor = user_sd.getC();
													String date2 = user_sd.getD();
													String date3 = user_sd.getE();
													String disease = user_sd.getF();
													model.addRow(new Object[] { cnt++, hospital, medical, doctor, date2,
															date3, disease });
													// -----------------------------------
												}
//												int rowIndex = table.getSelectedRow();
//												model.removeRow(rowIndex);

											}
											cancel.dispose();

										}

									});
									no.addActionListener(new ActionListener() {

										@Override
										public void actionPerformed(ActionEvent e) {
											// TODO Auto-generated method stub
											cancel.dispose();
										}

									});
									cancel.setVisible(true);

//								
								}
							}

							@Override
							public void mousePressed(MouseEvent e) {
								// TODO Auto-generated method stub

							}

							@Override
							public void mouseReleased(MouseEvent e) {
								// TODO Auto-generated method stub

							}

							@Override
							public void mouseEntered(MouseEvent e) {
								// TODO Auto-generated method stub

							}

							@Override
							public void mouseExited(MouseEvent e) {
								// TODO Auto-generated method stub

							}

						});
						table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
						Scroll = new JScrollPane(table);
						Scroll.setBounds(0, 0, 400, 220);
						right_2.add(Scroll);
						user_info.add(right_2);
						table.getColumnModel().getColumn(0).setPreferredWidth(50); // J테이블 내 속성들간의 간격 조절
						table.getColumnModel().getColumn(1).setPreferredWidth(160);
						table.getColumnModel().getColumn(2).setPreferredWidth(200);
						table.getColumnModel().getColumn(3).setPreferredWidth(80);
						table.getColumnModel().getColumn(4).setPreferredWidth(80);
						table.getColumnModel().getColumn(5).setPreferredWidth(100);
						table.getColumnModel().getColumn(6).setPreferredWidth(100);
						DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
						dtcr.setHorizontalAlignment(SwingConstants.CENTER);
						table.getColumn("번호").setCellRenderer(dtcr);
						table.getColumn("예약병원명").setCellRenderer(dtcr);
						table.getColumn("진료과").setCellRenderer(dtcr);
						table.getColumn("담당의").setCellRenderer(dtcr);
						table.getColumn("날짜").setCellRenderer(dtcr);
						table.getColumn("시간").setCellRenderer(dtcr);
						table.getColumn("증상").setCellRenderer(dtcr);
						ArrayList<Hospital_Sql_Vo> u_schedule = HS.u_schedule(data.getF(), tmp);
						int cnt = 1;
						for (int i = 0; i < u_schedule.size(); i++) {
							Hospital_Sql_Vo user_sd = (Hospital_Sql_Vo) u_schedule.get(i);
							String hospital = user_sd.getA();
							String medical = user_sd.getB();
							String doctor = user_sd.getC();
							String date2 = user_sd.getD();
							String date3 = user_sd.getE();
							String disease = user_sd.getF();
							model.addRow(new Object[] { cnt++, hospital, medical, doctor, date2, date3, disease });
							// -----------------------------------
						}

						cnt = 0;
					}

				});

			}

		});

		btn_myinfo.setIcon(new ImageIcon("img/ONE.jpg"));
		JButton btn_logout = new JButton();
		btn_logout.setIcon(new ImageIcon("img/TWO.jpg"));
		btn_logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JDialog exit = new JDialog(fmain_user, "종료 안내", true);
				exit.setSize(220, 150);
				exit.setLocationRelativeTo(null);
				exit.setLayout(null);
				JLabel msg_1 = new JLabel("종료 하시겠습니까?");
				msg_1.setBounds(50, 20, 140, 25);
				msg_1.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
				JButton yes = new JButton("예");
				yes.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						System.exit(0);
					}

				});
				yes.setBounds(20, 60, 60, 25);
				yes.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
				yes.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
				JButton no = new JButton("아니요");
				no.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						exit.dispose();
					}

				});
				no.setBounds(100, 60, 80, 25);
				no.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
				no.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
				exit.add(msg_1);
				exit.add(yes);
				exit.add(no);
				exit.setVisible(true);

			}

		});
		JButton btn_send = new JButton("예　　 약");
		JButton btn_cancel = new JButton("취　　 소");
		btn_cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				medical.removeAllItems();
				doctor.removeAllItems();
				date_3.removeAllItems();
				hospital.setText("");
				medical.addItem("먼저 병원을 입력해 주세요");
				medical.setEnabled(false);
				doctor.setEnabled(false);
				doctor.addItem("먼저 병원을 입력해 주세요");
				date_2.setText("");
				date_3.addItem("날짜 선택 후 시간 선택 가능");
				date_3.setEnabled(false);
				disease.setText("");
			}

		});
		JLabel Date_format = new JLabel();
		JLabel message_one = new JLabel(" ■ 희망하는 진료 예약일자를 선택해주세요");
		// -------------------------[실시간 시간 구하기]
		systemTime = System.currentTimeMillis(); // 현재 시스템 시간 구하기
		d_time = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		Date_format.setText(d_time.format(systemTime));
		Date_format.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		tmp = d_time.format(systemTime).replaceAll("[^0-9]", "");
		JPanel North = new JPanel();
		JPanel South = new JPanel();
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
		Center_p = new JPanel();
		fmain_user.add(m_user);
		fmain_user.add(p_left);
		fmain_user.add(p_right);
		fmain_user.add(btn_myinfo);
		fmain_user.add(btn_logout);
		fmain_user.add(Date_format);
		JButton btn_prev = new JButton("◀");
		JButton btn_next = new JButton("▶");
		JLabel sun = new JLabel("SUN");
		JLabel mon = new JLabel("MON");
		JLabel tue = new JLabel("TUE");
		JLabel wed = new JLabel("WED");
		JLabel thu = new JLabel("THU");
		JLabel fri = new JLabel("FRI");
		JLabel sat = new JLabel("SAT");
		JTextField name = new JTextField();
		name.setEditable(false);
		JTextField date_1 = new JTextField();
		date_1.setEditable(false);
		disease = new JTextField();
		JTextField contact = new JTextField();
		contact.setEditable(false);
		hospital = new JTextField();
		hospital.setEditable(false);
		medical = new JComboBox<String>();
		medical.setEnabled(false);
		medical.addItem("먼저 병원을 입력해 주세요");
		medical.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));

		btn_send.addActionListener(new ActionListener() { // 예약 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!name.getText().isEmpty() && !date_1.getText().isEmpty() && !contact.getText().isEmpty()
						&& !hospital.getText().isEmpty() && !medical.getSelectedItem().equals("먼저 병원을 선택하세요")
						&& !doctor.getSelectedItem().equals("먼저 병원을 선택하세요") && !date_2.getText().isEmpty()
						&& !date_3.getSelectedItem().equals("예약 가능한 시간이 없습니다")) {
					if (HS.schedule(data.getF(), hospital.getText(), medical.getSelectedItem().toString(),
							doctor.getSelectedItem().toString(), date_2.getText(), date_3.getSelectedItem().toString(),
							disease.getText()) == true) {
						JDialog send_ok = new JDialog(fmain_user, "예약 안내", true);
						send_ok.setSize(200, 150);
						send_ok.setLocationRelativeTo(null);
						send_ok.setLayout(null);
						JLabel msg = new JLabel("진료 예약이 되었습니다.");
						msg.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
						JButton send_yes = new JButton("확인");
						send_yes.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								send_ok.dispose();
								medical.removeAllItems();
								doctor.removeAllItems();
								date_3.removeAllItems();
								hospital.setText("");
								medical.addItem("먼저 병원을 입력해 주세요");
								medical.setEnabled(false);
								doctor.setEnabled(false);
								doctor.addItem("먼저 병원을 입력해 주세요");
								date_2.setText("");
								date_3.addItem("날짜 선택 후 시간 선택 가능");
								date_3.setEnabled(false);
								disease.setText("");
							}

						});
						send_yes.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
						send_yes.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f));
						send_ok.add(msg);
						send_ok.add(send_yes);
						msg.setBounds(24, 20, 160, 25);
						send_yes.setBounds(60, 60, 60, 25);
						send_ok.setVisible(true);
					}
				} else if (date_2.getText().isEmpty()) {
					JDialog msg = new JDialog(fmain_user, "예약 안내", true);
					JLabel msg_1 = new JLabel("예약 정보 입력란에 미입력 부분이 있습니다");
					JLabel msg_2 = new JLabel("빠짐없이 입력해주셔야 예약이 가능합니다");
					JButton ok = new JButton("확인");
					ok.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							msg.dispose();
						}

					});
					msg.setSize(320, 150);
					msg.setLocationRelativeTo(null);
					msg_1.setBounds(36, 20, 300, 25);
					msg_2.setBounds(38, 40, 300, 25);
					ok.setBounds(70, 70, 160, 25);
					ok.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
					ok.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f));
					msg.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
					msg_1.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
					msg_2.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));

					msg.setLayout(null);
					msg.add(msg_1);
					msg.add(msg_2);
					msg.add(ok);
					msg.setVisible(true);
				} else {
					if (date_3.getSelectedItem().toString().equals("예약 가능한 시간이 없습니다")) {
						JDialog msg = new JDialog(fmain_user, "예약 안내", true);
						JLabel msg_1 = new JLabel("예약 가능한 시간이 없습니다");
						JLabel msg_2 = new JLabel("다른 시간으로 예약해 주세요.");
						JButton ok = new JButton("확인");
						ok.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								msg.dispose();
							}

						});
						msg.setBounds(420, 250, 250, 150);
						msg_1.setBounds(40, 20, 160, 25);
						msg_2.setBounds(40, 40, 160, 25);
						ok.setBounds(40, 70, 160, 25);
						ok.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
						ok.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f));
						msg.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
						msg_1.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
						msg_2.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));

						msg.setLayout(null);
						msg.add(msg_1);
						msg.add(msg_2);
						msg.add(ok);
						msg.setVisible(true);
					}
				}

			}

		});
		medical.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				doctor.removeAllItems();
				ArrayList<Hospital_Sql_Vo> doctor_list = HS.doctor_list(result_name, result_address,
						e.getItem().toString());
				for (int i = 0; i < doctor_list.size(); i++) {
					Hospital_Sql_Vo doctor_info = (Hospital_Sql_Vo) doctor_list.get(i);
					d_number = doctor_info.getZ();
					String doctor_name = doctor_info.getA();
					doctor.addItem(doctor_name);
					date_3.removeAllItems();
				}
				if (doctor_list.size() == 0) {
					doctor.addItem("예약 가능한 의사가 없습니다");
				}
			}

		});
		doctor = new JComboBox<String>();
		doctor.setEnabled(false);
		doctor.addItem("예약 가능한 의사가 없습니다");
		doctor.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		doctor.setEditable(false);

		date_2 = new JTextField();
		date_3 = new JComboBox<String>();
		date_3.setEnabled(false);
		date_3.addItem("날짜 선택 후 시간 선택 가능");
		date_3.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		JButton btn_hospital = new JButton("[찾기]");
		date_2.setEditable(false);
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
		p_right.add(y_disease);
		p_right.add(y_contact);
		p_right.add(y_hospital);
		p_right.add(y_medical);
		p_right.add(y_date_2);
		p_right.add(name); // 텍스트필드
		p_right.add(date_1);
		p_right.add(disease);
		p_right.add(contact);
		p_right.add(hospital);
		p_right.add(medical);
		p_right.add(date_3);
		p_right.add(btn_hospital);
		p_right.add(y_date3);
		p_right.add(y_doctor);
		p_right.add(doctor);
		p_right.add(date_2);
		p_right.add(btn_send);
		p_right.add(btn_cancel);

		sun.setForeground(Color.white);
		mon.setForeground(Color.white);
		tue.setForeground(Color.white);
		wed.setForeground(Color.white);
		thu.setForeground(Color.white);
		fri.setForeground(Color.white);
		sat.setForeground(Color.white);
		message_one.setBounds(10, 8, 300, 25);
		message_one.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		p_left.add(Center_p);
		name.setBounds(130, 80, 210, 25);
		date_1.setBounds(130, 120, 210, 25);
		disease.setBounds(130, 400, 210, 25);
		contact.setBounds(130, 160, 210, 25);
		hospital.setBounds(130, 200, 160, 25);
		medical.setBounds(130, 240, 210, 25);
		doctor.setBounds(130, 280, 210, 25);
		date_2.setBounds(130, 320, 210, 25);
		date_3.setBounds(130, 360, 210, 25);

		btn_hospital.setBounds(290, 200, 70, 25);
		btn_hospital.setFont(btn_nomal);
		btn_hospital.setBorderPainted(false);
		btn_hospital.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f));
		y_title.setBounds(124, 30, 200, 25); // 예약정보
		y_title.setFont(new Font("나눔바른고딕", Font.PLAIN, 20));
		y_name.setBounds(40, 80, 200, 25);
		y_name.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		y_date.setBounds(40, 120, 200, 25);
		y_date.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		y_disease.setBounds(40, 400, 200, 25);
		y_disease.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		y_contact.setBounds(40, 160, 200, 25);
		y_contact.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		y_hospital.setBounds(40, 200, 200, 25);
		y_hospital.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		y_medical.setBounds(40, 240, 200, 25);
		y_medical.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		y_doctor.setBounds(40, 280, 200, 25);
		y_doctor.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		y_date3.setBounds(40, 320, 200, 25);
		y_date3.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		y_date_2.setBounds(40, 360, 200, 25);
		y_date_2.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		btn_prev.setBounds(100, 70, 60, 30);
		btn_next.setBounds(380, 70, 60, 30);
		North.setBounds(4, 0, 570, 40);
		South.setBounds(40, 590, 530, 4);
		btn_myinfo.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
		btn_logout.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
		btn_send.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
		btn_cancel.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
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
		btn_myinfo.setBounds(870, 30, 52, 24);
		btn_logout.setBounds(924, 32, 63, 20);
		btn_send.setBounds(130, 450, 100, 25);
		btn_cancel.setBounds(240, 450, 100, 25);
		btn_send.setFont(btn_nomal);
		btn_cancel.setFont(btn_nomal);
		Date_format.setBounds(44, 30, 220, 25);
		Date_format.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
		btn_Arr = new JButton[42]; // 숫자넣어줄버튼들
		p_left.setBounds(40, 100, 530, 490);
		p_right.setBounds(600, 100, 390, 500);
		Center_p.setBounds(0, 180, 530, 310);
		Center_p.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
		p_left.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9f));
		p_right.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f));
		m_user.setBounds(720, 30, 240, 25);
		m_user.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		btn_prev.setBorderPainted(false);
		btn_next.setBorderPainted(false);
		btn_myinfo.setBorderPainted(false);
		btn_logout.setBorderPainted(false);
		btn_myinfo.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btn_logout.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		name.setText(data.getA());
		date_1.setText(data.getB());
		contact.setText(data.getC());
		btn_hospital.addActionListener(new ActionListener() { // 병원 검색
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				find_hospital(2);
			}

		});
		// ---------------------[달력셋팅]

		Calendar date = Calendar.getInstance();
		L_YearMonth = new JLabel();
		L_YearMonth.setVisible(true);
		L_YearMonth.setBounds(220, 66, 140, 40);

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

		p_left.add(L_YearMonth);
		// ---------------------
		Center_p.setLayout(new GridLayout(6, 7));
		for (int i = 0; i < btn_Arr.length; i++) {
			btn_Arr[i] = new JButton("");
			btn_Arr[i].addActionListener(this);
			Center_p.add(btn_Arr[i]);
		}
		// ---------------------
		setDays(date);
	}

	public void find_hospital(int select_n) {
		JFrame find_hsp = new JFrame("병원명 검색");
		find_hsp.setSize(700, 300);
		find_hsp.setLocationRelativeTo(null);
		find_hsp.setResizable(false);
		find_hsp.setLayout(null);
		find_hsp.setVisible(true);
		JTextField find_hospital = new JTextField();
		JLabel hos_name = new JLabel("병원명 :");
		hos_name.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		JButton h_btn = new JButton("검색");

		h_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ------------------------------- Jtable에 생성된 정보 초기화 하기 위한 코드
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setNumRows(0);

				// ---------------------------------------------------------------
				ArrayList<Hospital_Sql_Vo> hoslist = HS.hoslist(find_hospital.getText());
				for (int i = 0; i < hoslist.size(); i++) {
					Hospital_Sql_Vo hos_data = (Hospital_Sql_Vo) hoslist.get(i);
					String name = hos_data.getA();
					String address = hos_data.getB();
					String contact = hos_data.getC();
					model.addRow(new Object[] { name, address, contact });
				}
			}

		});

		userColumn.clear(); // 해당 클래스에서 검색을 연속해서 누를경우 컬럼이 중복으로 증가해서 시작전에 초기화함
		userColumn.addElement("병원명");
		userColumn.addElement("주소");
		userColumn.addElement("전화번호");

		model = new DefaultTableModel(userColumn, 0) {
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};

		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(150); // J테이블 내 속성들간의 간격 조절
		table.getColumnModel().getColumn(1).setPreferredWidth(450);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getClickCount() == 2) {
					int row = table.getSelectedRow();
					result_name = (String) table.getValueAt(row, 0);
					result_address = (String) table.getValueAt(row, 1);
					ArrayList<Hospital_Sql_Vo> medical_list = HS.medical_list(result_name, result_address);
					String[] strArr = new String[medical_list.size()];
					if (select_n == 1) {
						Hospital_sign.T_medical.removeAllItems();
					} else if (select_n == 2) {
						medical.removeAllItems();
						date_3.removeAllItems();
					}
					for (int i = 0; i < medical_list.size(); i++) {
						Hospital_Sql_Vo medical_info = (Hospital_Sql_Vo) medical_list.get(i);
						h_medical = medical_info.getA();
						strArr[i] = h_medical;
						if (select_n == 1) { // 회원가입시
							find_hsp.dispose();
							Hospital_sign.T_hospital.setText(result_name);
							Hospital_sign.T_medical.addItem(strArr[i]);
						} else if (select_n == 2) { // 예약시
							find_hsp.dispose();
							hospital.setText(result_name);
							medical.addItem(strArr[i]);
							medical.setEnabled(true);
							doctor.setEnabled(true);
							date_3.setEnabled(true);

						}
					}
					if (select_n == 1) {

					} else if (select_n == 2) {
						date_Arr = new String[] { "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00",
								"12:30", "13:00", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00",
								"17:30" };
						if (!date_2.getText().isEmpty()) {
							ArrayList<Hospital_Sql_Vo> schedule_find = HS.schedule_find(date_2.getText(), doctor.getSelectedItem().toString(),
									hospital.getText(), medical.getSelectedItem().toString());

							for (int k = 0; k < schedule_find.size(); k++) {//
								Hospital_Sql_Vo schedule_info = (Hospital_Sql_Vo) schedule_find.get(k);
								String s_date_3 = schedule_info.getA();
								for (int j = 0; j < date_Arr.length; j++) {
									if (date_Arr[j].equals(s_date_3)) {
										date_Arr[j] = "";
									}
								}
							}
							for (int l = 0; l < date_Arr.length; l++) {
								if (!date_Arr[l].isEmpty()) {
									date_3.addItem(date_Arr[l]);
								}
							}
						}
					}
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});

		P = new JPanel();
		P.setLayout(new BorderLayout());
		Scroll = new JScrollPane(table);
		P.add(Scroll);
		P.setBounds(4, 0, 680, 200);
		find_hospital.setBounds(245, 220, 200, 25);
		hos_name.setBounds(200, 220, 60, 25);
		h_btn.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		h_btn.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f));
		h_btn.setBounds(450, 220, 60, 25);

		find_hsp.add(P);

		find_hsp.add(find_hospital);
		find_hsp.add(hos_name);
		find_hsp.add(h_btn);
		find_hsp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	public void setDays(Calendar date) {
		Calendar date_r = Calendar.getInstance();
		Border lineBorder = BorderFactory.createLineBorder(Color.getHSBColor(0.0f, 0.0f, 0.9f), 1);
		year = date.get(Calendar.YEAR);
		month = date.get(Calendar.MONTH);
		int year_r = date_r.get(Calendar.YEAR);
		int month_r = date_r.get(Calendar.MONTH);
		int day_r = date_r.get(Calendar.DATE);
		L_YearMonth.setText(year + " / " + (month + 1));
		Font YearMonth = new Font("나눔바른고딕", Font.BOLD, 24); // 글씨 폰트변경 위한 객체
		L_YearMonth.setFont(YearMonth);
		Calendar sDay = Calendar.getInstance(); // 시작일

		sDay.set(year, month, 1);
		sDay.add(Calendar.DATE, -sDay.get(Calendar.DAY_OF_WEEK) + 1);
		int check = 1;
		for (int i = 0; i < btn_Arr.length; i++, sDay.add(Calendar.DATE, 1)) {
			btn_Arr[i].setEnabled(true);
			int day = sDay.get(Calendar.DATE);
			if (day == check) {
				btn_Arr[i].setLabel(day + "");
				btn_Arr[i].setBorder(lineBorder);
				check++;
				if (year_r == year) {
					if (month_r == month) { // 당월
						if (day_r >= day) {
							btn_Arr[i].setEnabled(false);
						}

					} else if (month_r > month) {
						btn_Arr[i].setEnabled(false);
					}
				} else if (year_r > year) {
					btn_Arr[i].setEnabled(false);
				}
			} else {
				btn_Arr[i].setLabel("");
				btn_Arr[i].setBorder(lineBorder);
				btn_Arr[i].setEnabled(false);
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
		date_3.removeAllItems();
		String month_r = Integer.toString(month + 1);
		String day_r = e.getActionCommand().toString();
		if (month_r.length() != 2) {
			month_r = "0" + month_r;
		}
		if (day_r.length() != 2) {
			day_r = "0" + day_r;
		}
		date_2.setText(year + "년 " + month_r + "월 " + day_r + "일");
		String[] date_Arr = new String[] { "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30",
				"13:00", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30" };
		if (doctor.getSelectedItem().toString().equals("먼저 병원을 입력해 주세요") && !date_2.getText().isEmpty()) {
			for (int i = 0; i < date_Arr.length; i++) {
				date_3.addItem(date_Arr[i]);
			}
		}
		if (!doctor.getSelectedItem().toString().isEmpty() && !date_2.getText().isEmpty()) {
			ArrayList<Hospital_Sql_Vo> schedule_find = HS.schedule_find(date_2.getText(), doctor.getSelectedItem().toString(),
					hospital.getText(), medical.getSelectedItem().toString());
			for (int k = 0; k < schedule_find.size(); k++) {//
				Hospital_Sql_Vo schedule_info = (Hospital_Sql_Vo) schedule_find.get(k);
				String s_date_3 = schedule_info.getA();
				for (int j = 0; j < date_Arr.length; j++) {
					if (date_Arr[j].equals(s_date_3)) {
						date_Arr[j] = "";
					}
				}
			}
			for (int l = 0; l < date_Arr.length; l++) {
				if (!date_Arr[l].isEmpty()) {
					date_3.addItem(date_Arr[l]);
				}
			}
			int cnt = 0;
			for (int l = 0; l < date_Arr.length; l++) {
				if (date_Arr[l].isEmpty()) {
					cnt++;
					if (cnt == 17) {
						date_3.addItem("예약 가능한 시간이 없습니다");
					}
				}
			}
			cnt = 0;

		}

	}
}
