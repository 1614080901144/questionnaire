package com.ahpu.service;

import java.util.List;

import com.ahpu.entity.PageBean;
import com.ahpu.entity.Questionnaire;
import com.ahpu.entity.TGetquestion;
import com.ahpu.entity.TTitle;
import com.ahpu.entity.TitleSubmit;
import com.ahpu.entity.TitleUrl;

public interface QuestionnaireService {

	public void addQuestionnaire(TTitle title);
	
	public List<TTitle> getQiestionnaireList(PageBean pageBean);
	
	public int getCount(PageBean pageBean);
	
	public TTitle getQuestionnaireInfo(TTitle title);

	public Questionnaire getQuestionListByTitleId(int id);
	
	public boolean updateQuestion(TTitle title);
	
	public boolean deleteQuestionnaire(TTitle title);
	
	public boolean addAllToTitleUrl(TitleUrl titleUrl);
	
	public TitleUrl selectUrlByTid(Integer tid);
	
	public TitleUrl selectAllByUrl(String url);
	
	public boolean getQuestionnaireAndInsert(List<TGetquestion> getQuestionList);
	
	public boolean insertTitleSubmit(Integer tid);
	
	public boolean updateClickPlusOne(Integer titleid);
	
	public boolean deleteSubmitByTitleId(Integer titleid);
	
	public TitleSubmit selectByPrimaryKey(Integer titleid);
	
	public Questionnaire getQuestionnaireInfo(Integer tid);

	public Integer getChooseNumByQid(Integer questionid);
}
