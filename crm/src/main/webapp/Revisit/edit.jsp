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

.myright{
display: inline-block;
position: left;
}
</style>


<form class="layui-form" lay-filter="myform">
<c:if test="${param.id==null}">
<input type="hidden" name="cmd" value="insert">
</c:if>
<c:if test="${param.id!=null}">
<input type="hidden" name="cmd" value="update">
<input type="hidden" name="id" >
</c:if>
	<div class="layui-form-item myright">
    <label class="layui-form-label">客户名称</label>
    <div class="layui-input-block">
       <select name="clientid" >
      </select>
    </div>
  </div>
  
  <div class="layui-form-item myright">
    <label class="layui-form-label">联通状态</label>
    <div class="layui-input-block">
      <select name="linkstatus" >
      </select>
    </div>
  </div>
  <div class="layui-form-item myright">
    <label class="layui-form-label">客户状态</label>
    <div class="layui-input-block">
    <select name="clientstatus" >
      </select>
    </div>
  </div>
  <div class="layui-form-item myright">
    <label class="layui-form-label">意向状态</label>
    <div class="layui-input-block">
    <select name="purposestatus" >
      </select>
    </div>
  </div>
  <div class="layui-form-item myright">
    <label class="layui-form-label">评估状态</label>
    <div class="layui-input-block">
    <select name="assessstatus" >
      </select>
    </div>
  </div>
  <div class="layui-form-item myright">
    <label class="layui-form-label">处理状态</label>
    <div class="layui-input-block">
    <select name="execstatus" >
      </select>
    </div>
  </div>
  
  <div class="layui-form-item myright">
    <label class="layui-form-label">询问状态</label>
    <div class="layui-input-block">
    <input type="text" name="askinfo"  autocomplete="off" placeholder="询问状态" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item myright">
    <label class="layui-form-label">跟进方式</label>
    <div class="layui-input-block">
    <input type="text" name="followinfo"  autocomplete="off" placeholder="跟进方式" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item myright">
    <label class="layui-form-label">出现问题</label>
    <div class="layui-input-block">
     <input type="text" name="probleminfo"  autocomplete="off" placeholder="出项问题" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item myright">
    <label class="layui-form-label">状态</label>
    <div class="layui-input-block">
    <select name="status" >
      </select>
    </div>
  </div>
   
  <div class="layui-form-item myright">
    <label class="layui-form-label">备注</label>
    <div class="layui-input-block">
      <input type="text" name="comments"  autocomplete="off" placeholder="请输入备注" class="layui-input">
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
		 $.post("../Revisit/update.action", data.field, function(json) {
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
		getarray("link.action",{},"[name=linkstatus]",0);
		getarray("client.action",{},"[name=clientstatus]",0);
		getarray("purpose.action",{},"[name=purposestatus]",0);
		getarray("assesss.action",{},"[name=assessstatus]",0);
		getarray("exec.action",{},"[name=execstatus]",0);
		getarray("status.action",{},"[name=status]",0);
		getlist("clientt.action",{},"[name=clientid]",json.clientid);
	},"json");
	
}
if(id.length>0){
	init();
}else{
	getarray("link.action",{},"[name=linkstatus]",0);
	getarray("client.action",{},"[name=clientstatus]",0);
	getarray("purpose.action",{},"[name=purposestatus]",0);
	getarray("assesss.action",{},"[name=assessstatus]",0);
	getarray("exec.action",{},"[name=execstatus]",0);
	getarray("status.action",{},"[name=status]",0);
	getlist("clientt.action",{},"[name=clientid]",0);
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