package cn.bug.action;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

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

public class UpdateGoodsServlet implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		boolean flag = true;//判断是否第一次进入，防止创建多个文件夹
		int photoNum = 0;//该商品的第几张图
		String photoPath =null;//根目录		

		int gid=0;//商品编号
		gid = Integer.parseInt(request.getParameter("gid"));
		GoodsDao goo = new GoodsDaoImpl();
		Goods goods=goo.findGoodsById(gid);
		int gcid=0;//人群编号
		int tid=0;//类型编号
		Gtype gt=null;//类型对象
		int bid=0;//品牌编号
		Brand br=null;//品牌对象
		String gname=null;//商品名称
		double old_price=0.0;//原价
		double new_price=0.0;//现价
		String description=null;//描述
		String Url=goods.getImgUrl();//项目图片路径
		
		File []photos=null;//目录下的图片
		int photoName=0;
		String[] img = new String[20];//存放图片名字
		int imgnum=0;//第几个图片名字
		//判断提交的控件是否为多表单控件，如果是就以二进制的方式读取
		if(ServletFileUpload.isMultipartContent(request)){
			//创建一个FileItemFactory工厂
			FileItemFactory factory=new DiskFileItemFactory();
			//通过工厂获得该组件对象
			ServletFileUpload upload=new ServletFileUpload(factory);
			try {
				List<FileItem> list = upload.parseRequest(request);
				if(list!=null){
					for(FileItem fitem:list){
						if(fitem.isFormField()){
							//判断出为普通表单，并通过文件名取值
							if("gcategories".equals(fitem.getFieldName())){
								gcid=Integer.parseInt(fitem.getString("utf-8"));
							}
							if("gtype".equals(fitem.getFieldName())){
								tid=Integer.parseInt(fitem.getString("utf-8"));
								GtypeDao gd  = new GtypeDaoImpl();
								gt = gd.FindGtypeByGid(tid);
							}
							if("brand".equals(fitem.getFieldName())){
								bid=Integer.parseInt(fitem.getString("utf-8"));
								BrandDao bd = new BrandDaoImpl();
								br= bd.FindBrandByBid(bid);
							}
							if("gname".equals(fitem.getFieldName())){
								gname=fitem.getString("utf-8");
							}
							if("old_price".equals(fitem.getFieldName())){
								old_price=Double.parseDouble(fitem.getString("utf-8"));
							}
							if("new_price".equals(fitem.getFieldName())){
								new_price=Double.parseDouble(fitem.getString("utf-8"));
							}
							if("description".equals(fitem.getFieldName())){
								description=fitem.getString("utf-8");
							}
							if("photo".equals(fitem.getFieldName())){
								img[imgnum++]=fitem.getString("utf-8");
							}
						}else{				
							//获取到本项目的根目录
							if(flag){
								flag = false;								 
								photoPath = request.getSession().getServletContext().getRealPath("/"+Url);
								File photoFile = new File(photoPath);
								if(!photoFile.exists())
									{
									photoFile.mkdirs();
									}
								photos=photoFile.listFiles();										
								if(photos.length>0)
								{
									photoNum =photos.length ;	
								}
								if(photoNum==0)
								{
									photoName=0;
								}
								else{
									photoName=Integer.parseInt(photos[photoNum-1].getName().substring(0,photos[photoNum-1].getName().length()-4));
								}
							}
							//将file文件存储到，parentPath路径下
							
							if(!fitem.getName().equals("")&&fitem.getName()!=null){	
								int inum= Integer.parseInt((fitem.getFieldName().substring(5,fitem.getFieldName().length())));
								File newFile =null;
								if(inum<=imgnum)
								{									
									newFile = new File(photoPath,img[inum-1]);
								}
								else
								{
									newFile = new File(photoPath,(++photoName)+".jpg");
								}
								fitem.write(newFile);
							}									
						}
					}
				}
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
//		for(int i=0;i<imgnum;i++)
//		{
//			System.out.println(img[i]);
//		}
		Goods good = new Goods(gid,gname,new_price,old_price,description,Url,gt,gcid,br);
//		System.out.println(gname+";"+new_price+";"+old_price+";"+description+";"+Url+";"+gt.getTname()+";"+gcid+";"+br.getBname());
		GoodsDao gd = new GoodsDaoImpl();
		boolean addsu = gd.updateGoods(good);
		if(addsu){
			return "UpdateGoodsShow.do?gid="+gid;
		}
		return "MgrProduct.do";
	}
	
}
