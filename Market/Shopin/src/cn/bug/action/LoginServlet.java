package cn.bug.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bug.bean.ShopUser;
import cn.bug.dao.ShopUserDao;
import cn.bug.dao.impl.ShopUserDaoImpl;
import cn.bug.framework.Action;

public class LoginServlet  implements Action{


	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String s = request.getParameter("ck_signPSW");
		int savePSW = 0;
		if (s!=null) {
			savePSW = Integer.parseInt(s);
		}
		String uCount = request.getParameter("uname");
		String uPSW = request.getParameter("password");
		ShopUserDao userDao = new ShopUserDaoImpl();
		ShopUser user = null;
		if (userDao.findUserByName(uCount)!=null) {
			user = userDao.findUserByName(uCount);
		} else if(userDao.findUserByEmail(uCount)!=null) {
			user = userDao.findUserByEmail(uCount);
		} else if(userDao.findUserByPhone(Integer.parseInt(uCount))!=null){
			user = userDao.findUserByPhone(Integer.parseInt(uCount));
		}else{
			
		}
		if (user!=null) {
			if (user.getPassword().equals(uPSW)) {
				request.getSession().setAttribute("ShopUser", user);
			}else{
				request.setAttribute("errorPSW", "密码错误");
				return "login.jsp";
			}
			if(savePSW==1){
				Cookie uname = new Cookie("user_name", user.getUname());
				Cookie upsw = new Cookie("user_psw", user.getPassword());
				response.addCookie(uname);
				response.addCookie(upsw);
				System.out.println(request.getCookies().length);
			}
		}
		return "Index.do";
	}

}
