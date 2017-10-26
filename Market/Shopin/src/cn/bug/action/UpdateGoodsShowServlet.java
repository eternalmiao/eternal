package cn.bug.action;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bug.bean.Brand;
import cn.bug.bean.Goods;
import cn.bug.bean.Gtype;
import cn.bug.bean.Orther;
import cn.bug.dao.BrandDao;
import cn.bug.dao.GoodsDao;
import cn.bug.dao.GtypeDao;
import cn.bug.dao.impl.BrandDaoImpl;
import cn.bug.dao.impl.GoodsDaoImpl;
import cn.bug.dao.impl.GtypeDaoImpl;
import cn.bug.framework.Action;
import cn.bug.framework.GetPhoto;

public class UpdateGoodsShowServlet implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		GoodsDao gd  = new GoodsDaoImpl();
		int gid =Integer.parseInt(request.getParameter("gid"));
		Goods goods = gd.findGoodsById(gid);
	
		String path = request.getSession().getServletContext().getRealPath("/"+goods.getImgUrl());
		File parentPath = new File(path);
		if(!parentPath.exists())
		{
			parentPath.mkdirs();
		}
		File []fs=parentPath.listFiles();
//		for(int i=0;i<fs.length;i++)
//		{
//			System.out.println(fs[i].getName());
//		}
		BrandDao bd = new BrandDaoImpl();
		List<Brand> bli = bd.FindAllBrand();
		GtypeDao gt = new GtypeDaoImpl();
		List<Gtype> gli= gt.FindAllGtype();
		request.setAttribute("Gtype", gli);
		request.setAttribute("Brand", bli);
		request.setAttribute("photo", fs);
		request.setAttribute("goods", goods);
		request.setAttribute("length", fs.length);
		String[] img= GetPhoto.getPhotos(gid, request);
		request.setAttribute("img", img);
		return "updategoods.jsp";
	}

}
