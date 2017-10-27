package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bean.Subject;
import cn.dao.SubjectDao;
import cn.dbc.BaseDao;

public class SubjectDaoImpl implements SubjectDao {
	private static Connection conn;
	private static PreparedStatement pstmt;
	@Override
	public boolean addSubject(Subject subject) {
		String sql = "insert into subject(name,subtime) values(?,?)";
		List<Object> parms = new ArrayList<>();
		parms.add(subject.getName());
		parms.add(subject.getSubtime());
		return BaseDao.operUpdate(sql, parms);
	}

	@Override
	public boolean updateSubject(Subject sub) {
		String sql = "update subject set name=?,subtime=? where id=? ";
		List<Object> parms = new ArrayList<>();
		parms.add(sub.getName());
		parms.add(sub.getSubtime());
		parms.add(sub.getId());
		return BaseDao.operUpdate(sql, parms);
	}

	@Override
	public boolean deleteSubject(int id) {
		String sql = "delete from subject where id=?";
		List<Object> parms = new ArrayList<>();
		parms.add(id);
		return BaseDao.operUpdate(sql, parms);
	}

	@Override
	public Subject findSubject(int id) {
		Subject sub = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from subject where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				sub = new Subject();
				sub.setId(rs.getInt(1));
				sub.setName(rs.getString(2));
				sub.setSubtime(rs.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			BaseDao.close(conn, pstmt, rs);
		}
		
		return sub;
	}

	@Override
	public List<Subject> findAllSubject() {
		List<Subject> subs = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from subject";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			subs = new ArrayList<>();
			while (rs.next()) {
				Subject sub = new Subject();
				sub.setId(rs.getInt(1));
				sub.setName(rs.getString(2));
				sub.setSubtime(rs.getInt(3));
				subs.add(sub);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			BaseDao.close(conn, pstmt, rs);
		}
		return subs;
	}

}
