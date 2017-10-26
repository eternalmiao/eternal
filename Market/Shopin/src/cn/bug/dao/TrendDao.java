package cn.bug.dao;

import java.util.List;
import cn.bug.bean.Trend;
/**
 * 推荐商品
 * @author vincent
 *
 */
public interface TrendDao {
	/**
	 * 添加推荐商品
	 * @param trend
	 * @return
	 */
	public boolean AddTrendDao(Trend trend);
	/**
	 * 删除推荐商品
	 * @param tid
	 * @return
	 */
	public boolean DeleteTrend(int tid);
	/**
	 * 更新推荐商品，主要是位置
	 * @param trend
	 * @return
	 */
	public boolean UpdateTrend(Trend trend);
	/**
	 * 查询所有推荐商品
	 * @return
	 */
	public List<Trend> FindAllTrend();
 }
