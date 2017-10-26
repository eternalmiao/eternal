package cn.bug.dao;

import java.util.List;

import cn.bug.bean.Goods;
import cn.bug.bean.PageBean;

/**
 * 
 * @author vincent
 *
 */
public interface GoodsDao {
	public boolean addGoods(Goods good);
	public boolean updateGoods(Goods good);
	public boolean deleteGoods(int gid);
	/**
	 * 通过商品编号查询
	 * @param gid
	 * @return
	 */
	public Goods findGoodsById(int gid);
	/**
	 * 通过商品名称查询
	 * @param gname
	 * @return
	 */
	public Goods FindGoodsByGname(String gname);
	/**
	 * 通过商品类型查询
	 * @param tids
	 * @return
	 */
	public PageBean<Goods> FindGoodsByTypeId(List<Integer> tids,int index,int pageSize);
	/**
	 * 查询所有商品，无需条件
	 * @param index
	 * @param pageSize
	 * @return
	 */
	public PageBean<Goods> FindAllGoods(int index,int pageSize);
	/**
	 * 通过商品种类（男，女，童）查询
	 * @param gcaids
	 * @return
	 */
	public PageBean<Goods> FindGoodsByGcategories(List<Integer> gcaids,int index,int pageSize);
	/**
	 * 通过商品品牌查询
	 * @param bids
	 * @return
	 */
	public PageBean<Goods> FindGoodsByBrandId(List<Integer> bids,int index,int pageSize);
	/**
	 * 通过商品品牌（可多个）和商品种类（可多个）混合查询
	 * @param bids
	 * @param gcaids
	 * @return
	 */
	public PageBean<Goods> FindGoodsByBrandIdAndGcategories(List<Integer> bids,List<Integer> gcaids,int index,int pageSize);
	/**
	 * 通过商品类型（可多个）和商品种类（可多个）混合查询
	 * @param tids
	 * @param gcaids
	 * @return
	 */
	public PageBean<Goods> FindGoodsByTypeIdAndGca(List<Integer> tids,List<Integer> gcaids,int index,int pageSize);
	/**
	 * 通过商品类型（可多个）和商品品牌（可多个）混合查询
	 * @param tids
	 * @param bids
	 * @param index
	 * @param pageSize
	 * @return
	 */
	public PageBean<Goods> FindGoodsByTypeIdAndBrabd(List<Integer> tids,List<Integer> bids,int index,int pageSize);
	/**
	 * 通过商品品牌（可多个）和商品品牌（多个）和商品种类（可多个）混合查询
	 * @param tids
	 * @param bids
	 * @param gcaids
	 * @param index
	 * @param pageSize
	 * @return
	 */
	public PageBean<Goods> FindGoodsByTypeIdAndBrabdAndGca(List<Integer> tids,List<Integer> bids,List<Integer> gcaids,int index,int pageSize);
}
