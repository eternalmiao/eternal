package cn.bug.bean;


/**
 * 用户信息表
 * @author 远朋
 */
public class ShopUser {
	private int u_id;		//用户编号
	private String uname;	//用户名
	private long phone;		//电话
	private String email;	//邮件
	private String password;//用户密码
	private String address;	//常用地址
	
	public ShopUser() {
		super();
	}
	
	public ShopUser(int u_id, String uname, long phone, String email,
			String password, String address) {
		super();
		this.u_id = u_id;
		this.uname = uname;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.address = address;
	}

	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	
	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
