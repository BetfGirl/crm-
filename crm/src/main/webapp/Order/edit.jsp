<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="https://www.layuicdn.com/layui/css/layui.css" />
<link rel="stylesheet" href="/static/build/layui.css" media="all">
<script type="text/javascript" src="../lib/layui/layui.all.js"></script>
<script src="../js/jquery-2.2.4.min.js" ></script>
<script type="text/javascript" src="../js/my.js"></script>
<title></title>
</head>
<body>
<style>
.layui-input{width:200px;}

.myorder{
display: inline-block;
position: right;
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
  <div class="layui-form-item myorder">
    <label class="layui-form-label">客户姓名</label>
    <div class="layui-input-block">
      <select name="clientid" >
      </select>
    </div>
  </div>
  
  <div class="layui-form-item myorder">
    <label class="layui-form-label">签订时间</label>
    <div class="layui-input-block">
       <!-- <input  type="datetime" name="createdate" class="layui-input" id="test1" placeholder="yyyy-MM-dd"> -->
       <input  readonly="readonly" type="text" name="createdate" class="layui-input" placeholder="yyyy-MM-dd">
    </div>
  </div>
  
  <div class="layui-form-item myorder">
    <label class="layui-form-label">业绩日期</label>
    <div class="layui-input-block">
      <input type="datetime" name="compdate" class="layui-input" id="test2" placeholder="yyyy-MM-dd">
    </div>
  </div>
  
  <div class="layui-form-item myorder">
    <label class="layui-form-label">合同周期</label>
    <div class="layui-input-block">
      <input type="text" name="orderdate"  autocomplete="off" placeholder="请输入合同周期" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item myorder">
    <label class="layui-form-label">开始时间</label>
    <div class="layui-input-block">
      <input type="datetime" name="startdate" class="layui-input" id="test3" placeholder="yyyy-MM-dd">
    </div>
  </div>
  
  <div class="layui-form-item myorder">
    <label class="layui-form-label">结束时间</label>
    <div class="layui-input-block">
      <input type="datetime" name="enddate" class="layui-input" id="test4" placeholder="yyyy-MM-dd">
    </div>
  </div>
  
  <div class="layui-form-item myorder">
    <label class="layui-form-label">创建人</label>
    <div class="layui-input-block">
    <select disabled="disabled" name="operatorid">
    </select>
    </div>
  </div>
  
  <div class="layui-form-item myorder">
    <label class="layui-form-label">消息</label>
    <div class="layui-input-block">
    <input type="text" name="info"  autocomplete="off" placeholder="请输入消息" class="layui-input"> 
    </div>
  </div>
  
  <div class="layui-form-item myorder">
    <label class="layui-form-label">合同文件</label>
    <div class="layui-input-block">
     <input type="text" name="files"  autocomplete="off" placeholder="请输入合同文件" class="layui-input"> 
    </div>
  </div>
  
   <div class="layui-form-item myorder">
    <label class="layui-form-label">业绩人员</label>
    <div class="layui-input-block">
     <input type="text" name="compoperatorids"  autocomplete="off" placeholder="请输入业绩人员" class="layui-input">
    </div>
  </div>
  
   <div class="layui-form-item myorder">
    <label class="layui-form-label">业绩权重</label>
    <div class="layui-input-block">
      <input type="text" name="compweight"  autocomplete="off" placeholder="请输入业绩权重" class="layui-input">
    </div>
  </div>
  
   <div class="layui-form-item myorder">
    <label class="layui-form-label">状态</label>
    <div class="layui-input-block">
    <select name="status" >
      </select>
    </div>
  </div>
  
   <div class="layui-form-item myorder">
    <label class="layui-form-label">总金额</label>
    <div class="layui-input-block">
      <input type="text" name="amount"  autocomplete="off" placeholder="请输入总金额" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item ">
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

layui.use('laydate', function(){
	  var laydate = layui.laydate;
	  
	  //执行一个laydate实例
	  laydate.render({
	    elem: '#test1' //指定元素
	    ,trigger: 'click'
	  });
	  laydate.render({
		    elem: '#test2' //指定元素
		    ,trigger: 'click'
	   });
	  laydate.render({
		    elem: '#test3' //指定元素
		    ,trigger: 'click'
	   });
	  laydate.render({
		    elem: '#test4' //指定元素
		    ,trigger: 'click'
	   });
});

layui.use(['form',], function(){
	  var form = layui.form;
	  form.on('submit(demo1)', function(data){
		 $.post("../Order/update.action", data.field, function(json) {
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
		getarray("status.action",{},"[name=status]",0);
		getlist("clientname.action",{},"[name=clientid]",json.clientid);
		getlist("operatorname.action",{},"[name=operatorid]",json.operatorid);
	},"json");
	
}
if(id.length>0){
	init();
}else{
	getarray("status.action",{},"[name=status]",0);
	getlist("clientname.action",{},"[name=clientid]",0);
	getlist("operatorname.action",{},"[name=operatorid]",0);
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