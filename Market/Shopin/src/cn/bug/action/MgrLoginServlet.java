package cn.bug.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bug.bean.Manager;
import cn.bug.dao.ManagerDao;
import cn.bug.dao.impl.ManagerDaoImpl;
import cn.bug.framework.Action;

public class MgrLoginServlet implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String mname = request.getParameter("Username");
		String Psw = request.getParameter("Password");
		ManagerDao mdao = new ManagerDaoImpl();
		Manager mgr = mdao.FindManager(mname);
		if(mgr!=null){
			if(mgr.getPassword().equals(Psw)){
				request.getSession().setAttribute("mgr", mgr);
				return "CheckCommand.do";
			}else{
				request.setAttribute("error", 1);
				return "mgrlogin.jsp";
			}
		}else{
			request.setAttribute("error", 2);
			return "mgrlogin.jsp?";
		}
	}

}
