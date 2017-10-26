package cn.bug.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bug.bean.Goods;
import cn.bug.bean.ShopUser;
import cn.bug.bean.Wishlist;
import cn.bug.dao.CartDao;
import cn.bug.dao.GoodsDao;
import cn.bug.dao.WishlistDao;
import cn.bug.dao.impl.CartDaoImpl;
import cn.bug.dao.impl.GoodsDaoImpl;
import cn.bug.dao.impl.WishlistDaoImpl;
import cn.bug.framework.Action;

public class AddToWishlistServlet implements Action {


	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		if(request.getParameter("caid")!=null) {
			int caid = Integer.parseInt(request.getParameter("caid"));
			CartDao cd = new CartDaoImpl();
			boolean flag = cd.DeleteOrderFormCart(caid);
			if(!flag) {
				return "404.jsp";
			}
		} 
		int gid = Integer.parseInt(request.getParameter("gid"));
		GoodsDao gd = new GoodsDaoImpl();
		WishlistDao wld = new WishlistDaoImpl();
		Goods goods = gd.findGoodsById(gid);
		ShopUser user = (ShopUser)request.getSession().getAttribute("ShopUser");
		Wishlist wishlist = new Wishlist(0, goods, user);
		boolean  flag = wld.AddWishlist(wishlist);
		if(flag) {
			return "Wishlist.do";
		} else {
			return "404.jsp";
		}

	}

}
