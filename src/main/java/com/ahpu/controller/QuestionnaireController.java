package com.ahpu.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ahpu.entity.PageBean;
import com.ahpu.entity.Questionnaire;
import com.ahpu.entity.TGetquestion;
import com.ahpu.entity.TTitle;
import com.ahpu.entity.TitleSubmit;
import com.ahpu.entity.TitleUrl;
import com.ahpu.service.QuestionnaireService;
import com.ahpu.utils.ConstUtil;
import com.ahpu.utils.PageUtil;
import com.ahpu.utils.PropertiesUtil;



@Controller
@RequestMapping("/questionnaire")
public class QuestionnaireController {
	
	@Autowired
	private QuestionnaireService questionnaireService;
	
	
	//获取用户提交的问卷
	@RequestMapping("getQuestionnaire")
	public String getQuestionnaire(HttpServletRequest request){
		String titleid = request.getParameter("titleId");
		TGetquestion getquestion = null;
		List<TGetquestion> getQuestionList = new ArrayList<TGetquestion>();
		Map map = request.getParameterMap();
		Set keSet = map.entrySet();
		String submituser = UUID.randomUUID().toString();
		for(Iterator itr = keSet.iterator(); itr.hasNext();){
			Map.Entry me = (Map.Entry) itr.next();
			Object ok = me.getKey();
			Object ov = me.getValue();
			if("titleId".equals(ok.toString())){
				continue;
			}
			getquestion = new TGetquestion();
			//key
			String[] key = new String[1];
			if(ok instanceof String[]) {
				key = (String[]) ok;
			}else{
				key[0] = ok.toString();
			}
			for (String string : key) {
				getquestion.setQuestionid(Integer.parseInt(string));
			}
			//value
			String[] value = new String[1];
			if(ov instanceof String[]) {
				value = (String[]) ov;
			}else{
				value[0] = ov.toString();
			}
						
			for (String string : value) {
				//多选题--选择了多个选项        1--提交多选
				if(value.length != 1){
					Integer questionid = getquestion.getQuestionid();
					getquestion = new TGetquestion();
					getquestion.setIsmultiple(value.length);//该问题提交了多个选项
					getquestion.setQuestionid(questionid);
				}
				
				getquestion.setSubmituser(submituser);
				getquestion.setTitleid(Integer.parseInt(titleid));
				Integer choosenum = questionnaireService.getChooseNumByQid(getquestion.getQuestionid());
				getquestion.setChoosenum(choosenum);//该question的选项数量
				getquestion.setChoose(string);
				getQuestionList.add(getquestion);
				
			}
			
		}
		boolean b = questionnaireService.getQuestionnaireAndInsert(getQuestionList);
		boolean updateClickPlusOne = questionnaireService.updateClickPlusOne(Integer.parseInt(titleid));
		if(b && updateClickPlusOne){
			return "WEB-INF/jsp/questionnaire/thanksQuestionnaire";
		}
		return "WEB-INF/jsp/questionnaire/errorQuestionnaire";
	}
	
	//通过生成的url 跳转到用户提交界面
	@RequestMapping("getUserQuestionnaire")
	public String getUserQuestionnaire(HttpServletRequest request, String url){
		
		//对比titleuri表中的数据 ，查询tid
		TitleUrl titleUrl = questionnaireService.selectAllByUrl(url);
		if(titleUrl != null && titleUrl.getUstate() == 1){
			//根据tid查询问卷详细
			if(titleUrl!=null && titleUrl.getTid() != null && titleUrl.getTid() != 0){
				Questionnaire questionnaire = questionnaireService.getQuestionListByTitleId(titleUrl.getTid());
				//问卷问题List
				request.setAttribute("questionnaire", questionnaire);
				//展示到用户填写界面
				return "WEB-INF/jsp/questionnaire/showQuestionnaire";
			}
		}else{
			//问卷结束，跳转到结束界面
			return "WEB-INF/jsp/questionnaire/invalidQuestionnaire";
		}
		return "WEB-INF/jsp/index/error";
	}
	
	
	@RequestMapping("/doQuestionnaire")
	public String doQuestionnaire(HttpServletRequest request){
		String method = request.getParameter("method");
		int tid = Integer.parseInt(request.getParameter("tid"));
		TTitle title = new TTitle();
		title.setTid(tid);
		if("send".equals(method)){
			String state = "1";
			title.setState(state);
			boolean b = questionnaireService.updateQuestion(title);
			TitleUrl titleUrl = new TitleUrl();
			titleUrl.setTid(tid);
			String uuid = UUID.randomUUID().toString();
			String url = PropertiesUtil.getValue("currentUrl") + request.getContextPath()+"/questionnaire/getUserQuestionnaire.action?url="+uuid;
			titleUrl.setUrl(url);
			boolean addAllToTitleUrl = questionnaireService.addAllToTitleUrl(titleUrl);
			boolean insertTitleSubmit = questionnaireService.insertTitleSubmit(tid);
			if(b && addAllToTitleUrl && insertTitleSubmit){
				return "redirect:/questionnaire/questionnaireListUI.action?state=1";
			}
		}else if("stop".equals(method)){
			String state = "2";
			title.setState(state);
			boolean b = questionnaireService.updateQuestion(title);
			if(b){
				return "redirect:/questionnaire/questionnaireListUI.action?state=2";
			}
		}else if("delete".equals(method)){
			boolean b = questionnaireService.deleteQuestionnaire(title);
			boolean deleteSubmitByTitleId = questionnaireService.deleteSubmitByTitleId(tid);
			if(b && deleteSubmitByTitleId){
				return "redirect:/questionnaire/questionnaireListUI.action?state=2";
			}
		}
		return "WEB-INF/jsp/index/error";
	}
	
	
	@RequestMapping("/getQuestionnaireInfo")
	public String getQuestionnaireInfo(HttpServletRequest request, TTitle title){
		if(title != null && title.getTid() != null && title.getTid() != 0){
			request.setAttribute(ConstUtil.WJXT, "in");
			Questionnaire questionnaire = questionnaireService.getQuestionListByTitleId(title.getTid());
			//问卷问题List
			request.setAttribute("questionnaire", questionnaire);
			//查询问卷url
			if("1".equals(questionnaire.getState())){
				TitleUrl titleUrl = questionnaireService.selectUrlByTid(questionnaire.getTid());
				request.setAttribute("titleUrl", titleUrl);
			}
			return "WEB-INF/jsp/questionnaire/getQuestionnaireInfo";
		}
		return "WEB-INF/jsp/index/error";
	}
	
	@RequestMapping("/addQuestionnaire")
	public String addQuestionnaire(HttpServletRequest request, TTitle title){
		
		questionnaireService.addQuestionnaire(title);
		return "redirect:/questionnaire/questionnaireListUI.action?state=0";
	}
	
	
	@RequestMapping("/addQuestionnaireUI")
	public String addQuestionnaireUI(HttpServletRequest request){
		request.setAttribute(ConstUtil.WJXT, "in");
		return "WEB-INF/jsp/questionnaire/addQuestionnaireUI";
	}
	
	@RequestMapping("/questionnaireListUI")
	public String questionnaireListUI(HttpServletRequest request,String page, String state){
		if(StringUtils.isBlank(page)){
			page = "1";
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), ConstUtil.myPageSize, state);
		request.setAttribute(ConstUtil.WJXT, "in");
		List<TTitle> list = questionnaireService.getQiestionnaireList(pageBean);
		int total = questionnaireService.getCount(pageBean);
		String pageCode = null;
		if("0".equals(state)){
			pageCode = PageUtil.genPagation(request.getContextPath()+"/questionnaire/questionnaireListUI.action?state=0&", total, Integer.parseInt(page), ConstUtil.myPageSize);
		}
		if("1".equals(state)){
			pageCode = PageUtil.genPagation(request.getContextPath()+"/questionnaire/questionnaireListUI.action?state=1&", total, Integer.parseInt(page), ConstUtil.myPageSize);
		}
		if("2".equals(state)){
			pageCode = PageUtil.genPagation(request.getContextPath()+"/questionnaire/questionnaireListUI.action?state=2&", total, Integer.parseInt(page), ConstUtil.myPageSize);
		}
		request.setAttribute("pageCode", pageCode);
		if(list != null){
			request.setAttribute("questionnaireList", list);
			if("0".equals(state)){
				return "WEB-INF/jsp/questionnaire/questionnaireListUI";
			}
			if("1".equals(state)){
				List<TitleSubmit> times = new ArrayList<TitleSubmit>();
				for (TTitle tTitle : list) {
					TitleSubmit time = questionnaireService.selectByPrimaryKey(tTitle.getTid());
					times.add(time);
				}
				request.setAttribute("clickTimes", times);
				return "WEB-INF/jsp/questionnaire/onQuestionnaireUI";			
			}
			if("2".equals(state)){
				return "WEB-INF/jsp/questionnaire/overQuestionnaireUI";
			}
		}
		return "WEB-INF/jsp/index/error";
	}
}


