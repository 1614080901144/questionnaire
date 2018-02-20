package com.ahpu.entity;

import java.io.Serializable;

public class TidAndState implements Serializable{

	private static final long serialVersionUID = 8334708311071346956L;
	
	private int tid;
	
	private int state;

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	

}
