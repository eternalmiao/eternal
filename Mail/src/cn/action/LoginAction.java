package cn.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.bean.Mail;
import cn.bean.User;
import cn.dao.MailDao;
import cn.dao.UserDao;
import cn.util.ReceiveMailBySSL;


public class LoginAction extends ActionSupport{

	private MailDao mailDao;
	private UserDao userDao;
	private String email;
	private String password;
	private List<Mail> list;
	
	public MailDao getMailDao() {
		return mailDao;
	}

	public void setMailDao(MailDao mailDao) {
		this.mailDao = mailDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
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
	
	public List<Mail> getList() {
		return list;
	}

	public void setList(List<Mail> list) {
		this.list = list;
	}

	@Override
	public String execute() throws Exception {
		User user = userDao.findUser(email);
		try {
			ReceiveMailBySSL receiveMail = new ReceiveMailBySSL("pop3","pop.qq.com",email, password);
		
			List<Mail> temp = receiveMail.connect();
			list = new ArrayList<>();
			
			for(int i=0; i<temp.size(); i++) {
				if(! mailDao.isExist(temp.get(i)))
					list.add(temp.get(i));
			}
				
			mailDao.insertMail(list);
	
			if(user == null) {
				user = new User(email, password);
				userDao.insertUser(user);
			}
			
			ActionContext.getContext().getSession().put("list", list);
			ActionContext.getContext().getSession().put("user",user);
			
		} catch (Exception e) {
			return ERROR;
		} 
	
		return super.execute();
	}

	
	
}
