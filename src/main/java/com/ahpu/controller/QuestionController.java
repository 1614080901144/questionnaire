package com.ahpu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ahpu.entity.PageBean;
import com.ahpu.entity.QuestionList;
import com.ahpu.entity.TChoose;
import com.ahpu.entity.TQuestion;
import com.ahpu.entity.TitleQuestionKey;
import com.ahpu.service.QuestionService;
import com.ahpu.utils.ConstUtil;
import com.ahpu.utils.PageUtil;



@Controller
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService QuestionService;
	
	
	@RequestMapping("/deleteQuestionAndChoose")
	public String deleteQuestionAndChoose(TitleQuestionKey titleQuestionKey){
		
		boolean b = QuestionService.deleteQuestionAndChoose(titleQuestionKey);
		if(b){
			return "redirect:/questionnaire/getQuestionnaireInfo.action?tid="+titleQuestionKey.getTid();
		}
		return "WEB-INF/jsp/index/error";
		
	}
	
	@RequestMapping("/addQuestion")
	public String addQuestion(HttpServletRequest request){
		String tid = request.getParameter("tid");
		String title = request.getParameter("title");
		String radio = request.getParameter("optionsRadios");
		String[] values = request.getParameterValues("opt_name");
		
		TQuestion question = new TQuestion();
		question.setQuestion(title);
		question.setType(radio);
		ArrayList<TChoose> list = new ArrayList<TChoose>();
		TChoose choose = null;
		int i = 1;
		for (String string : values) {
			choose = new TChoose();
			choose.setQuestionoption(String.valueOf(i));
			choose.setOptioncontent(string);
			list.add(choose);
			i++;
		}
		Integer currentQid = QuestionService.addQuestion(question, list);
		
		boolean b = false;
		if(currentQid != null){
			//关联问卷与问题
			b = QuestionService.questionAssociation(currentQid, Integer.parseInt(tid));
			if(b){
				return "redirect:/questionnaire/getQuestionnaireInfo.action?tid="+tid;
			}
		}
		return "WEB-INF/jsp/index/error";
		
	}
	
//	@RequestMapping("/addQuestionUI")
//	public String addQuestionUI(HttpServletRequest request){
//		request.setAttribute(ConstUtil.WJTK, "in");
//		return "WEB-INF/jsp/question/addQuestionUI";
//	}
//	
//	@RequestMapping("/questionListUI")
//	public String questionListUI(HttpServletRequest request, String page){
//		if(StringUtils.isBlank(page)){
//			page = "1";
//		}
//		PageBean pageBean = new PageBean(Integer.parseInt(page), ConstUtil.myPageSize);
//		request.setAttribute(ConstUtil.WJTK, "in");
//		List<QuestionList> list = QuestionService.getQiestionList(pageBean);
//		int total = QuestionService.getCount();
//		String pageCode = PageUtil.genPagation(request.getContextPath()+"/question/questionListUI.action?", total, Integer.parseInt(page), ConstUtil.myPageSize);
//		request.setAttribute("pageCode", pageCode);
//		if(list != null){
//			request.setAttribute("questionList", list);
//			return "WEB-INF/jsp/question/questionListUI";
//		}
//		return "WEB-INF/jsp/index/error";
//	}
}












