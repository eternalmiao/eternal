package cn.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.bean.Function;
import cn.bean.User;
import cn.dao.FunctionDao;

public class FunctionDaoImpl extends HibernateDaoSupport implements FunctionDao {

	@Override
	public boolean insertFunction(Function function) {
		boolean isFlag = false;
		try {
			this.getHibernateTemplate().saveOrUpdate(function);
			isFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
			return isFlag;
		}
		return isFlag;
	}

	@Override
	public Function findFunction(User user) {
		List<Function> list = null;
		list = this.getHibernateTemplate().find("from Function where uid = " + user.getId());
		return list.get(0);
	}

	@Override
	public boolean updateFunction(Function function) {
		boolean isFlag = false;
		try {
			this.getHibernateTemplate().update(function);
			isFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
			return isFlag;
		}
		return isFlag;
	}

}
