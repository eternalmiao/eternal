package cn.bug.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bug.bean.ShopUser;
import cn.bug.dao.ShopUserDao;
import cn.bug.dao.impl.ShopUserDaoImpl;
import cn.bug.framework.Action;

public class UpdateInfoServlet implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		ShopUserDao suDao=new ShopUserDaoImpl();
		ShopUser su=(ShopUser) request.getSession().getAttribute("ShopUser");
		ShopUser suu=new ShopUser(su.getU_id(), su.getUname(), su.getPhone(), 
				su.getEmail(), su.getPassword(), su.getAddress());
		String uname=request.getParameter("up_name");
		String address=request.getParameter("up_address");
		String email=request.getParameter("up_email");
		String password=request.getParameter("up_password");
		long phone=Long.parseLong(request.getParameter("up_phone"));
		suu.setUname(uname);
		suu.setAddress(address);
		suu.setEmail(email);
		suu.setPassword(password);
		suu.setPhone(phone);
		if (suDao.updateUser(suu)) {
			return "myInfo.jsp";
		}else {
			return "404.jsp";
		}
	}

}
