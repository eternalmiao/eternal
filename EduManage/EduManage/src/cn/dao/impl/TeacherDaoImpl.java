package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bean.Teacher;
import cn.dao.TeacherDao;
import cn.dbc.BaseDao;

public class TeacherDaoImpl implements TeacherDao {
	private static Connection conn;
	private static PreparedStatement pstmt;
	@Override
	public boolean addTeacher(Teacher tea) {
		String sql = "insert into teacher(name,phone,password,address) values(?,?,?,?)";
		List<Object> parms =  new ArrayList<>();
		parms.add(tea.getName());
		parms.add(tea.getPhone());
		parms.add(tea.getPassword());
		parms.add(tea.getAddress());
		return BaseDao.operUpdate(sql, parms);
	}

	@Override
	public boolean UpdateTeacher(Teacher tea) {
		String sql = "update teacher set name=?,phone=?,password=?,address=? where id=?";
		List<Object> parms =  new ArrayList<>();
		parms.add(tea.getName());
		parms.add(tea.getPhone());
		parms.add(tea.getPassword());
		parms.add(tea.getAddress());
		parms.add(tea.getId());
		return BaseDao.operUpdate(sql, parms);
	}

	@Override
	public boolean deleteTeacher(int id) {
		String sql = "delete from teacher where id=?";
		List<Object> parms =  new ArrayList<>();
		parms.add(id);
		return BaseDao.operUpdate(sql, parms);
	}

	@Override
	public Teacher findTeacher(int id) {
		Teacher tea = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from teacher where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				tea = new Teacher();
				tea.setId(rs.getInt(1));
				tea.setName(rs.getString(2));
				tea.setPhone(rs.getString(3));
				tea.setPassword(rs.getString(4));
				tea.setAddress(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			BaseDao.close(conn, pstmt, rs);
		}
		
		return tea;
	}

	@Override
	public List<Teacher> findAllTeacher() {
		List<Teacher> teas = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from teacher";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			teas = new ArrayList<>();
			while(rs.next()){
				Teacher tea = new Teacher();
				tea.setId(rs.getInt(1));
				tea.setName(rs.getString(2));
				tea.setPhone(rs.getString(3));
				tea.setPassword(rs.getString(4));
				tea.setAddress(rs.getString(5));
				teas.add(tea);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			BaseDao.close(conn, pstmt, rs);
		}
		return teas;
	}

}
