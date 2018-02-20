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
			  <li class="active">问题列表</li>
			</ol>
			
			<!--  -->
			<c:forEach var="questionList" items="${questionList }">
				<c:choose>
					<c:when test="${questionList.type == 2 }">
						<!-- 多选 -->
						<div class="panel panel-info">
						  <div class="panel-heading">
						    <h3 class="panel-title"><span class="glyphicon glyphicon-question-sign" aria-hidden="true"></span>&nbsp; ${questionList.question }：
						    	<a href="#" type="button" class="btn btn-info btn-xs" style="float: right;color: white;">
						    		<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp; 添加到问卷
						    	</a>
						    </h3>
						  </div>
						  <div class="panel-body">
							
							<c:forEach var="chooseList" items="${questionList.chooseList }">
								<label class="checkbox-inline">
								  <input type="checkbox" id="inlineCheckbox1" value="${chooseList.questionoption }"> ${chooseList.questionoption }、${chooseList.optioncontent }&nbsp;&nbsp;
								</label>
							</c:forEach>
						  </div>
						</div>
					</c:when>
					
					<c:otherwise>
						<!-- 单选 -->
						<div class="panel panel-info">
						  <div class="panel-heading">
						    <h3 class="panel-title"><span class="glyphicon glyphicon-question-sign" aria-hidden="true"></span>&nbsp; ${questionList.question }：</h3>
						  </div>
						  <div class="panel-body">
						  	
						  	<c:forEach var="chooseList" items="${questionList.chooseList }">
								
								<div class="radio-inline">
								  <label>
								    <input type="radio" name="optionsRadios" id="optionsRadios1" value="${chooseList.questionoption }" checked> ${chooseList.questionoption }、${chooseList.optioncontent }&nbsp;&nbsp;
								  </label>
								</div>
							</c:forEach>
							
						  </div>
						</div>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			
			<div style="text-align: center; ">
		  	 <div class="pagination pagination-centered">
		  		 ${pageCode }
		 	 </div>
		   </div>
			
			<!-- End Panel -->
		</div>
		</div>
    </div>
  </body>
</body>
</html>