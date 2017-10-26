package cn.bug.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bug.bean.Manager;
import cn.bug.dao.ManagerDao;
import cn.bug.dao.impl.ManagerDaoImpl;
import cn.bug.framework.Action;

public class MgrChangePswServlet implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String newpsw = request.getParameter("newpsw");
		Manager mgr = (Manager) request.getSession().getAttribute("mgr");
		ManagerDao mdao = new ManagerDaoImpl();
		if(mgr!=null){
			mgr.setPassword(newpsw);
			if(mdao.UpdateManager(mgr)){
				return "changepswsucceed.jsp";
			}else{
				return "changepswfailed.jsp";
			}
		}
		return "mgrlogin.jsp";
	}

}
