package cn.bug.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bug.framework.Action;

public class CancelServlet implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		request.getSession().setAttribute("ShopUser", null);
		return "Index.do";
	}

}
