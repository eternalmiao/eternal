package cn.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.bean.Blacklist;
import cn.bean.Keyword;
import cn.bean.User;
import cn.bean.Whitelist;
import cn.dao.BlacklistDao;
import cn.dao.KeywordDao;
import cn.dao.WhitelistDao;

public class AddAction extends ActionSupport{
	private WhitelistDao whitelistDao;
	private BlacklistDao blacklistDao;
	private KeywordDao keywordDao;
	private String value;
	private String title = null;
	private int type=0;
	public WhitelistDao getWhitelistDao() {
		return whitelistDao;
	}
	public void setWhitelistDao(WhitelistDao whitelistDao) {
		this.whitelistDao = whitelistDao;
	}
	public BlacklistDao getBlacklistDao() {
		return blacklistDao;
	}
	public void setBlacklistDao(BlacklistDao blacklistDao) {
		this.blacklistDao = blacklistDao;
	}
	public KeywordDao getKeywordDao() {
		return keywordDao;
	}
	public void setKeywordDao(KeywordDao keywordDao) {
		this.keywordDao = keywordDao;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String title() throws Exception {
		if(type == 1) {
			title = "白名单";
		}else if(type == 2) {
			title = "黑名单";
		} else if(type ==3){
			title = "关键字";
		}
		System.out.println(title);
		return super.execute();
	}
	

	@Override
	public String execute() throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(type == 1) {
			Whitelist wl = new Whitelist(user, value);
			whitelistDao.insertWhitelist(wl);
		} else if(type == 2) {
			Blacklist bl = new Blacklist(user, value);
			blacklistDao.insertBlacklist(bl);
		} else if(type == 3) {
			Keyword kw = new Keyword(user, value);
			keywordDao.insertKeyword(kw);
		} 
		return super.execute();
	}
}
