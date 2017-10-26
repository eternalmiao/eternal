package cn.bug.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bug.bean.Brand;
import cn.bug.bean.Goods;
import cn.bug.bean.Gtype;
import cn.bug.bean.Orther;
import cn.bug.bean.PageBean;
import cn.bug.dao.BrandDao;
import cn.bug.dao.GoodsDao;
import cn.bug.dao.GtypeDao;
import cn.bug.dao.impl.BrandDaoImpl;
import cn.bug.dao.impl.GoodsDaoImpl;
import cn.bug.dao.impl.GtypeDaoImpl;
import cn.bug.framework.Action;

public class MgrProductServlet implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		int pageIndex;
		int pageSize=6;
		PageBean<Goods> pageGoods = null;
		String index = request.getParameter("index");
		if (index!=null) {
			pageIndex = Integer.parseInt(index);
		}else{
			pageIndex=1;
		}
		if (pageIndex<1) {
			pageIndex=1;
		}
	
	//获得页面传来的商品种类，类型，品牌的ID值
		String gcategories = request.getParameter("gcategories");
		String gtype = request.getParameter("gtype");
		String brand = request.getParameter("brand");
	//存进requset的Attribute里面	
		request.setAttribute("gcategories", gcategories);
		request.setAttribute("gtype", gtype);
		request.setAttribute("brand", brand);
	//获得页面传来的商品种类，类型，品牌的select标签下标	
		String flag_gca = request.getParameter("gca_flag");
		String flag_gty = request.getParameter("gty_flag");
		String falg_bra = request.getParameter("brand_flag");
	//判断并存进requset的Attribute里面	
		if (flag_gca==null&&flag_gty==null&&falg_bra==null) {
			request.setAttribute("gca_flag", 0);
			request.setAttribute("gty_flag", 0);
			request.setAttribute("brand_flag", 0);
		}else{
			request.setAttribute("gca_flag", flag_gca);
			request.setAttribute("gty_flag", flag_gty);
			request.setAttribute("brand_flag", falg_bra);
		}
		
			
		BrandDao brandDao = new BrandDaoImpl();
		GtypeDao gtDao = new GtypeDaoImpl();
		GoodsDao gsDao = new GoodsDaoImpl();
		request.setAttribute("gcategories", gcategories);
		request.setAttribute("GCA", Orther.people);//获取商品种类集合
//		gcategories=Orther.people[Integer.parseInt(flag_gca)-1];
		
		List<Gtype> gList = gtDao.FindAllGtype();//商品类型集合
		request.setAttribute("gList", gList);
//		gtype=gList.get(Integer.parseInt(flag_gty)-1).getTname();
		
		List<Brand> bList = brandDao.FindAllBrand();//商品品牌集合
		request.setAttribute("bList", bList);		
//		brand=bList.get(Integer.parseInt(falg_bra)-1).getBname();
		
		
		List<Integer> gtylist = new ArrayList<Integer>();
		if (gtype!=null&&(!gtype.equals(""))) {
			gtylist.add(Integer.parseInt(gtype));
		}
		List<Integer> gcalist = new ArrayList<Integer>();
		if (gcategories!=null&&(!gcategories.equals(""))) {
			gcalist.add(Integer.parseInt(gcategories));
		}
		List<Integer> blist = new ArrayList<Integer>();
		if (brand!=null&&(!brand.equals(""))) {
			blist.add(Integer.parseInt(brand));
		}
				
		if (gtype==null&&gcategories==null&&brand==null) {//商品类型，商品种类，品牌为空
			pageGoods = gsDao.FindAllGoods(pageIndex, pageSize);
		}else if(gtype.equals("")&&gcategories.equals("")&&brand.equals("")){////商品类型，商品种类，品牌为空字符串
			pageGoods = gsDao.FindAllGoods(pageIndex, pageSize);
		}else if(gtype!=null&&gcategories.equals("")&&brand.equals("")){//商品类型
			pageGoods = gsDao.FindGoodsByTypeId(gtylist, pageIndex, pageSize);
		}else if(gtype.equals("")&&gcategories!=null&&brand.equals("")){//商品种类
			pageGoods = gsDao.FindGoodsByGcategories(gcalist, pageIndex, pageSize);
		}else if(gtype.equals("")&&gcategories.equals("")&&brand!=null){//品牌
			pageGoods = gsDao.FindGoodsByBrandId(blist, pageIndex, pageSize);
		}else if(gtype!=null&&gcategories!=null&&brand.equals("")){//商品类型，商品种类
			pageGoods = gsDao.FindGoodsByTypeIdAndGca(gtylist, gcalist, pageIndex, pageSize);
		}else if(gtype.equals("")&&gcategories!=null&&brand!=null){//商品种类，品牌
			pageGoods = gsDao.FindGoodsByBrandIdAndGcategories(blist, gcalist, pageIndex, pageSize);
		}else if(gtype!=null&&gcategories.equals("")&&brand!=null){//商品类型，品牌
			pageGoods = gsDao.FindGoodsByTypeIdAndBrabd(gtylist, blist, pageIndex, pageSize);
		}else if(gtype!=null&&gcategories!=null&&brand!=null){//商品类型，商品种类，品牌
			pageGoods = gsDao.FindGoodsByTypeIdAndBrabdAndGca(gtylist, blist, gcalist, pageIndex, pageSize);
		}
//		if (pageIndex>=pageGoods.getPageCount()) {
//			pageGoods.setPageIndex(pageGoods.getPageCount());
//		}
		request.setAttribute("pageGDs", pageGoods);
		return "mgrProduct.jsp";
	}

}
