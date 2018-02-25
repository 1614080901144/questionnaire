package com.ahpu.controller;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ahpu.entity.TManager;
import com.ahpu.service.ManagerService;
import com.ahpu.utils.ConstUtil;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	
	@RequestMapping("/loginOut")
	public String loginOut(HttpSession session){
		
		session.removeAttribute("currentManager");
		return "index";
	}

	@RequestMapping("/login")
	public String login(HttpSession session, TManager manager, HttpServletRequest request, HttpServletResponse response){
		TManager currentManager = managerService.login(manager);
		if(currentManager != null){
			session.setAttribute("currentManager", currentManager);
			request.setAttribute(ConstUtil.WJXT, "in");
			
			String remember = (String) request.getParameter("remember");
			if("remember".equals(remember)){
				Cookie user = new Cookie("user",currentManager.getUsername()+"-"+currentManager.getPassword());
				user.setMaxAge(1*60*60*24*7);
				response.addCookie(user);
			}
			return "WEB-INF/jsp/index/main";
		}
		return "index";
	}
	
	@RequestMapping("/loginUI")
	public String loginUI(){
		return "WEB-INF/jsp/index/index";
	}
}