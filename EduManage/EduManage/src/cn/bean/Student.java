package cn.bean;

public class Student {
	private int id;
	private String name;
	private String phone;
	private String password;
	private String address;
	private String dormiting;
	private Major major;
	private Grade grade;
	private int classno;
	public Student() {
		super();
	}
	public Student(int id, String name, String phone, String password,
			String address, String dormiting, Major major, Grade grade,
			int classno) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.password = password;
		this.address = address;
		this.dormiting = dormiting;
		this.major = major;
		this.grade = grade;
		this.classno = classno;
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
	public String getDormiting() {
		return dormiting;
	}
	public void setDormiting(String dormiting) {
		this.dormiting = dormiting;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public int getClassno() {
		return classno;
	}
	public void setClassno(int classno) {
		this.classno = classno;
	}
}
