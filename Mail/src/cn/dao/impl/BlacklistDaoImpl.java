package cn.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.bean.Blacklist;
import cn.bean.Page;
import cn.bean.User;
import cn.bean.Whitelist;
import cn.dao.BlacklistDao;

public class BlacklistDaoImpl extends HibernateDaoSupport implements BlacklistDao {

	@Override
	public boolean insertBlacklist(Blacklist bl) {
		boolean isFlag = false;
		try {
			this.getHibernateTemplate().save(bl);
			isFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
			return isFlag;
		}
		return isFlag;
	}

	@Override
	public List<Blacklist> findBlacklist(User user) {
		List<Blacklist> list = null;
		list = this.getHibernateTemplate().find("from Blacklist where uid = " + user.getId());
		return list;
	}

	@Override
	public Page findBlacklistByPage(Page page) {
		User user = page.getUser();
		@SuppressWarnings("unchecked")
		List<Whitelist> list = (List<Whitelist>) this.getHibernateTemplate().execute(
					new HibernateCallback(){
						@Override
						public Object doInHibernate(Session session) throws HibernateException, SQLException {
							Query query = session.createQuery("from Blacklist where uid= " + user.getId());
							query.setFirstResult(page.getFirstIndex());
							query.setMaxResults(page.getPageSize());
							return query.list();
						}});
		page.setList(list);
		return page;
	}

	@Override
	public long rowCount(User user) {
		List list = this.getHibernateTemplate().find("select count(id) from Blacklist where uid = " + user.getId());
		return (long) list.get(0);
	}

}
