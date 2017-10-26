package cn.bean;

public class Blacklist {
	private int id;
	private User user;
	private String value;
	public Blacklist() {
		super();
	}
	public Blacklist(User user, String value) {
		super();
		this.user = user;
		this.value = value;
	}
	public Blacklist(int id, User user, String value) {
		super();
		this.id = id;
		this.user = user;
		this.value = value;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
	
}
