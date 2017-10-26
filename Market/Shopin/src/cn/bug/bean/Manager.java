package cn.bug.bean;

/**
 * 管理员信息表
 * @author 远朋
 *
 */
public class Manager {
	private int mid;		//管理员编号
	private String mname;	//管理员名称
	private String password;//管理员密码
	
	public Manager() {
		super();
	}
	public Manager(int mid, String mname, String password) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.password = password;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
