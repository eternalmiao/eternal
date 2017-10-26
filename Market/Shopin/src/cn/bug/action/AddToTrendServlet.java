package cn.bug.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bug.bean.Trend;
import cn.bug.dao.TrendDao;
import cn.bug.dao.impl.GoodsDaoImpl;
import cn.bug.dao.impl.TrendDaoImpl;
import cn.bug.framework.Action;

public class AddToTrendServlet implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String gid = request.getParameter("gid");
		if(gid!=null){
			TrendDao tdao = new TrendDaoImpl();
			Trend trend = new Trend();
			trend.setGoods(new GoodsDaoImpl().findGoodsById(Integer.parseInt(gid)));
			tdao.AddTrendDao(trend);
		}
		return "TrendShow.do";
	}

}
