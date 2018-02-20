<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
	<title>问卷调查系统</title>
    <%@include file="/WEB-INF/jsp/index/links.jsp" %>
    <script src="${pageContext.request.contextPath}/js/ckeditor/ckeditor.js"></script>
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
			  <li class="active">问卷系统</li>
			  <li class="active">新建问卷</li>
			</ol>
			<!-- Static Panel -->
			<div class="panel panel-default">
			  <div class="panel-body">
			  		<!--  -->
			    	<form action="${pageContext.request.contextPath}/questionnaire/addQuestionnaire.action" method="post">
					  <h4>问卷名称：</h4><input type="text" class="form-control" name="title" required><br>
					  <h4>问卷副标题：</h4><textarea class="ckeditor" id="subtitle" name="subtitle"></textarea>
					  
					  <div class="radio">
					  		<strong>面向人群： </strong>&nbsp;&nbsp;
						  <label>
						    <input type="radio" name="forwho" id="optionsRadios1" value="0" checked> 在校生&nbsp;&nbsp;
						  </label>
						  <label>
						    <input type="radio" name="forwho" id="optionsRadios2" value="1"> 毕业生
						  </label>
						</div>
					  <br>
					  <button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;新建</button>
					</form>
			  </div>
			</div>
			<!-- End Panel -->
		</div>
		</div>
    </div>
  </body>
</body>
</html>