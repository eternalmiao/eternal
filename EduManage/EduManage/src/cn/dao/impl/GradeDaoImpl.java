package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bean.Grade;
import cn.dao.GradeDao;
import cn.dbc.BaseDao;

public class GradeDaoImpl implements GradeDao{
	private static Connection conn;
	private static PreparedStatement pstmt;

	@Override
	public boolean addGrade(Grade grade) {
		String sql = "insert into grade(name) values(?)";
		List<Object> parms =  new ArrayList<>();
		parms.add(grade.getName());
		return BaseDao.operUpdate(sql, parms);

	}

	@Override
	public boolean updateGrade(Grade grade) {
		String sql = "update grade set name=? where id=?";
		List<Object> parms =  new ArrayList<>();
		parms.add(grade.getName());
		parms.add(grade.getId());
		return BaseDao.operUpdate(sql, parms);
	}

	@Override
	public boolean deleteGrade(int id) {
		String sql = "delete from grade where id=?";
		List<Object> parms =  new ArrayList<>();
		parms.add(id);
		return BaseDao.operUpdate(sql, parms);
	}

	@Override
	public Grade findGrade(int id) {
		Grade grade  = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from grade where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				grade = new Grade();
				grade.setId(rs.getInt(1));
				grade.setName(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			BaseDao.close(conn, pstmt, rs);
		}
		return grade;
	}

	@Override
	public List<Grade> findAllGrade() {
		List<Grade>  grades = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from grade";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			grades = new ArrayList<>();
			while(rs.next()){
				Grade grade = new Grade();
				grade.setId(rs.getInt(1));
				grade.setName(rs.getString(2));
				grades.add(grade);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			BaseDao.close(conn, pstmt, rs);
		}
		return grades;
	}

}
