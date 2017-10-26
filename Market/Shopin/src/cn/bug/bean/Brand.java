package cn.bug.bean;

/**
 * 品牌表
 * @author 远朋
 *
 */
public class Brand {
	private int bid;
	private String bname;
	
	public Brand() {
		super();
	}
	public Brand(int bid, String bname) {
		super();
		this.bid = bid;
		this.bname = bname;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}	
}
