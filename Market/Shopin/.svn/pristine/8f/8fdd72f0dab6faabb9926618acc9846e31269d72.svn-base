package cn.bug.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bug.dao.ShopUserDao;
import cn.bug.dao.impl.ShopUserDaoImpl;

@SuppressWarnings("serial")
public class CheckNameServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ShopUserDao userDao = new ShopUserDaoImpl();
		String name = request.getParameter("ucount");
		String info = null;
		try {
			PrintWriter out = response.getWriter();
			if (name.isEmpty()) {
				info = "请输入账号";
			}else{
				if (userDao.findUserByName(name) == null
						&& userDao.findUserByEmail(name) == null
						) {
					info = "用户不存在";
				}else{
					info = " ";
				}
			}
			out.print(info);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
