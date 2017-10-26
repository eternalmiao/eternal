package cn.bug.dao;

import cn.bug.bean.GOrder;
import cn.bug.bean.PageBean;
/**
 * 

 * @ClassName:     GOrderDao.java

 * @Description:   TODO

 * 

 * @author          vincent

 * @version         V1.0  

 * @Date           2016-7-25 上午10:01:31
 */
public interface GOrderDao {
	public boolean AddGOrder(GOrder order);
	public boolean updateGOrder(GOrder order);
	/**
	 * 通过ID查找订单
	 * @param oid 订单编号
	 * @return
	 */
	public GOrder FindOrderByOid(int oid);
	/**
	 * 通过用户查找订单
	 * @param uid
	 * @param index
	 * @param pageSize
	 * @return 订单集合
	 */
	public PageBean<GOrder> FindGOrderByUser(int uid,int index,int pageSize);
	/**
	 * 根据状态查找订单
	 * @param status
	 * @param index
	 * @param pageSize
	 * @return 订单集合
	 */
	public PageBean<GOrder> FindGOrderByStatus(int status,int index,int pageSize);
	/**
	 * 查看所有订单
	 * @return
	 */
	public PageBean<GOrder> FindAllGOrder(int index,int pageSize);
	/**
	 * 根据商品编号查找订单
	 * @param gid 
	 * @return
	 */
	public PageBean<GOrder> FindOrderByGid(int gid,int index,int pageSize);
}
