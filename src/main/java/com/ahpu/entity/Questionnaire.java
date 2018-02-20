package com.ahpu.entity;

import java.io.Serializable;
import java.util.List;

public class Questionnaire extends TTitle implements Serializable {

	private static final long serialVersionUID = 737601077350394121L;
	//完整问题集合
	private List<QuestionList> questionListList;
	
	private List<List<TGetquestion>> getQuestionListList;
	
	public List<QuestionList> getQuestionListList() {
		return questionListList;
	}
	public void setQuestionListList(List<QuestionList> questionListList) {
		this.questionListList = questionListList;
	}
	public List<List<TGetquestion>> getGetQuestionListList() {
		return getQuestionListList;
	}
	public void setGetQuestionListList(List<List<TGetquestion>> getQuestionListList) {
		this.getQuestionListList = getQuestionListList;
	}
	
	

}
