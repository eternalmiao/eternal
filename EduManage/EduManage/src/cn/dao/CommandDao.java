package cn.dao;

import java.util.List;

import cn.bean.Command;

public interface CommandDao {
	public boolean addCommand(Command comm);

	public List<Command> findCommandByTeaAndSub(int teaid, int subid);

	public List<Command> findCommandBySub(int subid);

	public List<Command> findCommandByTea(int teaid);
}
