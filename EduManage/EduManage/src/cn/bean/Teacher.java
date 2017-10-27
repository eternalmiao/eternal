package cn.bean;

public class Teacher {
	private int id;
	private String name;
	private String phone;
	private String password;
	private String address;
	public Teacher() {
		super();
	}
	public Teacher(int id, String name, String phone, String password,
			String address) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.password = password;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
