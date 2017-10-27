package cn.bean;

public class Major {
	private int id;
	private String name;
	private Collage collage;
	public Major() {
		super();
	}
	public Major(int id, String name, Collage collage) {
		super();
		this.id = id;
		this.name = name;
		this.collage = collage;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collage getCollage() {
		return collage;
	}
	public void setCollage(Collage collage) {
		this.collage = collage;
	}
	

}
