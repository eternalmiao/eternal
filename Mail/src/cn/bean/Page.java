package cn.bean;

import java.util.List;

public class Page {
	private int pageIndex;
	private int pageSize = 6;
	private int firstIndex;
	private long rowCount;
	private long pageCount;
	private User user;
	private List list;
	public Page() {
		super();
	}
	public Page(int pageIndex) {
		super();
		this.pageIndex = pageIndex;
		initFirstIndex();
	}
	public Page(int pageIndex, int pageSize) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		initFirstIndex();
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
		initFirstIndex();
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		initFirstIndex();
		initPageCount();
	}
	public int getFirstIndex() {
		return firstIndex;
	}
	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}
	public long getRowCount() {
		return rowCount;		
	}
	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
		initPageCount();
	}
	public long getPageCount() {
		return pageCount;
	}
	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
	private void initFirstIndex() {
		if(pageIndex <= 0 ) {
			pageIndex = 1;
		}
		firstIndex = (pageIndex-1) * pageSize;
	}
	
	private void initPageCount() {	
		if(rowCount != 0 && pageSize != 0) {
			if(rowCount % pageSize == 0) {
				pageCount = rowCount/pageSize;
			} else {
				pageCount = rowCount/pageSize + 1;
			}
			if(pageIndex > pageCount) {
				setPageIndex((int)pageCount); 
			}
		}
	}
}
