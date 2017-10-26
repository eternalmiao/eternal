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
public class RECheckNameServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ShopUserDao userDao = new ShopUserDaoImpl();
		String name = request.getParameter("uname");
		String info=null;
		try {
			PrintWriter out = response.getWriter();
			if (userDao.findUserByName(name)!=null) {		
				info="用户名已存在";
				out.print(info);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
