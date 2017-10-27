package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bean.Root;
import cn.dao.RootDao;
import cn.dbc.BaseDao;

public class RootDaoImpl implements RootDao {
	private static Connection conn;
	private static PreparedStatement pstmt;
	@Override
	public Root findRoot(String name) {
		Root root = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from root where name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()){
				root = new Root();
				root.setId(rs.getInt(1));
				root.setName(rs.getString(2));
				root.setPassword(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			BaseDao.close(conn, pstmt, rs);
		}
		return root;
	}
	@Override
	public boolean updateRoot(Root root) {
		String sql = "update root set password=? where id=?";
		List<Object> parms =  new ArrayList<>();
		parms.add(root.getPassword());
		parms.add(root.getId());
		return  BaseDao.operUpdate(sql, parms);
		
	}

}
