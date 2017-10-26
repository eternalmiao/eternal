package cn.util;


import java.util.List;

import cn.bean.Mail;
import cn.bean.User;
import cn.bean.Whitelist;
import cn.dao.UserDao;
import cn.dao.WhitelistDao;

public class WhiteFilter {
	public UserDao ud;
	public WhitelistDao wd;
	
	
	public UserDao getUd() {
		return ud;
	}


	public void setUd(UserDao ud) {
		this.ud = ud;
	}


	public WhitelistDao getWd() {
		return wd;
	}


	public void setWd(WhitelistDao wd) {
		this.wd = wd;
	}


	public String filter(Mail mail, User user) {
		String tag = "normal";
		List<Whitelist> list = wd.findWhitelist(user);
		String sender = mail.getSender();
		for(int i=0; i<list.size(); i++) {
			if(!sender.equals(list.get(i).getValue())) {
				tag = "spam";
				break;
			}			
		}	
		return tag;
	}
}
