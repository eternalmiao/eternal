package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bean.Result;
import cn.dao.ResultDao;
import cn.dbc.BaseDao;

public class ResultDaoImpl implements ResultDao {
	private static Connection conn;
	private static PreparedStatement pstmt;
	@Override
	public boolean addResult(Result res) {
		String sql = "insert into result(stuId,subId,teaId,score,time,iscomm)values(?,?,?,?,?,?)";
		List<Object> parms =  new ArrayList<>();
		parms.add(res.getStu().getId());
		parms.add(res.getSub().getId());
		parms.add(res.getTea().getId());
		parms.add(res.getScore());
		parms.add(res.getTime());
		parms.add(0);
		return BaseDao.operUpdate(sql, parms);
	}

	@Override
	public boolean updateResult(Result res) {
		String sql = "update result set score=?,time=?,iscomm=? where id=?";
		List<Object> parms =  new ArrayList<>();
		parms.add(res.getScore());
		parms.add(res.getTime());
		parms.add(res.getIscomm());
		parms.add(res.getId());
		return BaseDao.operUpdate(sql, parms);
	}
	@Override
	public boolean deleteResult(int stuid, int subid) {
		String sql = "delete from result where stuId=? and subId=?";
		List<Object> parms =  new ArrayList<>();
		parms.add(stuid);
		parms.add(subid);
		return BaseDao.operUpdate(sql, parms);
	}

	

	@Override
	public List<Result> findResultByStu(int stuid) {
		List<Result> ress = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from result where stuId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stuid);
			rs = pstmt.executeQuery();
			ress = new ArrayList<>();
			while(rs.next()){
				Result res = new Result();
				res.setId(rs.getInt(1));
				res.setStu(new StudentDaoImpl().findStudent(rs.getInt(2)));
				res.setSub(new SubjectDaoImpl().findSubject(rs.getInt(3)));
				res.setTea(new TeacherDaoImpl().findTeacher(rs.getInt(4)));
				res.setScore(rs.getDouble(5));
				res.setTime(rs.getString(6));
				res.setIscomm(rs.getInt(7));
				ress.add(res);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			BaseDao.close(conn, pstmt, rs);
		}
		return ress;
	}

	@Override
	public List<Result> findResultByTeaAndSub(int teaId, int subid) {
		List<Result> ress = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from result where teaId=? and subId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,teaId);
			pstmt.setInt(2, subid);
			rs = pstmt.executeQuery();
			ress = new ArrayList<>();
			while(rs.next()){
				Result res = new Result();
				res.setId(rs.getInt(1));
				res.setStu(new StudentDaoImpl().findStudent(rs.getInt(2)));
				res.setSub(new SubjectDaoImpl().findSubject(rs.getInt(3)));
				res.setTea(new TeacherDaoImpl().findTeacher(rs.getInt(4)));
				res.setScore(rs.getDouble(5));
				res.setTime(rs.getString(6));
				res.setIscomm(rs.getInt(7));
				ress.add(res);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			BaseDao.close(conn, pstmt, rs);
		}
		return ress;
	}

	@Override
	public Result checkResult(int stuid,int subid) {
		Result result = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from result where stuId=? and subId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,stuid);
			pstmt.setInt(2, subid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				result= new Result();
				result.setId(rs.getInt(1));
				result.setStu(new StudentDaoImpl().findStudent(rs.getInt(2)));
				result.setSub(new SubjectDaoImpl().findSubject(rs.getInt(3)));
				result.setTea(new TeacherDaoImpl().findTeacher(rs.getInt(4)));
				result.setScore(rs.getDouble(5));
				result.setTime(rs.getString(6));
				result.setIscomm(rs.getInt(7));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			BaseDao.close(conn, pstmt, rs);
		}
		return result;
		
	}

	@Override
	public List<Result> findResultBySub(int subid) {
		List<Result> ress = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from result where subId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, subid);
			rs = pstmt.executeQuery();
			ress = new ArrayList<>();
			while(rs.next()){
				Result res = new Result();
				res.setId(rs.getInt(1));
				res.setStu(new StudentDaoImpl().findStudent(rs.getInt(2)));
				res.setSub(new SubjectDaoImpl().findSubject(rs.getInt(3)));
				res.setTea(new TeacherDaoImpl().findTeacher(rs.getInt(4)));
				res.setScore(rs.getDouble(5));
				res.setTime(rs.getString(6));
				res.setIscomm(rs.getInt(7));
				ress.add(res);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			BaseDao.close(conn, pstmt, rs);
		}
		return ress;
	}

	

}
