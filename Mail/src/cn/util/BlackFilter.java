package cn.util;

import java.util.List;

import cn.bean.Blacklist;
import cn.bean.Mail;
import cn.bean.User;
import cn.dao.BlacklistDao;
import cn.dao.UserDao;


public class BlackFilter {
	public UserDao ud;
	public BlacklistDao bd;
	
	
	public UserDao getUd() {
		return ud;
	}


	public void setUd(UserDao ud) {
		this.ud = ud;
	}


	public BlacklistDao getBd() {
		return bd;
	}


	public void setBd(BlacklistDao bd) {
		this.bd = bd;
	}


	public String filter(Mail mail, User user) {
		String tag = "normal";
		List<Blacklist> list = bd.findBlacklist(user);
		String sender = mail.getSender();
		for(int i=0; i<list.size(); i++) {
			if(sender.equals(list.get(i).getValue())) {
				tag = "spam";
				break;
			}			
		}	
		return tag;
	}
}
