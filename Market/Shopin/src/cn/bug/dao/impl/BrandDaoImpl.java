package cn.bug.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bug.bean.Brand;
import cn.bug.dao.BrandDao;
import cn.bug.util.BaseDao;

public class BrandDaoImpl extends BaseDao<Brand> implements BrandDao {

	List<Brand> list = new ArrayList<Brand>();
	ResultSet rs=null;
	@Override
	public List<Brand> FindAllBrand() {
		String sql = "select * from brand";
		list = executQuery(sql);
		return list;
	}

	@Override
	public Brand FindBrandByBid(int bid) {
		String sql = "select * from brand where bid = ?";
		rs = executeQuery(sql, bid);
		try {
			if(rs.next()){
				return getEntity(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll(rs, null, null);;
		}
		return null;
//		Brand brand  = new Brand();		
//		rs = executeQuery(sql,bid);
//		try {
//			if(rs.next())
//			{
//				brand=getEntity(rs);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}		
//		ResultSet rs=executeQuery(sql, bid);
//		return getEntity(rs);
	}

	@Override
	public Brand getEntity(ResultSet rs) {
		Brand brand = new Brand();
		try {			 
			brand.setBid(rs.getInt(1));
			brand.setBname(rs.getString(2));			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return brand;
	}

}
