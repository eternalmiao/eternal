package cn.util;

import java.util.List;

import cn.bean.Keyword;
import cn.bean.Mail;
import cn.bean.User;
import cn.dao.KeywordDao;
import cn.dao.UserDao;

public class KeywordFilter {
	public UserDao ud;
	public KeywordDao kd;
	
	public UserDao getUd() {
		return ud;
	}
	public void setUd(UserDao ud) {
		this.ud = ud;
	}
	public KeywordDao getKd() {
		return kd;
	}
	public void setKd(KeywordDao kd) {
		this.kd = kd;
	}
	
	public String filter(Mail mail, User user) {
		String tag = "normal";
		List<Keyword> list = kd.findKeyword(user);
		String subject = mail.getSubject();
		String content = mail.getContent();
		for(int i=0; i<list.size(); i++) {
			if(subject.contains(list.get(i).getValue()) || content.contains(list.get(i).getValue())) {
				tag = "spam";
				break;
			}			
		}	
		return tag;	
	}
}
