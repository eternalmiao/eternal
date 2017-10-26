package cn.bug.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bug.bean.Command;
import cn.bug.bean.GOrder;
import cn.bug.bean.ShopUser;
import cn.bug.dao.CommandDao;
import cn.bug.dao.GOrderDao;
import cn.bug.dao.impl.CommandDaoImpl;
import cn.bug.dao.impl.GOrderDaoImpl;
import cn.bug.framework.Action;

public class AddCommServlet implements Action
{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response)
	{
		CommandDao cDao=new CommandDaoImpl();
		GOrderDao oDao=new GOrderDaoImpl();
		String content=request.getParameter("content");
		int csore=Integer.parseInt(request.getParameter("cscore"));
		ShopUser user=(ShopUser) request.getSession().getAttribute("ShopUser");
		int oid=Integer.parseInt(request.getParameter("oid"));
		GOrder gOrder=oDao.FindOrderByOid(oid);
		gOrder.setOstatus(5);
		Command comm=new Command();
		comm.setContent(content);
		comm.setCsore(csore);
		comm.setCtime(new Date());
		comm.setgOrder(gOrder);
		comm.setUser(user);
		if(cDao.AddCommand(comm))
		{
			oDao.updateGOrder(gOrder);
			return "Order.do";
		}
		else
		{
			return "404.jsp";
		}
	}

}
