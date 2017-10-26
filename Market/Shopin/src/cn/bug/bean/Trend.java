package cn.bug.bean;

/**
 * 商品
 * @author 远朋
 *
 */
public class Trend {
	private	int tid;	//推荐商品位置
	private Goods goods;//商品信息
	
	public Trend() {
		super();
	}
	public Trend(int tid, Goods goods) {
		super();
		this.tid = tid;
		this.goods = goods;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	
}
