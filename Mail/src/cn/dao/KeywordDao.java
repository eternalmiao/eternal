package cn.dao;

import java.util.List;

import cn.bean.Keyword;
import cn.bean.Page;
import cn.bean.User;

public interface KeywordDao {
	public boolean insertKeyword(Keyword kw);
	public List<Keyword> findKeyword(User user);
	public Page findKeywordByPage(Page page);
	public long rowCount(User user);
}
