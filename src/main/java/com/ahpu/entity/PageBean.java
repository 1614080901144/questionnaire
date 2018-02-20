package com.ahpu.entity;

public class PageBean {

	private int page;
	private int pageSize;
	private int start;
	private String state;
	
	
	

	public PageBean(int page, int pageSize, String state) {
		super();
		this.page = page;
		this.pageSize = pageSize;
		this.state = state;
	}

	public PageBean(int page, int pageSize) {
		super();
		this.page = page;
		this.pageSize = pageSize;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStart() {
		return (page-1)*pageSize;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}
