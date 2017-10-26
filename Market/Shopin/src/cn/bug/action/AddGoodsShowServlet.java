package cn.bug.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bug.bean.Brand;
import cn.bug.bean.Gtype;
import cn.bug.dao.BrandDao;
import cn.bug.dao.GtypeDao;
import cn.bug.dao.impl.BrandDaoImpl;
import cn.bug.dao.impl.GtypeDaoImpl;
import cn.bug.framework.Action;

public class AddGoodsShowServlet implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		BrandDao bd = new BrandDaoImpl();
		List<Brand> bli = bd.FindAllBrand();
		GtypeDao gt = new GtypeDaoImpl();
		List<Gtype> gli= gt.FindAllGtype();
		request.setAttribute("Gtype", gli);
		request.setAttribute("Brand", bli);
		return "addgoods.jsp";
	}

}
