package cn.bug.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bug.bean.*;
import cn.bug.dao.*;
import cn.bug.dao.impl.*;
import cn.bug.framework.Action;

public class SingleServlet implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		if (request.getSession().getAttribute("ShopUser") == null) {
			return "login.jsp";
		}
		ShopUser su = (ShopUser) request.getSession().getAttribute("ShopUser");
		String dowork = request.getParameter("dowork");
		String gid = request.getParameter("gid");
		// 加入购物车
		if (dowork.equals("cart")) {
			String size = request.getParameter("size");
			String buynum = request.getParameter("buynum");
			// System.out.println(size+";"+buynum+";"+gid);
			InventoryDao it = new InventoryDaoImpl();
			Inventory inv = it.FindInventoryByGidAndSize(Integer.parseInt(gid),
					size);
			CartDao cd = new CartDaoImpl();
			if (!cd.FindCartByUidAndCid(su.getU_id(), inv.getIid())) {
				Cart cart = new Cart(1, Integer.parseInt(buynum), inv, su);
				boolean flag = cd.AddtoCart(cart);
				if (!flag) {
					return "404.jsp";
				}
			}
			return "SingleShow.do?gid=" + gid;

		}
		// 加入收藏
		else {
			GoodsDao gd = new GoodsDaoImpl();
			Goods goods = gd.findGoodsById(Integer.parseInt(gid));
			WishlistDao wld = new WishlistDaoImpl();
			Wishlist wishlist = new Wishlist(1, goods, su);
			boolean flag = wld.AddWishlist(wishlist);
			if (flag) {

				return "SingleShow.do?gid=" + gid;

			} else {
				return "404.jsp";
			}
		}

	}

}
