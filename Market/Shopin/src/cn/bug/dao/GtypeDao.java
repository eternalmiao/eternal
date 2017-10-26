package cn.bug.dao;

import java.util.List;

import cn.bug.bean.Gtype;
/**
 * 
 * @author vincent
 *
 */

public interface GtypeDao {
	/**
	 * 查询所有商品类型
	 * @return
	 */
	public List<Gtype> FindAllGtype();
	/**
	 * 查询商品类型
	 * @param tid
	 * @return
	 */
	public Gtype FindGtypeByGid(int tid);
}
