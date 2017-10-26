package cn.dao;

import cn.bean.Function;
import cn.bean.User;

public interface FunctionDao {
	public boolean insertFunction(Function funcation);
	public boolean updateFunction(Function funcation);
	public Function findFunction(User user);
}
