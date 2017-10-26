package cn.bug.bean;

import java.util.List;

/**
 * 调用分页
 * @author 远朋
 *
 */
public class PageBean<T> {
	private int pageIndex;//当前页
	private int pageSize=2;//每页显示条数
	private int pageCount;//总页数
	private int totalCount;//总行数
	private List<T> list;//存储查询出来的分页数据
	
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		if(pageIndex<1){
			this.pageIndex=1;
		}else{
			this.pageIndex = pageIndex;
		}
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		setPageCount();
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount() {
		this.pageCount = this.totalCount%this.pageSize==0?
				this.totalCount/this.pageSize:
					this.totalCount/this.pageSize+1;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		setPageCount();
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}
