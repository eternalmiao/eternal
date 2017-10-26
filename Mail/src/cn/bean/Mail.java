package cn.bean;


public class Mail {
	private int id;
	private String item;
	private String sender;
	private String recipient;
	private String date;
	private String subject;
	private String content;
	
	public Mail() {
		super();
	}

	public Mail(int id, String item, String sender, String recipient, String date, String subject, String content) {
		super();
		this.id = id;
		this.item = item;
		this.sender = sender;
		this.recipient = recipient;
		this.date = date;
		this.subject = subject;
		this.content = content;
	}

	public Mail(String item, String sender, String recipient, String date, String subject, String content) {
		super();
		this.item = item;
		this.sender = sender;
		this.recipient = recipient;
		this.date = date;
		this.subject = subject;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	

	
}
