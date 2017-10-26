package cn.bug.bean;

/**
 * 商品类型表
 * @author 远朋
 *
 */
public class Gtype {
	private int tid;		//类型编号
	private String tname;	//类型名称
	
	public Gtype() {
		super();
	}
	public Gtype(int tid, String tname) {
		super();
		this.tid = tid;
		this.tname = tname;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	
	
}
