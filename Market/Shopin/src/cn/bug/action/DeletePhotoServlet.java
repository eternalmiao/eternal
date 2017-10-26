package cn.bug.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bug.bean.Goods;
import cn.bug.dao.GoodsDao;
import cn.bug.dao.impl.GoodsDaoImpl;
import cn.bug.framework.Action;

public class DeletePhotoServlet implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		int num = Integer.parseInt(request.getParameter("num"));
		int gid = Integer.parseInt(request.getParameter("gid"));
		GoodsDao gd = new GoodsDaoImpl();
		Goods goods = gd.findGoodsById(gid);
		String photoPath = request.getSession().getServletContext().getRealPath("/"+goods.getImgUrl());
		File photoFile = new File(photoPath);
		if(!photoFile.exists())
		{
		photoFile.mkdirs();
		}
		File[] photos=photoFile.listFiles();	
		System.out.println(num);
		photos[num-1].delete();
		return "UpdateGoodsShow.do?gid="+gid;
	}

}
