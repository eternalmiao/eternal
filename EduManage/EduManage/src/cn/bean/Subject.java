package cn.bean;

public class Subject {
	private int id;
	private String name;
	private int subtime;
	public Subject() {
		super();
	}
	public Subject(int id, String name, int subtime) {
		super();
		this.id = id;
		this.name = name;
		this.subtime = subtime;
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
	public int getSubtime() {
		return subtime;
	}
	public void setSubtime(int subtime) {
		this.subtime = subtime;
	}
	

}
