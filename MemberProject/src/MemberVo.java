//
public class MemberVo {
	private String u_id;
	private String u_pwd;
	private String u_number;
	private String u_name;
	private int u_date;
	private String u_address;
	private String u_contact;
	private String check;

	public MemberVo() {
	}

	public MemberVo(String u_id, String u_pwd, String u_name, int u_date, String u_address, String u_contact) {
		this.u_id = u_id;
		this.u_pwd = u_pwd;
		this.u_name = u_name;
		this.u_date = u_date;
		this.u_address = u_address;
		this.u_contact = u_contact;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_pwd() {
		return u_pwd;
	}

	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}

	public int getU_date() {
		return u_date;
	}

	public void setU_date(int u_date) {
		this.u_date = u_date;
	}

	public String getU_number() {
		return u_number;
	}

	public void setU_number(String u_number) {
		this.u_number = u_number;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_address() {
		return u_address;
	}

	public void setU_address(String u_address) {
		this.u_address = u_address;
	}

	public String getU_contact() {
		return u_contact;
	}

	public void setU_contact(String u_contact) {
		this.u_contact = u_contact;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}
}