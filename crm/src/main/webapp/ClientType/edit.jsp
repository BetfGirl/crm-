<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="https://www.layuicdn.com/layui/css/layui.css" />
<script type="text/javascript" src="../lib/layui/layui.all.js"></script>
<script src="../js/jquery-2.2.4.min.js" ></script>
<script type="text/javascript" src="../js/my.js"></script>

<title></title>
</head>
<body>
<style>
.layui-input{width:200px;}
</style>


<form class="layui-form" lay-filter="myform">
<c:if test="${param.id==null}">
<input type="hidden" name="cmd" value="insert">
</c:if>
<c:if test="${param.id!=null}">
<input type="hidden" name="cmd" value="update">
<input type="hidden" name="id" >
</c:if>
  <div class="layui-form-item">
    <label class="layui-form-label">名称</label>
    <div class="layui-input-block">
      <input type="text" name="name"  autocomplete="off" placeholder="请输入标题" class="layui-input">
    </div>
  </div>
  
  
   <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
    </div>
  </div>
</form>

<script type="text/javascript">
layui.use(['form',], function(){
	  var form = layui.form;
	  form.on('submit(demo1)', function(data){
		 $.post("../ClientType/update.action", data.field, function(json) {
			  closeFrame();
			  parent.fresh('demo');
			}, "json");
		    
		    return false;
		  });
});



var id="${param.id}";
function init(){
	//查询数据填充到表格里面
	$.post("edit.action",{cmd:"edit",id:id}, function(json) {
		render('myform', json);
		
	},"json");
	
}
if(id.length>0){
	init();
}else{
	
	//插入使用
	layui.use('form', function(){
		  var form = layui.form;
		  form.on('submit(demo1)', function(data){
			 $.post("insert.action", data.field, function(json) {
				  closeFrame();
				  parent.fresh('demo');
				}, "json");
			    return false;
			  });
	});
}

</script>
</body>
</html>