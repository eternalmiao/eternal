package cn.bug.bean;

import java.util.Date;

/**
 * 订单记录表
 * @author 远朋
 *
 */
public class GOrder {
	private int oid;		//订单编号
	private ShopUser user;	//用户信息
	private Inventory it;	//商品信息和尺寸
	private int ostatus;	//交易状态
	private double price;	//支付金额
	private Date otime;		//下单时间
	private String oaddress;//送货地址
	private String receiver;//接收人
	private long rephone;	//联系电话
	
	public GOrder() {
		super();
	}
	
	public GOrder(int oid, ShopUser user, Inventory it, int ostatus,
			double price, Date otime, String oaddress, String receiver,
			long rephone) {
		super();
		this.oid = oid;
		this.user = user;
		this.it = it;
		this.ostatus = ostatus;
		this.price = price;
		this.otime = otime;
		this.oaddress = oaddress;
		this.receiver = receiver;
		this.rephone = rephone;
	}

	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public ShopUser getUser() {
		return user;
	}
	public void setUser(ShopUser user) {
		this.user = user;
	}
	public Inventory getIt() {
		return it;
	}
	public void setIt(Inventory it) {
		this.it = it;
	}
	public int getOstatus() {
		return ostatus;
	}
	public void setOstatus(int ostatus) {
		this.ostatus = ostatus;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getOtime() {
		return otime;
	}
	public void setOtime(Date otime) {
		this.otime = otime;
	}
	public String getOaddress() {
		return oaddress;
	}
	public void setOaddress(String oaddress) {
		this.oaddress = oaddress;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public long getRephone() {
		return rephone;
	}
	public void setRephone(long rephone) {
		this.rephone = rephone;
	}
	
	
}
