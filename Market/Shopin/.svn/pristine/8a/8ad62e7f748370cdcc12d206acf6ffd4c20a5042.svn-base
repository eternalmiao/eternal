package cn.bug.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bug.bean.Command;
import cn.bug.bean.GOrder;
import cn.bug.bean.GOrderAndComm;
import cn.bug.bean.Orther;
import cn.bug.bean.PageBean;
import cn.bug.bean.ShopUser;
import cn.bug.dao.CommandDao;
import cn.bug.dao.GOrderDao;
import cn.bug.dao.impl.CommandDaoImpl;
import cn.bug.dao.impl.GOrderDaoImpl;
import cn.bug.framework.Action;

public class OrderServlet implements Action {

	private int pageSize=5;
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		GOrderDao oDao = new GOrderDaoImpl();
		HttpSession session=request.getSession();
		ShopUser user=(ShopUser) session.getAttribute("ShopUser");
		if (user==null) {
			return "login.jsp";
		}
		int uid=user.getU_id();
		PageBean<GOrder> pb=null;
		if (request.getAttribute("order_pb")!=null)
		{
			pb=(PageBean<GOrder>) request.getAttribute("order_pb");
		}
		int index;
		String in=request.getParameter("index");
		if (in!=null)
		{
			index=Integer.parseInt(in);
		}else {
			index=1;
		}
		pb=oDao.FindGOrderByUser(uid, index, pageSize);
		if (index>pb.getPageCount())
		{
			index=pb.getPageCount();
		}
		pb=oDao.FindGOrderByUser(uid, index, pageSize);
		request.setAttribute("oAndcs", getList(pb.getList()));//获取订单评论对象集合
		request.setAttribute("pageIndex", pb.getPageIndex());
		String[] list=Orther.status;
		request.setAttribute("list", list);
		return "order.jsp";
	}

	/**
	 * 获取订单评论对象集合
	 * @param orders
	 * @return
	 */
	private List<GOrderAndComm> getList(List<GOrder> orders)
	{
		if (orders!=null) {
			CommandDao cDao = new CommandDaoImpl();
			List<GOrderAndComm> list = new ArrayList<GOrderAndComm>();
			for (GOrder order : orders) {
				GOrderAndComm oAndc = new GOrderAndComm();
				oAndc.setOrder(order);
				Command command = cDao.FindCommandByOid(order.getOid());
				oAndc.setComm(command);
				list.add(oAndc);
			}
			return list;
		}
		else
		{
			return null;
		}
	}
	
}
