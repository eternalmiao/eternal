package cn.bug.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bug.bean.Inventory;
import cn.bug.dao.InventoryDao;
import cn.bug.dao.impl.InventoryDaoImpl;

public class SingleSizeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String size = request.getParameter("size");
		String gid = request.getParameter("gid");
		PrintWriter out;
		try {
			out = response.getWriter();
			InventoryDao it = new InventoryDaoImpl();
			Inventory inv =  it.FindInventoryByGidAndSize(Integer.parseInt(gid),size);
			out.print(inv.getGnum());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
