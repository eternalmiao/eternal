package cn.dao;

import java.util.List;

import cn.bean.Grade;

public interface GradeDao {
	public boolean addGrade(Grade grade);

	public boolean updateGrade(Grade grade);

	public boolean deleteGrade(int id);

	public Grade findGrade(int id);

	public List<Grade> findAllGrade();

}
