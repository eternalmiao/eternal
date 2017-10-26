package cn.bug.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bug.bean.ShopUser;
import cn.bug.dao.ShopUserDao;
import cn.bug.dao.impl.ShopUserDaoImpl;
import cn.bug.framework.Action;


public class RegisterServlet implements Action{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		ShopUserDao userDao = new ShopUserDaoImpl();
		long phone = Long.parseLong(request.getParameter("uphone"));
		String email = request.getParameter("uemail");
		String psw = request.getParameter("uPSW");
		String name = request.getParameter("uname");
		String address = request.getParameter("uaddress");
		if (email!=null&&psw!=null&&name!=null&&address!=null&&phone!=0) {
			if (userDao.findUserByName(name)==null) {
				ShopUser user = new ShopUser(0, name, phone, email, psw, address);
				userDao.addUser(user);
				request.getSession().setAttribute("ShopUser", user);
				return "Index.do";
			}else{
				return "register.jsp";
			}
		}
		return "register.jsp";
	}


}
