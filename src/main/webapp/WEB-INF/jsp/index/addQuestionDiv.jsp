<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	var opt = 2;
	function addDom(){
		opt++;
		var dom_option="<div id='opt_div"+opt+"' class='form-group'><label for='exampleInputPassword1'>选项"+opt+"</label><input name='opt_name' type='text' class='form-control' required></div>";
	    $("#opt_div"+(opt-1)).after(dom_option);
	}
</script>

<form action="${pageContext.request.contextPath}/question/addQuestion.action" method="post" >
  <button onclick="addDom()" type="button" class="btn btn-primary btn-xs" style="float: right;"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 添加选项</button><br>
  <div class="form-group">
    <label for="exampleInputEmail1">问题题干</label>
    <input type="hidden" name="tid" value="${questionnaire.tid }"/>
    <input type="text" class="form-control" name="title" required>
  </div>
  <div id="opt_div1" class="form-group">
    <label for="exampleInputPassword1">选项1</label>
    <input name="opt_name" type="text" class="form-control" required>
  </div>
  <div id="opt_div2" class="form-group">
    <label for="exampleInputPassword1">选项2</label>
    <input name="opt_name" type="text" class="form-control" required>
  </div>
  
  	<div class="radio-inline">
	  <label>
	    <input type="radio" name="optionsRadios" id="optionsRadios1" value="1" checked>
	    	单选
	  </label>
	</div>
	<div class="radio-inline">
	  <label>
	    <input type="radio" name="optionsRadios" id="optionsRadios2" value="2">
	    	多选
	  </label>
	</div>
	<div class="radio-inline">
	  <label>
	    <input type="radio" name="optionsRadios" id="optionsRadios3" value="3">
	    	判断
	  </label>
	</div>
	<br>
  <button style="float: right;" type="submit" class="btn btn-success"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span> 提交</button>
</form>
<br><br><hr>