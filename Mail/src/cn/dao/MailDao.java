package cn.dao;

import java.util.List;

import cn.bean.Mail;
import cn.bean.Page;
import cn.bean.User;

public interface MailDao {
	public boolean insertMail(Mail mail);
	public boolean insertMail(List<Mail> list);
	public boolean isExist(Mail mail);
	public Mail findMailByID(int id);
	public List<Mail> findAllMail();
	public Page findMailByPage(Page page);
	public long rowCount(User user);
}
