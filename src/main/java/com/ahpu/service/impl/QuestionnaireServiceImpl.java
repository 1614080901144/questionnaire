package com.ahpu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahpu.entity.PageBean;
import com.ahpu.entity.QIdList;
import com.ahpu.entity.QuestionList;
import com.ahpu.entity.Questionnaire;
import com.ahpu.entity.TChoose;
import com.ahpu.entity.TGetQuestionList;
import com.ahpu.entity.TGetquestion;
import com.ahpu.entity.TQuestion;
import com.ahpu.entity.TTitle;
import com.ahpu.entity.TidAndState;
import com.ahpu.entity.TitleQuestionKey;
import com.ahpu.entity.TitleSubmit;
import com.ahpu.entity.TitleUrl;
import com.ahpu.mapper.TChooseMapper;
import com.ahpu.mapper.TGetquestionMapper;
import com.ahpu.mapper.TQuestionMapper;
import com.ahpu.mapper.TTitleMapper;
import com.ahpu.mapper.TitleQuestionMapper;
import com.ahpu.mapper.TitleSubmitMapper;
import com.ahpu.mapper.TitleUrlMapper;
import com.ahpu.service.QuestionnaireService;
import com.ahpu.utils.ConstUtil;
import com.ahpu.utils.DateUtil;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

	@Autowired
	private TTitleMapper titleMapper;
	@Autowired
	private TitleQuestionMapper titleQuestionMapper;
	@Autowired
	private TQuestionMapper tQuestionMapper;
	@Autowired
	private TChooseMapper tChooseMapper;
	@Autowired
	private TitleUrlMapper titleUrlMapper;
	@Autowired
	private TGetquestionMapper getquestionMapper;
	@Autowired
	private TitleSubmitMapper titleSubmitMapper;
	
	
	
	/**
	 * 搁到tid查询，然后导出到excel
	 */
	public Questionnaire getQuestionnaireInfo(Integer id) {
		List<TGetquestion> getQuestionList0 = null;
		//根据问卷id查询问题qid集合
		List<TitleQuestionKey> qIdList = titleQuestionMapper.selectByPrimaryKey(id);
		if(qIdList.size() < 1){
			qIdList.clear();
		}
		Questionnaire questionnaire = new Questionnaire();
		List<QuestionList> questionListList = new ArrayList<QuestionList>();
		//查询问卷信息
		TTitle t = titleMapper.selectByPrimaryKey(id);
		questionnaire.setTitle(t.getTitle());
		//遍历qid集合
		if(qIdList != null && qIdList.size() > 0){
			for (TitleQuestionKey titleQuestionKey : qIdList) {
				//查询每个qid对应的question
				TQuestion question = tQuestionMapper.selectByPrimaryKey(titleQuestionKey.getQid());
				//查询question对应的choose集合
				List<TChoose> chooseList = tChooseMapper.getChooseByQid(titleQuestionKey.getQid());
				
				//将question和其对应的choose放入QuestionList,构成完整的问题
				QuestionList questionList = new QuestionList();
				questionList.setQid(question.getQid());
				questionList.setQuestion(question.getQuestion());
				questionList.setType(question.getType());
				questionList.setChooseList(chooseList);
				
				questionListList.add(questionList);
				//将question放入问卷集合
			}
			
		}
		//根据tid得到不重复的提交用户集合 SELECT DISTINCT submitUser FROM t_getquestion WHERE titleId = '11';
		getQuestionList0 = getquestionMapper.selectSubmitUserByTid(id);
		//遍历集合，获取详细信息
		List<List<TGetquestion>> getQuestionListList = new ArrayList<List<TGetquestion>>();
		List<TGetquestion> getQuestionList = null;
		for (TGetquestion getQuestion : getQuestionList0) {
			//一个用户所提交的问卷列表   SELECT * FROM t_getquestion WHERE submitUser = 'edc36ccc-4388-4b75-ad12-2935ea5d5439';
			getQuestionList = getquestionMapper.selectBySubmitUser(getQuestion);
			getQuestionListList.add(getQuestionList);
		}
		questionnaire.setGetQuestionListList(getQuestionListList);
		questionnaire.setQuestionListList(questionListList);
		//返回Questionnaire
		return questionnaire;
	}
	
	
	public void addQuestionnaire(TTitle title) {
		
		Date joindate = DateUtil.formatReturnDate(new Date());
		title.setJoindate(joindate);
		title.setState(ConstUtil.NEW_QUESTIONNAIRE);
		titleMapper.insert(title);
	}

	
	public List<TTitle> getQiestionnaireList(PageBean pageBean) {
		if(pageBean != null && StringUtils.isNotBlank(String.valueOf(pageBean.getStart())) && StringUtils.isNotBlank(String.valueOf(pageBean.getStart())) ){
			List<TTitle> list = titleMapper.selectAll(pageBean);
			for (TTitle tTitle : list) {
				System.out.println(tTitle);
			}
			return list;
		}
		return null;
	}
	
	public int getCount(PageBean pageBean) {
		int count = titleMapper.getCount(pageBean);
		return count;
	}


	
	public TTitle getQuestionnaireInfo(TTitle title) {
		TTitle questionnaireInfo = titleMapper.selectByPrimaryKey(title.getTid());
		return questionnaireInfo;
	}


	public Questionnaire getQuestionListByTitleId(int id) {
		//根据问卷id查询问题qid集合
		List<TitleQuestionKey> qIdList = titleQuestionMapper.selectByPrimaryKey(id);
		if(qIdList.size() < 1){
			qIdList.clear();
		}
		//完整的问卷，有完整问题集合，问卷详情
		Questionnaire questionnaire = new Questionnaire();
		List<QuestionList> questionListList = new ArrayList<QuestionList>();
		//查询问卷信息
		TTitle t = titleMapper.selectByPrimaryKey(id);
		questionnaire.setTid(t.getTid());
		questionnaire.setTitle(t.getTitle());
		questionnaire.setSubtitle(t.getSubtitle());
		questionnaire.setJoindate(t.getJoindate());
		questionnaire.setForwho(t.getForwho());
		questionnaire.setState(t.getState());
		//遍历集合
		if(qIdList != null && qIdList.size() > 0){
			for (TitleQuestionKey titleQuestionKey : qIdList) {
				//查询每个qid对应的question
				TQuestion question = tQuestionMapper.selectByPrimaryKey(titleQuestionKey.getQid());
				//查询question对应的choose
				List<TChoose> chooseList = tChooseMapper.getChooseByQid(titleQuestionKey.getQid());
				//将question和其对应的choose放入QuestionList,构成完整的问题
				QuestionList questionList = new QuestionList();
				questionList.setQid(question.getQid());
				questionList.setQuestion(question.getQuestion());
				questionList.setType(question.getType());
				questionList.setChooseList(chooseList);
				questionListList.add(questionList);
				//将question放入问卷集合
				//questionnaire.setQuestionListList(questionListList);
				//查询并设置title信息
			}
			
		}
		questionnaire.setQuestionListList(questionListList);
		//返回Questionnaire
		return questionnaire;
	}


	public boolean updateQuestion(TTitle title) {
		try {
			titleMapper.updateStateByTid(title);
			titleUrlMapper.updateUstateByTid(title.getTid());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


	public boolean deleteQuestionnaire(TTitle title) {
		try {
			//根据title查询所有的question
			List<TitleQuestionKey> qIdList = titleQuestionMapper.selectByPrimaryKey(title.getTid());
			//根据question的qid删除所有的choose
			for (TitleQuestionKey titleQuestionKey : qIdList) {
				tChooseMapper.deleteChooseByQid(titleQuestionKey.getQid());
				//根据tid和qid删除title_question里面的记录
				titleQuestionKey.setTid(title.getTid());
				titleQuestionMapper.deleteByPrimaryKey(titleQuestionKey);
				//根据qid删除所有的question
				tQuestionMapper.deleteByPrimaryKey(titleQuestionKey.getQid());
				
			}
			//根据tid 删除所有的titer
			titleMapper.deleteByPrimaryKey(title.getTid());
			//根据tid删除title_url中的数据
			titleUrlMapper.deleteByTid(title.getTid());
			//根据tid删除title_submit
			titleSubmitMapper.deleteByPrimaryKey(title.getTid());
			//根据tid删除t_getquestion
			getquestionMapper.deleteBytitleId(title.getTid());
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


	public boolean addAllToTitleUrl(TitleUrl titleUrl) {
		try {
			titleUrl.setUstate((Integer.parseInt(ConstUtil.ON_QUESTIONNAIRE)));
			titleUrlMapper.insert(titleUrl);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


	public TitleUrl selectUrlByTid(Integer tid) {
		return titleUrlMapper.selectAllByTid(tid);
	}


	public TitleUrl selectAllByUrl(String url) {
		TitleUrl titleUrl = new TitleUrl();
		titleUrl.setUrl(url);
		return titleUrlMapper.selectAllByUrl(titleUrl);
	}


	
	public boolean getQuestionnaireAndInsert(List<TGetquestion> getQuestionList) {
		if(getQuestionList != null && getQuestionList.size() > 0){
			try {
				for (TGetquestion getquestion : getQuestionList) {
					getquestionMapper.insert(getquestion);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
		return false;
	}


	public boolean insertTitleSubmit(Integer tid) {
		try {
			TitleSubmit titleSubmit = new TitleSubmit();
			titleSubmit.setTitleid(tid);
			titleSubmit.setSubmittimes(0);
			titleSubmitMapper.insert(titleSubmit);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


	
	public boolean updateClickPlusOne(Integer titleid) {
		try {
			titleSubmitMapper.updateClickPlusOne(titleid);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


	public boolean deleteSubmitByTitleId(Integer titleid) {
		try {
			titleSubmitMapper.deleteByPrimaryKey(titleid);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


	public TitleSubmit selectByPrimaryKey(Integer titleid) {
		try {
			TitleSubmit selectByPrimaryKey = titleSubmitMapper.selectByPrimaryKey(titleid);
			return selectByPrimaryKey;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	public Integer getChooseNumByQid(Integer qid) {
		return tChooseMapper.selectCountByQid(qid);
	}
}











