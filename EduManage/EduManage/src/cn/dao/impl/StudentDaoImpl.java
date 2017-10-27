package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bean.Student;
import cn.dao.StudentDao;
import cn.dbc.BaseDao;

public class StudentDaoImpl implements StudentDao {
	private static Connection conn;
	private static PreparedStatement pstmt;
	@Override
	public boolean addStudent(Student stu) {
		String sql = "insert into student(name,phone,password,address,dormiting,majorId,gradeId,classno) values(?,?,?,?,?,?,?,?)";
		List<Object> parms =  new ArrayList<>();
		parms.add(stu.getName());
		parms.add(stu.getPhone());
		parms.add(stu.getPassword());
		parms.add(stu.getAddress());
		parms.add(stu.getDormiting());
		parms.add(stu.getMajor().getId());
		parms.add(stu.getGrade().getId());
		parms.add(stu.getClassno());
		return BaseDao.operUpdate(sql, parms);
	
	}

	@Override
	public boolean updateStudent(Student stu) {
		String sql = "update student set name=?,phone=?,password=?,address=?,dormiting=?,majorId=?,gradeId=?,classno=? where id=?";
		List<Object> parms =  new ArrayList<>();
		parms.add(stu.getName());
		parms.add(stu.getPhone());
		parms.add(stu.getPassword());
		parms.add(stu.getAddress());
		parms.add(stu.getDormiting());
		parms.add(stu.getMajor().getId());
		parms.add(stu.getGrade().getId());
		parms.add(stu.getClassno());
		parms.add(stu.getId());
		return BaseDao.operUpdate(sql, parms);
	}

	@Override
	public boolean deleteStudent(int id) {
		String sql = "delete from student where id=?";
		List<Object> parms =  new ArrayList<>();
		parms.add(id);
		return BaseDao.operUpdate(sql, parms);
	}
	@Override
	public boolean deleteStudentByGrade(int gradeid) {
		String sql = "delete from student where gradeId=?";
		List<Object> parms =  new ArrayList<>();
		parms.add(gradeid);
		return BaseDao.operUpdate(sql, parms);
	}
	@Override
	public Student findStudent(int id) {
		Student stu = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from student where id=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				stu = new Student();
				stu.setId(rs.getInt(1));
				stu.setName(rs.getString(2));
				stu.setPhone(rs.getString(3));
				stu.setPassword(rs.getString(4));
				stu.setAddress(rs.getString(5));
				stu.setDormiting(rs.getString(6));
				stu.setMajor(new MajorDaoImpl().findMajor(rs.getInt(7)));
				stu.setGrade(new GradeDaoImpl().findGrade(rs.getInt(8)));
				stu.setClassno(rs.getInt(9));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.close(conn, pstmt, rs);
		}
		return stu;
	}

	@Override
	public List<Student> findAllStudent() {
		List<Student> stus = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from student";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			stus = new ArrayList<Student>();
			while(rs.next()){
				Student stu = new Student();
				stu.setId(rs.getInt(1));
				stu.setName(rs.getString(2));
				stu.setPhone(rs.getString(3));
				stu.setPassword(rs.getString(4));
				stu.setAddress(rs.getString(5));
				stu.setDormiting(rs.getString(6));
				stu.setMajor(new MajorDaoImpl().findMajor(rs.getInt(7)));
				stu.setGrade(new GradeDaoImpl().findGrade(rs.getInt(8)));
				stu.setClassno(rs.getInt(9));
				stus.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.close(conn, pstmt, rs);
		}
		return stus;
	}

	@Override
	public List<Student> findStudentByGrade(int gradeid) {
		List<Student> stus = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from student where gradeId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gradeid);
			rs = pstmt.executeQuery();
			stus = new ArrayList<Student>();
			while(rs.next()){
				Student stu = new Student();
				stu.setId(rs.getInt(1));
				stu.setName(rs.getString(2));
				stu.setPhone(rs.getString(3));
				stu.setPassword(rs.getString(4));
				stu.setAddress(rs.getString(5));
				stu.setDormiting(rs.getString(6));
				stu.setMajor(new MajorDaoImpl().findMajor(rs.getInt(7)));
				stu.setGrade(new GradeDaoImpl().findGrade(rs.getInt(8)));
				stu.setClassno(rs.getInt(9));
				stus.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.close(conn, pstmt, rs);
		}
		return stus;
		
	}

	@Override
	public List<Student> findStudentByMajor(int majorid) {
		List<Student> stus = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from student where majorId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, majorid);
			rs = pstmt.executeQuery();
			stus = new ArrayList<Student>();
			while(rs.next()){
				Student stu = new Student();
				stu.setId(rs.getInt(1));
				stu.setName(rs.getString(2));
				stu.setPhone(rs.getString(3));
				stu.setPassword(rs.getString(4));
				stu.setAddress(rs.getString(5));
				stu.setDormiting(rs.getString(6));
				stu.setMajor(new MajorDaoImpl().findMajor(rs.getInt(7)));
				stu.setGrade(new GradeDaoImpl().findGrade(rs.getInt(8)));
				stu.setClassno(rs.getInt(9));
				stus.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.close(conn, pstmt, rs);
		}
		return stus;
	}

	@Override
	public List<Student> findStudentByMG(int gradeid, int majorid) {
		List<Student> stus = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from student where gradeId=? and majorId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gradeid);
			pstmt.setInt(2, majorid);
			rs = pstmt.executeQuery();
			stus = new ArrayList<Student>();
			while(rs.next()){
				Student stu = new Student();
				stu.setId(rs.getInt(1));
				stu.setName(rs.getString(2));
				stu.setPhone(rs.getString(3));
				stu.setPassword(rs.getString(4));
				stu.setAddress(rs.getString(5));
				stu.setDormiting(rs.getString(6));
				stu.setMajor(new MajorDaoImpl().findMajor(rs.getInt(7)));
				stu.setGrade(new GradeDaoImpl().findGrade(rs.getInt(8)));
				stu.setClassno(rs.getInt(9));
				stus.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.close(conn, pstmt, rs);
		}
		return stus;
	}

	@Override
	public List<Student> findStudentByMGC(int gradeid, int majorid, int classno) {
		List<Student> stus = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from student where gradeId=? and majorId=? and classno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gradeid);
			pstmt.setInt(2, majorid);
			pstmt.setInt(3, classno);
			rs = pstmt.executeQuery();
			stus = new ArrayList<Student>();
			while(rs.next()){
				Student stu = new Student();
				stu.setId(rs.getInt(1));
				stu.setName(rs.getString(2));
				stu.setPhone(rs.getString(3));
				stu.setPassword(rs.getString(4));
				stu.setAddress(rs.getString(5));
				stu.setDormiting(rs.getString(6));
				stu.setMajor(new MajorDaoImpl().findMajor(rs.getInt(7)));
				stu.setGrade(new GradeDaoImpl().findGrade(rs.getInt(8)));
				stu.setClassno(rs.getInt(9));
				stus.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.close(conn, pstmt, rs);
		}
		return stus;
	}

	

}
