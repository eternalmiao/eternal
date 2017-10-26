package cn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.bean.Assortment;
import cn.bean.User;
import cn.dao.AssortmentDao;
import cn.dao.MailDao;

public class AssortmentDaoImpl extends HibernateDaoSupport implements AssortmentDao {
	@Override
	public boolean insertAssortment(Assortment assortment) {
		boolean isFlag = false;
		try {
			this.getHibernateTemplate().saveOrUpdate(assortment);
			isFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
			return isFlag;
		}
		return isFlag;
	}

	@Override
	public List<Assortment> findAssortment(User user, String tag) {
		List<Assortment> temp = this.getHibernateTemplate().find("from Assortment where tag='" + tag + "'");
		List<Assortment> list = new ArrayList<>();
		String recipient = user.getEmail();
		for(int i=0; i<temp.size(); i++) {
			if(temp.get(i).getMail().getRecipient().equals(recipient)) {
				list.add(temp.get(i));
			}
		}
		return temp;
	}

	@Override
	public long rowCount(User user, String tag) {
		List<Assortment> list = findAssortment(user, tag);
		return (long) list.size();
	}

}
