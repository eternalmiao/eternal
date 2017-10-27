package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bean.Collage;
import cn.dao.CollageDao;
import cn.dbc.BaseDao;

public class CollageDaoImpl implements CollageDao {
	private static Connection conn;
	private static PreparedStatement pstmt;
	@Override
	public boolean addCollage(Collage col) {
		String sql = "insert into collage(name) values(?)";
		List<Object> parms =  new ArrayList<>();
		parms.add(col.getName());
		return  BaseDao.operUpdate(sql, parms);
	
	}

	@Override
	public boolean updateCollage(Collage col) {
		String sql = "update collage set name=? where id=?";
		List<Object> parms =  new ArrayList<>();
		parms.add(col.getName());
		parms.add(col.getId());
		return  BaseDao.operUpdate(sql, parms);
	
	}

	@Override
	public boolean deleteCollage(int colId) {
		String sql = "delete from collage where id=?";
		List<Object> parms =  new ArrayList<>();
		parms.add(colId);
		return  BaseDao.operUpdate(sql, parms);
	
	}

	@Override
	public Collage findCollage(int id) {
		Collage col = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from collage where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				col = new Collage();
				col.setId(rs.getInt(1));
				col.setName(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			BaseDao.close(conn, pstmt, rs);
		}
		
		return col;
	}

	@Override
	public List<Collage> findAllCollage() {
		List<Collage> cols = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from collage";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			cols = new ArrayList<>();
			while(rs.next()){
				Collage col = new Collage();
				col.setId(rs.getInt(1));
				col.setName(rs.getString(2));
				cols.add(col);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			BaseDao.close(conn, pstmt, rs);
		}
		return cols;
	}

}
