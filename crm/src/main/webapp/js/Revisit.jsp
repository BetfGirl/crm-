<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="https://www.layuicdn.com/layui/css/layui.css" />
<script type="text/javascript" src="../lib/layui/layui.all.js"></script>
<script src="jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="my.js"></script>
<title></title>
<style type="text/css">
.input {
	font-size: 16px; width : 200px;
	height: 30px;
	margin-top: -10px;
	margin-right: 10px;
	width: 200px;
}

.layui-form-select{width:200px;
}
</style>
</head>
<body>
	<table id="demo" lay-filter="test"></table>
	<script type="text/html" id="barDemo">
<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
	<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <div class="layui-input-inline">
      <input type="text" name="txt" lay-verify="title"  autocomplete="off" placeholder="请输入名称" class="layui-input input">
    </div>
    <button class="layui-btn layui-btn-sm" lay-event="search">查询</button>
    <button class="layui-btn layui-btn-sm" lay-event="add">新增</button>
  </div>
</script>

	<script>
	
		layui.use('table', function() {
			var table = layui.table;

			//第一个实例
			table.render({
				elem : '#demo',
				height : 462,
				url : '../Revisit/index.action',//数据接口
				toolbar : '#toolbarDemo',
				page : true //开启分页
				,
				cols : [ [ //表头
				/* {
					field : 'id',
					title : 'ID',
					width : 80,
					sort : true,
					fixed : 'right'
				}, */ {
					field : 'clientname',
					title : '客户名称',
					width : 90
				}, {
					field : 'link',
					title : '联通状态',
					width : 100
				}, {
					field : 'client',//dao层和表关联  使用别名
					title : '客户状态',
					width : 100
				}, {
					field : 'purpose',//调用model里面的 getpowername方法返回
					title : '意向状态',
					width : 100
				}, {
					field : 'assesss',
					title : '评估状态',
					width : 100
				}, {
					field : 'exec',
					title : '处理状态',
					width : 100
				},{
					field : 'askinfo',
					title : '询问状态',
					width : 100
				},{
					field : 'followinfo',
					title : '跟进方式',
					width : 100
				},{
					field : 'probleminfo',
					title : '出现问题',
					width : 100
				},{
					field : 'sttatus',
					title : '状态',
					width : 100
				},{
					field : 'comments',
					title : '备注',
					width : 100
				},{
					fixed : 'right',
					title : '操作',
					toolbar : '#barDemo',
					width : 150,
					align : 'center'
				}

				] ],
				parseData : function(res) {
					return {
						"code" :res.code,
						"msg" :res.msg,
						"count" :res.count,
						data : res.list
					}
				}
			});
			
			

			//obj 行      obj.data 行数据    data.id 列
			//test  是table的lay-filter="test" 属性
			table.on('tool(test)', function(obj) {
				var data = obj.data;
				if (obj.event === 'del') { ///lay-event 属性
					
					myconfirm("刪除？",function(){
						$.post("../Revisit/delete.action", {cmd : "delete",id : data.id}, 
								function(json) {
							reload('demo');
							layer.close(layer.index);
								}, "json");
					});
				}else{
					openFrameR('../Revisit/edit.jsp?id='+data.id);
				}
			});

			table.on('toolbar(test)', function(obj) {
				if (obj.event === 'search') {
					var txt = $(event.target).prev().find("input").val();
					reload('demo',{txt : txt});
				} else {
					openFrameR("../Revisit/edit.jsp");
				}
			});

		});
	</script>
</body>
</html>