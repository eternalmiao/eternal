package cn.dao;

import java.util.Map;

import cn.bean.TokenCount;


public interface TokenCountDao {

	public boolean insertTokenCount(Map<String, TokenCount> tokenMap);
	public Map<String, TokenCount> findAllTokenCount();
	
}
