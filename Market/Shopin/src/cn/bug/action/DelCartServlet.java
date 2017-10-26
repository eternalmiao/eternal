package cn.bug.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bug.dao.CartDao;
import cn.bug.dao.impl.CartDaoImpl;
import cn.bug.framework.Action;

public class DelCartServlet implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		int caid = Integer.parseInt(request.getParameter("caid"));
		CartDao cd = new CartDaoImpl();
		boolean flag = cd.DeleteOrderFormCart(caid);
		if(flag) {
			return "Cart.do";
		} else {
			return "404.jsp";
		}
	}

}
