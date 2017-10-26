package cn.bug.framework;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import cn.bug.bean.Goods;
import cn.bug.dao.GoodsDao;
import cn.bug.dao.impl.GoodsDaoImpl;

public class GetPhoto {
	/**
	 * 获取图片路径
	 * （注意：图片需改名为：1.jpg,2.jpg...
	 * 数据库存储格式如：images/imageUrl/）
	 * @param gid 商品编号
	 * @param request 请求
	 * @return String[] 储存数张图片的路径
	 */
	public  static String[] getPhotos(int gid,HttpServletRequest request)
	{
		GoodsDao gd  = new GoodsDaoImpl();
		Goods goods = gd.findGoodsById(gid);
		String photoUrl = goods.getImgUrl();
		//获取图片文件夹的真实路径
		String path =request.getSession().getServletContext().getRealPath("/"+photoUrl);		
		File file=new File(path);//获取文件夹
		File []fs=file.listFiles();//返回当前路径下的所有文件。
		String[] img=new String[fs.length];
		for(int i=0;i<fs.length;i++)
		{			
			img[i]=photoUrl+"/"+fs[i].getName();
		}
		return img;		
	}
}
