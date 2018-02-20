<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse navbar-static-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#"><span style="color: white;">问卷调查后台管理</span></a>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav navbar-right">
        <!--  -->
      	<li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> 超级管理员 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <!-- <li><a href="#"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> 修改信息</a></li>
            <li role="separator" class="divider"></li> -->
            <li><a href="${pageContext.request.contextPath}/manager/loginOut.action"><span class="glyphicon glyphicon-off" aria-hidden="true"></span> 安全退出</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>