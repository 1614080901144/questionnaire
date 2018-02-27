package com.ahpu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahpu.entity.PageBean;
import com.ahpu.entity.QuestionList;
import com.ahpu.entity.TChoose;
import com.ahpu.entity.TQuestion;
import com.ahpu.entity.TitleQuestionKey;
import com.ahpu.mapper.TChooseMapper;
import com.ahpu.mapper.TQuestionMapper;
import com.ahpu.mapper.TitleQuestionMapper;
import com.ahpu.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private TQuestionMapper questionMapper;
	@Autowired
	private TChooseMapper chooseMapper;
	@Autowired
	private TitleQuestionMapper titleQuestionMapper;
	
	
	public boolean deleteQuestionAndChoose(TitleQuestionKey titleQuestionKey){
		try {
			//删除title_question里面关联问卷的选项
			titleQuestionMapper.deleteByPrimaryKey(titleQuestionKey);
			//删除t_choose里面关联问题的选项
			chooseMapper.deleteChooseByQid(titleQuestionKey.getQid());
			//删除t_question里面的问题
			questionMapper.deleteByPrimaryKey(titleQuestionKey.getQid());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	
	
	public Integer addQuestion(TQuestion question, ArrayList<TChoose> list) {
		if(question != null && StringUtils.isNotBlank(question.getQuestion()) && StringUtils.isNotBlank(question.getType()) && list != null && list.size() > 1){
			Integer currentQid = null;
			//根据question查询是否有相同问题
			List<TQuestion> selectByQuestion1 = questionMapper.selectByQuestion(question);
			//插入新建question
			questionMapper.insert(question);
			List<TQuestion> selectByQuestion2 = questionMapper.selectByQuestion(question);
			//如果selectByQuestion1 为空，那么selectByQuestion2 为
			if(selectByQuestion1.size() == 0){
				currentQid = selectByQuestion2.get(0).getQid();
			}else{
				//如果selectByQuestion1 不为空，获取selectByQuestion1与selectByQuestion2 的差集的qid
				List<Integer> la = new ArrayList<Integer>();
				List<Integer> lb = new ArrayList<Integer>();
				for (TQuestion question1 : selectByQuestion1) {
					la.add(question1.getQid());
				}
				for (TQuestion question2 : selectByQuestion2) {
					lb.add(question2.getQid());
				}
				lb.removeAll(la);
				currentQid = lb.get(0);
			}
			if(currentQid != null && currentQid != 0){
				TChoose c = new TChoose();
				c.setQid(currentQid);
				for (TChoose choose : list) {
					c.setQuestionoption(choose.getQuestionoption());
					c.setOptioncontent(choose.getOptioncontent());
					chooseMapper.insert(c);
				}
			}
			return currentQid;
		}
		return null;
	}

	public List<QuestionList> getQiestionList(PageBean pageBean) {
		if(pageBean != null && StringUtils.isNotBlank(String.valueOf(pageBean.getStart())) && StringUtils.isNotBlank(String.valueOf(pageBean.getStart())) ){
			
			List<TQuestion> list = questionMapper.selectAll(pageBean);
			QuestionList questionList = null;
			if(list != null){
				List<QuestionList> questionListList = new ArrayList<QuestionList>();
				for (TQuestion question : list) {
					questionList = new QuestionList();
					List<TChoose> chooseList = chooseMapper.getChooseByQid(question.getQid());
					questionList.setQuestion(question.getQuestion());
					questionList.setType(question.getType());
					questionList.setChooseList(chooseList);
					questionListList.add(questionList);
				}
				return questionListList;
			}
		}
		return null;
	}

	
	public int getCount() {
		int count = questionMapper.getCount();
		return count;
	}
	
	
	
	//关联问题与问卷
	public boolean questionAssociation(int qid, int tid) {
		TitleQuestionKey record = new TitleQuestionKey();
		record.setQid(qid);
		record.setTid(tid);
		try {
			titleQuestionMapper.insert(record);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
















 