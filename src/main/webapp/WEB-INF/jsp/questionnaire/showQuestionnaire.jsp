<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
	<title>问卷调查系统</title>
    <%@include file="/WEB-INF/jsp/index/links.jsp" %>
</head>
<body>
	<body style="background-color: #5FB878">
    
    <div class="container" style="padding-top: 50px;margin: 0 auto;">
	    <div class="row">
	    <div class="col-md-2"></div>
		<div class="col-md-8">
			<!-- Static Panel -->
			
			<div class="panel panel-success" style="text-align: center;">
			  <div class="panel-heading" style="font-size: 18px;"><span class="glyphicon glyphicon-check" aria-hidden="true"></span>&nbsp; ${questionnaire.title }</div>
			  <div class="panel-body">
			  	
		  		<span class="glyphicon glyphicon-time" aria-hidden="true"></span>&nbsp; <strong>创建时间：</strong><span style="color: #5FB878;"><fmt:formatDate type="date" value="${questionnaire.joindate }" /></span>&nbsp;&nbsp;
			  	<span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp; <strong>面向人群：</strong>
			  		<span style="color: #5FB878;">
			  		<c:choose>
			  			<c:when test="${questionnaire.forwho == 0 }">在校生</c:when>
			  			<c:otherwise>毕业生</c:otherwise>
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
					
					<form action="${pageContext.request.contextPath}/questionnaire/getQuestionnaire.action" method="post">
						<input type="hidden" name="titleId" value="${questionnaire.tid }">
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
												    <h3 class="panel-title"><span class="glyphicon glyphicon-question-sign" aria-hidden="true"></span>&nbsp; ${questionList.question }： </h3>
												  </div>
												  <div class="panel-body">
													
													<c:forEach var="chooseList" items="${questionList.chooseList }">
														<label class="checkbox-inline">
														  <input onclick="checkbox(this);" type="checkbox" id="${chooseList.cid }" name="${questionList.qid }" value="${chooseList.questionoption }" required> ${chooseList.questionoption }、${chooseList.optioncontent }&nbsp;&nbsp;
														</label>
													</c:forEach>
												  </div>
												</div>
											</c:when>
											
											<c:otherwise>
												<!-- 单选 -->
												<div class="panel panel-info">
												  <div class="panel-heading">
												    <h3 class="panel-title"><span class="glyphicon glyphicon-question-sign" aria-hidden="true"></span>&nbsp; ${questionList.question }： </h3>
												  </div>
												  <div class="panel-body">
												  	
												  	<c:forEach var="chooseList" items="${questionList.chooseList }">
														<div class="radio-inline">
														  <label>
														    <input type="radio" name="${questionList.qid }" id="${chooseList.cid }" value="${chooseList.questionoption }" required> ${chooseList.questionoption }、${chooseList.optioncontent }&nbsp;&nbsp;
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
				  	<button type="submit" class="btn btn-success btn-lg btn-block">提交</button>
					</form>
			  	
			  </div>
			</div>
				
			<!-- End Panel -->
		</div>
		<div class="col-md-2"></div>
		</div>
    </div>
    <div style="text-align: center;color: white;">
    	<p style="text-align: center;">Copyright © 2017  XXX问卷调查系统  版权所有</p>
    </div>
  </body>
</body>
<script type="text/javascript">

	function checkbox(dom) {
		var name = dom.name;
		var a = $("input[name='"+name+"']:checked").length;
		if(a != 0){
			$("input[name='"+name+"']").removeAttr("required",false);
		}else{
			$("input[name='"+name+"']").attr("required",true);
		}
	}
</script>
</html>












