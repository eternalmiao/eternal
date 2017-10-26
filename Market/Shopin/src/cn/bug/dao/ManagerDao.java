package cn.bug.dao;

import cn.bug.bean.Manager;
/**
 * 
 * @author vincent
 *
 */

public interface ManagerDao {
	/**
	 * 管理员更新
	 * @param mgr
	 * @return
	 */
	public boolean UpdateManager(Manager mgr);
	/**
	 * 管理员查询，主要用于登陆操作
	 * @param mid
	 * @return
	 */
	public Manager FindManager(String mname);
}
