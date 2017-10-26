/**
 * 
 */
package cn.bug.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.bug.bean.Manager;
import cn.bug.dao.ManagerDao;
import cn.bug.util.BaseDao;

/**
 * 
 * @ClassName: ManagerDaoImpl.java
 * 
 * @Description: TODO
 * 
 * 
 * 
 * @author vincent
 * 
 * @version V1.0
 * 
 * @Date 2016-7-25 上午10:55:30
 */
public class ManagerDaoImpl extends BaseDao<Manager> implements ManagerDao {

	@Override
	public boolean UpdateManager(Manager mgr) {
		String sql = "update manager set password=?,mname=? where mid=?";
		int len = executUpdate(sql, mgr.getPassword(), mgr.getMname(),
				mgr.getMid());
		if (len > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Manager FindManager(String mname) {
		String sql = "select * from manager where mname=?";
		Manager mgr = getEntity(executeQuery(sql, mname));
		return mgr;
	}

	@Override
	public Manager getEntity(ResultSet rs) {
		Manager mgr = null;
		try {
			while(rs.next()) {
				mgr = new Manager();
				mgr.setMid(rs.getInt(1));
				mgr.setMname(rs.getString(2));
				mgr.setPassword(rs.getString(3));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return mgr;
	}

}
