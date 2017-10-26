package cn.bug.bean;

import java.util.Date;

/**
 * 评论记录表
 * @author Administrator
 *
 */
public class Command {
	private int cid;		//评论编号
	private GOrder gOrder;	//订单信息
	private ShopUser user;	//用户信息
	private String content;	//评论内容
	private Date ctime;		//评论时间
	private int csore;		//评论分数
	
	public GOrder getgOrder() {
		return gOrder;
	}
	public void setgOrder(GOrder gOrder) {
		this.gOrder = gOrder;
	}
	public Command(int cid, GOrder gOrder, ShopUser user, String content,
			Date ctime, int csore) {
		super();
		this.cid = cid;
		this.gOrder = gOrder;
		this.user = user;
		this.content = content;
		this.ctime = ctime;
		this.csore = csore;
	}
	public Command() {
		super();
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public ShopUser getUser() {
		return user;
	}
	public void setUser(ShopUser user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	public int getCsore() {
		return csore;
	}
	public void setCsore(int csore) {
		this.csore = csore;
	}
}
