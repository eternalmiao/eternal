package cn.dao;

import java.util.List;

import cn.bean.Subject;

public interface SubjectDao {
	public boolean addSubject (Subject subject);
	public boolean updateSubject(Subject sub);
	public boolean deleteSubject(int id);
	public Subject findSubject(int id);
	public List<Subject> findAllSubject();
}
