/**
 * 
 */
package cn.bug.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.bug.bean.ShopUser;
import cn.bug.dao.ShopUserDao;
import cn.bug.util.BaseDao;

/**
 * 
 * @ClassName: ShopUserDaoImpl.java
 * 
 * @Description: TODO
 * 
 * 
 * 
 * @author vincent
 * 
 * @version V1.0
 * 
 * @Date 2016-7-25 上午11:10:04
 */
public class ShopUserDaoImpl extends BaseDao<ShopUser> implements ShopUserDao {

	@Override
	public boolean addUser(ShopUser u) {
		String sql = "insert into shopuser(uname,phone,email,password,address) values(?,?,?,?,?)";
		int len = executUpdate(sql, u.getUname(), u.getPhone(), u.getEmail(),
				u.getPassword(), u.getAddress());
		if (len > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateUser(ShopUser u) {
		String sql = "update shopuser set uname=?,phone=?,email=?,password=?,address=? where u_id=?";
		int len = executUpdate(sql, u.getUname(), u.getPassword(),
				u.getEmail(), u.getPassword(), u.getAddress(), u.getU_id());
		if (len > 0) {
			return true;
		}
		return false;
	}

	@Override
	public ShopUser findUserById(int id) {
		String sql = "select * from shopuser where u_id=?";
		ShopUser user = getEntity(executeQuery(sql, id));
		return user;
	}

	@Override
	public ShopUser findUserByName(String name) {
		String sql = "select * from shopuser where uname=?";
		ShopUser user = getEntity(executeQuery(sql, name));
		return user;
	}

	@Override
	public ShopUser findUserByPhone(long phone) {
		String sql = "select * from shopuser where phone=?";
		ShopUser user = getEntity(executeQuery(sql, phone));
		return user;
	}

	@Override
	public ShopUser findUserByEmail(String email) {
		String sql = "select * from shopuser where email=?";
		ShopUser user = getEntity(executeQuery(sql, email));
		return user;
	}

	@Override
	public ShopUser getEntity(ResultSet rs) {
		ShopUser user = null;
		try {
			while (rs.next()) {
				user = new ShopUser();
				user.setU_id(rs.getInt(1));
				user.setUname(rs.getString(2));
				user.setPhone(rs.getLong(3));
				user.setEmail(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setAddress(rs.getString(6));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
