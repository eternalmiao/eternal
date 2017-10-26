package cn.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.bean.TokenCount;
import cn.dao.TokenCountDao;

public class TokenCountDaoImpl extends HibernateDaoSupport implements TokenCountDao {

	@Override
	public boolean insertTokenCount(Map<String, TokenCount> tokenMap) {
		boolean isFlag = false;
		try {
			for (Map.Entry<String, TokenCount> entry : tokenMap.entrySet()) {
				TokenCount tokenCount = entry.getValue();
				this.getHibernateTemplate().save(tokenCount);
			}
			isFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
			return isFlag;
		}
		return isFlag;
	}

	@Override
	public Map<String, TokenCount> findAllTokenCount() {
		Map<String, TokenCount> tokenMap = new HashMap<String, TokenCount>();
		List<TokenCount> list = this.getHibernateTemplate().find("from TokenCount");
		for(int i=0; i<list.size(); i++) {
			tokenMap.put(list.get(i).getToken(), list.get(i));
		}
	
		return tokenMap;
	}

}
