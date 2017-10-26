package cn.bug.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bug.bean.Cart;
import cn.bug.dao.CartDao;
import cn.bug.dao.impl.CartDaoImpl;

public class ChangeCanumServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int caid = Integer.parseInt(request.getParameter("caid"));
		int canum = Integer.parseInt(request.getParameter("canum"));
		CartDao cd = new CartDaoImpl();
		Cart c = cd.FindCartByCaid(caid);
		c.setCanum(canum);
		boolean flag = cd.UpdateCart(c);
		PrintWriter out = response.getWriter();
		if(flag) {
			out.println("true");
		} else {
			out.println("false");
		}

	}

}
