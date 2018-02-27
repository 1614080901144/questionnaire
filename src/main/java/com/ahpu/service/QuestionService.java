package com.ahpu.service;

import java.util.ArrayList;
import java.util.List;

import com.ahpu.entity.PageBean;
import com.ahpu.entity.QuestionList;
import com.ahpu.entity.TChoose;
import com.ahpu.entity.TQuestion;
import com.ahpu.entity.TitleQuestionKey;

public interface QuestionService {

	public Integer addQuestion(TQuestion question, ArrayList<TChoose> list);

	public List<QuestionList> getQiestionList(PageBean pageBean);
	
	public int getCount();
	
	public boolean questionAssociation(int qid, int tid);
	
	public boolean deleteQuestionAndChoose(TitleQuestionKey titleQuestionKey);
}
