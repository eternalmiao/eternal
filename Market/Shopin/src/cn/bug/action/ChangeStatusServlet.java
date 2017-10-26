package cn.bug.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bug.bean.GOrder;
import cn.bug.dao.GOrderDao;
import cn.bug.dao.impl.GOrderDaoImpl;
import cn.bug.framework.Action;

public class ChangeStatusServlet implements Action
{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response)
	{
		GOrderDao goDao=new GOrderDaoImpl();
		int oid=Integer.parseInt(request.getParameter("oid"));
		int ostatus=Integer.parseInt(request.getParameter("ostatus"));
		GOrder order=goDao.FindOrderByOid(oid);
		order.setOstatus(ostatus);
		request.setAttribute("ostatus", ostatus);
		if (goDao.updateGOrder(order))
		{
			if (ostatus==3||ostatus==2)
			{
				return "Order.do";
			}else {
				return "CheckCommand.do";
			}
		}else {
			return "404.jsp";
		}
	}

}
