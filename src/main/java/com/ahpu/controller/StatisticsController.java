package com.ahpu.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ahpu.entity.PageBean;
import com.ahpu.entity.Questionnaire;
import com.ahpu.entity.TTitle;
import com.ahpu.service.QuestionnaireService;
import com.ahpu.utils.ConstUtil;
import com.ahpu.utils.OUtPutStreamUtil;
import com.ahpu.utils.PageUtil;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {
	
	@Autowired
	private QuestionnaireService questionnaireService;
	
	@RequestMapping("/exportExcel")
	public void outExcel(String tid, HttpServletResponse response){
		//根据tid得到问卷的所有信息，包括每个选项的提交量
		Questionnaire questionnaireInfo = questionnaireService.getQuestionnaireInfo(Integer.parseInt(tid));
		
		//得到questionnaireInfo，传递到工具类  生成excel
		OUtPutStreamUtil.exportExcel(response, questionnaireInfo);
		
	}
	
	@RequestMapping("/statisticsListUI")
	public String statisticsListUI(HttpServletRequest request,String page){
		String state = "2";//已完成问卷
		if(StringUtils.isBlank(page)){
			page = "1";
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), ConstUtil.myPageSize, state);
		request.setAttribute(ConstUtil.WJTJ, "in");
		List<TTitle> list = questionnaireService.getQiestionnaireList(pageBean);
		int total = questionnaireService.getCount(pageBean);
		String pageCode = null;
		pageCode = PageUtil.genPagation(request.getContextPath()+"/statistics/statisticsListUI.action?state=2&", total, Integer.parseInt(page), ConstUtil.myPageSize);
		request.setAttribute("pageCode", pageCode);
		if(list != null){
			request.setAttribute("questionnaireList", list);
			return "WEB-INF/jsp/statistics/statisticsListUI";
		}
		return "WEB-INF/jsp/index/error";
	}
	
	@RequestMapping("/statisticsOutUI")
	public String statisticsOutUI(HttpServletRequest request){
		request.setAttribute(ConstUtil.WJTJ, "in");
		return "WEB-INF/jsp/statistics/statisticsOutUI";
	}
}