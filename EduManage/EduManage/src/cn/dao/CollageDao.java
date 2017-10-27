package cn.dao;

import java.util.List;

import cn.bean.Collage;

public interface CollageDao {
	public boolean addCollage(Collage col);
	public boolean updateCollage(Collage col);
	public boolean deleteCollage(int colid);
	public Collage findCollage(int id);
	public List<Collage> findAllCollage();

}
