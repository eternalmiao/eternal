package cn.bug.bean;

/**
 * 购物车表
 * @author 远朋
 *
 */
public class Cart {
	private int caid;		//购物车编号
	private int canum;		//购买数量
	private Inventory inventory;	//商品信息
	private ShopUser user;	//用户信息	
	
	public Cart() {
		super();
	}

	
	public Cart(int caid, int canum, Inventory inventory, ShopUser user) {
		super();
		this.caid = caid;
		this.canum = canum;
		this.inventory = inventory;
		this.user = user;
	}


	public Inventory getInventory() {
		return inventory;
	}
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	public int getCaid() {
		return caid;
	}
	public void setCaid(int caid) {
		this.caid = caid;
	}
	public int getCanum() {
		return canum;
	}
	public void setCanum(int canum) {
		this.canum = canum;
	}


	public ShopUser getUser() {
		return user;
	}
	public void setUser(ShopUser user) {
		this.user = user;
	}
	
}
