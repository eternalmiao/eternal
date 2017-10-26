package cn.bug.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bug.bean.Goods;
import cn.bug.bean.Inventory;
import cn.bug.dao.InventoryDao;
import cn.bug.dao.impl.GoodsDaoImpl;
import cn.bug.dao.impl.InventoryDaoImpl;
import cn.bug.framework.Action;

public class InventorySaveServlet implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String gid = request.getParameter("gid");
		String s = request.getParameter("S");
		String m = request.getParameter("M");
		String l = request.getParameter("L");
		String xl = request.getParameter("XL");
		String xxl = request.getParameter("XXL");
		GoodsDaoImpl gdao = new GoodsDaoImpl();
		if (gid != null && !gid.equals("")) {
			//Goods good = gdao.findGoodsById(Integer.parseInt(gid));
			int igid = Integer.parseInt(gid);
			InventoryDao idao = new InventoryDaoImpl();
			if(s!= null){
				if(!s.equals("")){
				Inventory inv= idao.FindInventoryByGidAndSize(igid, "S");
				inv.setGnum(Integer.parseInt(s));
				idao.UpdateInventory(inv);
				}
			}
			if( m!= null){
				if(!m.equals("")){
				Inventory inv= idao.FindInventoryByGidAndSize(igid, "M");
				inv.setGnum(Integer.parseInt(m));
				idao.UpdateInventory(inv);
				}
			}
			if( l!= null){
				if(!l.equals("")){
				Inventory inv= idao.FindInventoryByGidAndSize(igid, "L");
				inv.setGnum(Integer.parseInt(l));
				idao.UpdateInventory(inv);
				}
			}
			if( xl!= null){
				if(!xl.equals("")){
				Inventory inv= idao.FindInventoryByGidAndSize(igid, "XL");
				inv.setGnum(Integer.parseInt(xl));
				idao.UpdateInventory(inv);
				}
			}
			if( xxl!= null){
				if(!xxl.equals("")){
				Inventory inv= idao.FindInventoryByGidAndSize(igid, "XXL");
				inv.setGnum(Integer.parseInt(xxl));
				idao.UpdateInventory(inv);
				}
			}
		}
		return "MgrInventory.do?gid="+gid;
	}

}
