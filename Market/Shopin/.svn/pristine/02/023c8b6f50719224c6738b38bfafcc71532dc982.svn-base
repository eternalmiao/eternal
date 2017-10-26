package cn.bug.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bug.bean.ShopUser;
import cn.bug.bean.Wishlist;
import cn.bug.dao.CartDao;
import cn.bug.dao.WishlistDao;
import cn.bug.dao.impl.CartDaoImpl;
import cn.bug.dao.impl.WishlistDaoImpl;
import cn.bug.framework.Action;

public class WishlistServlet implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		ShopUser user = (ShopUser)session.getAttribute("ShopUser");
		WishlistDao wld = new WishlistDaoImpl();
		List<Wishlist> list = wld.FindWishListByUser(user.getU_id());
		session.setAttribute("Wishlist", list);
		return "wishlist.jsp";
	}

}
