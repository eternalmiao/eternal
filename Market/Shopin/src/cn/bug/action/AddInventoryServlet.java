package cn.bug.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bug.bean.Inventory;
import cn.bug.dao.InventoryDao;
import cn.bug.dao.impl.GoodsDaoImpl;
import cn.bug.dao.impl.InventoryDaoImpl;
import cn.bug.framework.Action;

public class AddInventoryServlet implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String size = request.getParameter("size");
		String gid = request.getParameter("gid");
		InventoryDao idao = new InventoryDaoImpl();
		Inventory inv = new Inventory();
		inv.setGnum(0);
		inv.setGoods(new GoodsDaoImpl().findGoodsById(Integer.parseInt(gid)));
		inv.setGsize(size);
		idao.AddInventory(inv);
		return "MgrInventory.do?gid="+gid;
	}

}
