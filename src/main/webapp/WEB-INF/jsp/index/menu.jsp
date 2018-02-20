<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="col-md-3">
   		<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
   		  <!--  -->
		  <div class="panel panel-default">
		    <div class="panel-heading" role="tab" id="headingOne">
		      <h4 class="panel-title">
		        <a style="text-decoration: none;" role="button" data-toggle="collapse">
		          	<span class="glyphicon glyphicon-home" aria-hidden="true"></span> 首页
		        </a>
		      </h4>
		    </div>
		  </div>
		  <!--  -->
		  <div class="panel panel-default">
		    <div class="panel-heading" role="tab" id="headingTwo">
		      <h4 class="panel-title">
		        <a style="text-decoration: none;" class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
		         	<span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>  问卷系统
		        </a>
		      </h4>
		    </div>
		    <div style="padding-left: 20px;" id="collapseTwo" class="panel-collapse collapse ${wjxt }" role="tabpanel" aria-labelledby="headingTwo">
		      <div class="panel-body">
		      	<a style="text-decoration: none;color: black;" href="${pageContext.request.contextPath}/questionnaire/addQuestionnaireUI.action"><span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span> 新建问卷</a>
		      </div>
		      <div class="panel-body">
		      	<a style="text-decoration: none;color: black;" href="${pageContext.request.contextPath}/questionnaire/questionnaireListUI.action?state=0"><span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span> 未发布问卷</a>
		      </div>
		      <div class="panel-body">
		      	<a style="text-decoration: none;color: black;" href="${pageContext.request.contextPath}/questionnaire/questionnaireListUI.action?state=1"><span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span> 进行中的问卷</a>
		      </div>
		      <div class="panel-body">
		      	<a style="text-decoration: none;color: black;" href="${pageContext.request.contextPath}/questionnaire/questionnaireListUI.action?state=2"><span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span> 已完成的问卷</a>
		      </div>
		    </div>
		  </div>
		  <!--  -->
<%-- 		  <div class="panel panel-default">
		    <div class="panel-heading" role="tab" id="headingThree">
		      <h4 class="panel-title">
		        <a style="text-decoration: none;" class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
		          	<span class="glyphicon glyphicon-comment" aria-hidden="true"></span> 问卷题库
		        </a>
		      </h4>
		    </div>
		    <div style="padding-left: 20px;" id="collapseThree" class="panel-collapse collapse ${wjtk }" role="tabpanel" aria-labelledby="headingThree">
		      <div class="panel-body">
		      	 <a style="text-decoration: none;color: black;" href="${pageContext.request.contextPath}/question/addQuestionUI.action"><span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span> 新建问题</a>
		      </div>
		      <div class="panel-body">
		      	 <a style="text-decoration: none;color: black;" href="${pageContext.request.contextPath}/question/questionListUI.action"><span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span> 问题列表</a>
		      </div>
		    </div>
		  </div> --%>
		  <!--  -->
		  <div class="panel panel-default">
		    <div class="panel-heading" role="tab" id="headingFour">
		      <h4 class="panel-title">
		        <a style="text-decoration: none;" class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
		          	<span class="glyphicon glyphicon-stats" aria-hidden="true"></span> 问卷统计
		        </a>
		      </h4>
		    </div>
		    <div style="padding-left: 20px;" id="collapseFour" class="panel-collapse collapse ${wjtj }" role="tabpanel" aria-labelledby="headingFour">
		      <div class="panel-body">
		      	 <a style="text-decoration: none;color: black;" href="${pageContext.request.contextPath}/statistics/statisticsListUI.action"><span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span> 已完成问卷列表</a>
		      </div>
		      <div class="panel-body">
		      	 <a style="text-decoration: none;color: black;" href="${pageContext.request.contextPath}/statistics/statisticsOutUI.action"><span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span> 问卷导出</a>
		      </div>
		    </div>
		  </div>
		  <!--  -->
		</div>
   	</div>