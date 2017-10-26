package cn.bug.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bug.bean.Orther;
import cn.bug.bean.Trend;
import cn.bug.dao.TrendDao;
import cn.bug.dao.impl.TrendDaoImpl;
import cn.bug.framework.Action;

public class TrendShowServlet implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		TrendDao tdao = new TrendDaoImpl();
		List<Trend> tlist = tdao.FindAllTrend();
		request.setAttribute("tlist", tlist);
		request.setAttribute("GCA", Orther.people);
		return "mgrTrend.jsp";
	}

}
