package cn.bean;

public class Command {
	private int id;
	private Student stu;
	private Subject sub;
	private Teacher tea;
	private String com;
	private int num;
	public Command() {
		super();
	}
	public Command(int id, Student stu, Subject sub, Teacher tea, String com,
			int num) {
		super();
		this.id = id;
		this.stu = stu;
		this.sub = sub;
		this.tea = tea;
		this.com = com;
		this.num = num;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	public Subject getSub() {
		return sub;
	}
	public void setSub(Subject sub) {
		this.sub = sub;
	}
	public Teacher getTea() {
		return tea;
	}
	public void setTea(Teacher tea) {
		this.tea = tea;
	}
	public String getCom() {
		return com;
	}
	public void setCom(String com) {
		this.com = com;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	

}
