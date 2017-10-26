package cn.bean;

public class Assortment {
	private int id;
	private Mail mail;
	private String tag;
	
	public Assortment() {
		super();
	}

	public Assortment(Mail mail, String tag) {
		super();
		this.mail = mail;
		this.tag = tag;
	}

	public Assortment(int id, Mail mail, String tag) {
		super();
		this.id = id;
		this.mail = mail;
		this.tag = tag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Mail getMail() {
		return mail;
	}

	public void setMail(Mail mail) {
		this.mail = mail;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	
	
	
}
