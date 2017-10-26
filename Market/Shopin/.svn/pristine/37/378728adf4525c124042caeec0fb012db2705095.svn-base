package cn.bug.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bug.bean.Trend;
import cn.bug.dao.TrendDao;
import cn.bug.dao.impl.TrendDaoImpl;
import cn.bug.framework.Action;

public class IndexServlet implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		TrendDao tdao = new TrendDaoImpl();
		List<Trend> tlist = tdao.FindAllTrend();
		request.setAttribute("trend", tlist);
		return "index.jsp";
	}

}
