package cn.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.bean.Page;
import cn.bean.User;
import cn.dao.BlacklistDao;
import cn.dao.KeywordDao;
import cn.dao.WhitelistDao;

public class ManageAction extends ActionSupport {
	private WhitelistDao whitelistDao;
	private BlacklistDao blacklistDao;
	private KeywordDao keywordDao;
	private String title = null;
	private int type = 0;
	private Page page;	

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

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

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String white() throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		title = "白名单";
		type = 1;
		if(page == null) {
			page = new Page(1);
		}
		page.setUser(user);
		page.setRowCount(this.whitelistDao.rowCount(user));
		page = this.whitelistDao.findWhitelistByPage(page);
		return super.execute();
	}
	
	public String black() throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		title = "黑名单";
		type = 2;
		if(page == null) {
			page = new Page(1);
		}
		page.setUser(user);
		page.setRowCount(this.blacklistDao.rowCount(user));
		page = this.blacklistDao.findBlacklistByPage(page);
		return super.execute();
	}
	
	public String keyword() throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		title = "关键字";
		type = 3;
		if(page == null) {
			page = new Page(1);
		}
		page.setUser(user);
		page.setRowCount(this.keywordDao.rowCount(user));
		page = this.keywordDao.findKeywordByPage(page);
		return super.execute();
	}
	
}
