package cn.dao;

import cn.bean.User;

public interface UserDao {
	public User findUser(String email);
	public boolean insertUser(User user);
}
