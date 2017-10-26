package cn.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.bean.User;
import cn.dao.AssortmentDao;

public class LeftAction extends ActionSupport {

	private AssortmentDao assortmentDao;
	private long normal = 0;
	private long spam = 0;
	
	public AssortmentDao getAssortmentDao() {
		return assortmentDao;
	}

	public void setAssortmentDao(AssortmentDao assortmentDao) {
		this.assortmentDao = assortmentDao;
	}
	
	public long getNormal() {
		return normal;
	}

	public void setNormal(long normal) {
		this.normal = normal;
	}

	public long getSpam() {
		return spam;
	}

	public void setSpam(long spam) {
		this.spam = spam;
	}

	@Override
	public String execute() throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		normal = assortmentDao.rowCount(user, "normal");
		spam = assortmentDao.rowCount(user, "spam");
		return super.execute();
	}
}
