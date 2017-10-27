package cn.dao;

import java.util.List;

import cn.bean.Student;

public interface StudentDao {
	public boolean addStudent(Student stu);

	public boolean updateStudent(Student stu);

	public boolean deleteStudent(int id);

	public boolean deleteStudentByGrade(int gradeid);

	public Student findStudent(int id);

	public List<Student> findAllStudent();

	public List<Student> findStudentByGrade(int gradeid);

	public List<Student> findStudentByMajor(int majorid);

	public List<Student> findStudentByMG(int gradeid, int majorid);

	public List<Student> findStudentByMGC(int gradeid, int majorid, int classno);
}
