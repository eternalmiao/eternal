/**
 * 
 */
package cn.bug.test;

import org.junit.Test;

import cn.bug.bean.Goods;
import cn.bug.bean.Manager;
import cn.bug.bean.ShopUser;
import cn.bug.bean.Trend;
import cn.bug.dao.GoodsDao;
import cn.bug.dao.ManagerDao;
import cn.bug.dao.TrendDao;
import cn.bug.dao.impl.GoodsDaoImpl;
import cn.bug.dao.impl.ManagerDaoImpl;
import cn.bug.dao.impl.ShopUserDaoImpl;
import cn.bug.dao.impl.TrendDaoImpl;

/**

 * @ClassName:     Demo111.java

 * @Description:   TODO

 * 

 * @author          vincent

 * @version         V1.0  

 * @Date           2016-7-25 下午4:09:31 

 */
public class Demo111 {
	@Test
	public void kkk(){
		GoodsDao gDao=new GoodsDaoImpl();
		Goods goods=gDao.findGoodsById(7);
		System.out.println(goods);
	}
	
	@Test
	public void test01(){
		Manager mgr = null;
		ManagerDao mdao = new ManagerDaoImpl();
		mgr = mdao.FindManager("admin");
		System.out.println(mgr.getMname());
		mgr.setPassword("root");
		mdao.UpdateManager(mgr);
	}
	@Test
	public void test02(){
		ShopUser user = new ShopUser();
		ShopUserDaoImpl udao = new ShopUserDaoImpl();
//		user.setUname("vin");
//		user.setAddress("gd");
//		user.setPhone(1234);
//		user.setEmail("222@www.com");
//		user.setPassword("123");
//		System.out.println(udao.addUser(user));
		user =udao.findUserById(2);
		System.out.println(user);
		System.out.println(udao.findUserByEmail("222@www.com"));;
		System.out.println(udao.findUserByPhone(1234));
		System.out.println(udao.findUserByName("vin"));
		user.setPassword("666");
		System.out.println(udao.updateUser(user));
	}
	@Test
	public void test03(){
		Trend trend = new Trend();
		TrendDao tdao = new TrendDaoImpl();
		Goods goods = new Goods();
		goods.setGid(1);
		trend.setGoods(goods);
		System.out.println(tdao.AddTrendDao(trend));
	}

}
