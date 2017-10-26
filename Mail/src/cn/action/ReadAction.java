package cn.action;

import com.opensymphony.xwork2.ActionSupport;

import cn.bean.Mail;
import cn.dao.MailDao;

public class ReadAction extends ActionSupport {
	private int id;
	private MailDao mailDao;
	private Mail mail;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public MailDao getMailDao() {
		return mailDao;
	}
	public void setMailDao(MailDao mailDao) {
		this.mailDao = mailDao;
	}

	public Mail getMail() {
		return mail;
	}
	public void setMail(Mail mail) {
		this.mail = mail;
	}
	@Override
	public String execute() throws Exception {
		mail = mailDao.findMailByID(id);	
		return super.execute();
	}
}
