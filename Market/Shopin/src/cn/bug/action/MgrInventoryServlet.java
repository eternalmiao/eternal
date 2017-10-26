package cn.bug.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bug.bean.Goods;
import cn.bug.bean.Inventory;
import cn.bug.bean.Orther;
import cn.bug.dao.GoodsDao;
import cn.bug.dao.InventoryDao;
import cn.bug.dao.impl.GoodsDaoImpl;
import cn.bug.dao.impl.InventoryDaoImpl;
import cn.bug.framework.Action;

public class MgrInventoryServlet implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String gid = request.getParameter("gid");
		if(gid!=null && gid!=""){
			GoodsDao gdao = new GoodsDaoImpl();
			Goods goods = gdao.findGoodsById(Integer.parseInt(gid));
			InventoryDao idao = new InventoryDaoImpl();
			List<Inventory> inventList = idao.FindInventoryByGid(Integer.parseInt(gid));
			request.setAttribute("ilist", inventList);
			request.setAttribute("goods", goods);
			request.setAttribute("GCA", Orther.people);
		}
		return "mgrInventory.jsp";
	}

}
