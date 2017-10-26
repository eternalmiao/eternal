package cn.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.bean.User;
import cn.dao.UserDao;

public class UserDaoImpl  extends HibernateDaoSupport implements UserDao {

	@Override
	public User findUser(String email) {
		List<User> list = null;
		list = this.getHibernateTemplate().find("from User where email = '" + email + "'");
		return list.get(0);
	}

	@Override
	public boolean insertUser(User user) {
		boolean isFlag = false;
		try {
			this.getHibernateTemplate().save(user);
			isFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
			return isFlag;
		}
		return isFlag;
	}
	

}
