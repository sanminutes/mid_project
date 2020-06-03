import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDAO {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/orcl";
	String user = "kosea";
	String password = "kosea2019a";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public ArrayList<MemberVo> list(String id) {
		// ArrayList는 자바에서 지원하는 자료구조..
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		System.out.println(list.size());
		try {
			connDB();
			String find = "SELECT pi.P_ID, pi.P_PWD, ui.U_NAME, ui.U_DATE, ui.U_ADDRESS, ui.U_CONTACT FROM PRIVATE_INFORMATION pi JOIN USER_INFORMATION ui ON pi.P_DUNUMBER = ui.U_NUMBER WHERE p_id = '"+id+"'";
			rs = stmt.executeQuery(find);
			while (rs.next()) {
				String u_id = rs.getString(1);
				String u_pwd = rs.getString(2);
				String u_name = rs.getString(3);
				int u_date = rs.getInt(4);
				String u_address = rs.getString(5);
				String u_contact = rs.getString(6);
				MemberVo pvinfo = new MemberVo(u_id, u_pwd, u_name, u_date, u_address, u_contact); 
				list.add(pvinfo);
			}
			

			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
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
