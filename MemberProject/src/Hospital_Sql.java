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
				String find_info = "SELECT di.d_name, di.d_date, di.d_address, di.d_contact, hi.H_NAME, di.d_medical,"
						+ " pi2.p_id, pi2.p_pwd, pi2.u_NUMBER, di.d_number" + " FROM DOCTOR_INFORMATION di"
						+ " INNER JOIN private_information pi2 ON di.D_NUMBER = pi2.D_NUMBER"
						+ " INNER JOIN HOSPITAL_INFORMATION hi ON di.D_HOSPITAL = hi.H_NUMBER where pi2.p_id ='" + id
						+ "'";
				rs = stmt.executeQuery(find_info);
				while (rs.next()) {

					String u_name = rs.getString(1);
					int u_date = rs.getInt(2);
					String u_address = rs.getString(3);
					String u_contact = rs.getString(4);
					String d_hospital = rs.getString(5);
					String d_medical = rs.getString(6);
					String u_id = rs.getString(7);
					String u_pwd = rs.getString(8);
					String u_num = rs.getString(9);
					String d_num = rs.getString(10);
					Hospital_Sql_Vo pvinfo = new Hospital_Sql_Vo(u_name, u_date, u_address, u_contact, u_id, u_pwd,
							d_hospital, d_medical, u_num, d_num);
					list.add(pvinfo);
				}
			} else if (d_number == 0) { // null값이면 로그인 대상은 '환자'

				String find_info = "select distinct ui.u_name, ui.u_date, ui.u_address, ui.u_contact, pi2.p_id, pi2.p_pwd, ui.u_number, pi2.D_NUMBER"
						+ " from user_information ui INNER JOIN private_information pi2"
						+ " ON ui.U_NUMBER = pi2.U_NUMBER" + " WHERE p_id = '" + id + "'";
				rs = stmt.executeQuery(find_info);
				while (rs.next()) {

					String u_name = rs.getString(1);
					int u_date = rs.getInt(2);
					String u_address = rs.getString(3);
					String u_contact = rs.getString(4);
					String u_id = rs.getString(5);
					String u_pwd = rs.getString(6);
					String u_num = rs.getString(7);
					String d_num = rs.getString(8);
					Hospital_Sql_Vo pvinfo = new Hospital_Sql_Vo(u_name, u_date, u_address, u_contact, u_id, u_pwd,
							u_num, d_num);
					list.add(pvinfo);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public boolean inseruser(String id, String pwd, String name, int date, String address, String contact) { // 가져오기
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
					+ "','" + address + "','" + contact + "')" + " into private_information values(" + (p_max + 1)
					+ ",'" + id + "','" + pwd + "'," + (u_max + 1) + "," + "''" + ")" + " SELECT * from dual";
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

	public boolean insertdoctor(String id, String pwd, String name, int date, String address, String contact,
			String hospital, String medical) { // 가져오기
		// ArrayList는 자바에서 지원하는 자료구조..
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
					+ date + "','" + address + "','" + contact + "'," + h_number + ",'" + medical + "')"
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
				String medical = rs.getString(2);
				Hospital_Sql_Vo medical_info = new Hospital_Sql_Vo(medical);
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
			String findB = "select d_name from doctor_information where d_hospital=" + hospital_n + " and d_medical='"
					+ medical + "'";
			rs = stmt.executeQuery(findB);
			while (rs.next()) {
				String u_name = rs.getString(1);
				Hospital_Sql_Vo doctor_info = new Hospital_Sql_Vo(u_name);
				doctor_list.add(doctor_info);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return doctor_list;
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
