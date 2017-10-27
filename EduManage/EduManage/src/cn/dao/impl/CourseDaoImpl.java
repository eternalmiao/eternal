package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bean.Course;
import cn.bean.Student;
import cn.dao.CourseDao;
import cn.dbc.BaseDao;

public class CourseDaoImpl implements CourseDao {
	private static Connection conn;
	private static PreparedStatement pstmt;
	@Override
	public boolean addCourse(Course cou) {
		String sql = "insert into course(subId,teaId,gradeId,classno,majorId,week,room,weekday,timepoint) values(?,?,?,?,?,?,?,?,?)";
		List<Object> parms =  new ArrayList<>();
		parms.add(cou.getSub().getId());
		parms.add(cou.getTea().getId());
		parms.add(cou.getGrade().getId());
		parms.add(cou.getClassno());
		
		parms.add(cou.getMajor().getId());
		parms.add(cou.getWeek());
		parms.add(cou.getRoom());
		parms.add(cou.getWeekday());
		parms.add(cou.getTimepoint());
		return BaseDao.operUpdate(sql, parms);
	}

	@Override
	public boolean updateCourse(Course cou) {
		String sql = "update course set subId=?,teaId=?,gradeId=?,classno=?,positionId=?,majorId=?,week=?,room=? where id=?";
		List<Object> parms =  new ArrayList<>();
		parms.add(cou.getSub().getId());
		parms.add(cou.getTea().getId());
		parms.add(cou.getGrade().getId());
		parms.add(cou.getClassno());
	
		parms.add(cou.getMajor().getId());
		parms.add(cou.getWeek());
		parms.add(cou.getRoom());
		parms.add(cou.getWeekday());
		parms.add(cou.getTimepoint());
		parms.add(cou.getId());
		return BaseDao.operUpdate(sql, parms);
	}
	
	@Override
	public boolean deleteCourse(int gradeid,int majorid,int classno,int weekday,int timepoint) {
		String sql = "delete from course where gradeId=? and majorId=? and classno=? and weekday=? and timepoint=?";
		List<Object> parms =  new ArrayList<>();
		parms.add(gradeid);
		parms.add(majorid);
		parms.add(classno);
		parms.add(weekday);
		parms.add(timepoint);
		return BaseDao.operUpdate(sql, parms);
	}
	
	@Override
	public boolean deleteCourseByClass(int gradeid, int majorid, int classno) {
		String sql = "delete from course where gradeId=? and majorId=? and classno=? ";
		List<Object> parms =  new ArrayList<>();
		parms.add(gradeid);
		parms.add(majorid);
		parms.add(classno);
		return BaseDao.operUpdate(sql, parms);
	}
	
	@Override
	public List<Course> findCouseByStu(Student stu) {
		List<Course> cous = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql  = "select * from course where gradeId=? and majorId=? and classno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stu.getGrade().getId());
			pstmt.setInt(2, stu.getMajor().getId());
			pstmt.setInt(3, stu.getClassno());
			rs = pstmt.executeQuery();
			cous = new ArrayList<>();
			while(rs.next()){
				Course cou = new Course();
				cou.setId(rs.getInt(1));
				cou.setSub(new SubjectDaoImpl().findSubject(rs.getInt(2)));
				cou.setTea(new TeacherDaoImpl().findTeacher(rs.getInt(3)));
				cou.setGrade(new GradeDaoImpl().findGrade(rs.getInt(4)));
				cou.setClassno(rs.getInt(5));
				cou.setMajor(new MajorDaoImpl().findMajor(rs.getInt(6)));
				cou.setWeek(rs.getString(7));
				cou.setRoom(rs.getString(8));
				cou.setWeekday(rs.getInt(9));
				cou.setTimepoint(rs.getInt(10));
				cous.add(cou);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			BaseDao.close(conn, pstmt, rs);
		}
		
		return cous;
	}

	@Override
	public List<Course> findCouseByTea(int teaId) {
		List<Course> cous = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql  = "select * from course where teaId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, teaId);
			rs = pstmt.executeQuery();
			cous = new ArrayList<>();
			while(rs.next()){
				Course cou = new Course();
				cou.setId(rs.getInt(1));
				cou.setSub(new SubjectDaoImpl().findSubject(rs.getInt(2)));
				cou.setTea(new TeacherDaoImpl().findTeacher(rs.getInt(3)));
				cou.setGrade(new GradeDaoImpl().findGrade(rs.getInt(4)));
				cou.setClassno(rs.getInt(5));
				cou.setMajor(new MajorDaoImpl().findMajor(rs.getInt(6)));
				cou.setWeek(rs.getString(7));
				cou.setRoom(rs.getString(8));
				cou.setWeekday(rs.getInt(9));
				cou.setTimepoint(rs.getInt(10));
				cous.add(cou);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			BaseDao.close(conn, pstmt, rs);
		}
		
		return cous;
	}

	@Override
	public List<Course> findCouseByClass(int gradeid, int majorid, int classno) {
		List<Course> cous = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql  = "select * from course where gradeId=? and majorId=? and classno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gradeid);
			pstmt.setInt(2, majorid);
			pstmt.setInt(3, classno);
			rs = pstmt.executeQuery();
			cous = new ArrayList<>();
			while(rs.next()){
				Course cou = new Course();
				cou.setId(rs.getInt(1));
				cou.setSub(new SubjectDaoImpl().findSubject(rs.getInt(2)));
				cou.setTea(new TeacherDaoImpl().findTeacher(rs.getInt(3)));
				cou.setGrade(new GradeDaoImpl().findGrade(rs.getInt(4)));
				cou.setClassno(rs.getInt(5));
				cou.setMajor(new MajorDaoImpl().findMajor(rs.getInt(6)));
				cou.setWeek(rs.getString(7));
				cou.setRoom(rs.getString(8));
				cou.setWeekday(rs.getInt(9));
				cou.setTimepoint(rs.getInt(10));
				cous.add(cou);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			BaseDao.close(conn, pstmt, rs);
		}
		
		return cous;
	}



	

}
