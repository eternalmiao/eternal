package cn.bug.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bug.framework.Action;

public class MgrCancelServlet implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("mgr", null);
		return "mgrlogin.jsp";
	}

}
