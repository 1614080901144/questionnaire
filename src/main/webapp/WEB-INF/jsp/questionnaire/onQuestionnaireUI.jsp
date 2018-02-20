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
			  <li class="active">问卷系统</li>
			  <li class="active">进行中的问卷</li>
			</ol>
			<!-- Static Panel -->
			<c:forEach var="title" items="${questionnaireList }">
				<div class="panel panel-success" style="text-align: center;">
				  <div class="panel-heading">
				  	<c:forEach var="times" items="${clickTimes }">
				  		<c:choose>
				  			<c:when test="${times.titleid == title.tid }">
				  				<span class="badge" style="float: left;">已收集&nbsp;${times.submittimes }</span>
				  			</c:when>
				  			<c:otherwise></c:otherwise>
				  		</c:choose>
				  	</c:forEach>
				  	
				  	
				  	<span class="glyphicon glyphicon-check" aria-hidden="true"></span>&nbsp; 问卷：<a href="${pageContext.request.contextPath}/questionnaire/getQuestionnaireInfo.action?tid=${title.tid }" style="text-decoration: none;">${title.title }</a>
				  	<a onclick="return checkStop();" href="${pageContext.request.contextPath}/questionnaire/doQuestionnaire.action?method=stop&tid=${title.tid }" type="button" class="btn btn-warning btn-xs" style="float: right;"><span class="glyphicon glyphicon-stop" aria-hidden="true"></span> 结束</a>
				  </div>
				  <div class="panel-body">
				  	<span class="glyphicon glyphicon-time" aria-hidden="true"></span>&nbsp; <strong>创建时间：</strong><span style="color: #5FB878;"><fmt:formatDate type="date" value="${title.joindate }" /></span>&nbsp;&nbsp;
				  	<span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp; <strong>面向人群：</strong>
				  		<span style="color: #5FB878;">
				  		<c:choose>
				  			<c:when test="${title.forwho == 0 }">在校生</c:when>
				  			<c:otherwise>毕业生</c:otherwise>
				  		</c:choose>
				  		</span>
				  	&nbsp;&nbsp;
				  	<span class="glyphicon glyphicon-send" aria-hidden="true"></span>&nbsp; <strong>问卷状态：</strong>
				  		<span style="color: #5FB878;">
				  		<c:choose>
				  			<c:when test="${title.state == 0 }">未发布问卷</c:when>
				  			<c:when test="${title.state == 1 }">进行中的问卷</c:when>
				  			<c:otherwise>已完成问卷</c:otherwise>
				  		</c:choose>
				  		</span>
					  
				  </div>
				</div>
				
			</c:forEach>
			<c:choose>
				<c:when test="${!empty questionnaireList }">
					<div style="text-align: center; ">
				  	 <div class="pagination pagination-centered">
				  		 ${pageCode }
				 	 </div>
				   </div>
				</c:when>
				<c:otherwise>
					<div style="background-color: #FF5722;width: 100%;height: 200px;margin: 0 auto;text-align: center;padding-top: 60px;color: white;">
						<font size="25">暂无表单！</font>
					</div>
				</c:otherwise>
			</c:choose>
			
			<!-- End Panel -->
		</div>
		</div>
    </div>
  </body>
</body>
<script type="text/javascript">

	function checkStop(){
		var r = confirm("是否结束问卷调查？");
		if(r == true){
			return true;
		}else{
			return false;
		}
	}
</script>
</html>