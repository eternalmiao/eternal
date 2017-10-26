package cn.bug.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bug.dao.WishlistDao;
import cn.bug.dao.impl.WishlistDaoImpl;
import cn.bug.framework.Action;

public class DelWishlistServlet implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		int wid = Integer.parseInt(request.getParameter("wid"));
		WishlistDao wld = new WishlistDaoImpl();
		boolean flag = wld.deleteWishList(wid);
		if(flag) {
			return "Wishlist.do";
		} else {
			return "404.jsp";
		}
	}

}
