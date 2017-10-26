package cn.bug.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bug.dao.TrendDao;
import cn.bug.dao.impl.TrendDaoImpl;
import cn.bug.framework.Action;

public class RemoveFromTrendServlet implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String tid = request.getParameter("tid");
		TrendDao tdao = new TrendDaoImpl();
		tdao.DeleteTrend(Integer.parseInt(tid));
		return "TrendShow.do?";
	}

}
