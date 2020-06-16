public class Hospital_Sql_Vo {
	private String id;
	private String pwd;
	private String name;
	private int date;
	private String address;
	private String contact;
	private String hospital;
	private String medical;
	private String u_number;
	private String d_number;
	private String h_number;

	public Hospital_Sql_Vo() {
	}

	public Hospital_Sql_Vo(String u_id) {
		this.id = u_id;
	}

	public Hospital_Sql_Vo(int date, String u_id) { // int타입 string타입, 변수명 무시
		this.date = date;
		this.id = u_id;
	}

	public Hospital_Sql_Vo(String name, String address, String contact) {
		this.name = name;
		this.address = address;
		this.contact = contact;
	}

	public Hospital_Sql_Vo(String u_number, String name, int date, String address, String contact) {
		this.u_number = u_number;
		this.name = name;
		this.date = date;
		this.address = address;
		this.contact = contact;
	}

	public Hospital_Sql_Vo(String u_number, String medical, String name, int date, String address, String contact) {
		this.u_number = u_number;
		this.medical = medical;
		this.name = name;
		this.date = date;
		this.address = address;
		this.contact = contact;
	}

	public Hospital_Sql_Vo(String name, int date, String address, String contact, String id, String pwd,
			String u_number, String d_number) {

		this.name = name;
		this.date = date;
		this.address = address;
		this.contact = contact;
		this.id = id;
		this.pwd = pwd;
		this.u_number = u_number;
		this.d_number = d_number;
	}

	public Hospital_Sql_Vo(String name, int date, String address, String contact, String h_number, String id,
			String pwd, String hospital, String medical, String u_number, String d_number) {

		this.name = name;
		this.date = date;
		this.address = address;
		this.contact = contact;
		this.h_number = h_number;
		this.hospital = hospital;
		this.medical = medical;
		this.id = id;
		this.pwd = pwd;
		this.u_number = u_number;
		this.d_number = d_number;
	}

	public String getU_id() {
		return id;
	}

	public void setU_id(String u_id) {
		this.id = u_id;
	}

	public String getU_pwd() {
		return pwd;
	}

	public void setU_pwd(String u_pwd) {
		this.pwd = u_pwd;
	}

	public int getU_date() {
		return date;
	}

	public void setU_date(int u_date) {
		this.date = u_date;
	}

	public String getU_number() {
		return u_number;
	}

	public void setU_number(String u_number) {
		this.u_number = u_number;
	}

	public String getU_name() {
		return name;
	}

	public void setU_name(String u_name) {
		this.name = u_name;
	}

	public String getU_address() {
		return address;
	}

	public void setU_address(String u_address) {
		this.address = u_address;
	}

	public String getU_contact() {
		return contact;
	}

	public void setU_contact(String u_contact) {
		this.contact = u_contact;
	}

	public String getD_hospital() {
		return hospital;
	}

	public void setD_hospital(String d_hospital) {
		this.hospital = d_hospital;
	}

	public String getD_medical() {
		return medical;
	}

	public void setD_medical(String d_medical) {
		this.medical = d_medical;
	}

	public String getD_number() {
		return d_number;
	}

	public void setD_number(String d_number) {
		this.d_number = d_number;
	}

	public String getH_number() {
		return h_number;
	}

	public void setH_number(String h_number) {
		this.h_number = h_number;
	}

}