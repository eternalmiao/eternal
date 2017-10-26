package cn.bug.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bug.dao.GoodsDao;
import cn.bug.dao.impl.GoodsDaoImpl;
import cn.bug.framework.Action;

public class MgrProductDeleServlet implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String gID = request.getParameter("GoodId");
		GoodsDao gDao = new GoodsDaoImpl();
		boolean flag = gDao.deleteGoods(Integer.parseInt(gID));
		System.out.println("-----------------商品"+gID+":删除？"+flag+"--------------------");
		return "MgrProduct.do";
	}

}
