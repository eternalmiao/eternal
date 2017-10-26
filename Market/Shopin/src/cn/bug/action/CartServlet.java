package cn.bug.action;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bug.bean.Cart;
import cn.bug.bean.ShopUser;
import cn.bug.dao.CartDao;
import cn.bug.dao.impl.CartDaoImpl;
import cn.bug.framework.Action;

public class CartServlet  implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		CartDao cd = new CartDaoImpl();
		ShopUser user = (ShopUser) request.getSession().getAttribute("ShopUser");
		List<Cart> list = cd.FindCartByUser(user.getU_id());;
		session.setAttribute("CartList", list);
		return "cart.jsp";
	}

}
