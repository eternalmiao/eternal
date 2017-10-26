package cn.bug.action;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bug.bean.Command;
import cn.bug.bean.Goods;
import cn.bug.bean.Inventory;
import cn.bug.bean.ShopUser;
import cn.bug.dao.CartDao;
import cn.bug.dao.CommandDao;
import cn.bug.dao.GoodsDao;
import cn.bug.dao.InventoryDao;
import cn.bug.dao.WishlistDao;
import cn.bug.dao.impl.CartDaoImpl;
import cn.bug.dao.impl.CommandDaoImpl;
import cn.bug.dao.impl.GoodsDaoImpl;
import cn.bug.dao.impl.InventoryDaoImpl;
import cn.bug.dao.impl.WishlistDaoImpl;
import cn.bug.framework.Action;
import cn.bug.framework.GetPhoto;

public class SingleShowServlet implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		GoodsDao gd  = new GoodsDaoImpl();
		int gid =Integer.parseInt(request.getParameter("gid"));
		Goods goods = gd.findGoodsById(gid);
		if(goods!=null){
			String[] img = GetPhoto.getPhotos(gid, request);
			CommandDao cd = new CommandDaoImpl();
			InventoryDao it = new InventoryDaoImpl();
			List<Inventory> inve= it.FindInventoryByGid(gid);
			int numcount = 0 ;//统计商品的库存总量
			for(Inventory in:inve){
				numcount+=in.getGnum();
			}
			List<Command> comlist =  cd.FindCommamdByGid(gid);	
			List<String> imli = new ArrayList<String>();//将剩余的图片变成集合
	 		for(int i=3;i<img.length;i++)
			{
				imli.add(img[i]);
			}
	 		//判断是否已收藏
	 		request.setAttribute("wish", 0);
			if(request.getSession().getAttribute("ShopUser")!=null)
			{
				ShopUser su =(ShopUser)request.getSession().getAttribute("ShopUser");
				WishlistDao wi = new WishlistDaoImpl();
				if(wi.FindWislistByUserAndWid(su.getU_id(), gid))
				{
					request.setAttribute("wish", 1);
				}
			} 				
			request.setAttribute("goods", goods);
			request.setAttribute("img",img);
			request.setAttribute("imli", imli);
			request.setAttribute("comlist", comlist);
			request.setAttribute("inve", inve);
			request.setAttribute("numcount", numcount);
			return "single.jsp";			
		}
		else
		{
			return "404.jsp";
		}
	}

}
