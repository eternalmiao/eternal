package cn.bug.dao;

import java.util.List;

import cn.bug.bean.Inventory;
import cn.bug.bean.PageBean;

/**
 * 库存类
 * @author vincent
 * 
 */
public interface InventoryDao {
	public boolean AddInventory(Inventory inv);
	public boolean UpdateInventory(Inventory inv);
	/**
	 * 通过商品编码查询某类商品的所有尺寸的库存总量
	 * @param gid 商品编号
	 * @return 返回该类衣服所有尺寸集合
	 */
	public List<Inventory> FindInventoryByGid(int gid);
	/**
	 * 通过商品编号和尺码查询
	 * @param gid
	 * @param size
	 * @return
	 */
	public Inventory FindInventoryByGidAndSize(int gid,String size);
	/**
	 * 通过库存标号查询，即查询某款商品的具体尺寸的库存量
	 * @param iid
	 * @return 返回单累商品单个尺寸的商品
	 */
	public Inventory FindInventoryByIid(int iid);
	/**
	 * 查询所有商品的库存
	 * @return
	 */
	public PageBean<Inventory> FindAllInventory(int index,int pageSize);
}
