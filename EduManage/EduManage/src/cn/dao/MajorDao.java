package cn.dao;

import java.util.List;

import cn.bean.Major;

public interface MajorDao {
	public boolean addMajor(Major major);
	public boolean updateMajor(Major maj);
	public boolean deleteMajor(int id);
	public Major findMajor(int id);
	public List<Major> findAllMajor();
	
}
