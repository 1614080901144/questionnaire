<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page language="java" import="com.ahpu.entity.TManager" %>
<%
	if(request.getAttribute("user")==null){
	    String userName = null;
	    String password = null;
	    Cookie[] cookie = request.getCookies();
	    for(int i = 0;cookie!=null&&i<cookie.length;i++){
			if(cookie[i].getName().equals("user")){
			    userName = cookie[i].getValue().split("-")[0];
			    password = cookie[i].getValue().split("-")[1];
			}
	    }
	    if(userName == null){
			userName = "";
	    }
	    if(password == null){
			password = "";
  	  }
	    TManager manager = new TManager();
	    manager.setUsername(userName);
	    manager.setPassword(password);
	    pageContext.setAttribute("user", manager);
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
	<title>问卷调查系统</title>
    <%@include file="/WEB-INF/jsp/index/links.jsp" %>
</head>
<body>
	 <div class="container" style="width: 400px;padding-top: 180px;">
	 <h1 style="text-align: center;">调查问卷管理系统</h1>
		<hr>
	   <form class="form-signin" action="${pageContext.request.contextPath}/manager/login.action" method="post">
	     <input type="text" id="username" name="username" value="${user.username}" class="form-control" placeholder="请输入用户名..." required autofocus><br>
	     <input type="password" id="password" name="password" value="${user.password}" class="form-control" placeholder="请输入密码..." required>
	     <div class="checkbox">
	       <label>
	         <input type="checkbox" name="remember" value="remember"> 记住密码
	       </label>
	     </div>
	     <button class="btn btn-lg btn-primary btn-block" type="submit">登  陆</button>
	   </form>
	 </div>
</body>
</html>