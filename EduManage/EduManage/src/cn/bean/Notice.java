package cn.bean;

public class Notice {
	private String stucontent;
	private String teacontent;

	public Notice() {
		super();
	}

	public Notice(String stucontent, String teacontent) {
		super();
		this.stucontent = stucontent;
		this.teacontent = teacontent;
	}

	public String getStucontent() {
		return stucontent;
	}

	public void setStucontent(String stucontent) {
		this.stucontent = stucontent;
	}

	public String getTeacontent() {
		return teacontent;
	}

	public void setTeacontent(String teacontent) {
		this.teacontent = teacontent;
	}

}
