package cn.bug.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.bug.bean.Inventory;
import cn.bug.bean.PageBean;
import cn.bug.dao.GoodsDao;
import cn.bug.dao.InventoryDao;
import cn.bug.util.BaseDao;

public class InventoryDaoImpl extends BaseDao<Inventory> implements InventoryDao {

	@Override
	public boolean AddInventory(Inventory inv) {
		String sql="insert into Inventory(Gid,Gsize,Gnum) values(?,?,?)";
		int num=executUpdate(sql, inv.getGoods().getGid(),inv.getGsize(),inv.getGnum());
		if (num>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean UpdateInventory(Inventory inv) {
		String sql="update Inventory set Gid=?,Gsize=?,Gnum=? where iid=?";
		int num=executUpdate(sql, inv.getGoods().getGid(),inv.getGsize(),inv.getGnum(),inv.getIid());
		if (num>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Inventory> FindInventoryByGid(int gid) {
		String sql="select * from Inventory where Gid=?";
		List<Inventory> list=executQuery(sql, gid);
		return list;
	}

	@Override
	public Inventory FindInventoryByGidAndSize(int gid, String size) {
		String sql="select * from Inventory where Gid=? and Gsize=?";
		ResultSet res = executeQuery(sql, gid,size);
		try {
			while(res.next()){
				return getEntity(res);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll(res, null, null);
		}
		return null;
	}

	@Override
	public Inventory FindInventoryByIid(int iid) {
		String sql="select * from Inventory where Iid=?";
		ResultSet res = executeQuery(sql,iid);
		try {
			while(res.next()){
				return getEntity(res);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PageBean<Inventory> FindAllInventory(int index, int pageSize) {
		PageBean<Inventory> pb = new PageBean<Inventory>();
		pb.setPageIndex(index);
		pb.setPageSize(pageSize);
		String sql="select * from Inventory";
		int count=getCount(sql);
		pb.setTotalCount(count);
		sql = "select * from (select I.*,rownum rn from Inventory I) where rn>? and rn<=?";		
		if(pb.getTotalCount()>0){
			int startRow = (pb.getPageIndex()-1)*pageSize;
			int endRow = pb.getPageIndex()*pageSize;
			List<Inventory> list = executQuery(sql, startRow,endRow);
			pb.setList(list);
		}
		return pb;
	}

	@Override
	public Inventory getEntity(ResultSet rs) {
		GoodsDao gd=new GoodsDaoImpl();
		Inventory Inventory=null;
		try {
				Inventory=new Inventory();
				Inventory.setIid(rs.getInt(1));
				Inventory.setGoods(gd.findGoodsById(rs.getInt(2)));
				Inventory.setGsize(rs.getString(3));
				Inventory.setGnum(rs.getInt(4));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Inventory;
	}

}
