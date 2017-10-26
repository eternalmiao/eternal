package cn.dao;

import java.util.List;

import cn.bean.Blacklist;
import cn.bean.Page;
import cn.bean.User;

public interface BlacklistDao {

	public boolean insertBlacklist(Blacklist bl);
	public List<Blacklist> findBlacklist(User user);
	public Page findBlacklistByPage(Page page);
	public long rowCount(User user);
}
