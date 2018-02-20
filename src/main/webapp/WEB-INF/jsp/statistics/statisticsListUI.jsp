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
			  <li>首页</li>
			  <li>问卷统计</li>
			  <li>已完成问卷列表</li>
			</ol>
			<!-- Static Panel -->
			<c:forEach var="title" items="${questionnaireList }" varStatus="status">
				  <div class="col-md-4" style="height: 390px;">
				    <div class="thumbnail">
				      <div class="caption" style="background-color: #5FB878;color: white;">
				        <h3 style="text-align: center;">${title.title }</h3><br>
				        <span class="glyphicon glyphicon-time" aria-hidden="true"></span>&nbsp; <strong>创建时间：</strong><span style="color: white;"><fmt:formatDate type="date" value="${title.joindate }" /></span>&nbsp;&nbsp;<br>
					  	<span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp; <strong>面向人群：</strong>
				  		<span style="color: white;">
				  		<c:choose>
				  			<c:when test="${title.forwho == 0 }">在校生</c:when>
				  			<c:otherwise>毕业生</c:otherwise>
				  		</c:choose>
				  		</span><br>
				  		<span class="glyphicon glyphicon-send" aria-hidden="true"></span>&nbsp; <strong>问卷状态：</strong>
				  		<span style="color: white;">已完成问卷</span><br>
				      </div>
				      <div class="caption" style="color: gray;"><p>${fn:substring(title.subtitle, 0, 110)}...</p></div>
				      <p style="text-align: center;">
					      <a href="#" class="btn btn-success" role="button"><span class="glyphicon glyphicon-stats" aria-hidden="true"></span>&nbsp; 数据分析</a>
					      <button onclick="doOutExcel('${title.tid }');"  class="btn btn-default" role="button"><span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span>&nbsp; 问卷导出</button>
				      </p>
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
	function doOutExcel(tid){
		window.open("${pageContext.request.contextPath}/statistics/exportExcel.action?tid="+tid);
	}
</script>
</html>