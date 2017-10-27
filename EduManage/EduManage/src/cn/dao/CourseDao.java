package cn.dao;

import java.util.List;

import cn.bean.Course;
import cn.bean.Student;

public interface CourseDao {
	public boolean addCourse(Course cou);

	public boolean updateCourse(Course cou);
	
	public boolean deleteCourse(int gradeid,int majorid,int classno,int weekday,int timepoint);
	
	public boolean deleteCourseByClass(int gradeid,int majorid,int classno);

	public List<Course> findCouseByStu(Student stu);
	
	public List<Course> findCouseByClass(int gradeid,int majorid,int classno);

	public List<Course> findCouseByTea(int teaId);
}
