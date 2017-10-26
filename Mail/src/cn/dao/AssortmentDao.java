package cn.dao;

import java.util.List;

import cn.bean.Assortment;
import cn.bean.User;

public interface AssortmentDao {
	public boolean insertAssortment(Assortment assortment);
	public List<Assortment> findAssortment(User user, String tag);
	public long rowCount(User user, String tag);
}
