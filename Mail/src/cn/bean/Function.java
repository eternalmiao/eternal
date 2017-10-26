package cn.bean;

public class Function {
	private int id;
	private User user;
	private int white;
	private int black;
	private int keyword;
	private int bayes;
	public Function() {
		super();
	}
	public Function(User user, int white, int black, int keyword, int bayes) {
		super();
		this.user = user;
		this.white = white;
		this.black = black;
		this.keyword = keyword;
		this.bayes = bayes;
	}
	public Function(int id, User user, int white, int black, int keyword, int bayes) {
		super();
		this.id = id;
		this.user = user;
		this.white = white;
		this.black = black;
		this.keyword = keyword;
		this.bayes = bayes;
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
	public int getWhite() {
		return white;
	}
	public void setWhite(int white) {
		this.white = white;
	}
	public int getBlack() {
		return black;
	}
	public void setBlack(int black) {
		this.black = black;
	}
	public int getKeyword() {
		return keyword;
	}
	public void setKeyword(int keyword) {
		this.keyword = keyword;
	}
	public int getBayes() {
		return bayes;
	}
	public void setBayes(int bayes) {
		this.bayes = bayes;
	}
	
}
