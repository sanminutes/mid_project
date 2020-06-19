import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Hospital_Sql {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/orcl";
	String user = "kosea";
	String password = "kosea2019a";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public ArrayList<Hospital_Sql_Vo> list(String id) { // 정보 가져오기
		// ArrayList는 자바에서 지원하는 자료구조..
		ArrayList<Hospital_Sql_Vo> list = new ArrayList<Hospital_Sql_Vo>();
		try {
			connDB();
			String find_id = "select * from private_information where p_id='" + id + "'";
			rs = stmt.executeQuery(find_id);
			int u_number = 0, d_number = 0;
			while (rs.next()) {
				u_number = rs.getInt(4);
				d_number = rs.getInt(5);
			}
			if (u_number == 0) { // null값이면 로그인 대상은 '의사'
				String find_info = "SELECT di.d_name, di.d_date, di.d_contact, pi2.p_id, pi2.p_pwd, pi2.u_NUMBER, di.d_number, hi.H_number, hi.H_NAME, di.d_medical, di.D_level"
						+ " FROM DOCTOR_INFORMATION di"
						+ " INNER JOIN private_information pi2 ON di.D_NUMBER = pi2.D_NUMBER"
						+ " INNER JOIN HOSPITAL_INFORMATION hi ON di.D_HOSPITAL = hi.H_NUMBER where pi2.p_id ='" + id
						+ "'";
				rs = stmt.executeQuery(find_info);
				while (rs.next()) {

					String u_name = rs.getString(1);
					String u_date = rs.getString(2);
					String u_contact = rs.getString(3);
					String u_id = rs.getString(4);
					String u_pwd = rs.getString(5);
					String u_num = rs.getString(6);
					String d_num = rs.getString(7);
					String h_number = rs.getString(8);
					String d_hospital = rs.getString(9);
					String d_medical = rs.getString(10);
					int d_level = rs.getInt(11);
					Hospital_Sql_Vo data = new Hospital_Sql_Vo(u_name, u_date, u_contact, u_id, u_pwd, u_num, d_num,
							h_number, d_hospital, d_medical, d_level);
					list.add(data);
				}
			} else if (d_number == 0) { // null값이면 로그인 대상은 '환자'

				String find_info = "select distinct ui.u_name, ui.u_date,  ui.u_contact, pi2.p_id, pi2.p_pwd, ui.u_number, pi2.D_NUMBER"
						+ " from user_information ui INNER JOIN private_information pi2"
						+ " ON ui.U_NUMBER = pi2.U_NUMBER" + " WHERE p_id = '" + id + "'";
				rs = stmt.executeQuery(find_info);
				while (rs.next()) {
					String u_name = rs.getString(1);
					String u_date = rs.getString(2);
					String u_contact = rs.getString(3);
					String u_id = rs.getString(4);
					String u_pwd = rs.getString(5);
					String u_num = rs.getString(6);
					String d_num = rs.getString(7);
					Hospital_Sql_Vo data = new Hospital_Sql_Vo(u_name, u_date, u_contact, u_id, u_pwd, u_num, d_num);
					list.add(data);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public boolean insertuser(String id, String pwd, String name, String date, String contact) { // 가져오기
		// ArrayList는 자바에서 지원하는 자료구조..
		boolean join_result = false;
		try {
			connDB();
			// --------------------------------------------[유저정보 저장하기 위한 쿼리]

			int u_max = 0;
			String u_max_number = "select max(u_number) from user_information";
			rs = stmt.executeQuery(u_max_number);
			while (rs.next()) {
				u_max = rs.getInt(1);
			}
			int p_max = 0;
			String p_max_number = "select max(p_number) from private_information";
			rs = stmt.executeQuery(p_max_number);
			while (rs.next()) {
				p_max = rs.getInt(1);
			}

			String u_insert = "insert all " + "into user_information values(" + (u_max + 1) + ",'" + name + "','" + date
					+ "','" + contact + "')" + " into private_information values(" + (p_max + 1) + ",'" + id + "','"
					+ pwd + "'," + (u_max + 1) + "," + "''" + ")" + " SELECT * from dual";
			rs = stmt.executeQuery(u_insert);
			join_result = true;
			// 아이디 결과값이 없으면 가입ok
			// 아이디 결과값이 있으면 중복으로 가입불가
			// --------------------------------------------[유저계정 저장하기 위한 쿼리]
		} catch (Exception e) {
			e.printStackTrace();
		}
		return join_result;
	}

	// 의사 회원가입시 사용하는 쿼리
	public boolean insertdoctor(String id, String pwd, String name, String date, String contact, String hospital,
			String medical) {
		boolean join_result = false;
		try {
			connDB();
			// --------------------------------------------[유저정보 저장하기 위한 쿼리]

			int d_max = 0;
			String d_max_number = "select max(d_number) from doctor_information";
			rs = stmt.executeQuery(d_max_number);
			while (rs.next()) {
				d_max = rs.getInt(1);
			}
			int p_max = 0;
			String p_max_number = "select max(p_number) from private_information";
			rs = stmt.executeQuery(p_max_number);
			while (rs.next()) {
				p_max = rs.getInt(1);
			}
			int h_number = 0;
			String h_num = "select * from hospital_information where h_name ='" + hospital + "'";
			rs = stmt.executeQuery(h_num);
			while (rs.next()) {
				h_number = rs.getInt(1);
			}
			String u_insert = "insert all " + "into doctor_information values(" + (d_max + 1) + ",'" + name + "','"
					+ date + "','" + contact + "'," + h_number + ",'" + medical + "',1)"
					+ " into private_information values(" + (p_max + 1) + ",'" + id + "','" + pwd + "','" + "',"
					+ (d_max + 1) + ")" + " SELECT * from dual";
			rs = stmt.executeQuery(u_insert);
			join_result = true;
			// 아이디 결과값이 없으면 가입ok
			// 아이디 결과값이 있으면 중복으로 가입불가
			// --------------------------------------------[유저계정 저장하기 위한 쿼리]
		} catch (Exception e) {
			e.printStackTrace();
		}
		return join_result;
	}

	// JTABLE에 검색된 병원 이름, 주소, 연락처를 출력하기 위함
	public ArrayList<Hospital_Sql_Vo> hoslist(String hospital) {
		// ArrayList는 자바에서 지원하는 자료구조..
		ArrayList<Hospital_Sql_Vo> hoslist = new ArrayList<Hospital_Sql_Vo>();
		try {
			connDB();
			String find = "Select * from hospital_information where h_name like '%" + hospital + "%'";
			rs = stmt.executeQuery(find);

			while (rs.next()) {
				String h_name = rs.getString(2);
				String h_address = rs.getString(3);
				String h_contact = rs.getString(4);
				Hospital_Sql_Vo hinfo = new Hospital_Sql_Vo(h_name, h_address, h_contact);
				hoslist.add(hinfo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return hoslist;
	}

	// 해당 병원에서 진료중인 과목들 출력
	public ArrayList<Hospital_Sql_Vo> medical_list(String h_name, String h_address) {
		// ArrayList는 자바에서 지원하는 자료구조..
		ArrayList<Hospital_Sql_Vo> medical_list = new ArrayList<Hospital_Sql_Vo>();
		try {
			connDB();
			String hospital_number = "select * from hospital_information where h_name ='" + h_name + "' and h_address='"
					+ h_address + "'";
			rs = stmt.executeQuery(hospital_number);
			int hospital_n = 0;
			while (rs.next()) {
				hospital_n = rs.getInt(1);
			}
			String findB = "select * from medical_information where h_number =" + hospital_n;
			rs = stmt.executeQuery(findB);
			while (rs.next()) {
				int m_number = rs.getInt(1);
				String medical = rs.getString(2);
				Hospital_Sql_Vo medical_info = new Hospital_Sql_Vo(m_number, medical);
				medical_list.add(medical_info);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return medical_list;
	}

	// 해당 병원에서 진료중인 과목들 출력
	public ArrayList<Hospital_Sql_Vo> doctor_list(String h_name, String h_address, String medical) {
		// ArrayList는 자바에서 지원하는 자료구조..
		ArrayList<Hospital_Sql_Vo> doctor_list = new ArrayList<Hospital_Sql_Vo>();
		try {
			connDB();
			String hospital_number = "select * from hospital_information where h_name ='" + h_name + "' and h_address='"
					+ h_address + "'";
			rs = stmt.executeQuery(hospital_number);
			int hospital_n = 0;
			while (rs.next()) {
				hospital_n = rs.getInt(1);
			}
			String findB = "select d_number, d_name from doctor_information where d_hospital=" + hospital_n
					+ " and d_medical='" + medical + "'";
			rs = stmt.executeQuery(findB);
			while (rs.next()) {
				int d_number = rs.getInt(1);
				String d_name = rs.getString(2);
				Hospital_Sql_Vo doctor_info = new Hospital_Sql_Vo(d_number, d_name);
				doctor_list.add(doctor_info);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return doctor_list;
	}

	// ---------------------------------[예약 정보 저장]
	public boolean schedule(String u_number, int doctor_n, String date_2, String date_3, String disease) { // 가져오기
		boolean insert_result = false;
		try {
			connDB();
			int date_2_i = Integer.parseInt(date_2.replaceAll("[^0-9]", ""));
			String max_find = "select max(s_number) from schedule_info";
			rs = stmt.executeQuery(max_find);
			int max = 0;
			while (rs.next()) {
				max = rs.getInt(1);
			}
			String doctor_f = "SELECT d_hospital FROM doctor_information WHERE d_number = " + doctor_n;
			rs = stmt.executeQuery(doctor_f);
			int d_n = 0;
			while (rs.next()) {
				d_n = rs.getInt(1);
			}
			String schedule = "insert into schedule_info values(" + (max + 1) + "," + u_number + "," + doctor_n + ","
					+ date_2_i + ",'" + date_3 + "'," + d_n + ",'" + disease + "','진료대기'"+")";
			rs = stmt.executeQuery(schedule);
			insert_result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return insert_result;
	}

	// 스케쥴 찾기
	public ArrayList<Hospital_Sql_Vo> schedule_find(String date_2, int d_number) {
		// ArrayList는 자바에서 지원하는 자료구조..
		ArrayList<Hospital_Sql_Vo> schedule_find = new ArrayList<Hospital_Sql_Vo>();
		try {
			connDB();
			int date_2_i = Integer.parseInt(date_2.replaceAll("[^0-9]", ""));
			String s_find = "select s_date_2, s_date_3 from schedule_info where d_number =" + d_number
					+ " and s_date_2=" + date_2_i;
			rs = stmt.executeQuery(s_find);
			while (rs.next()) {
				int u_date = rs.getInt(1);
				String u_id = rs.getString(2);
				Hospital_Sql_Vo schedule_info = new Hospital_Sql_Vo(u_date, u_id);
				schedule_find.add(schedule_info);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return schedule_find;
	}

	// 의사아이디로 로그인했을 때, 클릭한 날에 예약한 환자들 정보 조회하기 위한 쿼리
	public ArrayList<Hospital_Sql_Vo> user_schedule(String d_number, String date_2, int sel) {
		ArrayList<Hospital_Sql_Vo> user_schedule = new ArrayList<Hospital_Sql_Vo>();
		try {
			connDB();
			String h_find = "select d_hospital from doctor_information where d_number =" + d_number;
			rs = stmt.executeQuery(h_find);
			String hospital = null;
			while (rs.next()) {
				hospital = rs.getString(1); // 병원
			}
			if (sel == 1) {
				String s_find = "SELECT s.S_DATE_3, u.U_NAME, u.U_DATE, s.S_DISEASE, u.U_CONTACT,s.s_etc, d.D_MEDICAL, d.D_NAME  "
						+ "FROM SCHEDULE_INFO s " + "INNER JOIN DOCTOR_INFORMATION d " + "ON s.D_NUMBER = d.D_NUMBER "
						+ "INNER JOIN USER_INFORMATION u " + "ON s.U_NUMBER = u.U_NUMBER " + "WHERE s.H_number = "
						+ hospital + "AND s_date_2 = " + date_2 + "ORDER BY s_date_2 " + "ASC, s_date_3";
				rs = stmt.executeQuery(s_find);
				while (rs.next()) {
					String s_date_3 = rs.getString(1); // 예약시간
					String u_name = rs.getString(2); // 이름
					String u_date = rs.getString(3); // 생년월일
					String disease = rs.getString(4); // 증상
					String u_contact = rs.getString(5); // 연락처
					String etc = rs.getString(6); // 예약구분
					String d_name = rs.getString(7); // 진료과목
					String doctor = rs.getString(8); // 담당의
					System.out.println(etc);
					Hospital_Sql_Vo user_schedule_info = new Hospital_Sql_Vo(s_date_3, u_name, u_date, disease,
							u_contact, etc, doctor, d_name);
					user_schedule.add(user_schedule_info);

				}
			} else if (sel == 2) { // 담당
				String s_find = "SELECT s.S_DATE_3, u.U_NAME, u.U_DATE, s.S_DISEASE, u.U_CONTACT, s.s_etc "
						+ "FROM SCHEDULE_INFO s " + "INNER JOIN DOCTOR_INFORMATION d " + "ON s.D_NUMBER = d.D_NUMBER "
						+ "INNER JOIN USER_INFORMATION u " + "ON s.U_NUMBER = u.U_NUMBER " + "WHERE d.D_HOSPITAL = "
						+ hospital + "AND s_date_2 = " + date_2 + "AND d.D_NUMBER = " + d_number + "ORDER BY s_date_2 "
						+ "ASC, s_date_3";
				rs = stmt.executeQuery(s_find);
				while (rs.next()) {
					String s_date_3 = rs.getString(1); // 예약시간
					String u_name = rs.getString(2); // 이름
					String u_date = rs.getString(3); // 생년월일
					String disease = rs.getString(4); // 증상
					String u_contact = rs.getString(5); // 연락처
					String etc = rs.getString(6); // 예약구분
					Hospital_Sql_Vo user_schedule_info = new Hospital_Sql_Vo(s_date_3, u_name, u_date, disease,
							u_contact,etc);
					user_schedule.add(user_schedule_info);

				}
			}

		} catch (

		Exception e) {
			e.printStackTrace();
		}

		return user_schedule;
	}

	// 환자의 이전 방문 내역을 조회하기 위한 쿼리
	public ArrayList<Hospital_Sql_Vo> schedule_check(String date_f, String date_d, String d_hospital,
			String daily_date) { // 예약시간 , 선택된 날짜, 병원번호, 금일 날짜
		ArrayList<Hospital_Sql_Vo> schedule_check = new ArrayList<Hospital_Sql_Vo>();
		try {
			connDB();
			String s_find_a = "SELECT U_NUMBER " + "FROM schedule_info " + "WHERE h_number=" + d_hospital
					+ " and S_DATE_2 ='" + date_d + "' AND s_date_3 = '" + date_f + "'";
			rs = stmt.executeQuery(s_find_a);
			int u_number = 0;
			while (rs.next()) {
				u_number = rs.getInt(1);
			}
			String s_find_b = "SELECT u.U_NAME, u.U_DATE, s.s_DATE_2, s.S_DATE_3, d.D_MEDICAL, d.D_NAME, s.s_disease, s.s_etc "
					+ "FROM SCHEDULE_INFO s" + " INNER JOIN DOCTOR_INFORMATION d" + " ON s.D_NUMBER = d.D_NUMBER"
					+ " INNER JOIN USER_INFORMATION u" + " ON s.U_NUMBER = u.U_NUMBER " + "WHERE s.U_NUMBER ="
					+ u_number + " AND s_date_2 <" + daily_date + " ORDER BY s_date_2 ASC, s_date_3";
			rs = stmt.executeQuery(s_find_b);
			while (rs.next()) {
				String u_name = rs.getString(1); // 이름
				String u_date = rs.getString(2); // 생년월일
				String s_date_2 = rs.getString(3); // 예약날짜
				String s_date_3 = rs.getString(4); // 예약시간
				String medical = rs.getString(5); // 진료과목
				String d_name = rs.getString(6); // 담당의
				String disease = rs.getString(7); // 증상
				String etc = rs.getString(8); // 증상
				Hospital_Sql_Vo user_schedule_check = new Hospital_Sql_Vo(u_name, u_date, s_date_2, s_date_3, medical,
						d_name, disease, etc);
				schedule_check.add(user_schedule_check);
			}

		} catch (

		Exception e) {
			e.printStackTrace();
		}

		return schedule_check;
	}

	public void connDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.");
//			stmt = con.createStatement();
//------------------stmt 전방향 어쩌고 에러뜸
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("statement create success.");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
