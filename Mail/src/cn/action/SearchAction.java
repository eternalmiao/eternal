package cn.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.bean.Assortment;
import cn.bean.Mail;
import cn.bean.Page;
import cn.bean.User;
import cn.dao.AssortmentDao;
import cn.dao.MailDao;

public class SearchAction extends ActionSupport{
	private Page page;
	private MailDao mailDao;
	private AssortmentDao assortmentDao;
	private long rowCount;
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public MailDao getMailDao() {
		return mailDao;
	}
	public void setMailDao(MailDao mailDao) {
		this.mailDao = mailDao;
	}
	public long getRowCount() {
		return rowCount;
	}
	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}
	
	public AssortmentDao getAssortmentDao() {
		return assortmentDao;
	}
	public void setAssortmentDao(AssortmentDao assortmentDao) {
		this.assortmentDao = assortmentDao;
	}
	
	@Override
	public String execute() throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(page == null) {
			page = new Page(1);
		}
		page.setUser(user);
		page.setRowCount(this.mailDao.rowCount(user));
		page = this.mailDao.findMailByPage(page);
		return super.execute();
	}
	
	public String spam() throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		List<Assortment> list = assortmentDao.findAssortment(user,"spam");
		if(page == null) {
			page = new Page(1);
		}
		page.setUser(user);
		page.setRowCount(list.size());
		List<Mail> mails = new ArrayList<Mail>();
		for(int i=0; i<list.size(); i++) {
			Mail mail = list.get(i).getMail();
			mails.add(mail);
		}
		page.setList(mails);
		return super.execute();
	}
	
}
