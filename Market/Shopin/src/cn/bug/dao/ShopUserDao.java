package cn.bug.dao;

import cn.bug.bean.ShopUser;
/**
 * 用户类
 * @author Vincent
 *
 */
public interface ShopUserDao {
	/**
	 * 添加用户
	 * @param u
	 * @return
	 */
	public boolean addUser(ShopUser u);
	/**
	 * 更新用户
	 * @param u
	 * @return
	 */
	public boolean updateUser(ShopUser u);
	/**
	 * 通过id查询用户
	 * @param id
	 * @return
	 */
	public ShopUser findUserById(int id);
	/**
	 * 通过用户名查询
	 * @param name
	 * @return
	 */
	public ShopUser findUserByName(String name);
	/**
	 * 通过手机号码查询用户
	 * @param phone
	 * @return
	 */
	public ShopUser findUserByPhone(long phone);
	/**
	 * 通过email查询用户
	 * @param email
	 * @return
	 */
	public ShopUser findUserByEmail(String email);
}
