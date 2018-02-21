package com.ahpu.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionResolver implements HandlerExceptionResolver{

	
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
			Object handler, Exception ex) {
		//handler就是处理器适配器要执行的Handler对象(只有method)  
        //解析出异常类型。  
        //如果该 异常类型是系统 自定义的异常，直接取出异常信息，在错误页面展示。
		MyException myException = null;
		if(ex instanceof MyException){
			myException = (MyException) ex;
		}else{
			//如果该 异常类型不是系统 自定义的异常，构造一个自定义的异常类型（信息为“未知错误”）。
			myException = new MyException("页面发生一些问题，请联系管理员！");
		}
		
		//错误信息
		String message = myException.getMessage();
		ModelAndView mv = new ModelAndView();
		mv.addObject("message",message);
		mv.setViewName("error");
		
		return mv;
	}

}
