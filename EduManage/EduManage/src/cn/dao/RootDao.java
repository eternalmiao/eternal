package cn.dao;

import cn.bean.Root;

public interface RootDao {
	public Root findRoot(String name);
	public boolean updateRoot(Root root);
	
}
