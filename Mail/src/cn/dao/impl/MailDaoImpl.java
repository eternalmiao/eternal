package cn.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.bean.Mail;
import cn.bean.Page;
import cn.bean.User;
import cn.dao.MailDao;

public class MailDaoImpl extends HibernateDaoSupport implements MailDao {
//	private SessionFactory sessionFactory;

//	public SessionFactory getSessionFactory() {
//		return sessionFactory;
//	}
//	
//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}
	
	@Override
	public boolean insertMail(Mail mail) {
		boolean isFlag = false;
		try {
			this.getHibernateTemplate().save(mail);
			isFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
			return isFlag;
		}
		return isFlag;
	}

	@Override
	public boolean insertMail(List<Mail> list) {
		boolean isFlag = false;
		try {
			for(int i=0; i<list.size(); i++) {
				this.getHibernateTemplate().saveOrUpdate(list.get(i));
			}
			isFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
			return isFlag;
		}
		return isFlag;
	}

	@Override
	public boolean isExist(Mail mail) {
		boolean isExist = false;
		List<Mail> list = this.getHibernateTemplate().find("from Mail where item = '" + mail.getItem() + "'");
		if(! list.isEmpty()) {
			isExist = true;
		}
		return isExist;
	}

	@Override
	public List<Mail> findAllMail() {
		List<Mail> list = this.getHibernateTemplate().find("from Mail");
		return list;
	}

	@Override
	public Page findMailByPage(Page page) {
		String recipient = page.getUser().getEmail();
		
		@SuppressWarnings("unchecked")
		List<Mail> list = (List<Mail>) this.getHibernateTemplate().execute(
					new HibernateCallback(){
						@Override
						public Object doInHibernate(Session session) throws HibernateException, SQLException {
							Query query = session.createQuery("from Mail where recipient= '" + recipient +"'");
							query.setFirstResult(page.getFirstIndex());
							query.setMaxResults(page.getPageSize());
							return query.list();
						}});
		page.setList(list);
		return page;
		
	}

	@Override
	public long rowCount(User user) {
		List list = this.getHibernateTemplate().find("select count(id) from Mail where recipient = '" + user.getEmail() + "'");
		return (long) list.get(0);
	}

	@Override
	public Mail findMailByID(int id) {
			List<Mail> list = this.getHibernateTemplate().find("from Mail where id = " + id);
			return list.get(0);
	}

}
