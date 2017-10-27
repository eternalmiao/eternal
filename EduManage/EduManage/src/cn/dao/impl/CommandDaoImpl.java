package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bean.Command;
import cn.dao.CommandDao;
import cn.dbc.BaseDao;

public class CommandDaoImpl implements CommandDao {
	private static Connection conn;
	private static PreparedStatement pstmt;

	@Override
	public boolean addCommand(Command comm) {
		String sql = "insert into command(stuId,subId,teaId,com,num) values (?,?,?,?,?)";
		List<Object> parms = new ArrayList<>();
		parms.add(comm.getStu().getId());
		parms.add(comm.getSub().getId());
		parms.add(comm.getTea().getId());
		parms.add(comm.getCom());
		parms.add(comm.getNum());
		return BaseDao.operUpdate(sql, parms);
	}

	@Override
	public List<Command> findCommandByTeaAndSub(int teaid, int subid) {
		List<Command> comms = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from command where subId=? and teaId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, subid);
			pstmt.setInt(2, teaid);
			rs = pstmt.executeQuery();
			comms = new ArrayList<>();
			while (rs.next()) {
				Command comm = new Command();
				comm.setId(rs.getInt(1));
				comm.setStu(new StudentDaoImpl().findStudent(rs.getInt(2)));
				comm.setSub(new SubjectDaoImpl().findSubject(rs.getInt(3)));
				comm.setTea(new TeacherDaoImpl().findTeacher(rs.getInt(4)));
				comm.setCom(rs.getString(5));
				comm.setNum(rs.getInt(6));
				comms.add(comm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.close(conn, pstmt, rs);
		}

		return comms;
	}

	@Override
	public List<Command> findCommandBySub(int subid) {
		List<Command> comms = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from command where subId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, subid);
			rs = pstmt.executeQuery();
			comms = new ArrayList<>();
			while (rs.next()) {
				Command comm = new Command();
				comm.setId(rs.getInt(1));
				comm.setStu(new StudentDaoImpl().findStudent(rs.getInt(2)));
				comm.setSub(new SubjectDaoImpl().findSubject(rs.getInt(3)));
				comm.setTea(new TeacherDaoImpl().findTeacher(rs.getInt(4)));
				comm.setCom(rs.getString(5));
				comm.setNum(rs.getInt(6));
				comms.add(comm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.close(conn, pstmt, rs);
		}

		return comms;
	}

	@Override
	public List<Command> findCommandByTea(int teaid) {
		List<Command> comms = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from command where teaId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, teaid);
			rs = pstmt.executeQuery();
			comms = new ArrayList<>();
			while (rs.next()) {
				Command comm = new Command();
				comm.setId(rs.getInt(1));
				comm.setStu(new StudentDaoImpl().findStudent(rs.getInt(2)));
				comm.setSub(new SubjectDaoImpl().findSubject(rs.getInt(3)));
				comm.setTea(new TeacherDaoImpl().findTeacher(rs.getInt(4)));
				comm.setCom(rs.getString(5));
				comm.setNum(rs.getInt(6));
				comms.add(comm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.close(conn, pstmt, rs);
		}

		return comms;
	}

}
