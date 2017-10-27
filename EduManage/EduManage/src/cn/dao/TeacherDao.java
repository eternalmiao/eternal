package cn.dao;

import java.util.List;

import cn.bean.Teacher;

public interface TeacherDao {
	public boolean addTeacher(Teacher tea);
	public boolean UpdateTeacher(Teacher tea);
	public boolean deleteTeacher(int id);
	public Teacher findTeacher(int id);
	public List<Teacher> findAllTeacher();
}
