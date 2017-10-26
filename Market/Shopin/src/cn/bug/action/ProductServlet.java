package cn.bug.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bug.bean.Goods;
import cn.bug.bean.PageBean;
import cn.bug.dao.GoodsDao;
import cn.bug.dao.impl.GoodsDaoImpl;
import cn.bug.framework.Action;

/**
 * 
 * @author vincent
 *
 */
public class ProductServlet implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		// 获取条件信息
		String gca = request.getParameter("gca");
		String gtype = request.getParameter("gtype");
		String brand = request.getParameter("brand");
		GoodsDao goodsDao = new GoodsDaoImpl();
		// 初始化分页信息，pagesize默认为9
		int index = 1;
		if (request.getParameter("index") == null) {
			index = 1;
		} else if (request.getParameter("index").equals("")) {
			index = 1;
		} else {
			index = Integer.parseInt(request.getParameter("index"));
		}
		int pageSize = 6;
		PageBean<Goods> pb = null;
		// 根据传参获取goods的信息
		if (gca.equals("") && gtype.equals("") && brand.equals("")) {

			pb = goodsDao.FindAllGoods(index, pageSize);

		} else if ( !gca.equals("") && gtype.equals("") && brand.equals("")) {

			pb = goodsDao.FindGoodsByGcategories(getList(gca), index, pageSize);

		} else if (gca.equals("") && !gtype.equals("") && brand.equals("")) {

			pb = goodsDao.FindGoodsByTypeId(getList(gtype), index, pageSize);

		} else if (gca.equals("") && gtype.equals("") && !brand.equals("")) {

			pb = goodsDao.FindGoodsByBrandId(getList(brand), index, pageSize);

		} else if (!gca.equals("") && !gtype.equals("") && brand.equals("")) {

			pb = goodsDao.FindGoodsByTypeIdAndGca(getList(gtype), getList(gca),
					index, pageSize);

		} else if (!gca.equals("") && gtype.equals("") && !brand.equals("")) {

			pb = goodsDao.FindGoodsByBrandIdAndGcategories(getList(brand),
					getList(gca), index, pageSize);

		} else if (gca.equals("") && !gtype.equals("") && !brand.equals("")) {

			pb = goodsDao.FindGoodsByTypeIdAndBrabd(getList(gtype),
					getList(brand), index, pageSize);

		} else {

			pb = goodsDao.FindGoodsByTypeIdAndBrabdAndGca(getList(gtype),
					getList(brand), getList(gca), index, pageSize);
		}
		// 将数据设置到request中
		request.setAttribute("pagebean", pb);
		request.setAttribute("gca", gca);
		request.setAttribute("gtype", gtype);
		request.setAttribute("brand", brand);
		// 将选择的条件返回，为了保持checkbox的选状态
		return "product.jsp";
	}

	/**
	 * 将字符串转化为List<Integer>集合
	 * 
	 * @param s
	 * @return
	 */
	public List<Integer> getList(String s) {
		List<Integer> list = new ArrayList<Integer>();
		// 切割出来开的第一个元素是""，应当舍弃
		String[] ss = s.split("");
		for (int i = 1; i < ss.length; i++) {
			list.add(Integer.parseInt(ss[i]));
		}
		return list;
	}

}
