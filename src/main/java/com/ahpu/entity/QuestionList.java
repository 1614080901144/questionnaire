package com.ahpu.entity;

import java.util.List;

public class QuestionList extends TQuestion{

	private List<TChoose> chooseList;

	public List<TChoose> getChooseList() {
		return chooseList;
	}
	public void setChooseList(List<TChoose> chooseList) {
		this.chooseList = chooseList;
	}
	
	
}
