package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bean.Major;
import cn.dao.MajorDao;
import cn.dbc.BaseDao;

public class MajorDaoImpl implements MajorDao {
	private static Connection conn;
	private static PreparedStatement pstmt;

	@Override
	public boolean addMajor(Major major) {
		String sql = "insert into major(name,colId) values(?,?)";
		List<Object> parms = new ArrayList<>();
		parms.add(major.getName());
		parms.add(major.getCollage().getId());
		return BaseDao.operUpdate(sql, parms);
	}

	@Override
	public boolean updateMajor(Major maj) {
		String sql = "update major set name=?,colID=? where id=?";
		List<Object> parms = new ArrayList<>();
		parms.add(maj.getName());
		parms.add(maj.getCollage().getId());
		parms.add(maj.getId());
		return BaseDao.operUpdate(sql, parms);
	}

	@Override
	public boolean deleteMajor(int id) {
		String sql = "delete from major where id=?";
		List<Object> parms = new ArrayList<>();
		parms.add(id);
		return BaseDao.operUpdate(sql, parms);
	}

	@Override
	public Major findMajor(int id) {
		Major maj = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from major where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				maj = new Major();
				maj.setId(rs.getInt(1));
				maj.setName(rs.getString(2));
				maj.setCollage(new CollageDaoImpl().findCollage(rs.getInt(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			BaseDao.close(conn, pstmt, rs);
		}
		return maj;
	}

	@Override
	public List<Major> findAllMajor() {
		List<Major> majs = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from major";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			majs = new ArrayList<>();
			while(rs.next()){
				Major maj = new Major();
				maj.setId(rs.getInt(1));
				maj.setName(rs.getString(2));
				maj.setCollage(new CollageDaoImpl().findCollage(rs.getInt(3)));
				majs.add(maj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			BaseDao.close(conn, pstmt, rs);
		}
		return majs;
	}

}
