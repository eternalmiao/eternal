package cn.dao;

import java.util.List;

import cn.bean.Page;
import cn.bean.User;
import cn.bean.Whitelist;

public interface WhitelistDao {
	public boolean insertWhitelist(Whitelist bl);
	public List<Whitelist> findWhitelist(User user);
	public Page findWhitelistByPage(Page page);
	public long rowCount(User user);
}
