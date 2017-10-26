package cn.bug.bean;

/**
 * 商品信息表
 * @author 远朋
 *
 */
public class Goods {
	private	int	gid;			//商品编号
	private String gname;		//商品名称
	private double new_price;	//折后价格
	private double old_price;	//原价
	private String description;	//商品描述
	private String imgUrl;		//商品图片文件夹路径
	private Gtype type;		//商品类型
	private int gcategories;	//商品种类（男，女，小孩）
	private Brand brand;		//商品品牌
	
	public Goods() {
		super();
	}
	public Goods(int gid, String gname, double new_price, double old_price,
			String description, String imgUrl, Gtype type, int gcategories,
			Brand brand) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.new_price = new_price;
		this.old_price = old_price;
		this.description = description;
		this.imgUrl = imgUrl;
		this.type = type;
		this.gcategories = gcategories;
		this.brand = brand;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public double getNew_price() {
		return new_price;
	}
	public void setNew_price(double new_price) {
		this.new_price = new_price;
	}
	public double getOld_price() {
		return old_price;
	}
	public void setOld_price(double old_price) {
		this.old_price = old_price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public Gtype getType() {
		return type;
	}
	public void setType(Gtype type) {
		this.type = type;
	}
	public int getGcategories() {
		return gcategories;
	}
	public void setGcategories(int gcategories) {
		this.gcategories = gcategories;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}		
}
