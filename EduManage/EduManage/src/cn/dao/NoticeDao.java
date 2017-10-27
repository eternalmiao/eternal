package cn.dao;

import cn.bean.Notice;

public interface NoticeDao {
	public boolean updateNotice(Notice notice);
	public Notice findNotice();

}
