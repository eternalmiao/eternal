package cn.bug.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bug.bean.Cart;
import cn.bug.bean.GOrder;
import cn.bug.bean.Inventory;
import cn.bug.bean.ShopUser;
import cn.bug.dao.CartDao;
import cn.bug.dao.GOrderDao;
import cn.bug.dao.InventoryDao;
import cn.bug.dao.impl.CartDaoImpl;
import cn.bug.dao.impl.GOrderDaoImpl;
import cn.bug.dao.impl.InventoryDaoImpl;
import cn.bug.framework.Action;

public class CheckOutServlet implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		GOrderDao god = new GOrderDaoImpl();
		InventoryDao idao = new InventoryDaoImpl();
		CartDao cd = new CartDaoImpl();
		HttpSession session = request.getSession();
		ShopUser user = (ShopUser) session.getAttribute("ShopUser");
		int ostatus = 0;
		String oaddress = request.getParameter("oaddress");
		String receiver = request.getParameter("receiver");
		long rephone = Long.parseLong(request.getParameter("rephone"));
		Date now = new Date();
		java.sql.Date otime = new java.sql.Date(now.getTime());
		List<Cart> list = (List<Cart>) session.getAttribute("CartList");
		GOrder gorder = null;
		for (int i = 0; i < list.size(); i++) {
			int caid = list.get(i).getCaid();
			Inventory it = list.get(i).getInventory();
			double price = list.get(i).getInventory().getGoods().getNew_price()
					* list.get(i).getCanum();
			gorder = new GOrder(0, user, it, ostatus, price, otime, oaddress,
					receiver, rephone);
			int gnum = list.get(i).getCanum();
			it.setGnum(it.getGnum() - gnum);
			//加入订单
			boolean flag1 = god.AddGOrder(gorder);
			if (!flag1) {
				return "404.jsp";
			} else {
				//成功继续更新库存
				boolean flag3 = idao.UpdateInventory(it);
				if (!flag3) {
					return "404.jsp";
				} else {
					//成功继续删掉购物车记录
					boolean flag2 = cd.DeleteOrderFormCart(caid);
					if (!flag2) {
						return "404.jsp";
					}
				}
			}

		}
		return "Cart.do";
	}
}
