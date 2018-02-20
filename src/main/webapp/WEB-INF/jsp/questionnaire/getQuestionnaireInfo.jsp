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
			  <li class="active">问卷详细</li>
			</ol>
			<!-- Static Panel -->
			
			<div class="panel panel-success" style="text-align: center;">
			  <div class="panel-heading" style="font-size: 18px;"><span class="glyphicon glyphicon-check" aria-hidden="true"></span>&nbsp; 问卷：${questionnaire.title }</div>
			  <div class="panel-body">
			  	
		  		<span class="glyphicon glyphicon-time" aria-hidden="true"></span>&nbsp; <strong>创建时间：</strong><span style="color: #5FB878;"><fmt:formatDate type="date" value="${questionnaire.joindate }" /></span>&nbsp;&nbsp;
			  	<span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp; <strong>面向人群：</strong>
			  		<span style="color: #5FB878;">
			  		<c:choose>
			  			<c:when test="${questionnaire.forwho == 0 }">在校生</c:when>
			  			<c:otherwise>毕业生</c:otherwise>
			  		</c:choose>
			  		</span>&nbsp;&nbsp;
			  	<span class="glyphicon glyphicon-send" aria-hidden="true"></span>&nbsp; <strong>问卷状态：</strong>
			  		<span style="color: #5FB878;">
			  		<c:choose>
			  			<c:when test="${questionnaire.state == 0 }">未发布问卷</c:when>
			  			<c:when test="${questionnaire.state == 1 }">进行中的问卷</c:when>
			  			<c:otherwise>已完成问卷</c:otherwise>
			  		</c:choose>
			  		</span>
			  		<c:choose>
			  			<c:when test="${!empty questionnaire.subtitle }">
			  				<hr>
				  			<div class="row clearfix" style="text-align: left;">
								<div class="col-md-12 column">
									<blockquote>
										<span style="font-size: 14px;">${questionnaire.subtitle }</span>
									</blockquote>
								</div>
							</div>
							<hr>
			  			</c:when>
			  			<c:otherwise></c:otherwise>
			  		</c:choose>
					<c:choose>
						<c:when test="${questionnaire.state == 0 }">
							<div style="text-align: left;"><%@include file="/WEB-INF/jsp/index/addQuestionDiv.jsp" %></div>
						</c:when>
						<c:when test="${questionnaire.state == 1 }">
							<div class="input-group" style="padding-top: 20px;">
						      <span class="input-group-addon" id="basic-addon3">问卷链接</span>
						      <input type="text" class="form-control" value="${titleUrl.url }" readonly>
						    </div><br>&nbsp;
						</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
					<c:choose>
		  			<c:when test="${!empty questionnaire.questionListList }">
					<div style="text-align: left;">
						<c:choose>
							<c:when test="${questionnaire.questionListList != null }">
								<c:forEach var="questionList" items="${questionnaire.questionListList }">
									<c:choose>
										<c:when test="${questionList.type == 2 }">
											<!-- 多选 -->
											<div class="panel panel-info">
											  <div class="panel-heading">
											    <h3 class="panel-title"><span class="glyphicon glyphicon-question-sign" aria-hidden="true"></span>&nbsp; ${questionList.question }：
											    	<c:choose>
														<c:when test="${questionnaire.state == 0 }">
											    			<a onclick="return checkDelete();" type="button" href="${pageContext.request.contextPath}/question/deleteQuestionAndChoose.action?qid=${questionList.qid }&tid=${questionnaire.tid }" class="btn btn-danger btn-xs" style="float: right;color: white;"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span> 删除</a>
														</c:when>
														<c:otherwise></c:otherwise>
													</c:choose>
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
											    <h3 class="panel-title"><span class="glyphicon glyphicon-question-sign" aria-hidden="true"></span>&nbsp; ${questionList.question }：
											    	<c:choose>
														<c:when test="${questionnaire.state == 0 }">
											    			<a onclick="return checkDelete();" type="button" href="${pageContext.request.contextPath}/question/deleteQuestionAndChoose.action?qid=${questionList.qid }&tid=${questionnaire.tid }" class="btn btn-danger btn-xs" style="float: right;color: white;"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span> 删除</a>
														</c:when>
														<c:otherwise></c:otherwise>
													</c:choose>
											    </h3>
											  </div>
											  <div class="panel-body">
											  	
											  	<c:forEach var="chooseList" items="${questionList.chooseList }">
													<div class="radio-inline">
													  <label>
													    <input type="radio" name="optionsRadio${questionList.qid }" id="optionsRadios${questionList.qid }" value="${chooseList.questionoption }"> ${chooseList.questionoption }、${chooseList.optioncontent }&nbsp;&nbsp;
													  </label>
													</div>
												</c:forEach>
												
											  </div>
											</div>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
					</div>
			  		</c:when>
			  		<c:otherwise></c:otherwise>
			  	</c:choose>
			  	
			  </div>
			</div>
				
			<!-- End Panel -->
		</div>
		</div>
    </div>
  </body>
</body>
<script type="text/javascript">
	function checkDelete(){
		var r = confirm("确认删除？");
		if(r == true){
			return true;
		}else{
			return false;
		}
	}
</script>
</html>