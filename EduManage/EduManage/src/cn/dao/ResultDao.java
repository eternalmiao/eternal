package cn.dao;

import java.util.List;

import cn.bean.Result;

public interface ResultDao {
	public boolean addResult(Result res);

	public boolean updateResult(Result res);
	
	public boolean deleteResult(int stuid,int subid);
	
	public Result checkResult(int stuid,int subid);

	public List<Result> findResultByStu(int stuid);
	
	public List<Result> findResultByTeaAndSub(int teaId, int subid);
	
	public List<Result>  findResultBySub(int subid);

}
