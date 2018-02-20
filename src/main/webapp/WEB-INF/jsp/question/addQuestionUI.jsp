<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
	<title>问卷调查系统</title>
    <%@include file="/WEB-INF/jsp/index/links.jsp" %>
</head>
<body>
	<body>
    <!-- Static navbar -->
    <%@include file="/WEB-INF/jsp/index/header.jsp" %>
    <!-- End navbar -->
    <div class="container">
	    <div class="row">
	    <!-- Static menu -->
	    <%@include file="/WEB-INF/jsp/index/menu.jsp" %>
	    <!-- End menu -->
		<div class="col-md-9">
			<ol class="breadcrumb">
			  <li class="active">首页</li>
			  <li class="active">问卷题库</li>
			  <li class="active">新建问题</li>
			</ol>
			<!-- Static Panel -->
			<div class="panel panel-default">
			  <div class="panel-body">
			    	<%@include file="/WEB-INF/jsp/index/addQuestionDiv.jsp" %>
			  </div>
			</div>
			<!-- End Panel -->
		</div>
		</div>
    </div>
  </body>
</body>

</html>